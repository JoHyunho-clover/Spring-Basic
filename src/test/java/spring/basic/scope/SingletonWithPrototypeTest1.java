package spring.basic.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest1 {
    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);

        int count1 = clientBean1.logic(); //이거 실행시 logic안에 getObject가 있어 이때 prototype빈이 생성된다. 그리고 ClientBean의 의존관계가 완성된다.
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);

        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1);
    }

    @Scope("singleton")
    static class ClientBean {

        //@Autowired
        private final ObjectProvider<PrototypeBean> prototypeBeanProvider; //지정한 빈을 컨테이너에서 대신 찾아주는 DL 서비스를 제공하는 것
        //의존관계가 Jsr330Provider가 주입된 상태로 된다.


        public ClientBean(ObjectProvider<PrototypeBean> prototypeBeanProvider) {
            this.prototypeBeanProvider = prototypeBeanProvider;
            System.out.println("prototypeBeanProvider = " + prototypeBeanProvider);
        }

        public int logic() {
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject(); //getObject 호출 시 이때 해당 타입의 프로토 타입 빈이 생성되고. 스프링 컨테이너에서 등록된 프로토타입 빈을 찾아서 준다.
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }

        /*

        private final PrototypeBean prototypeBean;

        @Autowired
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }*/
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }


}
