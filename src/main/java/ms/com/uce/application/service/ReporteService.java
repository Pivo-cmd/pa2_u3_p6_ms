package ms.com.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ms.com.uce.domain.model.Reporte;
import ms.com.uce.infrastructure.repository.ReporteRepositoryImpl;

@ApplicationScoped
@Transactional
public class ReporteService {
    @Inject
    private ReporteRepositoryImpl repoImpl;

    public void guardar(Reporte reporte) {
        this.repoImpl.persist(reporte);
    }
    
    public Reporte buscarPorId(Integer id){
        return this.repoImpl.findById(id);
    }
}
