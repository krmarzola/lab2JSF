/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.bos;

import java.util.ArrayList;



/**
 *
 * @author usuario
 */

public class Cliente {

      private String tipoDocumento;
      private String numerodocumento;
      private String nombre;
      private String telefonoResidencia;
      private String direccion;
      private String ciudadResidencia;
      private String departamento;
      private String profesion;
      private String email;
      private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
      private ArrayList<Compra> listaCompras; 

    public Cliente(String tipoDocumento, String numerodocumento, String nombre, String telefonoResidencia, String direccion, String ciudadResidencia, String departamento, String profesion, String email, Usuario usuario) {
        this.tipoDocumento = tipoDocumento;
        this.numerodocumento = numerodocumento;
        this.nombre = nombre;
        this.telefonoResidencia = telefonoResidencia;
        this.direccion = direccion;
        this.ciudadResidencia = ciudadResidencia;
        this.departamento = departamento;
        this.profesion = profesion;
        this.email = email;
        this.usuario=usuario;
        this.listaCompras=null;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
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

    public ArrayList<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(ArrayList<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }
}
