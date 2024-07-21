
package backend.entidades;

public class ProyectoDeUsuario {
    
    private Integer proyectos_idProyecto;
    
    private Integer proyectos_usuarios_idUsuarios;
    
    private Integer usuarios_idUsuario;
    
    public ProyectoDeUsuario(){
        
    }

    public ProyectoDeUsuario(Integer proyectos_idProyecto, Integer proyectos_usuarios_idUsuarios, Integer usuarios_idUsuario) {
        this.proyectos_idProyecto = proyectos_idProyecto;
        this.proyectos_usuarios_idUsuarios = proyectos_usuarios_idUsuarios;
        this.usuarios_idUsuario = usuarios_idUsuario;
    }
    
    
    

    public Integer getProyectos_idProyecto() {
        return proyectos_idProyecto;
    }

    public void setProyectos_idProyecto(Integer proyectos_idProyecto) {
        this.proyectos_idProyecto = proyectos_idProyecto;
    }

    public Integer getProyectos_usuarios_idUsuarios() {
        return proyectos_usuarios_idUsuarios;
    }

    public void setProyectos_usuarios_idUsuarios(Integer proyectos_usuarios_idUsuarios) {
        this.proyectos_usuarios_idUsuarios = proyectos_usuarios_idUsuarios;
    }

    public Integer getUsuarios_idUsuario() {
        return usuarios_idUsuario;
    }

    public void setUsuarios_idUsuario(Integer usuarios_idUsuario) {
        this.usuarios_idUsuario = usuarios_idUsuario;
    }

    @Override
    public String toString() {
        return "ProyectoDeUsuario{" + "proyectos_idProyecto=" + proyectos_idProyecto + ", proyectos_usuarios_idUsuarios=" + proyectos_usuarios_idUsuarios + ", usuarios_idUsuario=" + usuarios_idUsuario + '}';
    }
    
    
    
}
