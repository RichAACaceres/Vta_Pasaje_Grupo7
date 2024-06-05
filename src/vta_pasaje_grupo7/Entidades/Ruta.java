
package vta_pasaje_grupo7.Entidades;

import java.time.LocalTime;


public class Ruta {
    
    private int idRuta;
    private String origen;
    private String destino;
    private LocalTime duracionEstima;
    private boolean estado;

    public Ruta() {
    }

    public Ruta(int idRuta, String origen, String destino, LocalTime duracionEstima, boolean estado) {
        this.idRuta = idRuta;
        this.origen = origen;
        this.destino = destino;
        this.duracionEstima = duracionEstima;
        this.estado = estado;
    }

    public Ruta(String origen, String destino, LocalTime duracionEstima, boolean estado) {
        this.origen = origen;
        this.destino = destino;
        this.duracionEstima = duracionEstima;
        this.estado = estado;
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

    public boolean isEstado() {
        return estado;
    }

   

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ruta{" + "idRuta=" + idRuta + ", origen=" + origen + ", destino=" + destino + ", duracionEstima=" + duracionEstima + ", estado=" + estado + '}';
    }

    
    
    
}
