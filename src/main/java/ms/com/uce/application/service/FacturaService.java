package ms.com.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ms.com.uce.domain.model.Factura;
import ms.com.uce.infrastructure.repository.FacturaRepositoryImpl;

@ApplicationScoped
@Transactional
public class FacturaService {
    @Inject
    private FacturaRepositoryImpl facturaRepository;
    public void guardar(Factura factura) {
        factura.persist();
        // this.facturaRepository.persist(factura);
    }
    public Factura buscarPorId(Integer id) {
        return Factura.findById(id);
        // return this.facturaRepository.findById(id);
    }
}