
package modelo;

/**
 *  Matias Posada
 *  @version 12/11/2025
 */
public class Dueno {
    private int id_dueno;
    private String rut; 
    private String nombre;
    private String telefono;
    private String direccion;

    public Dueno() {
    }

    public Dueno(int id_dueno, String rut, String nombre, String telefono, String direccion) {
        this.id_dueno = id_dueno;
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId_dueno() {
        return id_dueno;
    }

    public void setId_dueno(int id_dueno) {
        this.id_dueno = id_dueno;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Dueno{" + "id_dueno=" + id_dueno + ", rut=" + rut + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
    
    
    
}
