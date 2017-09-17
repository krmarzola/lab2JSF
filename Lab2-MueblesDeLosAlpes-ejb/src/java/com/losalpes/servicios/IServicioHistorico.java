/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Compra;
import com.losalpes.excepciones.AutenticacionException;
import java.util.ArrayList;

/**
 * Contrato funcional de los servicios que se le prestan al histórico de la aplicación
 */
public interface IServicioHistorico {
    
    /**
     * Devuelve la lista de compras registradas en el histórico
     * @return lista de compras del histórico
     */
    public ArrayList<Compra> getCompras();
    
    /**
     * Agrega una compra al histórico
     * @param compra compra que se agrega al históricos
     */
    public void agregarCompra(Compra compra);
}
