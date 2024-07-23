package backend.consultas;

public class UsuarioSQL {
    public static final String INSERTAR = "INSERT INTO Usuarios (nombre, telefono, password, acceso) VALUES (?, ?, ?, ?)";
    public static final String ACTUALIZAR = "UPDATE Usuarios SET nombre = ?, telefono = ?, password = ?, acceso = ? WHERE id = ?";
    public static final String ELIMINAR = "DELETE FROM Usuarios WHERE id = ?";
    public static final String OBTENER_POR_ID = "SELECT * FROM Usuarios WHERE id = ?";
    public static final String OBTENER_TODOS = "SELECT * FROM Usuarios";
    public static final String OBTENER_POR_NOMBRE = "SELECT * FROM Usuarios WHERE nombre = ?";
    public static final String VALIDAR_USUARIO = "SELECT * FROM Usuarios WHERE nombre = ? AND password = ?";
}
