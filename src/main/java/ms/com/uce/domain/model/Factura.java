package ms.com.uce.domain.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "factura")
public class Factura  extends PanacheEntityBase{
    @Id
    @SequenceGenerator(name = "seq_factura_generador", sequenceName = "seq_factura", allocationSize = 1)
    @GeneratedValue(generator = "seq_factura_generador", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "numero")
    private String numero;
    @Column(name = "ruc")
    private String ruc;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getRuc() {
        return ruc;
    }
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    @Override
    public String toString() {
        return "Factura [id=" + id + ", fecha=" + fecha + ", numero=" + numero + ", ruc=" + ruc + "]";
    }
           
}
