package spring.basic.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//public class NetworkClient implements InitializingBean, DisposableBean { // (1)
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+url);
    }

    public void setUrl(String url){
        this.url=url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call; = " + url+" message = "+message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: " + url);
    }

    /*
    @Override //(1)
    public void afterPropertiesSet() throws Exception { //InitializingBean 인터페이스 - 의존관계 주입이 끝나면 이것을 호출한다.
        connect();
        call("초기화 연결 메시지");
    }

    @Override // (1)
    public void destroy() throws Exception { //DisposableBean 인터페이스 - 빈이 종료될 때 호출됨
        disconnect();
    }*/

    /*
    public void init() { //(2)
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }
    public void close() { //(2)
        System.out.println("NetworkClient.close");
        disconnect();
    }
    */

    @PostConstruct //(3)
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }
    @PreDestroy //(3)
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }

}
