package hw.my_spring;

public class CleanerProxy implements Cleaner{
    private Cleaner cleaner;

    public CleanerProxy() {
        cleaner = ObjectFactory.getInstance().createObject(CleanerImpl.class);
    }

    @Override
    public void clean() {
        long start = System.currentTimeMillis();
        cleaner.clean();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
