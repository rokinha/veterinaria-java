package controlador;

import bd.Conexion;
import modelo.Mascota;
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
public class MascotaRegistro {

    public boolean agregar(Mascota mascota) {
        try {
            Conexion con = new Conexion();
            Connection cxn = con.obtenerConexion();

            String query = "INSERT INTO mascota(nombre,especie,raza,edad,id_dueno)VALUES(?,?,?,?,?)";

            PreparedStatement stmt = cxn.prepareStatement(query);

            stmt.setString(1, mascota.getNombre());
            stmt.setString(2, mascota.getEspecie());
            stmt.setString(3, mascota.getRaza());
            stmt.setInt(4, mascota.getEdad());
            stmt.setInt(5, mascota.getId_dueno());

            stmt.executeUpdate();
            stmt.close();
            cxn.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al agregar la mascota: " + e.getMessage());
            return false;
        }

    }

    public List<Mascota> buscarTodos() {
        List<Mascota> lista = new ArrayList();

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = ("SELECT * FROM mascota order by nombre");
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setId_mascota(rs.getInt("id_mascota"));
                mascota.setNombre(rs.getString("nombre"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setEdad(rs.getInt("edad"));
                mascota.setId_dueno(rs.getInt("id_dueno"));

                lista.add(mascota);

            }
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error al listar las mascotas" + e.getMessage());
        }
        return lista;

    }

    public Mascota buscarPorId(int id_mascota) {
        Mascota mascota = null;

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = ("SELECT * FROM mascota where id_mascota = ?");

            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_mascota);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                mascota = new Mascota();
                mascota.setId_mascota(rs.getInt("id_mascota"));
                mascota.setNombre(rs.getString("nombre"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setEdad(rs.getInt("edad"));
                mascota.setId_dueno(rs.getInt("id_dueno"));

            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar la mascota" + e.getMessage());
        }
        return mascota;

    }

    public boolean actualizar(Mascota mascota) {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = ("UPDATE mascota SET nombre=?,especie=?,raza=?,edad=?,id_dueno=? WHERE id_mascota=?");
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setString(1, mascota.getNombre());
            stmt.setString(2, mascota.getEspecie());
            stmt.setString(3, mascota.getRaza());
            stmt.setInt(4, mascota.getEdad());
            stmt.setInt(5, mascota.getId_dueno());
            stmt.setInt(6, mascota.getId_mascota());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar la mascota" + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id_mascota) {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = ("DELETE FROM mascota WHERE id_mascota = ?");
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_mascota);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la mascota" + e.getMessage());
            return false;
        }
    }

    public List<Mascota> buscarPorNombre(String nombre) {
        List<Mascota> lista = new ArrayList<>();

        try {
            Conexion con = new Conexion();
            Connection cxn = con.obtenerConexion();

            String sql = "SELECT * FROM mascota WHERE nombre LIKE ?";
            PreparedStatement stmt = cxn.prepareStatement(sql);
            stmt.setString(1, "%" + nombre + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Mascota m = new Mascota();
                m.setId_mascota(rs.getInt("id_mascota"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));
                m.setEdad(rs.getInt("edad"));
                m.setId_dueno(rs.getInt("id_dueno"));

                lista.add(m);
            }

            rs.close();
            stmt.close();
            cxn.close();

        } catch (SQLException e) {
            System.out.println("Error en buscarPorNombre Mascota: " + e.getMessage());
        }

        return lista;
    }
}
