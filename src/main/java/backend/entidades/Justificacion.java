package backend.entidades;

public class Justificacion {
    
    private Integer id_justificacion;
    
    private String descripcion_de_la_justificacion;
    
    private Integer cambios_idCambios;
    
    private Integer cambios_proyectos_idProyectos;
    
    public Justificacion(){
        
    }

    public Justificacion(Integer id_justificacion, String descripcion_de_la_justificacion, Integer cambios_idCambios, Integer cambios_proyectos_idProyectos) {
        this.id_justificacion = id_justificacion;
        this.descripcion_de_la_justificacion = descripcion_de_la_justificacion;
        this.cambios_idCambios = cambios_idCambios;
        this.cambios_proyectos_idProyectos = cambios_proyectos_idProyectos;
    }

    public Integer getId_justificacion() {
        return id_justificacion;
    }

    public void setId_justificacion(Integer id_justificacion) {
        this.id_justificacion = id_justificacion;
    }

    public String getDescripcion_de_la_justificacion() {
        return descripcion_de_la_justificacion;
    }

    public void setDescripcion_de_la_justificacion(String descripcion_de_la_justificacion) {
        this.descripcion_de_la_justificacion = descripcion_de_la_justificacion;
    }

    public Integer getCambios_idCambios() {
        return cambios_idCambios;
    }

    public void setCambios_idCambios(Integer cambios_idCambios) {
        this.cambios_idCambios = cambios_idCambios;
    }

    public Integer getCambios_proyectos_idProyectos() {
        return cambios_proyectos_idProyectos;
    }

    public void setCambios_proyectos_idProyectos(Integer cambios_proyectos_idProyectos) {
        this.cambios_proyectos_idProyectos = cambios_proyectos_idProyectos;
    }

    @Override
    public String toString() {
        return "Justificacion{" + "id_justificacion=" + id_justificacion + ", descripcion_de_la_justificacion=" + descripcion_de_la_justificacion + ", cambios_idCambios=" + cambios_idCambios + ", cambios_proyectos_idProyectos=" + cambios_proyectos_idProyectos + '}';
    }
    
    
}
