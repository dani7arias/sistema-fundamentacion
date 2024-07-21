package backend.entidades;

public class Usuario {

    private Integer idUsuario;

    private String nombres;

    private Integer telefono;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombres, Integer telefono) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.telefono = telefono;
    }

    
    


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombres=" + nombres + ", telefono=" + telefono + '}';
    }
    
    
}
