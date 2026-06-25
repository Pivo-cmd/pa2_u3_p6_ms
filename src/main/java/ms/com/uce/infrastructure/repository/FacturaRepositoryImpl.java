package ms.com.uce.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import ms.com.uce.domain.model.Factura;

@ApplicationScoped
@Transactional
// <... , ....> --> La entidad y el tipo que maneja el id
public class FacturaRepositoryImpl implements PanacheRepositoryBase<Factura, Integer> {
    public Factura buscarPorNumero(String numero) {
        return null;
    }
}
