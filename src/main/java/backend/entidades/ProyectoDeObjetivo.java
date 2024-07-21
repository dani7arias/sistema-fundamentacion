package backend.entidades;

public class ProyectoDeObjetivo {
    
    private Integer objetivos_idObjetivos;
    
    private Integer proyectos_idProyecto;
    
    private Integer proyectos_usuarios_idUsuario;
    
    public ProyectoDeObjetivo(){
        
    }

    public ProyectoDeObjetivo(Integer objetivos_idObjetivos, Integer proyectos_idProyecto, Integer proyectos_usuarios_idUsuario) {
        this.objetivos_idObjetivos = objetivos_idObjetivos;
        this.proyectos_idProyecto = proyectos_idProyecto;
        this.proyectos_usuarios_idUsuario = proyectos_usuarios_idUsuario;
    }
    
    

    public Integer getObjetivos_idObjetivos() {
        return objetivos_idObjetivos;
    }

    public void setObjetivos_idObjetivos(Integer objetivos_idObjetivos) {
        this.objetivos_idObjetivos = objetivos_idObjetivos;
    }

    public Integer getProyectos_idProyecto() {
        return proyectos_idProyecto;
    }

    public void setProyectos_idProyecto(Integer proyectos_idProyecto) {
        this.proyectos_idProyecto = proyectos_idProyecto;
    }

    public Integer getProyectos_usuarios_idUsuario() {
        return proyectos_usuarios_idUsuario;
    }

    public void setProyectos_usuarios_idUsuario(Integer proyectos_usuarios_idUsuario) {
        this.proyectos_usuarios_idUsuario = proyectos_usuarios_idUsuario;
    }

    @Override
    public String toString() {
        return "ProyectoDeObjetivo{" + "objetivos_idObjetivos=" + objetivos_idObjetivos + ", proyectos_idProyecto=" + proyectos_idProyecto + ", proyectos_usuarios_idUsuario=" + proyectos_usuarios_idUsuario + '}';
    }
    
    
}
