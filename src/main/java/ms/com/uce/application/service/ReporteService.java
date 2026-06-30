package ms.com.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ms.com.uce.application.service.interceptors.MedirTiempo;
import ms.com.uce.domain.model.Reporte;
import ms.com.uce.infrastructure.repository.ReporteRepositoryImpl;

@ApplicationScoped
@Transactional
public class ReporteService {
    @Inject
    private ReporteRepositoryImpl repoImpl;
    @MedirTiempo
    public void guardarReporte(Reporte reporte) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("El hilo actual de ReporteService es: " + nombreHilo);
        System.out.println("ID: "+Thread.currentThread().threadId());
        this.repoImpl.persist(reporte);
    }

    public Reporte buscarPorId(Integer id) {
        return this.repoImpl.findById(id);
    }
}
