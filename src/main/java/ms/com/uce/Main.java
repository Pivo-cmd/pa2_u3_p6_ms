package ms.com.uce;

import java.time.LocalDate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import ms.com.uce.application.service.FacturaService;
import ms.com.uce.domain.model.Factura;

@QuarkusMain
public class Main {
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        @Inject
        private FacturaService facturaService;
        @Override
        public int run(String... args) {
            System.out.println("\n"+"Conectandose a base de datos"+"\n");
            // Factura f1 = new Factura();
            // f1.setFecha(LocalDate.of(2019, 8, 20));
            // f1.setNumero("0002");
            // f1.setRuc("384761234");
            // facturaService.guardar(f1);

            System.out.println(facturaService.buscarPorId(1));
            
            return 0;
        }
    }
}