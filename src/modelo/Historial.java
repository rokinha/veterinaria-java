package modelo;

import java.util.Date;

/**
 * Matias Posada
 *
 * @version 12/11/2025
 */
public class Historial {

    private int id_historial;
    private Date fecha;
    private String motivo;
    private String diagnostico;
    private String tratamiento;
    private int id_mascota;
    private String nombreMascota;

    public Historial() {
    }

    public Historial(int id_historial, Date fecha, String motivo, String diagnostico, String tratamiento, int id_mascota) {
        this.id_historial = id_historial;
        this.fecha = fecha;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.id_mascota = id_mascota;
    }

    public int getId_historial() {
        return id_historial;
    }

    public void setId_historial(int id_historial) {
        this.id_historial = id_historial;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    @Override
    public String toString() {
        return "Historial{" + "id_historial=" + id_historial + ", fecha=" + fecha + ", motivo=" + motivo + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", id_mascota=" + id_mascota + ", nombreMascota=" + nombreMascota + '}';
    }

   
}
