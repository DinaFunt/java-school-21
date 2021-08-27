package hw.my_spring;

import com.github.javafaker.Faker;
import hw.lab3.utils.RandomUtil;
import hw.my_spring.annotations.InjectRandomName;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectRandomNameAnnotationObjectConfigurator implements ObjectConfigurator{
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        for (Field field : type.getDeclaredFields()) {
            InjectRandomName annotation = field.getAnnotation(InjectRandomName.class);
            if(annotation!=null){
                field.setAccessible(true);
                field.set(t, RandomUtil.randomName());
            }
        }

    }
}
