/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.bos;



/**
 *
 * @author usuario
 */

public class Cliente {

    public Cliente(String nombre, TipoDocumento tipoDocumento, String numeroDocumento, String pais, String departamento, String ciudadResidencia, String direccion, String profesion, String email, String telefonoResidencia, String telefonoCelular, Usuario usuario) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.pais = pais;
        this.departamento = departamento;
        this.ciudadResidencia = ciudadResidencia;
        this.direccion = direccion;
        this.profesion = profesion;
        this.email = email;
        this.telefonoResidencia = telefonoResidencia;
        this.telefonoCelular = telefonoCelular;
        this.usuario = usuario;
    }
      private String nombre;
      private TipoDocumento tipoDocumento;
      private String numeroDocumento;
      private String pais;
      private String departamento;
      private String ciudadResidencia;      
      private String direccion;            
      private String profesion;
      private String email;      
      private String telefonoResidencia;
      private String telefonoCelular;
      private Usuario usuario;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
      
      
    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }
    
      

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente()
    {
        this.usuario = new Usuario();
    }
    
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numerodocumento) {
        this.numeroDocumento = numerodocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefonoResidencia() {
        return telefonoResidencia;
    }

    public void setTelefonoResidencia(String telefonoResidencia) {
        this.telefonoResidencia = telefonoResidencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}