package hw.my_spring;

public class ConsoleSpeaker implements Speaker {
    private int volume;
    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
