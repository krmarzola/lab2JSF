/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Mueble.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.bos;

/**
 * Clase que representa un articulo de compra en el sistema
 */
public class Articulo {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * mueble que se desea comprar.
     */
    private Mueble mueble;

    /**
     * Cantidad de artículos que desea comprar.
     */
    private int cantidad;

    /**
     * Costo para el mueble
     */
    private Double costo;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------
    /**
     * Constructor sin argumentos de la clase
     */
    public Articulo() {

    }
    
    /**
     * Crea un nuevo artículo de compra
     * @param mueble mueble que será comprado
     */
    public Articulo(Mueble mueble) {
        this.mueble = mueble;
        this.cantidad = 1;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    
    /**
     * @return costo del mueble
     */
    public Double getCosto() {
        return mueble.getPrecio() * cantidad;
    }

    /**
     * Modifica el costo del mueble
     * @param costo costo del mueble
     */
    public void setCosto(Double costo) {
        this.costo = costo;
    }

    /**
     * Devuelve el mueble que va a ser comprado
     * @return mueble que va a ser comprado
     */
    public Mueble getMueble() {
        return mueble;
    }

    /**
     * Modifica el mueble que será comprado
     *
     * @param nuevo mueble
     */
    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    /**
     * Cantidad de muebles que va a comprar
     *
     * @return cantidad de muebles que va a comprar
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Modifica la cantidad de artículos que se van a comprar
     *
     * @param nuevo cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
