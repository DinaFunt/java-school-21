package hw.my_spring;

import lombok.Getter;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
        Set<Class<? extends ObjectConfigurator>> configs = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> configurator : configs) {
            if (!Modifier.isAbstract(configurator.getModifiers())) {
                configurators.add(configurator.getDeclaredConstructor().newInstance());
            }
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImple(type);

        T t = type.getDeclaredConstructor().newInstance();

        configureObject(t);
        initializeObject(t);

        return t;
    }

    @SneakyThrows
    private <T> void initializeObject(T obj) {
        Method[] methods = obj.getClass().getMethods();
        for (var method: methods) {
            if (method.getName().startsWith("init")) {
                method.invoke(obj);
            }
        }
    }

    @SneakyThrows
    private <T> void configureObject(T obj) {
        for (ObjectConfigurator configurator : configurators) {
            configurator.configure(obj);
        }
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
