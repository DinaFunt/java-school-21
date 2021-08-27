package hw.my_spring;

import hw.my_spring.annotations.Benchmark;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ProxyWrapper {
    private List<ProxyConfigurator> invokeConfigurators = new ArrayList<>();
    private Reflections scanner;

    @SneakyThrows
    public ProxyWrapper(Reflections scanner) {
        this.scanner = scanner;
        Set<Class<? extends ProxyConfigurator>> classes = scanner.getSubTypesOf(ProxyConfigurator.class);
        for (Class<? extends ProxyConfigurator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                invokeConfigurators.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }

    public static <T> T wrapToProxy(Class<T> type, T t) {
        if (type.isAnnotationPresent(Benchmark.class) || Arrays.stream(type.getMethods()).anyMatch(method -> method.isAnnotationPresent(Benchmark.class))) {
            InvocationHandler handler = new BenchmarkInvocationHandler<T>(t);


            return (T) Proxy.newProxyInstance(type.getClassLoader()
                    , type.getInterfaces()
                    , handler
            );
        }

        return t;
    }

}
