package pruebas;

import backend.controladores.UsuarioControlador;
import backend.entidades.Usuario;

public class Pruebas {
    public static void main(String[] args) {
        UsuarioControlador usuarioControlador = new UsuarioControlador();

        // Crear un usuario de prueba
        Usuario usuarioPrueba = new Usuario(null, "Usuario", 123456, "123", true);
        usuarioControlador.insertar(usuarioPrueba);
    }
}
