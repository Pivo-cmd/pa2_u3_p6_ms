package ms.com.uce.application.service;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ms.com.uce.application.service.interceptors.MedirTiempo;
import ms.com.uce.domain.model.Factura;
import ms.com.uce.domain.model.Mail;
import ms.com.uce.domain.model.Reporte;
import ms.com.uce.infrastructure.repository.FacturaRepositoryImpl;

@Transactional
@ApplicationScoped
public class FacturaServiceParalelo {

    @Inject
    private FacturaRepositoryImpl facturaRepository;
    @Inject
    private ReporteService reporteServiceInyectado;
    @Inject
    private MailService mailServiceInyectado;

    @MedirTiempo
    public void guardarFactura(Factura factura) {

        String nombreHilo = Thread.currentThread().getName();
        System.out.println("El hilo actual de FacturaService es: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId() + "\n");

        this.facturaRepository.persist(factura);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Reporte reporte = new Reporte();
        reporte.setTitulo("Factura1");
        reporte.setDescripcion("Reporte de Factura1");
        reporte.setFecha(LocalDate.now());
        reporte.setTipo("Financiero");
        ReporteServiceTarea reporteService = new ReporteServiceTarea(reporte, reporteServiceInyectado);
        executorService.submit(reporteService);

        Mail mail = new Mail();
        mail.setDestinatario("matias@test.com1");
        mail.setAsunto("Factura1");
        mail.setCuerpo("1La factura de hoy sera a las 3:00 pm");
        mail.setFechaEnvio(LocalDate.of(2015, 5, 1));
        MailServiceTarea mailService = new MailServiceTarea(mail, mailServiceInyectado);
        executorService.submit(mailService);

        // Cerrar el proceso de ejecucion - No se envia más tareas
        executorService.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
