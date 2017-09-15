/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Articulo;
import com.losalpes.bos.Compra;
import com.losalpes.bos.Mueble;
import com.losalpes.servicios.IServicioCarrito;
import com.losalpes.servicios.IServicioHistorico;
import com.losalpes.servicios.ServicioCarritoMock;
import com.losalpes.servicios.ServicioCatalogoMock;
import com.losalpes.servicios.ServicioHistoricoMock;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class CompraBean {
    
    private IServicioCarrito servicioCarrito;
    private IServicioHistorico servicioHistorico;
    
    private String userName;
    private Compra compra;
    /**
     * Constructor de la clase principal
     */
    public CompraBean()
    {
        
        servicioCarrito = new ServicioCarritoMock();
    }
    
        
    public List<Articulo> getArticulos(){
        return servicioCarrito.darArticulos();
    }
    
    public String agregarArticulo(Mueble mueble){
        servicioCarrito.agregarArticulo(mueble);
        return "carrito.xhtml";
    }
    
    public String comprar(){
        //compra = new Compra();
        
        return "pagar.xhtml";
    }
    
    public String getUserName(){
        return userName = (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName");
    }
    
    public String pagar(){
        servicioHistorico = ServicioHistoricoMock.getInstance();
        servicioHistorico.agregarCompra(compra);
        compra = new Compra();
        return "index.xhtml";
    }

}
