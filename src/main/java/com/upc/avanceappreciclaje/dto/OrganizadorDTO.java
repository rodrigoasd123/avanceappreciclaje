package com.upc.avanceappreciclaje.dto;

public class OrganizadorDTO {
    private Long idOrganizador;
    private String nombre;

    // Constructores
    public OrganizadorDTO() {}

    // Getters y Setters
    public Long getIdOrganizador() { return idOrganizador; }
    public void setIdOrganizador(Long idOrganizador) { this.idOrganizador = idOrganizador; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}