package backend.controladores;

import java.util.ArrayList;

import backend.entidades.Objetivo;
import backend.servicios.ObjetivoServicio;

public class ObjetivoControlador extends ObjetivoServicio {

    public ObjetivoControlador() {
        super();
    }

    public Objetivo insertar(Objetivo objetivo) {
        return super.insertar(objetivo);
    }

    public Objetivo actualizar(Objetivo objetivo) {
        return super.actualizar(objetivo);
    }

    public void eliminar(Integer id) {
        super.eliminar(id);
    }

    public Objetivo buscarPorId(Integer id) {
        return super.buscarPorId(id);
    }

    public ArrayList<Objetivo> mostrarTodos() {
        return super.mostrarTodos();
    }

    public ArrayList<Objetivo> mostrarPorProyecto(Integer idProyecto) {
        return super.mostrarPorProyecto(idProyecto);
    }

}
