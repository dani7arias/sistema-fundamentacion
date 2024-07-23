package backend.entidades;

import java.util.Objects;

public class Alternativa {

    private Integer id;

    private String nombre;

    private String descripcion;

    private String pros;

    private String contras;

    private Double costo;

    private Integer tiempoDeImplementacion;

    private String categoria;

    private Integer idProyecto;

    public Alternativa() {

    }

    public Alternativa(Integer id, String nombre, String descripcion, String pros, String contras, Double costo, Integer tiempoDeImplementacion, String categoria, Integer idProyecto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pros = pros;
        this.contras = contras;
        this.costo = costo;
        this.tiempoDeImplementacion = tiempoDeImplementacion;
        this.categoria = categoria;
        this.idProyecto = idProyecto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros;
    }

    public String getContras() {
        return contras;
    }

    public void setContras(String contras) {
        this.contras = contras;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Integer getTiempoDeImplementacion() {
        return tiempoDeImplementacion;
    }

    public void setTiempoDeImplementacion(Integer tiempoDeImplementacion) {
        this.tiempoDeImplementacion = tiempoDeImplementacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.descripcion);
        hash = 23 * hash + Objects.hashCode(this.pros);
        hash = 23 * hash + Objects.hashCode(this.contras);
        hash = 23 * hash + Objects.hashCode(this.costo);
        hash = 23 * hash + Objects.hashCode(this.tiempoDeImplementacion);
        hash = 23 * hash + Objects.hashCode(this.categoria);
        hash = 23 * hash + Objects.hashCode(this.idProyecto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alternativa other = (Alternativa) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.pros, other.pros)) {
            return false;
        }
        if (!Objects.equals(this.contras, other.contras)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.costo, other.costo)) {
            return false;
        }
        if (!Objects.equals(this.tiempoDeImplementacion, other.tiempoDeImplementacion)) {
            return false;
        }
        return Objects.equals(this.idProyecto, other.idProyecto);
    }

    @Override
    public String toString() {
        return "Alternativa{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", pros=" + pros + ", contras=" + contras + ", costo=" + costo + ", tiempoDeImplementacion=" + tiempoDeImplementacion + ", categoria=" + categoria + ", idProyecto=" + idProyecto + '}';
    }

}
