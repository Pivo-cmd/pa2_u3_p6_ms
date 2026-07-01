package ms.com.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ms.com.uce.application.service.interceptors.MedirTiempo;
import ms.com.uce.infrastructure.repository.EnvioRepoImpl;

@ApplicationScoped
@Transactional
public class EnvioService {
    @Inject
    private EnvioRepoImpl envioRepo;
    @MedirTiempo
    public void guardarEnvio(ms.com.uce.domain.model.Envio envio) {
        System.out.println("Hilo (EnvioService): "+Thread.currentThread().getName());
        System.out.println("ID: "+Thread.currentThread().threadId());
        this.envioRepo.persist(envio);
    }
}
