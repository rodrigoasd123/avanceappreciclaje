package com.upc.avanceappreciclaje.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventoDTO {
    private Long idEvento;
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String lugar;
    private String descripcion;
    private Long idOrganizador;

    // Constructores
    public EventoDTO() {}

    // Getters y Setters
    public Long getIdEvento() { return idEvento; }
    public void setIdEvento(Long idEvento) { this.idEvento = idEvento; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Long getIdOrganizador() { return idOrganizador; }
    public void setIdOrganizador(Long idOrganizador) { this.idOrganizador = idOrganizador; }
}