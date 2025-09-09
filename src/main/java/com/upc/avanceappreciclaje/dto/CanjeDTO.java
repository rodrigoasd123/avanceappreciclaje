package com.upc.avanceappreciclaje.dto;

import java.time.LocalDate;

public class CanjeDTO {
    private Long idCanje;
    private LocalDate fecha;
    private Integer costo;
    private Long idUsuario;
    private Long idRecompensa;

    // Constructores
    public CanjeDTO() {}

    // Getters y Setters
    public Long getIdCanje() { return idCanje; }
    public void setIdCanje(Long idCanje) { this.idCanje = idCanje; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Integer getCosto() { return costo; }
    public void setCosto(Integer costo) { this.costo = costo; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getIdRecompensa() { return idRecompensa; }
    public void setIdRecompensa(Long idRecompensa) { this.idRecompensa = idRecompensa; }
}