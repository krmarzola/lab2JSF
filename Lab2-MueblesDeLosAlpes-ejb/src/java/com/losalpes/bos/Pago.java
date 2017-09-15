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
public class Pago
{

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
     * Fecha de expiración de la tarjeta
     */
    private Date fechaExpiracion;
	
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
    public Pago()
    {

    }

    /**
     * Constructor de la clase con argumentos
     * @param numeroTarjeta Número de la tarjeta de pago
	 * @param codigoSeguridad Código de seguridad de la tarjeta
	 * @param fechaExpiracion Fecha de expiración de la tarjeta
	 * @param numeroCuotas Número de cuotas
	 * @param naturaleza Naturaleza del pago (Crédito, Débito)
     */
    public Pago(String numeroTarjeta,int codigoSeguridad,Date fechaExpiracion,int numeroCuotas,String naturaleza)
    {
		this.numeroTarjeta = numeroTarjeta;
		this.codigoSeguridad = codigoSeguridad;
		this.fechaExpiracion = fechaExpiracion;
		this.numeroCuotas = numeroCuotas;
		this.naturaleza = naturaleza;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
	
    /**
     * Obtiene Número de tarjeta
     */
    private String getNumeroTarjeta(){
		return numeroTarjeta;
	}

	/**
     * Modifica Número de tarjeta
     */
    private void setNumeroTarjeta(String numeroTarjeta){
		this.numeroTarjeta = numeroTarjeta;
	}

    /**
     * Obtiene Código de seguridad
     */
    private int getCodigoSeguridad(){
		return codigoSeguridad;
	}

	/**
     * Modifica Código de seguridad
     */
    private void setCodigoSeguridad(int codigoSeguridad){
		this.codigoSeguridad = codigoSeguridad;
	}

    /**
     * Obtiene Fecha de expiración de la tarjeta
     */
    private Date getFechaExpiracion(){
		return fechaExpiracion;
	}

	/**
     * Modifica Fecha de expiración de la tarjeta
     */
    private void setFechaExpiracion(Date fechaExpiracion){
		this.fechaExpiracion = fechaExpiracion;
	}
	
    /**
     * Obtiene el Número de cuotas
     */
    private int getNumeroCuotas(){
		return numeroCuotas;
	}

	/**
     * Modifica el Número de cuotas
     */
    private void setNumeroCuotas(int numeroCuotas){
		this.numeroCuotas = numeroCuotas;
	}

	/**
     * Obtiene Naturaleza del pago (Crédito,Débito)
     */
    private String getNaturaleza(){
		return naturaleza;
	}

	/**
     * Modifica Naturaleza del pago (Crédito,Débito)
     */
    private void getNaturaleza(String naturaleza){
		this.naturaleza = naturaleza;
	}


}
