package ms.com.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ms.com.uce.application.service.interceptors.MedirTiempo;
import ms.com.uce.domain.model.Producto;
import ms.com.uce.infrastructure.repository.ProductoRepoImpl;

@Transactional
@ApplicationScoped
public class ProductoService {
    @Inject
    private ProductoRepoImpl productoService;
    @MedirTiempo
    public void guardarProducto(Producto producto) {
        System.out.println("Hilo (ProductoService): "+Thread.currentThread().getName());
        System.out.println("ID: "+Thread.currentThread().threadId());
        this.productoService.persist(producto);
    }
}
