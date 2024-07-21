package backend.entidades;


public class Proyecto {
    
    private Integer idProyecto;
    
    private String nombreProyecto;
    
    private String descripcionProyecto;
    
    private Integer usuarios_idUsuarios;
    
    public Proyecto(){
        
    }

    public Proyecto(Integer idProyecto, String nombreProyecto, String descripcionProyecto, Integer usuarios_idUsuarios) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.usuarios_idUsuarios = usuarios_idUsuarios;
    }
    
      
    
    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public Integer getUsuarios_idUsuarios() {
        return usuarios_idUsuarios;
    }

    public void setUsuarios_idUsuarios(Integer usuarios_idUsuarios) {
        this.usuarios_idUsuarios = usuarios_idUsuarios;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "idProyecto=" + idProyecto + ", nombreProyecto=" + nombreProyecto + ", descripcionProyecto=" + descripcionProyecto + ", usuarios_idUsuarios=" + usuarios_idUsuarios + '}';
    }
    
    
}
