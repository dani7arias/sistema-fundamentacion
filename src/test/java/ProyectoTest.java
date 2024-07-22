
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import backend.controladores.ProyectoControlador;
import backend.entidades.Proyecto;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Daniel Arias
 */
public class ProyectoTest {
    private static ProyectoControlador proyectoControlador;

    public ProyectoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        proyectoControlador = new ProyectoControlador();
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
        // Crear un proyecto de prueba
        Proyecto proyectoPrueba = new Proyecto(null, "ProyectoPrueba", "Descripcion", 1);

        // Insertar el proyecto en la base de datos
        Proyecto proyectoInsertado = proyectoControlador.insertar(proyectoPrueba);

        // Verificar que el proyecto insertado no es null
        assertNotNull(proyectoInsertado, "El proyecto insertado no debería ser null.");

        // Verificar que el ID del proyecto insertado no es null (asumiendo que la
        // base de datos asigna un ID al proyecto)
        assertNotNull(proyectoInsertado.getId(), "El ID del proyecto insertado no debería ser null.");

        // Verificar que el nombre del proyecto insertado es igual al nombre del
        // proyecto de prueba
        assertEquals(proyectoPrueba.getNombre(), proyectoInsertado.getNombre(),
                "El nombre del proyecto insertado debería ser igual al nombre del proyecto de prueba.");

        // Elimitar el proyecto insertado
        proyectoControlador.eliminar(proyectoInsertado.getId());
    }

    @Test
    public void testActualizar() {
        // Crear un proyecto de prueba
        Proyecto proyectoPrueba = new Proyecto(null, "ProyectoPrueba", "Descripcion", 1);

        // Insertar el proyecto en la base de datos
        Proyecto proyectoInsertado = proyectoControlador.insertar(proyectoPrueba);

        // Cambiar el nombre del proyecto insertado
        proyectoInsertado.setNombre("ProyectoPruebaActualizado");

        // Actualizar el proyecto en la base de datos
        Proyecto proyectoActualizado = proyectoControlador.actualizar(proyectoInsertado);

        // Verificar que el proyecto actualizado no es null
        assertNotNull(proyectoActualizado, "El proyecto actualizado no debería ser null.");

        // Verificar que el nombre del proyecto actualizado es igual al nombre del
        // proyecto insertado
        assertEquals(proyectoInsertado.getNombre(), proyectoActualizado.getNombre(),
                "El nombre del proyecto actualizado debería ser igual al nombre del proyecto insertado.");

        // Elimitar el proyecto actualizado
        proyectoControlador.eliminar(proyectoActualizado.getId());
    }

    @Test
    public void testEliminar() {
        // Crear un proyecto de prueba
        Proyecto proyectoPrueba = new Proyecto(null, "ProyectoPrueba", "Descripcion", 1);

        // Insertar el proyecto en la base de datos
        Proyecto proyectoInsertado = proyectoControlador.insertar(proyectoPrueba);

        // Eliminar el proyecto insertado
        proyectoControlador.eliminar(proyectoInsertado.getId());

        // Buscar el proyecto eliminado
        Proyecto proyectoEliminado = proyectoControlador.buscarPorId(proyectoInsertado.getId());

        // Verificar que el proyecto eliminado es null
        assertNull(proyectoEliminado, "El proyecto eliminado debería ser null.");
    }

    @Test
    public void testBuscarPorId() {
        // Crear un proyecto de prueba
        Proyecto proyectoPrueba = new Proyecto(null, "ProyectoPrueba", "Descripcion", 1);

        // Insertar el proyecto en la base de datos
        Proyecto proyectoInsertado = proyectoControlador.insertar(proyectoPrueba);

        // Buscar el proyecto por ID
        Proyecto proyectoEncontrado = proyectoControlador.buscarPorId(proyectoInsertado.getId());

        // Verificar que el proyecto encontrado no es null
        assertNotNull(proyectoEncontrado, "El proyecto encontrado no debería ser null.");

        // Verificar que el ID del proyecto encontrado es igual al ID del proyecto
        // insertado
        assertEquals(proyectoInsertado.getId(), proyectoEncontrado.getId(),
                "El ID del proyecto encontrado debería ser igual al ID del proyecto insertado.");

        // Verificar que el nombre del proyecto encontrado es igual al nombre del
        // proyecto insertado
        assertEquals(proyectoInsertado.getNombre(), proyectoEncontrado.getNombre(),
                "El nombre del proyecto encontrado debería ser igual al nombre del proyecto insertado.");

        // Eliminar el proyecto insertado
        proyectoControlador.eliminar(proyectoInsertado.getId());
    }

    @Test
    public void testMostrarTodos(){
        // Crear un proyecto de prueba
        Proyecto proyectoPrueba = new Proyecto(null, "ProyectoPrueba", "Descripcion", 1);

        // Insertar el proyecto en la base de datos
        Proyecto proyectoInsertado = proyectoControlador.insertar(proyectoPrueba);

        // Mostrar todos los proyectos
        assertNotNull(proyectoControlador.mostrarTodos(), "La lista de proyectos no debería ser null.");

        // Eliminar el proyecto insertado
        proyectoControlador.eliminar(proyectoInsertado.getId());
    }

}
