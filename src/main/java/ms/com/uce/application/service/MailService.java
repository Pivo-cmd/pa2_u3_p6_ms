package ms.com.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ms.com.uce.application.service.interceptors.MedirTiempo;
import ms.com.uce.domain.model.Mail;
import ms.com.uce.infrastructure.repository.MailRepositoryImpl;

@ApplicationScoped
@Transactional
public class MailService {
    @Inject
    private MailRepositoryImpl mailRepo;
    @MedirTiempo
    public void guardarMail(Mail mail){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("El hilo actual de MailService es: " + nombreHilo);
        System.out.println("ID: "+Thread.currentThread().threadId() + "\n");

        this.mailRepo.persist(mail);
    }
    public Mail buscarPorId(Integer id){
        return this.mailRepo.findById(id);
    }
}
