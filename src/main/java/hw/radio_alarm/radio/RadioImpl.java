package hw.radio_alarm.radio;

public class RadioImpl implements Radio {
    @Override
    public void catchRadioStation() {
        System.out.println("catchRadioStation method");
    }

    @Override
    public void record() {
        System.out.println("record method");
    }
}
