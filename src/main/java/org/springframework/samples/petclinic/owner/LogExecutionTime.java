package org.springframework.samples.petclinic.owner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 이 Annotation을 어디에다가 쓸 수 있는지: method에
@Retention(RetentionPolicy.RUNTIME) // 이 Annotation 정보를 언제까지 유지할 것인지: runtime까지
public @interface LogExecutionTime {
}
