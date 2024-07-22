package backend.interfaces;

import java.util.ArrayList;

public interface OperacionesCRUD<T, E> {
    public T insertar(T entidad);

    public T actualizar(T entidad);

    public void eliminar(E id);

    public T buscarPorId(E id);

    public ArrayList<T> mostrarTodos();
}
