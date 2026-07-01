package ms.com.uce.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "envio")
public class Envio extends PanacheEntityBase{ 
    @Id
    @SequenceGenerator(name = "seq_envio_generador", sequenceName = "seq_envio", allocationSize = 1)
    @GeneratedValue(generator = "seq_envio_generador", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @Column(name = "env_direccion")
    private String direccion;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    @Override
    public String toString() {
        return "Envio [id=" + id + ", direccion=" + direccion + "]";
    }

}
