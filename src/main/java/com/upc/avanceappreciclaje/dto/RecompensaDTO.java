package com.upc.avanceappreciclaje.dto;

public class RecompensaDTO {
    private Long idRecompensa;
    private String descripcion;
    private Integer requisito;

    // Constructores
    public RecompensaDTO() {}

    // Getters y Setters
    public Long getIdRecompensa() { return idRecompensa; }
    public void setIdRecompensa(Long idRecompensa) { this.idRecompensa = idRecompensa; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getRequisito() { return requisito; }
    public void setRequisito(Integer requisito) { this.requisito = requisito; }
}