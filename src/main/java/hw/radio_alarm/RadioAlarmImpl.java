package hw.radio_alarm;

import hw.radio_alarm.alarm.Alarm;
import hw.radio_alarm.alarm.AlarmImpl;
import hw.radio_alarm.radio.Radio;
import hw.radio_alarm.radio.RadioImpl;
import lombok.Setter;
import lombok.experimental.Delegate;

@Setter
public class RadioAlarmImpl implements RadioAlarm {
    @Delegate
    private Alarm alarm = new AlarmImpl();
    @Delegate
    private Radio radio = new RadioImpl();

    public static void main(String[] args) {
        RadioAlarmImpl ra = new RadioAlarmImpl();
        ra.catchRadioStation();
    }
}
