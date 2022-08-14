package io.dmitriibogachev.webtests.extensions.utils;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import io.dmitriibogachev.webtests.annotations.GuiceModules;

import java.util.ArrayList;
import java.util.List;

public final class InjectUtils {

    public static final String INJECTOR_KEY = "InjectorKey";

    private InjectUtils() {

    }

    public static Injector createInjector(final Class<?>... classes) {
        final List<Module> modules = new ArrayList<>(classes.length);
        for (final Class<?> module : classes) {
            try {
                modules.add((Module) module.getDeclaredConstructor().newInstance());
            } catch (final ReflectiveOperationException exception) {
                throw new IllegalStateException(exception);
            }
        }

        return Guice.createInjector(modules);
    }

    public static Class<?>[] getModules(final Class<?> object) {
        final GuiceModules annotation = object.getAnnotation(GuiceModules.class);

        if (annotation == null) {
            final String message = String.format("Missing @GuiceModule annotation for test `%s`", object.getName());
            throw new IllegalStateException(message);
        }

        return annotation.value();
    }
}
