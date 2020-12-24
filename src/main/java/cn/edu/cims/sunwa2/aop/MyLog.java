package cn.edu.cims.sunwa2.aop;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author hezhou
 * @Date 2020/3/21 17:10
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented //生成文档
@Component
public @interface MyLog {
    String value() default "";
}
