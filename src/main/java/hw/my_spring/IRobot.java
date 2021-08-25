package hw.my_spring;

import hw.annotations.InjectByType;
import hw.annotations.InjectRandomInt;
import lombok.Getter;

public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    @Getter
    @InjectRandomInt(min = 0, max = 100000)
    private int someValue;

    public IRobot() {
    }

    public void cleanRoom(){
        speaker.speak("Я начал работать");
        cleaner.clean();
        speaker.speak("Я закончил работать");
    }
}
