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
 *
 * @author user
 */
public interface IServicioCarrito {
    public Double darTotal();
    public void agregarArticulo(Mueble mueble);
    public List<Articulo> darArticulos();
}
