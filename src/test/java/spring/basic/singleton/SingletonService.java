package spring.basic.singleton;

public class SingletonService {//싱글톤 패턴 적용한 것- 완벽한 싱글톤으로 적용.!  -> 하지만 스프링 컨테이너가 싱글톤 패턴을 알아서 적용해준다.

    //static으로 선언
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService() { //public이 아닌 private생성자를 생성하여, 외부에서 SingletonService 객체 자체를 생성 못하게 한다.
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
