package hw.never_use_switch;

public class MailSender {

    public void send(MailInfo mailInfo) {
        MailType.act(mailInfo);
    }
}
