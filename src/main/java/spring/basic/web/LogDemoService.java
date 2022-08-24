package spring.basic.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import spring.basic.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger; //Provider 삭제 - Proxy설정으로 인해서

    public void logic(String id) {
        //MyLogger myLogger = myLoggerProvider.getObject(); //Provider 삭제 - Proxy설정으로 인해서
        myLogger.log("service id = "+id);
    }
}
