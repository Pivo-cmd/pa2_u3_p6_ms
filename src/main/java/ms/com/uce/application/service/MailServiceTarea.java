package ms.com.uce.application.service;

import jakarta.inject.Inject;
import ms.com.uce.domain.model.Mail;

public class MailServiceTarea implements Runnable {

    // @Inject
    private MailService mailService;

    private Mail mail;

    public MailServiceTarea(Mail mail, MailService mailService) {
        this.mail = mail;
        this.mailService = mailService;
    }

    @Override
    public void run() {
        this.mailService.guardarMail(this.mail);
    }
}
