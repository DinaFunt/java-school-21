package hw.my_spring;

public class Main {
    public static void main(String[] args) {

        /* ApplicationContext context = new ApplicationContext("com.epam", Map.of(Speaker.class, ConsoleSpeaker.class));
        context.getObject(IRobot.class).cleanRoom();*/


        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
    }
}
