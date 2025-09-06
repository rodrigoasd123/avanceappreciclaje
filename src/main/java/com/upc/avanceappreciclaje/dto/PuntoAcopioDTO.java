package com.upc.avanceappreciclaje.dto;

public class PuntoAcopioDTO {
    private Long idAcopio;
    private String nombre;
    private String ubicacion;

    // Constructores
    public PuntoAcopioDTO() {}

    // Getters y Setters
    public Long getIdAcopio() { return idAcopio; }
    public void setIdAcopio(Long idAcopio) { this.idAcopio = idAcopio; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}