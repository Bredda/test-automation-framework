package bredda.taf.extension;


import org.junit.jupiter.api.extension.ExtendWith;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@ExtendWith(WebExtension.class)
@ExtendWith(ReportExtension.class)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Web {
}
