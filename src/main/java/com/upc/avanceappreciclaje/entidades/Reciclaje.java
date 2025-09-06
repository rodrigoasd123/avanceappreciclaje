package com.upc.avanceappreciclaje.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reciclaje")
public class Reciclaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reciclaje")
    private Long idReciclaje;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(nullable = false)
    private Double peso;

    // Por ahora como ids simples (sin relaciones) para calzar con tu estilo
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_materiales", nullable = false)
    private Long idMateriales;

    @Column(name = "id_acopio", nullable = false)
    private Long idAcopio;

    // getters & setters
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
