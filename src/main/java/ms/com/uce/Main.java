package ms.com.uce;


import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import ms.com.uce.application.service.PedidoService;
import ms.com.uce.domain.model.Pedido;

@QuarkusMain
public class Main {
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        @Inject
        private PedidoService pedidoService;
        @Override
        public int run(String... args) {
            System.out.println("\n"+"Conectandose a base de datos"+"\n");
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("El hilo actual (Main) es: "+   nombreHilo);
            System.out.println("ID: "+Thread.currentThread().threadId() + "\n");

            Pedido pedido = new Pedido();
            pedido.setDescripcion("Pedido generado en linea");
            this.pedidoService.guardarPedido(pedido);
            
            return 0;
        }
    }
}