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
 * Contrato funcional de los servicios que se le prestan al carrito de compras
 */
public interface IServicioCarrito {
    /**
     * Devuelve el total de la compra
     * @return total de la compra
     */
    public Double darTotal();
    
    /**
     * Agrega un articulo al carrito de compras
     * @param mueble 
     */
    public void agregarArticulo(Mueble mueble);
    
    /**
     * Devuelve la lista de artículos
     * @return lista de articulos del carrito de compras
     */
    public List<Articulo> darArticulos();
    
    /**
     * Reinicia el carrito de compras
     */
    public void reiniciarCarrito();
}
