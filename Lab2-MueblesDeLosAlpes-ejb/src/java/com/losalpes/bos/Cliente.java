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
/**
 * Objeto que reprenta a un cliente en el sistema
 * @author usuario
 */
public class Cliente {
    
    /**
     * Constructir de la clase con parametros
     * @param nombre
     * @param tipoDocumento
     * @param numeroDocumento
     * @param pais
     * @param departamento
     * @param ciudadResidencia
     * @param direccion
     * @param profesion
     * @param email
     * @param telefonoResidencia
     * @param telefonoCelular
     * @param usuario 
     */
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

      /**
       * optiene el pais
       * @return 
       */
    public String getPais() {
        return pais;
    }

    /**
     * adiciona el pais
     * @param pais 
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
      
      /**
       * optiene el telefono celular
       * @return 
       */
    public String getTelefonoCelular() {
        return telefonoCelular;
    }
/**
 * adiciona el telefono celular
 * @param telefonoCelular 
 */
    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }
    
      
/**
 * obtiene el usuario
 * @return 
 */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * adiciona el usuario
     * @param usuario 
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Consturctor sin parametrode de la clase
     */
    public Cliente()
    {
        this.usuario = new Usuario();
    }
    
    /**
     * obtiene el tipo de documento
     * @return 
     */
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }
/**
 * adiciona el tipo de documento
 * @param tipoDocumento 
 */
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * obtiene el nuemro del documento
     * @return 
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * aiciona el nuemro del documento
     * @param numerodocumento 
     */
    public void setNumeroDocumento(String numerodocumento) {
        this.numeroDocumento = numerodocumento;
    }

    /**
     * obtien el nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
/**
 * adiciona el nombre
 * @param nombre 
 */
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