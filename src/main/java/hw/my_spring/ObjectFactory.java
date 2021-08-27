package hw.my_spring;

import lombok.Getter;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ObjectFactory {
    @Getter
    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("hw.my_spring");

    private List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                configurators.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) {

        type = resolveImple(type);

        T t = type.getDeclaredConstructor().newInstance();

        configure(t);

        invokeInit(type, t);

        return ProxyWrapper.wrapToProxy(type, t);
    }



    private <T> void invokeInit(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Set<Method> allMethods = ReflectionUtils
                .getAllMethods(type, method -> method.isAnnotationPresent(PostConstruct.class));

        for (Method method : allMethods) {
            method.invoke(t);
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(configurator -> configurator.configure(t));
    }

    private <T> Class<T> resolveImple(Class<T> type) {
        if (type.isInterface()) {
            Class<T> implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " has 0 or more than one impl was found, please update your config");
                }
                implClass = (Class<T>) classes.iterator().next();
            }
            type = implClass;
        }
        return type;
    }
}
