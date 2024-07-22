package backend.consultas;

public class ProyectoDeUsuarioSQL {
    public static final String INSERTAR = "INSERT INTO proyecto_de_usuario (id_proyecto, id_usuario) VALUES (?, ?)";
    public static final String ACTUALIZAR = "UPDATE proyecto_de_usuario SET id_proyecto = ?, id_usuario = ? WHERE id = ?";
    public static final String ELIMINAR = "DELETE FROM proyecto_de_usuario WHERE id = ?";
    public static final String BUSCAR_POR_ID = "SELECT * FROM proyecto_de_usuario WHERE id = ?";
    public static final String MOSTRAR_TODOS = "SELECT * FROM proyecto_de_usuario";
    public static final String OBTENER_POR_ID_PROYECTO = "SELECT * FROM proyecto_de_usuario WHERE id_proyecto = ?";
    public static final String OBTENER_POR_ID_USUARIO = "SELECT * FROM proyecto_de_usuario WHERE id_usuario = ?";
}
