package ms.com.uce;

import java.time.LocalDate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import ms.com.uce.application.service.FacturaService;
import ms.com.uce.application.service.FacturaServiceParalelo;
import ms.com.uce.domain.model.Factura;

@QuarkusMain
public class Main {
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        @Inject
        private FacturaServiceParalelo facturaService;

        @Override
        public int run(String... args) {
            System.out.println("\n" + "Conectandose a base de datos" + "\n");
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("El hilo actual (Main) es: " + nombreHilo);
            System.out.println("ID: " + Thread.currentThread().threadId() + "\n");

            Factura f1 = new Factura();
            f1.setNumero("9012726");
            f1.setFecha(LocalDate.of(2015, 5, 1));
            f1.setRuc("1234567890");
            this.facturaService.guardarFactura(f1);
            return 0;
        }
    }
}