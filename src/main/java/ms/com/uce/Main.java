package ms.com.uce;

import java.time.LocalDate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import ms.com.uce.application.service.FacturaService;
import ms.com.uce.application.service.MailService;
import ms.com.uce.application.service.ReporteService;
import ms.com.uce.domain.model.Factura;
import ms.com.uce.domain.model.Mail;
import ms.com.uce.domain.model.Reporte;

@QuarkusMain
public class Main {
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        @Inject
        private ReporteService repoService;
        @Inject
        private MailService mailService;
        @Override
        public int run(String... args) {
            System.out.println("\n"+"Conectandose a base de datos"+"\n");
            Reporte r1 = new Reporte();
            r1.setTitulo("Gastos Octubre");
            r1.setTipo("Financiero");
            r1.setDescripcion("Reporte de gastos durante el mes de Octubre");
            r1.setFecha(LocalDate.of(2010, 10, 25));
            repoService.guardar(r1);
            System.out.println(repoService.buscarPorId(1));

            Mail m1 = new Mail();
            m1.setAsunto("Reunion");
            m1.setCuerpo("La reunion de hoy será a las 3:00 pm");
            m1.setDestinatario("matias@test.com");
            m1.setFechaEnvio(LocalDate.of(2015, 5, 1));
            mailService.guardar(m1);
            System.out.println(mailService.buscarPorId(1));

            return 0;
        }
    }
}