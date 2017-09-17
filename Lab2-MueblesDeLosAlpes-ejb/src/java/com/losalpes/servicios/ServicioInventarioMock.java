/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Articulo;
import com.losalpes.bos.Mueble;
import java.util.List;

/**
 * Implementacion de los servicios del inventario que se le prestan al sistema. [Mock Object]
 * 
 */
public class ServicioInventarioMock implements IServicioInventario {
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    /**
     * Servicio de catalogo
     */
    private IServicioCatalogo servicioCatalogo;
    
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioInventarioMock (){
        servicioCatalogo = new ServicioCatalogoMock();
    }
    
    /**
     * Verifica la existencia de los articulos solicitados asi como su cantidad
     * @param articulosComprados articulos solicitados
     * @return Vacío si la cantidad de articulos está disponible sino deuelve una descripción de lo faltante
     */
    public String verificarExistencia(List<Articulo> articulosComprados){
        String existencia = "";
        List<Mueble> mueblesExistentes = servicioCatalogo.darMuebles();
        
        for(Articulo articulo : articulosComprados){
            for(Mueble mueble : mueblesExistentes){
                if(articulo.getMueble().getReferencia().equals(mueble.getReferencia())){
                    if(articulo.getCantidad()>mueble.getCantidadInventario()){
                        existencia += "La cantidad solicitada supera la disponible para el mueble de referencia " + mueble.getReferencia() 
                                + " , la cantidad en inventario es " + String.valueOf(mueble.getCantidadInventario()) + ", ";
                    }
                }
            }
        }
        
        if(existencia.length()>0){
            existencia = existencia.substring(0, existencia.length() - 2);
        }
        
        return existencia;
    }

    /**
     * Actualiza el inventario, restando lo comprado
     * @param articulosComprados Artículos que se compraron
     */
    @Override
    public void actualizarInventario(List<Articulo> articulosComprados) {
        List<Mueble> mueblesExistentes = servicioCatalogo.darMuebles();
        
        for(Articulo articulo : articulosComprados){
            for(Mueble mueble : mueblesExistentes){
                if(articulo.getMueble().getReferencia().equals(mueble.getReferencia())){
                    int inventarioActual = mueble.getCantidadInventario();
                    
                    mueble.setCantidadInventario(inventarioActual - articulo.getCantidad());
                }
            }
        }
    }
    
}
