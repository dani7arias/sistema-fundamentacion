package backend.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionDB {
    protected Connection CONEXION;
    protected String DB;
    protected String HOST;
    protected String PORT;
    protected String URL;
    protected String USER;
    protected String PASSWORD;

    public ConexionDB() {
        this.DB = "sistemaDeFundamentacion";
        this.HOST = "localhost";
        this.PORT = "3306";
        this.URL = "jdbc:mysql://" + this.HOST + ":" + this.PORT + "/" + this.DB;
        this.USER = "root";
        this.PASSWORD = "admin";
    }

    protected Connection abrirConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.CONEXION = java.sql.DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
            return this.CONEXION;
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }

    protected void cerrarConexion() {
        try {
            this.CONEXION.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión a la base de datos: " + e.getMessage());
        }
    }
}
