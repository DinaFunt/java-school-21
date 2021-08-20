package hw.radio_alarm.alarm;

public class AlarmImpl implements Alarm{
    @Override
    public void turnOffAlarm() {
        System.out.println("turnOffAlarm method");
    }

    @Override
    public void setAnAlarm() {
        System.out.println("setAnAlarm method");
    }
}
