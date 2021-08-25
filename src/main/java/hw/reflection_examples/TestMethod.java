package hw.reflection_examples;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface TestMethod {
    int numberOfInvocations();
}
