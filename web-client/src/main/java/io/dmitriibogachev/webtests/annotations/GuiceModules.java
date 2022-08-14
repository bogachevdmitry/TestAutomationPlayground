package io.dmitriibogachev.webtests.annotations;

import com.google.inject.Module;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GuiceModules {

    Class<? extends Module>[] value();
}
