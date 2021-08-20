package hw.radio_alarm;

public class RadioAlarmImpl implements RadioAlarm {

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

    public static void main(String[] args) {
        RadioAlarmImpl ra = new RadioAlarmImpl();
        ra.catchRadioStation();
    }
}
