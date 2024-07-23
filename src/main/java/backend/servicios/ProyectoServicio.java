package backend.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import backend.conexion.ConexionDB;
import backend.consultas.ProyectoSQL;
import backend.entidades.Proyecto;
import backend.interfaces.OperacionesCRUD;

public class ProyectoServicio extends ConexionDB implements OperacionesCRUD<Proyecto, Integer> {
    protected PreparedStatement ps;
    protected ResultSet rs;

    public ProyectoServicio() {
        super();
    }

    @Override
    public Proyecto insertar(Proyecto entidad) {
        try {
            ps = super.abrirConexion().prepareStatement(ProyectoSQL.INSERTAR, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setInt(3, entidad.getIdUsuario());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                entidad.setId(rs.getInt(1));
            }
            return entidad;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar proyecto: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public Proyecto actualizar(Proyecto entidad) {
        try {
            ps = super.abrirConexion().prepareStatement(ProyectoSQL.ACTUALIZAR);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setInt(3, entidad.getIdUsuario());
            ps.setInt(4, entidad.getId());
            ps.executeUpdate();
            return entidad;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar proyecto: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            ps = super.abrirConexion().prepareStatement(ProyectoSQL.ELIMINAR);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar proyecto: " + e.getMessage());
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public Proyecto buscarPorId(Integer id) {
        Proyecto proyecto = null;
        try {
            ps = super.abrirConexion().prepareStatement(ProyectoSQL.OBTENER_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                proyecto = new Proyecto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            return proyecto;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar proyecto por id: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }

    }

    @Override
    public ArrayList<Proyecto> mostrarTodos() {
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        try {
            ps = super.abrirConexion().prepareStatement(ProyectoSQL.OBTENER_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                proyectos.add(new Proyecto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            return proyectos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener todos los proyectos: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    public ArrayList<Proyecto> obtenerPorIdUsuario(Integer idUsuario) {
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        try {
            ps = super.abrirConexion().prepareStatement(ProyectoSQL.OBTENER_POR_ID_USUARIO);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                proyectos.add(new Proyecto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            return proyectos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener proyectos por id de usuario: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }
}
