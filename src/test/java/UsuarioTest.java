
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.controladores.UsuarioControlador;
import backend.entidades.Usuario;

import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Daniel Arias
 */
public class UsuarioTest {

    private static UsuarioControlador usuarioControlador;

    public UsuarioTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        usuarioControlador = new UsuarioControlador();
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testInsertar() {
        // Crear un usuario de prueba
        Usuario usuarioPrueba = new Usuario(null, "UsuarioPrueba", 123456, "password");

        // Insertar el usuario en la base de datos
        Usuario usuarioInsertado = usuarioControlador.insertar(usuarioPrueba);

        // Verificar que el usuario insertado no es null
        assertNotNull(usuarioInsertado, "El usuario insertado no debería ser null.");

        // Verificar que el ID del usuario insertado no es null (asumiendo que la
        // inserción genera un ID)
        assertNotNull(usuarioInsertado.getId(), "El ID del usuario insertado no debería ser null.");

        // Opcional: Verificar otros campos para asegurar que el usuario se insertó
        // correctamente
        assertEquals("UsuarioPrueba", usuarioInsertado.getNombre(),
                "El nombre de usuario debería coincidir con el insertado.");
        assertEquals("UsuarioPrueba", usuarioInsertado.getNombre(), "El nombre debería coincidir con el insertado.");

        // Limpieza: Eliminar el usuario insertado para mantener limpia la base de datos
        // Esto asume que existe un método para eliminar usuarios por ID
        usuarioControlador.eliminar(usuarioInsertado.getId());
    }

    @Test
    public void testActualizar() {
        // Insertar un usuario de prueba para asegurar que exista en la base de datos
        Usuario usuarioPrueba = new Usuario(null, "UsuarioPrueba", 123456, "password");
        usuarioPrueba = usuarioControlador.insertar(usuarioPrueba);

        // Cambiar algún dato del usuario
        usuarioPrueba.setNombre("NombreActualizado");

        // Actualizar el usuario en la base de datos
        Usuario usuarioActualizado = usuarioControlador.actualizar(usuarioPrueba);

        // Buscar el usuario por ID para verificar la actualización
        Usuario usuarioEncontrado = usuarioControlador.buscarPorId(usuarioPrueba.getId());

        // Verificar que el usuario encontrado no es null
        assertNotNull(usuarioEncontrado, "El usuario encontrado no debería ser null.");

        // Verificar que el nombre del usuario encontrado ha sido actualizado
        assertEquals("NombreActualizado", usuarioEncontrado.getNombre(),
                "El nombre del usuario debería haber sido actualizado.");

        // Verificar que el usuario actualizado coincide con el usuario encontrado
        // Esto asume que Usuario tiene implementado correctamente equals
        assertEquals(usuarioActualizado, usuarioEncontrado,
                "El usuario actualizado debería coincidir con el usuario encontrado.");

        usuarioControlador.eliminar(usuarioPrueba.getId());
    }

    @Test
    public void testBuscarPorId() {
        // Insertar un usuario de prueba para asegurar que exista en la base de datos
        Usuario usuarioPrueba = new Usuario(1, "UsuarioPrueba", 123456, "password");
        usuarioPrueba = usuarioControlador.insertar(usuarioPrueba);

        // Buscar el usuario por ID
        Usuario usuarioEncontrado = usuarioControlador.buscarPorId(usuarioPrueba.getId());

        // Verificar que el usuario encontrado no es null
        assertNotNull(usuarioEncontrado, "El usuario encontrado no debería ser null.");

        // Verificar que el ID del usuario encontrado coincide con el buscado
        assertEquals(usuarioPrueba.getId(), usuarioEncontrado.getId(),
                "El ID del usuario encontrado debería coincidir con el buscado.");

        // Verificar que el usuario encontrado coincide con el usuario de prueba
        // insertado
        // Esto asume que Usuario tiene implementado correctamente equals
        assertEquals(usuarioPrueba, usuarioEncontrado,
                "El usuario encontrado debería coincidir con el usuario de prueba insertado.");

        // Opcional: Test para verificar el comportamiento cuando el usuario no existe
        Usuario usuarioNoExistente = usuarioControlador.buscarPorId(999);
        assertNull(usuarioNoExistente, "La búsqueda de un ID inexistente debería retornar null.");
        usuarioControlador.eliminar(usuarioPrueba.getId());
    }

    @Test
    public void testMostrarTodos() {
        // Insertar un usuario de prueba para asegurar que la lista no esté vacía
        Usuario usuarioPrueba = new Usuario(null, "Prueba", 123456, "password");
        usuarioPrueba = usuarioControlador.insertar(usuarioPrueba);

        // Llamar al método mostrarTodos
        ArrayList<Usuario> listaUsuarios = usuarioControlador.mostrarTodos();

        // Verificar que la lista no esté vacía
        assertFalse(listaUsuarios.isEmpty(), "La lista de usuarios no debería estar vacía.");

        // Verificar que la lista contenga al usuario de prueba
        // Esto asume que Usuario tiene implementado correctamente equals y hashCode
        assertTrue(listaUsuarios.contains(usuarioPrueba), "La lista debería contener al usuario de prueba.");
        usuarioControlador.eliminar(usuarioPrueba.getId());
    }

    @Test
    public void testEliminar() {
        // Insertar un usuario de prueba
        Usuario usuarioPrueba = new Usuario(null, "Daniel", 123456, "password");
        usuarioPrueba = usuarioControlador.insertar(usuarioPrueba);

        // Asumiendo que el método insertar devuelve el usuario con un ID asignado
        int idUsuarioPrueba = usuarioPrueba.getId();

        // Eliminar el usuario de prueba
        usuarioControlador.eliminar(idUsuarioPrueba);

        // Intentar buscar el usuario después de eliminarlo
        Usuario usuarioEliminado = usuarioControlador.buscarPorId(idUsuarioPrueba);

        // Verificar que el usuario ya no existe
        assertNull(usuarioEliminado);
    }

    @Test
    public void testValidarUsuario() {
        // Insertar un usuario de prueba
        Usuario usuarioPrueba = new Usuario(null, "Daniel", 123456, "password");
        usuarioPrueba = usuarioControlador.insertar(usuarioPrueba);

        // Validar el usuario de prueba
        boolean usuarioValido = usuarioControlador.validarUsuario("Daniel", "password");

        // Verificar que el usuario es válido
        assertTrue(usuarioValido, "El usuario debería ser válido.");

        // Validar un usuario inexistente
        boolean usuarioInvalido = usuarioControlador.validarUsuario("UsuarioInexistente", "password");

        // Verificar que el usuario es inválido
        assertFalse(usuarioInvalido, "El usuario debería ser inválido.");

        usuarioControlador.eliminar(usuarioPrueba.getId());
    }
}
