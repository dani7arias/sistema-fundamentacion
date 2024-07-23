package backend.controladores;

import java.util.ArrayList;

import backend.entidades.Alternativa;
import backend.servicios.AlternativaServicio;

public class AlternativaControlador extends AlternativaServicio {

    public AlternativaControlador() {
        super();
    }

    public Alternativa insertar(Alternativa alternativa) {
        return super.insertar(alternativa);
    }

    public Alternativa actualizar(Alternativa alternativa) {
        return super.actualizar(alternativa);
    }

    public void eliminar(Integer id) {
        super.eliminar(id);
    }

    public Alternativa buscarPorId(Integer id) {
        return super.buscarPorId(id);
    }

    public ArrayList<Alternativa> mostrarTodos() {
        return super.mostrarTodos();
    }

    public ArrayList<Alternativa> mostrarPorProyecto(Integer idProyecto) {
        return super.listarPorProyecto(idProyecto);
    }

}
