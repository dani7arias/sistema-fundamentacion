package backend.consultas;

public class AlternativaSQL {
    public static final String INSERTAR = "INSERT INTO alternativas (nombre, descripcion, pros, contras, costo, tiempoDeImplementacion, categoria, idProyecto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String ACTUALIZAR = "UPDATE alternativas SET nombre = ?, descripcion = ?, pros = ?, contras = ?, costo = ?, tiempoDeImplementacion = ?, categoria = ?, idProyecto = ? WHERE id = ?";
    public static final String ELIMINAR = "DELETE FROM alternativas WHERE id = ?";
    public static final String OBTENER_POR_ID = "SELECT * FROM alternativas WHERE id = ?";
    public static final String OBTENER_TODOS = "SELECT * FROM alternativas";
    public static final String OBTENER_POR_NOMBRE = "SELECT * FROM alternativas WHERE nombre = ?";
    public static final String OBTENER_POR_DESCRIPCION = "SELECT * FROM alternativas WHERE descripcion = ?";
    public static final String OBTENER_POR_PROS = "SELECT * FROM alternativas WHERE pros = ?";
    public static final String OBTENER_POR_CONTRAS = "SELECT * FROM alternativas WHERE contras = ?";
    public static final String OBTENER_POR_COSTO = "SELECT * FROM alternativas WHERE costo = ?";
    public static final String OBTENER_POR_TIEMPO_DE_IMPLEMENTACION = "SELECT * FROM alternativas WHERE tiempoDeImplementacion = ?";
    public static final String OBTENER_POR_CATEGORIA = "SELECT * FROM alternativas WHERE categoria = ?";
    public static final String OBTENER_POR_ID_PROYECTO = "SELECT * FROM alternativas WHERE idProyecto = ?";
}
