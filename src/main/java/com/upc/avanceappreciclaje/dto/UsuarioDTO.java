package com.upc.avanceappreciclaje.dto;

public class UsuarioDTO {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena; // Agregado para consistencia con la entidad
    private Double pesoRecolectado;
    private Integer puntos;

    // Getters y Setters
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public Double getPesoRecolectado() { return pesoRecolectado; }
    public void setPesoRecolectado(Double pesoRecolectado) { this.pesoRecolectado = pesoRecolectado; }

    public Integer getPuntos() { return puntos; }
    public void setPuntos(Integer puntos) { this.puntos = puntos; }
}