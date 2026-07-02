package ms.com.uce.application.service;

import jakarta.inject.Inject;
import ms.com.uce.domain.model.Reporte;

public class ReporteServiceTarea implements Runnable {

    // @Inject
    private ReporteService reporteService;

    private Reporte reporte;

    public ReporteServiceTarea(Reporte reporte, ReporteService reporteService) {
        this.reporte = reporte;
        this.reporteService = reporteService;
    }

    @Override
    public void run() {
        this.reporteService.guardarReporte(this.reporte);
    }
}
