package ms.com.uce.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import ms.com.uce.domain.model.Reporte;

@ApplicationScoped
@Transactional
public class ReporteRepositoryImpl implements PanacheRepositoryBase<Reporte, Integer>{

}
