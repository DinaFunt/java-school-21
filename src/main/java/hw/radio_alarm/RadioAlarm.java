package hw.radio_alarm;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RadioAlarm implements Radio, Alarm{

    private Alarm alarm;
    private Radio radio;

    @Override
    public void turnOffAlarm() {
        System.out.println("turnOffAlarm method");
    }

    @Override
    public void setAnAlarm() {
        System.out.println("setAnAlarm method");
    }

    @Override
    public void catchRadioStation() {
        System.out.println("catchRadioStation method");
    }

    @Override
    public void record() {
        System.out.println("record method");
    }
}
