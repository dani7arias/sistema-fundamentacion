package backend.entidades;

import java.util.Objects;

public class Cambio {

    private Integer id;

    private String nombre;

    private String descripcion;

    private String justificacion;

    private Integer idProyecto;

    public Cambio() {

    }

    public Cambio(Integer id, String nombre, String descripcion, String justificacion, Integer idProyecto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.justificacion = justificacion;
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

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.descripcion);
        hash = 61 * hash + Objects.hashCode(this.justificacion);
        hash = 61 * hash + Objects.hashCode(this.idProyecto);
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
        final Cambio other = (Cambio) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.justificacion, other.justificacion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.idProyecto, other.idProyecto);
    }

    @Override
    public String toString() {
        return "Cambio{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", justificacion=" + justificacion + ", idProyecto=" + idProyecto + '}';
    }

}
