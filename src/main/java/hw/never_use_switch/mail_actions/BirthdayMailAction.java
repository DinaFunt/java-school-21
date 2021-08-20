package hw.never_use_switch.mail_actions;

import hw.never_use_switch.MailInfo;

public class BirthdayMailAction implements MailAction {
    @Override
    public void act(MailInfo mailInfo) {
        System.out.println("Happy Birthdate mail was sent "+mailInfo.getContext());
    }
}
