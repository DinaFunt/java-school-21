package hw.my_spring;

import hw.annotations.InjectByType;
import hw.annotations.InjectRandomInt;
import hw.lab3.utils.RandomUtil;
import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class ObjectFactory {

    @Getter
    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }

        T t = type.getDeclaredConstructor().newInstance();

        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                if (annotation != null) {
                    field.setAccessible(true);
                    field.set(t, RandomUtil.between(annotation.min(), annotation.max()));
                    field.setAccessible(false);
                }
            } else if (field.isAnnotationPresent(InjectByType.class)) {
                InjectByType annotation = field.getAnnotation(InjectByType.class);
                if (annotation != null) {
                    field.setAccessible(true);
                    field.set(t, instance.createObject(field.getType()));
                    field.setAccessible(false);
                }
            }
        }


        return t;
    }
}
