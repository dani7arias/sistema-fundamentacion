package backend.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import backend.conexion.ConexionDB;
import backend.consultas.UsuarioSQL;
import backend.entidades.Usuario;
import backend.interfaces.OperacionesCRUD;

public class UsuarioServicio extends ConexionDB implements OperacionesCRUD<Usuario, Integer> {
    protected PreparedStatement ps;
    protected ResultSet rs;

    public UsuarioServicio() {
        super();
    }

    @Override
    public Usuario insertar(Usuario entidad) {
        try {
            ps = super.abrirConexion().prepareStatement(UsuarioSQL.INSERTAR, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, entidad.getNombre());
            ps.setInt(2, entidad.getTelefono());
            ps.setString(3, entidad.getPassword());
            ps.setBoolean(4, entidad.getAcceso());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                entidad.setId(rs.getInt(1));
            }
            return entidad;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar usuario: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public Usuario actualizar(Usuario entidad) {
        try {
            ps = super.abrirConexion().prepareStatement(UsuarioSQL.ACTUALIZAR);
            ps.setString(1, entidad.getNombre());
            ps.setInt(2, entidad.getTelefono());
            ps.setString(3, entidad.getPassword());
            ps.setBoolean(4, entidad.getAcceso());
            ps.setInt(5, entidad.getId());
            ps.executeUpdate();
            return entidad;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            ps = super.abrirConexion().prepareStatement(UsuarioSQL.ELIMINAR);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        try {
            ps = super.abrirConexion().prepareStatement(UsuarioSQL.OBTENER_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Usuario usuario = null;
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setTelefono(rs.getInt(3));
                usuario.setPassword(rs.getString(4));
                usuario.setAcceso(rs.getBoolean(5));
            }
            return usuario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuario por id: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    @Override
    public ArrayList<Usuario> mostrarTodos() {
        try {
            ps = super.abrirConexion().prepareStatement(UsuarioSQL.OBTENER_TODOS);
            rs = ps.executeQuery();
            ArrayList<Usuario> usuarios = new ArrayList<>();
            Usuario usuario;
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setTelefono(rs.getInt(3));
                usuario.setPassword(rs.getString(4));
                usuario.setAcceso(rs.getBoolean(5));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar todos los usuarios: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

    public Boolean validarUsuario(String nombre, String password) {
        try {
            ps = super.abrirConexion().prepareStatement(UsuarioSQL.VALIDAR_USUARIO);
            ps.setString(1, nombre);
            ps.setString(2, password);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al validar usuario: " + e.getMessage());
            return false;
        } finally {
            super.cerrarConexion();
        }
    }

    public Usuario buscarPorNombre(String nombre) {
        try {
            ps = super.abrirConexion().prepareStatement(UsuarioSQL.OBTENER_POR_NOMBRE);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            Usuario usuario = null;
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setTelefono(rs.getInt(3));
                usuario.setPassword(rs.getString(4));
                usuario.setAcceso(rs.getBoolean(5));
            }
            return usuario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuario por nombre: " + e.getMessage());
            return null;
        } finally {
            super.cerrarConexion();
        }
    }

}
