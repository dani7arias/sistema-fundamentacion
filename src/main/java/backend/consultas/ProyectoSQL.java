package backend.consultas;

public class ProyectoSQL {
    public static final String INSERTAR = "INSERT INTO Proyectos (nombre, descripcion, idUsuario) VALUES (?, ?, ?)";
    public static final String ACTUALIZAR = "UPDATE Proyectos SET nombre = ?, descripcion = ?, idUsuario = ? WHERE id = ?";
    public static final String ELIMINAR = "DELETE FROM Proyectos WHERE id = ?";
    public static final String OBTENER_POR_ID = "SELECT * FROM Proyectos WHERE id = ?";
    public static final String OBTENER_TODOS = "SELECT * FROM Proyectos";
    public static final String OBTENER_POR_NOMBRE = "SELECT * FROM Proyectos WHERE nombre = ?";
    public static final String OBTENER_POR_ID_USUARIO = "SELECT * FROM Proyectos WHERE idUsuario = ?";
}
