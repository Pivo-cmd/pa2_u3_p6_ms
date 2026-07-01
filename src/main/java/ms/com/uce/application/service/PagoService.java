package ms.com.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ms.com.uce.application.service.interceptors.MedirTiempo;
import ms.com.uce.domain.model.Pago;
import ms.com.uce.infrastructure.repository.PagoRepoImpl;

@ApplicationScoped
@Transactional
public class PagoService {
    @Inject
    private PagoRepoImpl pagoRepo;
    @MedirTiempo
    public void guardarPago(Pago pago) {
        System.out.println("Hilo (PagoService): "+Thread.currentThread().getName());
        System.out.println("ID: "+Thread.currentThread().threadId());
        this.pagoRepo.persist(pago);
    }
}
