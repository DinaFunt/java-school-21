package hw.my_spring;

import hw.my_spring.annotations.Benchmark;

public class Main {
    public static void main(String[] args) {

       /* ApplicationContext context = new ApplicationContext("com.epam", Map.of(Speaker.class, ConsoleSpeaker.class));
        context.getObject(IRobot.class).cleanRoom();*/

//        System.out.println(IRobot.class.isAnnotationPresent(Benchmark.class));
//        System.out.println(CleanerImpl.class.isAnnotationPresent(Benchmark.class));

        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);

        iRobot.cleanRoom();
    }
}

/*
    1. Refactor the code, extract proxy benchmark logic from ObjectFactory
    2. Add additional support for @Benchmark annotation, method marked with @Benchmark should be benchmarked and other not
    3. Write support for proxy classes, which doesn't have any interfaces (use CGLIB)
*/
