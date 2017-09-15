/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Articulo;
import com.losalpes.bos.Mueble;
import com.losalpes.bos.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ServicioCarritoMock implements IServicioCarrito{
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Arreglo con los muebles del sistema
     */
    private ArrayList<Articulo> articulos;
    private int cantidadMinima = 1;
    private Double total;


    public ServicioCarritoMock() {

        //Inicializa el arreglo de los muebles
        articulos = new ArrayList<Articulo>();

    }
    
            //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    
    public Double darTotal(){
        total = 0.0;
        for(Articulo articulo : articulos){
            total += (articulo.getMueble().getPrecio()) * (articulo.getCantidad());
        }
        return total;
    }
    


    /**
     * Agrega un mueble al sistema
     * @param mueble Nuevo mueble
     */
    @Override
    public void agregarArticulo(Mueble mueble)
    {
        Articulo articulo= new Articulo();
        articulo.setMueble(mueble);
        articulo.setCantidad(cantidadMinima);
        articulos.add(articulo);
    }

    /**
     * Devuelve los muebles del sistema
     * @return muebles Arreglo con todos los muebles del sistema
     */
    @Override
    public List<Articulo> darArticulos()
    {
        return articulos;
    }

}

