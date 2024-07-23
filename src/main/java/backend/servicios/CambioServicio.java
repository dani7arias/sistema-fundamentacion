package backend.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import backend.conexion.ConexionDB;
import backend.consultas.CambioSQL;
import backend.entidades.Cambio;
import backend.interfaces.OperacionesCRUD;

public class CambioServicio extends ConexionDB implements OperacionesCRUD<Cambio, Integer> {
    protected PreparedStatement ps;
    protected ResultSet rs;

    public CambioServicio() {
        super();
    }

    @Override
    public Cambio insertar(Cambio entidad) {
        try {
            ps = super.abrirConexion().prepareStatement(CambioSQL.INSERTAR, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setString(3, entidad.getJustificacion());
            ps.setInt(4, entidad.getIdProyecto());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                entidad.setId(rs.getInt(1));
            }
            return entidad;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar cambio: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public Cambio actualizar(Cambio entidad) {
        try {
            ps = super.abrirConexion().prepareStatement(CambioSQL.ACTUALIZAR);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setString(3, entidad.getJustificacion());
            ps.setInt(4, entidad.getIdProyecto());
            ps.setInt(5, entidad.getId());
            ps.executeUpdate();
            return entidad;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cambio: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            ps = super.abrirConexion().prepareStatement(CambioSQL.ELIMINAR);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cambio: " + e.getMessage());
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public Cambio buscarPorId(Integer id) {
        Cambio cambio = null;
        try {
            ps = super.abrirConexion().prepareStatement(CambioSQL.OBTENER_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cambio = new Cambio(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
            return cambio;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar cambio por id: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public ArrayList<Cambio> mostrarTodos() {
        ArrayList<Cambio> cambios = new ArrayList<>();
        try {
            ps = super.abrirConexion().prepareStatement(CambioSQL.OBTENER_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cambio cambio = new Cambio(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5));
                cambios.add(cambio);
            }
            return cambios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener todos los cambios: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    public ArrayList<Cambio> obtenerPorProyecto(Integer idProyecto) {
        ArrayList<Cambio> cambios = new ArrayList<>();
        try {
            ps = super.abrirConexion().prepareStatement(CambioSQL.OBTENER_POR_PROYECTO);
            ps.setInt(1, idProyecto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cambio cambio = new Cambio(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5));
                cambios.add(cambio);
            }
            return cambios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener cambios por proyecto: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }
}
