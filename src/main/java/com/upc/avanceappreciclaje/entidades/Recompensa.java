package com.upc.avanceappreciclaje.entidades;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recompensa")
public class Recompensa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recompensa")
    private Long idRecompensa;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(nullable = false)
    private Integer requisito;

    // Constructores
    public Recompensa() {}

    // Getters y Setters
    public Long getIdRecompensa() { return idRecompensa; }
    public void setIdRecompensa(Long idRecompensa) { this.idRecompensa = idRecompensa; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getRequisito() { return requisito; }
    public void setRequisito(Integer requisito) { this.requisito = requisito; }
}