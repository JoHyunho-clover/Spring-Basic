package spring.basic.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope("request")
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("["+uuid+"]"+"["+requestURL+"]"+" - "+message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();//전세계적으로 유일한 ID가 생성된다.
        System.out.println("["+uuid+"] request scope bean create: "+this);
    }

    @PreDestroy
    public void close(){
        System.out.println("["+uuid+"] request scope bean close: "+this);
    }
}
