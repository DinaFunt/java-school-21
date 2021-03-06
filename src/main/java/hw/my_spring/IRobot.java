package hw.my_spring;

import hw.my_spring.annotations.Benchmark;
import hw.my_spring.annotations.InjectByType;

import javax.annotation.PostConstruct;

//@Benchmark
public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    @PostConstruct
    public void init() { //todo teach our framework to run all methods which starts with init
        System.out.println(cleaner.getClass());
    }

    public void cleanRoom() {
        speaker.speak("Я начал работать");
        cleaner.clean();
        speaker.speak("Я закончил работать");
    }
}
