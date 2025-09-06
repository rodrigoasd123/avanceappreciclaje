package com.upc.avanceappreciclaje.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReciclajeDTO {
    private Long idReciclaje;
    private LocalDate fecha;
    private LocalTime hora;
    private Double peso;
    private Long idUsuario;
    private Long idMateriales;
    private Long idAcopio;

    public Long getIdReciclaje() { return idReciclaje; }
    public void setIdReciclaje(Long idReciclaje) { this.idReciclaje = idReciclaje; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public Long getIdMateriales() { return idMateriales; }
    public void setIdMateriales(Long idMateriales) { this.idMateriales = idMateriales; }
    public Long getIdAcopio() { return idAcopio; }
    public void setIdAcopio(Long idAcopio) { this.idAcopio = idAcopio; }
}
