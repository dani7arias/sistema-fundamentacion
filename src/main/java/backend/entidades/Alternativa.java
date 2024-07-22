package backend.entidades;

public class Alternativa {

    private Integer id_alternativa;

    private String nombre_alternativa;

    private String descripcion_alternativa;

    private String pros_alternativa;

    private String contras_alternativas;

    private Double costo_alternativa;

    private Integer tiempo_de_implementacion;

    private Integer proyectos_idProyecto;

    private Integer proyectos_usuarios_idUsuario;

    public Alternativa() {

    }

    public Alternativa(Integer id_alternativa, String nombre_alternativa, String descripcion_alternativa,
            String pros_alternativa, String contras_alternativas, Double costo_alternativa,
            Integer tiempo_de_implementacion, Integer proyectos_idProyecto, Integer proyectos_usuarios_idUsuario) {
        this.id_alternativa = id_alternativa;
        this.nombre_alternativa = nombre_alternativa;
        this.descripcion_alternativa = descripcion_alternativa;
        this.pros_alternativa = pros_alternativa;
        this.contras_alternativas = contras_alternativas;
        this.costo_alternativa = costo_alternativa;
        this.tiempo_de_implementacion = tiempo_de_implementacion;
        this.proyectos_idProyecto = proyectos_idProyecto;
        this.proyectos_usuarios_idUsuario = proyectos_usuarios_idUsuario;
    }

    public Integer getId_alternativa() {
        return id_alternativa;
    }

    public void setId_alternativa(Integer id_alternativa) {
        this.id_alternativa = id_alternativa;
    }

    public String getNombre_alternativa() {
        return nombre_alternativa;
    }

    public void setNombre_alternativa(String nombre_alternativa) {
        this.nombre_alternativa = nombre_alternativa;
    }

    public String getDescripcion_alternativa() {
        return descripcion_alternativa;
    }

    public void setDescripcion_alternativa(String descripcion_alternativa) {
        this.descripcion_alternativa = descripcion_alternativa;
    }

    public String getPros_alternativa() {
        return pros_alternativa;
    }

    public void setPros_alternativa(String pros_alternativa) {
        this.pros_alternativa = pros_alternativa;
    }

    public String getContras_alternativas() {
        return contras_alternativas;
    }

    public void setContras_alternativas(String contras_alternativas) {
        this.contras_alternativas = contras_alternativas;
    }

    public Double getCosto_alternativa() {
        return costo_alternativa;
    }

    public void setCosto_alternativa(Double costo_alternativa) {
        this.costo_alternativa = costo_alternativa;
    }

    public Integer getTiempo_de_implementacion() {
        return tiempo_de_implementacion;
    }

    public void setTiempo_de_implementacion(Integer tiempo_de_implementacion) {
        this.tiempo_de_implementacion = tiempo_de_implementacion;
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
        return "Alternativa{" + "id_alternativa=" + id_alternativa + ", nombre_alternativa=" + nombre_alternativa
                + ", descripcion_alternativa=" + descripcion_alternativa + ", pros_alternativa=" + pros_alternativa
                + ", contras_alternativas=" + contras_alternativas + ", costo_alternativa=" + costo_alternativa
                + ", tiempo_de_implementacion=" + tiempo_de_implementacion + ", proyectos_idProyecto="
                + proyectos_idProyecto + ", proyectos_usuarios_idUsuario=" + proyectos_usuarios_idUsuario + '}';
    }

}
