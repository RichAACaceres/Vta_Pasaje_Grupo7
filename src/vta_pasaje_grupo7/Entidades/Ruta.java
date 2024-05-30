/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vta_pasaje_grupo7.Entidades;

import java.time.LocalTime;

/**
 *
 * @author Usuario
 */
public class Ruta {
    
    private int idRuta;
    private String origen;
    private String destino;
    private LocalTime duracionEstima;

    public Ruta() {
    }

    public Ruta(int idRuta, String origen, String destino, LocalTime duracionEstima) {
        this.idRuta = idRuta;
        this.origen = origen;
        this.destino = destino;
        this.duracionEstima = duracionEstima;
    }

    public Ruta(String origen, String destino, LocalTime duracionEstima) {
        this.origen = origen;
        this.destino = destino;
        this.duracionEstima = duracionEstima;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalTime getDuracionEstima() {
        return duracionEstima;
    }

    public void setDuracionEstima(LocalTime duracionEstima) {
        this.duracionEstima = duracionEstima;
    }

    @Override
    public String toString() {
        return "Ruta{" + "idRuta=" + idRuta + ", origen=" + origen + ", destino=" + destino + ", duracionEstima=" + duracionEstima + '}';
    }
    
    
}
