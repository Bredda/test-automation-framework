package bredda.taf.extension;

import bredda.taf.TestTypeKey;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Tag(TestTypeKey.WEB)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(WebExtension.class)
@Target(ElementType.TYPE)
public @interface WEB {
}
