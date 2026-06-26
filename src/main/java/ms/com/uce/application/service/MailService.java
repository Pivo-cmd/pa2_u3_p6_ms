package ms.com.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ms.com.uce.domain.model.Mail;
import ms.com.uce.infrastructure.repository.MailRepositoryImpl;

@ApplicationScoped
@Transactional
public class MailService {
    @Inject
    private MailRepositoryImpl mailRepo;
    public void guardar(Mail mail){
        this.mailRepo.persist(mail);
    }
    public Mail buscarPorId(Integer id){
        return this.mailRepo.findById(id);
    }
}
