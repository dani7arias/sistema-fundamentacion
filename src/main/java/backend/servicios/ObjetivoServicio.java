package backend.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import backend.conexion.ConexionDB;
import backend.consultas.ObjetivoSQL;
import backend.entidades.Objetivo;
import backend.interfaces.OperacionesCRUD;

public class ObjetivoServicio extends ConexionDB implements OperacionesCRUD<Objetivo, Integer> {

    protected PreparedStatement ps;
    protected ResultSet rs;

    public ObjetivoServicio() {
        super();
    }

    @Override
    public Objetivo insertar(Objetivo entidad) {
        try {
            ps = super.abrirConexion().prepareStatement(ObjetivoSQL.INSERTAR, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setInt(3, entidad.getIdProyecto());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                entidad.setId(rs.getInt(1));
            }
            return entidad;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar objetivo: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public Objetivo actualizar(Objetivo entidad) {
        try {
            ps = super.abrirConexion().prepareStatement(ObjetivoSQL.ACTUALIZAR);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setInt(3, entidad.getIdProyecto());
            ps.setInt(4, entidad.getId());
            ps.executeUpdate();
            return entidad;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar objetivo: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            ps = super.abrirConexion().prepareStatement(ObjetivoSQL.ELIMINAR);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar objetivo: " + e.getMessage());
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public Objetivo buscarPorId(Integer id) {
        Objetivo objetivo = null;
        try {
            ps = super.abrirConexion().prepareStatement(ObjetivoSQL.OBTENER_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                objetivo = new Objetivo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            return objetivo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar objetivo por ID: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public ArrayList<Objetivo> mostrarTodos() {
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        try {
            ps = super.abrirConexion().prepareStatement(ObjetivoSQL.OBTENER_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Objetivo objetivo = new Objetivo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                objetivos.add(objetivo);
            }
            return objetivos;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar todos los objetivos: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    public ArrayList<Objetivo> mostrarPorProyecto(Integer idProyecto) {
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        try {
            ps = super.abrirConexion().prepareStatement(ObjetivoSQL.OBTENER_POR_PROYECTO);
            ps.setInt(1, idProyecto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Objetivo objetivo = new Objetivo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                objetivos.add(objetivo);
            }
            return objetivos;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar objetivos por proyecto: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

}
