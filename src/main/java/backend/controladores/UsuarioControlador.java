package backend.controladores;

import java.util.ArrayList;

import backend.entidades.Usuario;
import backend.servicios.UsuarioServicio;

public class UsuarioControlador extends UsuarioServicio {

    public UsuarioControlador() {
        super();
    }

    public Usuario insertar(Usuario usuario) {
        return super.insertar(usuario);
    }

    public Usuario actualizar(Usuario usuario) {
        return super.actualizar(usuario);
    }

    public void eliminar(Integer id) {
        super.eliminar(id);
    }

    public Usuario buscarPorId(Integer id) {
        return super.buscarPorId(id);
    }

    public ArrayList<Usuario> mostrarTodos() {
        return super.mostrarTodos();
    }

    public Boolean validarUsuario(String nombre, String password) {
        return super.validarUsuario(nombre, password);
    }

    public Usuario buscarPorNombre(String nombre) {
        return super.buscarPorNombre(nombre);
    }
}
