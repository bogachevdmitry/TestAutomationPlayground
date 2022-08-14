package io.dmitriibogachev.webtests.extensions;

import com.google.inject.Injector;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.dmitriibogachev.webtests.extensions.utils.InjectUtils.*;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class InjectExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws IllegalStateException {
        final Injector injector = createInjector(getModules(
                context.getTestClass()
                        .orElseThrow(() -> new IllegalStateException("Test class doesn't exist"))
        ));
        injector.injectMembers(context.getTestInstance()
                .orElseThrow(() -> new IllegalStateException("Test method doesn't exist"))
        );

        context.getStore(GLOBAL).put(INJECTOR_KEY, injector);
    }
}
