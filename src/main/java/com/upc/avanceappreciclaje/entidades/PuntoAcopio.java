package com.upc.avanceappreciclaje.entidades;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "punto_acopio")
public class PuntoAcopio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acopio")
    private Long idAcopio;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String ubicacion;

    // Constructores
    public PuntoAcopio() {}

    // Getters y Setters
    public Long getIdAcopio() { return idAcopio; }
    public void setIdAcopio(Long idAcopio) { this.idAcopio = idAcopio; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}