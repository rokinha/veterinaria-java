package controlador;

import bd.Conexion;
import modelo.Dueno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 * Matias Posada
 *
 * @version 12/11/2025
 */
public class DuenoRegistro {

    public boolean agregar(Dueno dueno) {
        try {
            Conexion con = new Conexion();
            Connection cxn = con.obtenerConexion();

            String query = "INSERT INTO dueno(rut,nombre,telefono,direccion)VALUES(?,?,?,?)";

            PreparedStatement stmt = cxn.prepareStatement(query);

            stmt.setString(1, dueno.getRut());
            stmt.setString(2, dueno.getNombre());
            stmt.setString(3, dueno.getTelefono());
            stmt.setString(4, dueno.getDireccion());

            stmt.executeUpdate();
            stmt.close();
            cxn.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al agregar dueño: " + e.getMessage());
            return false;
        }

    }

    public List<Dueno> buscarTodos() {
        List<Dueno> lista = new ArrayList();

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = ("SELECT * FROM dueno order by id_dueno");
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Dueno dueno = new Dueno();
                dueno.setId_dueno(rs.getInt("id_dueno"));
                dueno.setRut(rs.getString("rut"));
                dueno.setNombre(rs.getString("nombre"));
                dueno.setDireccion(rs.getString("direccion"));
                dueno.setTelefono(rs.getString("telefono"));

                lista.add(dueno);

            }
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error al listar los dueños" + e.getMessage());
        }
        return lista;

    }

    public Dueno buscarPorId(int id_dueno) {
        Dueno dueno = null;

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = ("SELECT * FROM dueno where id_dueno = ?");

            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_dueno);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dueno = new Dueno();
                dueno.setId_dueno(rs.getInt("id_dueno"));
                dueno.setRut(rs.getString("rut"));
                dueno.setNombre(rs.getString("nombre"));
                dueno.setDireccion(rs.getString("direccion"));
                dueno.setTelefono(rs.getString("telefono"));

            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar el dueño" + e.getMessage());
        }
        return dueno;

    }

    public boolean actualizar(Dueno dueno) {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = ("UPDATE dueno SET rut=?,nombre=?,telefono=?,direccion=? WHERE id_dueno=?");
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setString(1, dueno.getRut());
            stmt.setString(2, dueno.getNombre());
            stmt.setString(3, dueno.getTelefono());
            stmt.setString(4, dueno.getDireccion());
            stmt.setInt(5, dueno.getId_dueno());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar el dueño" + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id_dueno) {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = ("DELETE FROM dueno WHERE id_dueno = ?");
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_dueno);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el dueño" + e.getMessage());
            return false;
        }
    }

    public List<Dueno> buscarPorNombre(String nombre) {
        List<Dueno> lista = new ArrayList<>();

        try {
            Conexion con = new Conexion();
            Connection cxn = con.obtenerConexion();

            String sql = "SELECT * FROM dueno WHERE nombre LIKE ?";
            PreparedStatement stmt = cxn.prepareStatement(sql);
            stmt.setString(1, "%" + nombre + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Dueno d = new Dueno();
                d.setId_dueno(rs.getInt("id_dueno"));
                d.setRut(rs.getString("rut"));
                d.setNombre(rs.getString("nombre"));
                d.setTelefono(rs.getString("telefono"));
                d.setDireccion(rs.getString("direccion"));

                lista.add(d);
            }

            rs.close();
            stmt.close();
            cxn.close();

        } catch (SQLException e) {
            System.out.println("Error en buscarPorNombre Dueno: " + e.getMessage());
        }

        return lista;
    }
}
