package ms.com.uce.application.service;

import java.time.LocalDate;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ms.com.uce.application.service.interceptors.MedirTiempo;
import ms.com.uce.domain.model.Factura;
import ms.com.uce.domain.model.Mail;
import ms.com.uce.domain.model.Reporte;
import ms.com.uce.infrastructure.repository.FacturaRepositoryImpl;

@ApplicationScoped
@Transactional
public class FacturaService {
    @Inject
    private ReporteService reporteService;
    @Inject
    private FacturaRepositoryImpl facturaRepository;
    @Inject
    private MailService mailService;
    @MedirTiempo
    public void guardarFactura(Factura factura) {

        String nombreHilo = Thread.currentThread().getName();
        System.out.println("El hilo actual de FacturaService es: " + nombreHilo);
        System.out.println("ID: "+Thread.currentThread().threadId()+ "\n");
        
        this.facturaRepository.persist(factura);

        Reporte reporte = new Reporte();
        reporte.setTitulo("Factura");
        reporte.setDescripcion("Reporte de Factura");
        reporte.setFecha(LocalDate.now());
        reporte.setTipo("Financiero");
        this.reporteService.guardarReporte(reporte);

        Mail mail = new Mail();
        mail.setDestinatario("matias@test.com");
        mail.setAsunto("Factura");
        mail.setCuerpo("La factura de hoy sera a las 3:00 pm");
        mail.setFechaEnvio(LocalDate.of(2015, 5, 1));
        this.mailService.guardarMail(mail);
    }
    public Factura buscarPorId(Integer id) {
        // return Factura.findById(id);
        return this.facturaRepository.findById(id);
    }
}