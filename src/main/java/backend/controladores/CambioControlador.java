package backend.controladores;

import java.util.ArrayList;

import backend.entidades.Cambio;
import backend.servicios.CambioServicio;

public class CambioControlador extends CambioServicio {

    public CambioControlador() {
        super();
    }

    public Cambio insertar(Cambio cambio) {
        return super.insertar(cambio);
    }

    public Cambio actualizar(Cambio cambio) {
        return super.actualizar(cambio);
    }

    public void eliminar(Integer id) {
        super.eliminar(id);
    }

    public Cambio buscarPorId(Integer id) {
        return super.buscarPorId(id);
    }

    public ArrayList<Cambio> mostrarTodos() {
        return super.mostrarTodos();
    }

    public ArrayList<Cambio> mostrarPorProyecto(Integer idProyecto) {
        return super.obtenerPorProyecto(idProyecto);
    }
}
