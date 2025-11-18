/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import bd.Conexion;

/**
 *
 * @author matia
 */
public class Main {
    public static void main(String[] args) {
        Conexion cxn = new Conexion();
        
        cxn.obtenerConexion();
        
    }
}
