package backend.consultas;

public class UsuarioSQL {
    public static final String INSERTAR = "INSERT INTO Usuarios (nombre, telefono, password) VALUES (?, ?, ?)";
    public static final String ACTUALIZAR = "UPDATE Usuarios SET nombre = ?, telefono = ?, password = ? WHERE id = ?";
    public static final String ELIMINAR = "DELETE FROM Usuarios WHERE id = ?";
    public static final String OBTENER_POR_ID = "SELECT * FROM Usuarios WHERE id = ?";
    public static final String OBTENER_TODOS = "SELECT * FROM Usuarios";
    public static final String OBTENER_POR_NOMBRE = "SELECT * FROM Usuarios WHERE nombre = ?";
    public static final String OBTENER_POR_TELEFONO = "SELECT * FROM Usuarios WHERE telefono = ?";
    public static final String VALIDAR_USUARIO = "SELECT * FROM Usuarios WHERE nombre = ? AND password = ?";
}
