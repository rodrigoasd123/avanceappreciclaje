package com.upc.avanceappreciclaje.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "canje")
public class Canje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_canje")
    private Long idCanje;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Integer costo;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_recompensa", nullable = false)
    private Long idRecompensa;

    // Constructores
    public Canje() {}

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