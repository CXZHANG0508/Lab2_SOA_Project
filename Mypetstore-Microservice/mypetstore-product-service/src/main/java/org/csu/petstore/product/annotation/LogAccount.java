package org.csu.petstore.product.annotation;

import java.lang.annotation.*;


@Target(ElementType.METHOD)//注解放置的目标位置即方法级别
@Retention(RetentionPolicy.RUNTIME)//注解在哪个阶段执行
@Documented
public @interface LogAccount {
    String value() default "";

}
