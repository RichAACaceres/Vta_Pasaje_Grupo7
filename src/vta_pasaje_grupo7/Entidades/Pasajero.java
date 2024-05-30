/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vta_pasaje_grupo7.Entidades;

/**
 *
 * @author Usuario
 */
public class Pasajero {
    
    private int idPasajero;
    private String nombre;
    private String apellido;
    private int dni;
    private String email;
    private int telefono;

    public Pasajero() {
    }

    public Pasajero(int idPasajero, String nombre, String apellido, int dni, String email, int telefono) {
        this.idPasajero = idPasajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

    public Pasajero(String nombre, String apellido, int dni, String email, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Pasajero{" + "idPasajero=" + idPasajero + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
    
    
}