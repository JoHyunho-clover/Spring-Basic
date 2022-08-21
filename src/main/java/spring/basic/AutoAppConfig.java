package spring.basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration//설정정보니까 이거 적어줌
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =
        Configuration.class))//스프링 빈을 자동으로 끌어와야해  // excludeFilters는 스프링 빈으로 등록하는 것 중 뺄 것을 정한다. - @Configuration이 붙은 어노테이션은 제외하고 스프링 빈들을 끌어오겠다
public class AutoAppConfig { //즉, AppConfig , TestConfig에서 만든거 빼고 작동하는 것
}
