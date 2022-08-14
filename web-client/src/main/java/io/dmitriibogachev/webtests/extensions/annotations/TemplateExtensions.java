package io.dmitriibogachev.webtests.extensions.annotations;

import io.dmitriibogachev.webtests.extensions.InjectExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith(InjectExtension.class)
public @interface TemplateExtensions {
}
