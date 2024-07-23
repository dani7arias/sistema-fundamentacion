package backend.consultas;

public class CambioSQL {
    public static final String INSERTAR = "INSERT INTO cambios (nombre, descripcion, justificacion, idProyecto) VALUES (?, ?, ?, ?)";
    public static final String ACTUALIZAR = "UPDATE cambios SET nombre = ?, descripcion = ?, justificacion = ?, idProyecto = ? WHERE id = ?";
    public static final String ELIMINAR = "DELETE FROM cambios WHERE id = ?";
    public static final String OBTENER_POR_ID = "SELECT * FROM cambios WHERE id = ?";
    public static final String OBTENER_TODOS = "SELECT * FROM cambios";
    public static final String OBTENER_POR_PROYECTO = "SELECT * FROM cambios WHERE idProyecto = ?";
}
