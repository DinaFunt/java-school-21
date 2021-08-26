package hw.my_spring;

import java.util.Map;

public interface Context {
    String getPackagesToScan();
    Map<Class,Class> getIfc2ImplClass();

    <T> T getObject(Class<T> type);
}
