/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

/**
 * Contrato funcional de los servicios que genera el número de orden de compra
 */
public interface IServicioGeneradorReferencia {
    
    /**
     * Genera el número de orden 
     * @return número de orden
     */
    public int generarReferencia();
    
}
