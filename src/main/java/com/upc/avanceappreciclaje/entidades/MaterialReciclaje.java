package com.upc.avanceappreciclaje.entidades;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "material_reciclaje")
public class MaterialReciclaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materiales")
    private Long idMateriales;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    // Constructores
    public MaterialReciclaje() {}

    // Getters y Setters
    public Long getIdMateriales() { return idMateriales; }
    public void setIdMateriales(Long idMateriales) { this.idMateriales = idMateriales; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}