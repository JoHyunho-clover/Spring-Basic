package spring.basic.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.basic.common.MyLogger;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger; //완전한 의존 주입을 지연시키게 해준다. //다시 Provider삭제

    @RequestMapping("log-demo")
    @ResponseBody
    public String lofDemo(HttpServletRequest request){
        System.out.println("myLogger = " + myLogger.getClass());
        String requestURL = request.getRequestURL().toString();
        //MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }
}
