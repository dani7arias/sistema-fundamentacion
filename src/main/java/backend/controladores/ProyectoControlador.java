package backend.controladores;

import java.util.ArrayList;

import backend.entidades.Proyecto;
import backend.servicios.ProyectoServicio;

public class ProyectoControlador extends ProyectoServicio {

    public ProyectoControlador() {
    }

    public Proyecto insertar(Proyecto proyecto) {
        return super.insertar(proyecto);
    }

    public Proyecto actualizar(Proyecto proyecto) {
        return super.actualizar(proyecto);
    }

    public void eliminar(Integer id) {
        super.eliminar(id);
    }

    public Proyecto buscarPorId(Integer id) {
        return super.buscarPorId(id);
    }

    public ArrayList<Proyecto> mostrarTodos() {
        return super.mostrarTodos();
    }

    public ArrayList<Proyecto> mostrarPorUsuario(Integer idUsuario) {
        return super.obtenerPorIdUsuario(idUsuario);
    }

}
