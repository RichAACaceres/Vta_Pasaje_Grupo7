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
public class Horario {
    
    private int idHorario;
    private Ruta ruta;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;

    public Horario() {
    }

    public Horario(int idHorario, Ruta ruta, LocalTime horaSalida, LocalTime horaLlegada) {
        this.idHorario = idHorario;
        this.ruta = ruta;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public Horario(Ruta ruta, LocalTime horaSalida, LocalTime horaLlegada) {
        this.ruta = ruta;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    @Override
    public String toString() {
        return "Horario{" + "idHorario=" + idHorario + ", ruta=" + ruta + ", horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada + '}';
    }
    
    
    
}
