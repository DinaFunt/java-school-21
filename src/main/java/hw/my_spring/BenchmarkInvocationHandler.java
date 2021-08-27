package hw.my_spring;

import hw.my_spring.annotations.Benchmark;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BenchmarkInvocationHandler<T> implements InvocationHandler {
    private T originalObject;

    public BenchmarkInvocationHandler(T originalObject) {
        this.originalObject = originalObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getAnnotations().length);
        if (originalObject.getClass().isAnnotationPresent(Benchmark.class) || method.isAnnotationPresent(Benchmark.class)) {
            return benchmarkInvoke(proxy, method, args);
        }
        return simpleInvoke(proxy, method, args);
//        return benchmarkInvoke(proxy, method, args);
    }

    @SneakyThrows
    private Object benchmarkInvoke(Object proxy, Method method, Object[] args) {
        System.out.println("********BENCHMARK STARTED FOR METHOD " + method.getName() + " **********");

        long start = System.nanoTime();
        Object retVal = method.invoke(originalObject, args);
        long end = System.nanoTime();
        System.out.println(end - start);

        System.out.println("********BENCHMARK ENDED FOR METHOD " + method.getName() + " **********");


        return retVal;
    }

    @SneakyThrows
    private Object simpleInvoke(Object proxy, Method method, Object[] args) {
        return method.invoke(originalObject, args);
    }
}
