package hw.my_spring;

import hw.my_spring.annotations.InjectByType;

public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public void init() {
        System.out.println("init method: " + cleaner.getClass());
    }

    public void cleanRoom(){
        speaker.speak("Я начал работать");
        cleaner.clean();
        speaker.speak("Я закончил работать");
    }
}
