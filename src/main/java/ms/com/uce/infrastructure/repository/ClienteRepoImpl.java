package ms.com.uce.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import ms.com.uce.domain.model.Cliente;

@ApplicationScoped
@Transactional
public class ClienteRepoImpl implements PanacheRepositoryBase<Cliente, Integer> {

}
