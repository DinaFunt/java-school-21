package hw.never_use_switch;

import hw.never_use_switch.mail_actions.*;

public enum MailType {

    WELCOME_MAIL(1, new WelcomeMailAction()), BIRTHDAY_MAIL(2, new BirthdayMailAction());

    private final int mailTypeId;
    private final MailAction mailAction;

    MailType(int mailTypeId, MailAction mailAction) {
        this.mailTypeId = mailTypeId;
        this.mailAction = mailAction;
    }

    public static void act(MailInfo mailInfo) {
        MailType[] types = values();
        for (MailType type : types) {
            if (type.mailTypeId == mailInfo.getMailType()) {
                type.mailAction.act(mailInfo);
                return;
            }
        }
        throw new IllegalStateException(mailInfo.getMailType() + " not supported");
    }
}
