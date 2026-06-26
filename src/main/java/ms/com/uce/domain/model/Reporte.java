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
@Table(name = "reporte")
public class Reporte extends PanacheEntityBase{
    @Id
    @SequenceGenerator(name = "seq_reporte_gen", sequenceName = "seq_reporte", allocationSize = 1)
    @GeneratedValue(generator =  "seq_reporte_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "repo_id")
    private Integer id;
    @Column(name = "repo_titulo")
    private String titulo;
    @Column(name = "repo_descripcion")
    private String descripcion;
    @Column(name = "repo_fecha")
    private LocalDate fecha;
    @Column(name = "repo_tipo")
    private String tipo;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Reporte [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fecha=" + fecha
                + ", tipo=" + tipo + "]";
    }
}
