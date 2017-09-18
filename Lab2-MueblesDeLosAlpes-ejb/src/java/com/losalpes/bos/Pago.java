/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Usuario.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.bos;

import java.util.Date;

/**
 * Clase que representa el tipo de pago que se realizará para una compra
 */
public class Pago {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Número de tarjeta
     */
    private String numeroTarjeta;

    /**
     * Código de seguridad
     */
    private int codigoSeguridad;

    /**
     * Año de expiración de la tarjeta
     */
    private int anioExpiracion;

    /**
     * Mes de expiración de la tarjeta
     */
    private int mesExpiracion;

    /**
     * Número de cuotas
     */
    private int numeroCuotas;

    /**
     * Naturaleza del pago (Crédito,Débito)
     */
    private String naturaleza;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------
    /**
     * Constructor de la clase sin argumentos
     */
    public Pago() {

    }

    /**
     * Constructor de la clase con argumentos
     *
     * @param numeroTarjeta Número de la tarjeta de pago
     * @param codigoSeguridad Código de seguridad de la tarjeta
     * @param fechaExpiracion Fecha de expiración de la tarjeta
     * @param numeroCuotas Número de cuotas
     * @param naturaleza Naturaleza del pago (Crédito, Débito)
     */
    public Pago(String numeroTarjeta, int codigoSeguridad, int numeroCuotas, String naturaleza, int anioExpiracion, int mesExpiracion) {
        this.numeroTarjeta = numeroTarjeta;
        this.codigoSeguridad = codigoSeguridad;
        this.numeroCuotas = numeroCuotas;
        this.naturaleza = naturaleza;
        this.anioExpiracion = anioExpiracion;
        this.mesExpiracion = mesExpiracion;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    /**
     * Obtiene Número de tarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Modifica Número de tarjeta
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Obtiene Código de seguridad
     */
    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    /**
     * Modifica Código de seguridad
     */
    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    /**
     * Obtiene el Número de cuotas
     */
    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    /**
     * Modifica el Número de cuotas
     */
    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    /**
     * Obtiene Naturaleza del pago (Crédito,Débito)
     */
    public String getNaturaleza() {
        return naturaleza;
    }

    /**
     * Modifica Naturaleza del pago (Crédito,Débito)
     */
    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    /**
     * @return the anioExpiracion
     */
    public int getAnioExpiracion() {
        return anioExpiracion;
    }

    /**
     * @param anioExpiracion the anioExpiracion to set
     */
    public void setAnioExpiracion(int anioExpiracion) {
        this.anioExpiracion = anioExpiracion;
    }

    /**
     * @return the mesExpiracion
     */
    public int getMesExpiracion() {
        return mesExpiracion;
    }

    /**
     * @param mesExpiracion the mesExpiracion to set
     */
    public void setMesExpiracion(int mesExpiracion) {
        this.mesExpiracion = mesExpiracion;
    }

}
