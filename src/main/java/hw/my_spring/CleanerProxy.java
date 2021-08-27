package hw.my_spring;

public class CleanerProxy {
    private Cleaner cleaner;

    public CleanerProxy() {
        cleaner = ObjectFactory.getInstance().createObject(CleanerImpl.class);
    }

    public void clean() {
        long start = System.currentTimeMillis();
        cleaner.clean();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
