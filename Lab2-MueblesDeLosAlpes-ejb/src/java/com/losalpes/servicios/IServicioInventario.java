/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Articulo;
import java.util.List;

/**
 * Contrato funcional de los servicios del inventario de la aplicación
 */
public interface IServicioInventario {
    
    /**
     * Verifica la existencia de los productos solicitados en la compra
     * @param articulos lista de artículos solcitados
     * @return Vacío si la cantidad de articulos está disponible sino deuelve una descripción de lo faltante
     */
    public String verificarExistencia(List<Articulo> articulos);
    
    /**
     * Actualiza el inventario, restando lo comprado
     * @param articulos Artículos que se compraron
     */
    public void actualizarInventario(List<Articulo> articulos);
}
