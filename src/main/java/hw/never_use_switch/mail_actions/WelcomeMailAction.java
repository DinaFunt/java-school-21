package hw.never_use_switch.mail_actions;

import hw.never_use_switch.MailInfo;

public class WelcomeMailAction implements MailAction{
    @Override
    public void act(MailInfo mailInfo) {
        System.out.println("Welcome mail was sent " + mailInfo.getContext());
    }
}
