package ms.com.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ms.com.uce.application.service.interceptors.MedirTiempo;
import ms.com.uce.domain.model.Cliente;
import ms.com.uce.infrastructure.repository.ClienteRepoImpl;

@ApplicationScoped
@Transactional
public class ClienteService {
    @Inject
    private ClienteRepoImpl clrepo;
    @MedirTiempo
    public void guardarCliente(Cliente cliente) {
        System.out.println("Hilo (ClienteService): "+Thread.currentThread().getName());
        System.out.println("ID: "+Thread.currentThread().threadId());
        this.clrepo.persist(cliente);
    }
}
