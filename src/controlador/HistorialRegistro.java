package controlador;

import bd.Conexion;
import modelo.Historial;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Matias Posada
 *
 * @version 12/11/2025
 */
public class HistorialRegistro {

    public boolean agregar(Historial historial) {

        Date date;
        try {
            Conexion con = new Conexion();
            Connection cxn = con.obtenerConexion();

            date = historial.getFecha();

            String query = "INSERT INTO historial(fecha,motivo,diagnostico,tratamiento,id_mascota)VALUES(?,?,?,?,?)";

            PreparedStatement stmt = cxn.prepareStatement(query);

            stmt.setDate(1, new java.sql.Date(date.getTime()));
            stmt.setString(2, historial.getMotivo());
            stmt.setString(3, historial.getDiagnostico());
            stmt.setString(4, historial.getTratamiento());
            stmt.setInt(5, historial.getId_mascota());

            stmt.executeUpdate();
            stmt.close();
            cxn.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al agregar el historial: " + e.getMessage());
            return false;
        }

    }

    public List<Historial> buscarTodos() {
        List<Historial> lista = new ArrayList();

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = ("SELECT * FROM historial order by fecha");
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Historial historial = new Historial();
                historial.setId_historial(rs.getInt("id_historial"));
                historial.setFecha(rs.getDate("fecha"));
                historial.setMotivo(rs.getString("motivo"));
                historial.setDiagnostico(rs.getString("diagnostico"));
                historial.setTratamiento(rs.getString("tratamiento"));
                historial.setId_mascota(rs.getInt("id_mascota"));

                lista.add(historial);

            }
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error al listar los historiales" + e.getMessage());
        }
        return lista;

    }

    public Historial buscarPorId(int id_historial) {
        Historial historial = null;

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = ("SELECT * FROM historial where id_historial = ?");

            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_historial);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                historial = new Historial();
                historial.setId_historial(rs.getInt("id_historial"));
                historial.setFecha(rs.getDate("fecha"));
                historial.setMotivo(rs.getString("motivo"));
                historial.setDiagnostico(rs.getString("diagnostico"));
                historial.setTratamiento(rs.getString("tratamiento"));
                historial.setId_mascota(rs.getInt("id_mascota"));

            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar la mascota" + e.getMessage());
        }
        return historial;

    }

    public boolean actualizar(Historial historial) {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = ("UPDATE historial SET fecha=?,motivo=?,diagnostico=?,tratamiento=?,id_mascota=? WHERE id_historial=?");
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setDate(1, new java.sql.Date(historial.getFecha().getTime()));
            stmt.setString(2, historial.getMotivo());
            stmt.setString(3, historial.getDiagnostico());
            stmt.setString(4, historial.getTratamiento());
            stmt.setInt(5, historial.getId_mascota());
            stmt.setInt(6, historial.getId_historial());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar el historial" + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id_historial) {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = ("DELETE FROM historial WHERE id_historial = ?");
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_historial);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el historial" + e.getMessage());
            return false;
        }
    }

    public List<Historial> buscarPorNombreMascota(String nombreMascota) {
        List<Historial> lista = new ArrayList<>();

        try {
            Conexion con = new Conexion();
            Connection cxn = con.obtenerConexion();

            String sql = """
            SELECT h.*, m.nombre AS mascota_nombre
            FROM historial h
            JOIN mascota m ON h.id_mascota = m.id_mascota
            WHERE m.nombre LIKE ?
        """;

            PreparedStatement stmt = cxn.prepareStatement(sql);
            stmt.setString(1, "%" + nombreMascota + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Historial h = new Historial();
                h.setId_historial(rs.getInt("id_historial"));
                h.setFecha(rs.getDate("fecha"));
                h.setMotivo(rs.getString("motivo"));
                h.setDiagnostico(rs.getString("diagnostico"));
                h.setTratamiento(rs.getString("tratamiento"));
                h.setId_mascota(rs.getInt("id_mascota"));

                // OPCIONAL: mostrar nombre de mascota
                h.setNombreMascota(rs.getString("mascota_nombre"));
                // Si quieres esto, te agrego el atributo ahora

                lista.add(h);
            }

            rs.close();
            stmt.close();
            cxn.close();

        } catch (SQLException e) {
            System.out.println("Error buscando historial por nombre mascota: " + e.getMessage());
        }

        return lista;
    }

}
