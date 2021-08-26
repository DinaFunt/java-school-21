package hw.my_spring;

import hw.my_spring.annotations.InjectByType;

public class CleanerProxy implements Cleaner{
    @InjectByType
    private CleanerImpl cleaner;

    @Override
    public void clean() {
        long start = System.currentTimeMillis();
        cleaner.clean();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
