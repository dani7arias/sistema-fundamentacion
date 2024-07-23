package backend.consultas;

public class ObjetivoSQL {
    public static final String INSERTAR = "INSERT INTO Objetivos (nombre, descripcion, idProyecto) VALUES (?, ?, ?)";
    public static final String ACTUALIZAR = "UPDATE Objetivos SET nombre = ?, descripcion = ?, idProyecto = ? WHERE id = ?";
    public static final String ELIMINAR = "DELETE FROM Objetivos WHERE id = ?";
    public static final String OBTENER_POR_ID = "SELECT * FROM Objetivos WHERE id = ?";
    public static final String OBTENER_TODOS = "SELECT * FROM Objetivos";
    public static final String OBTENER_POR_PROYECTO = "SELECT * FROM Objetivos WHERE idProyecto = ?";
}
