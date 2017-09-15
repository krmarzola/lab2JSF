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

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa una compra en el sistema
 */
public class Compra
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	/**
     * Fecha de compra
     */
    private Date fechaCompra;

    /**
     * Número de orden
     */
    private int numeroOrden;

    /**
     * Username del cliente
     */
    private String userName;

    /**
     * Arreglo con los articulos que se van a comprar
     */
    private ArrayList<Articulo> articulos;

	 /**
     * Total de compras
     */
    private Double totalCompras;

	 /**
     * Descripción de la compra
     */
    private String descripcionCompra;

	 /**
     * Detalle de la forma de pago
     */
    private Pago pago;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase sin argumentos
     */
    public Compra()
    {

    }

    /**
     * 
     * @param fechaCompra
     * @param numeroOrden 
     */
    public Compra(Date fechaCompra,int numeroOrden)
    {
        this.fechaCompra = fechaCompra;
        this.numeroOrden = numeroOrden;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

	/**
     * Obtiene la Fecha de compra
     */
    public Date getFechaCompra(){
		return fechaCompra;
	};

	 /**
     * Modificar la Fecha de compra
     */
    public void setFechaCompra(Date fechaCompra){
		this.fechaCompra = fechaCompra;
	};

    /**
     * Obtiene Número de orden
     */
    public int getNumeroOrden(){
		return numeroOrden;
	}

	/**
     * Modificar Número de orden
     */
    public void setNumeroOrden(int numeroOrden){
		this.numeroOrden = numeroOrden;
	}

    /**
     * Obtiene Username del cliente
     */
    public String getUserName(){
		return userName;
	}

	/**
     * Modificar Username del cliente
     */
    public void setUserName(String userName){
		this.userName = userName;
	}

    /**
     * Obtiene Arreglo con los articulos que se van a comprar
     */
    public ArrayList<Articulo> getArticulos(){
		return articulos;
	}

	/**
     * Modifica Arreglo con los articulos que se van a comprar
     */
    public void setArticulos(ArrayList<Articulo> articulos){
		this.articulos = articulos;
	}

	 /**
     * Obtiene Total de compras
     */
    public Double getTotalCompras(){
		return totalCompras;
	}

	/**
     * Modificar Total de compras
     */
    public void setTotalCompras(Double totalCompras){
		this.totalCompras = totalCompras;
	}

	 /**
     * Obtiene Descripción de la compra
     */
    public String getDescripcionCompra(){
		return descripcionCompra;
	}

	/**
     * Modificar Descripción de la compra
     */
    public void setDescripcionCompra(String descripcionCompra){
		this.descripcionCompra = descripcionCompra;
	}

	 /**
     * Obtiene Detalle de la forma de pago
     */
    public Pago getPago(){
		return pago;
	}

	/**
     * Modificar Detalle de la forma de pago
     */
    public void setPago(Pago pago){
		this.pago = pago;
	}
}
