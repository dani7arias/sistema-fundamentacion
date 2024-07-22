package backend.entidades;

public class Cambio {

    private Integer id_cambios;

    private String nombre_cambio;

    private String descripcion;

    private Integer proyectos_idProyectos;

    public Cambio() {

    }

    public Cambio(Integer id_cambios, String nombre_cambio, String descripcion, Integer proyectos_idProyectos) {
        this.id_cambios = id_cambios;
        this.nombre_cambio = nombre_cambio;
        this.descripcion = descripcion;
        this.proyectos_idProyectos = proyectos_idProyectos;
    }

    public Integer getId_cambios() {
        return id_cambios;
    }

    public void setId_cambios(Integer id_cambios) {
        this.id_cambios = id_cambios;
    }

    public String getNombre_cambio() {
        return nombre_cambio;
    }

    public void setNombre_cambio(String nombre_cambio) {
        this.nombre_cambio = nombre_cambio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getProyectos_idProyectos() {
        return proyectos_idProyectos;
    }

    public void setProyectos_idProyectos(Integer proyectos_idProyectos) {
        this.proyectos_idProyectos = proyectos_idProyectos;
    }

    @Override
    public String toString() {
        return "Cambio{" + "id_cambios=" + id_cambios + ", nombre_cambio=" + nombre_cambio + ", descripcion="
                + descripcion + ", proyectos_idProyectos=" + proyectos_idProyectos + '}';
    }
}
