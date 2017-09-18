/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Compra;
import com.losalpes.servicios.IServicioHistorico;
import com.losalpes.servicios.ServicioCarritoMock;
import com.losalpes.servicios.ServicioHistoricoMock;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 * Clase para mostrar el histórico de  la compra
 */
@ManagedBean
public class HistoricoBean {
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    private IServicioHistorico servicioHistorico;
        
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
    public HistoricoBean()
    {     
        servicioHistorico = ServicioHistoricoMock.getInstance();
    }
    
        //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    
    /**
     * Devuelve la lista de las compras 
     * @return lista de compras
     */
    public List<Compra> getCompras(){
        List<Compra> compras = servicioHistorico.getCompras();
        return servicioHistorico.getCompras();
    }
    
}
