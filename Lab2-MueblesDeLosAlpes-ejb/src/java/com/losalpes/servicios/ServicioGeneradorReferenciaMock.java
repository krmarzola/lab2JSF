/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

/**
 * Implementacion de los servicios del generador de número de orden que se le prestan al sistema. [Mock Object]
 * 
 */
public class ServicioGeneradorReferenciaMock implements IServicioGeneradorReferencia {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    private static ServicioGeneradorReferenciaMock instance = null;

    private int ultimaReferencia;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
    protected ServicioGeneradorReferenciaMock() {
        ultimaReferencia = 0;
    }

    /**
     * Crea una instancia del servicio 
     * @return 
     */
    public static ServicioGeneradorReferenciaMock getInstance() {
        if (instance == null) {
            instance = new ServicioGeneradorReferenciaMock();
        }
        return instance;
    }

    /**
     * Genera la nueva orden
     * @return orden de compra
     */
    public int generarReferencia() {
        ultimaReferencia += 1;
        return ultimaReferencia;
    }

}
