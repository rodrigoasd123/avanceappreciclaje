package com.upc.avanceappreciclaje.entidades;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "organizador")
public class Organizador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_organizador")
    private Long idOrganizador;

    @Column(nullable = false, length = 100)
    private String nombre;

    // Constructores
    public Organizador() {}

    // Getters y Setters
    public Long getIdOrganizador() { return idOrganizador; }
    public void setIdOrganizador(Long idOrganizador) { this.idOrganizador = idOrganizador; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}