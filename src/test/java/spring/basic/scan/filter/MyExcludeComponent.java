package spring.basic.scan.filter;

import java.lang.annotation.*;
@Target(ElementType.TYPE) //TYPE이면 클래스 레벨에 붙는 것이다.
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
