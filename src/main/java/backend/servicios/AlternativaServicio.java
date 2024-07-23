package backend.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import backend.conexion.ConexionDB;
import backend.consultas.AlternativaSQL;
import backend.entidades.Alternativa;
import backend.interfaces.OperacionesCRUD;

public class AlternativaServicio extends ConexionDB implements OperacionesCRUD<Alternativa, Integer> {
    protected PreparedStatement ps;
    protected ResultSet rs;

    public AlternativaServicio() {
        super();
    }

    @Override
    public Alternativa insertar(Alternativa entidad) {
        try {
            ps = super.abrirConexion().prepareStatement(AlternativaSQL.INSERTAR,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setString(3, entidad.getPros());
            ps.setString(4, entidad.getContras());
            ps.setDouble(5, entidad.getCosto());
            ps.setInt(6, entidad.getTiempoDeImplementacion());
            ps.setString(7, entidad.getCategoria());
            ps.setInt(8, entidad.getIdProyecto());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                entidad.setId(rs.getInt(1));
            }
            return entidad;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar alternativa: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public Alternativa actualizar(Alternativa entidad) {
        try {
            ps = super.abrirConexion().prepareStatement(AlternativaSQL.ACTUALIZAR);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setString(3, entidad.getPros());
            ps.setString(4, entidad.getContras());
            ps.setDouble(5, entidad.getCosto());
            ps.setInt(6, entidad.getTiempoDeImplementacion());
            ps.setString(7, entidad.getCategoria());
            ps.setInt(8, entidad.getIdProyecto());
            ps.setInt(9, entidad.getId());
            ps.executeUpdate();
            return entidad;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar alternativa: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            ps = super.abrirConexion().prepareStatement(AlternativaSQL.ELIMINAR);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar alternativa: " + e.getMessage());
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public Alternativa buscarPorId(Integer id) {
        Alternativa alternativa = null;
        try {
            ps = super.abrirConexion().prepareStatement(AlternativaSQL.OBTENER_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                alternativa = new Alternativa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
            }
            return alternativa;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar alternativa por id: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public ArrayList<Alternativa> mostrarTodos() {
        ArrayList<Alternativa> alternativas = new ArrayList<>();
        try {
            ps = super.abrirConexion().prepareStatement(AlternativaSQL.OBTENER_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alternativa alternativa = new Alternativa(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4),
                        rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
                alternativas.add(alternativa);
            }
            return alternativas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar alternativas: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    public ArrayList<Alternativa> listarPorProyecto(Integer idProyecto) {
        ArrayList<Alternativa> alternativas = new ArrayList<>();
        try {
            ps = super.abrirConexion().prepareStatement(AlternativaSQL.OBTENER_POR_ID_PROYECTO);
            ps.setInt(1, idProyecto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alternativa alternativa = new Alternativa(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4),
                        rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
                alternativas.add(alternativa);
            }
            return alternativas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar alternativas por proyecto: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

}
