package ms.com.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ms.com.uce.application.service.interceptors.MedirTiempo;
import ms.com.uce.domain.model.Cliente;
import ms.com.uce.domain.model.Envio;
import ms.com.uce.domain.model.Pago;
import ms.com.uce.domain.model.Producto;
import ms.com.uce.infrastructure.repository.PedidoRepoImpl;

@ApplicationScoped
@Transactional
public class PedidoService {
    @Inject
    private ClienteService clienteService;
    @Inject
    private ProductoService productoService;
    @Inject
    private PagoService pagoService;
    @Inject
    private EnvioService envioService;
    @Inject
    private PedidoRepoImpl pedidoRepo;
    @MedirTiempo
    public void guardarPedido(ms.com.uce.domain.model.Pedido pedido) {
        System.out.println("Hilo (PedidoService): "+Thread.currentThread().getName());
        System.out.println("ID: "+Thread.currentThread().threadId());
        this.pedidoRepo.persist(pedido);
        
        Cliente c1 = new Cliente();
        c1.setNombre("Juan");
        c1.setApellido("Perez");
        this.clienteService.guardarCliente(c1);
        
        Producto p1 = new Producto();
        p1.setNombre("SmartPhone");
        p1.setCategoria("Electronica");
        this.productoService.guardarProducto(p1);

        Pago pago = new Pago();
        pago.setMonto(100.0);
        pago.setMetodoPago("Efectivo");
        this.pagoService.guardarPago(pago);

        Envio envio = new Envio();
        envio.setDireccion("Av. Principal 123");
        this.envioService.guardarEnvio(envio);
    }
}
