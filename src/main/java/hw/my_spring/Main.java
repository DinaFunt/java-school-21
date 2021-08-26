package hw.my_spring;

public class Main {
    public static void main(String[] args) {

        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
    }
}
