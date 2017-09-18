/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Articulo;
import com.losalpes.bos.Cliente;
import com.losalpes.bos.Compra;
import com.losalpes.bos.Mueble;
import com.losalpes.bos.TipoMueble;
import com.losalpes.servicios.IServicioHistorico;
import com.losalpes.servicios.ServicioClientesMock;
import com.losalpes.servicios.ServicioHistoricoMock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class Reporte1Bean {

    ArrayList<Reporte> listaMueblesInterior;
    ArrayList<Reporte> listaMueblesExterior;
    
    Date fechaInicio;
    Date fechaFin;
    String ciudad;
    
    public void obtenerListasMuebles()
    {
          listaMueblesInterior = new   ArrayList<Reporte>();
          listaMueblesExterior = new   ArrayList<Reporte>();
         
      ArrayList<Compra> listaCompras = getListaCompras(fechaInicio,fechaFin, ciudad);
       
       for(Compra c:listaCompras)
       {
         ArrayList<Articulo> listaArticulo = (ArrayList<Articulo>)c.getArticulos();
         
         for(Articulo art: listaArticulo)
         {
            Mueble mueble = art.getMueble();
           if (mueble.getTipo()==TipoMueble.Interior)
           {
             this.addInterior(mueble.getNombre(),art.getCantidad(),mueble.getPrecio());
           }
           if (mueble.getTipo()==TipoMueble.Exterior)
           {
             this.addExterior(mueble.getNombre(),art.getCantidad(),mueble.getPrecio());
           }
         }
         
       }
       
             
    }
    
    public void addExterior(String nombre, int cantidad, double cu)
    {
       boolean nuevo=true;
        for(Reporte r: listaMueblesExterior)
        {
          if( r.nombre.equals(nombre))
          {
             r.cantidad=r.cantidad+ cantidad;
             r.costeTotal = r.cantidad*r.costeUnitario;
             nuevo = false;
             break;
          }
        }
        if(nuevo)
        {
          double costeTotal= cu*cantidad;
          Reporte nuevoReporte = new Reporte(nombre,cantidad,cu,costeTotal);
        }      
        
    }
    
       public void addInterior(String nombre, int cantidad, double cu)
    {
       boolean nuevo=true;
        for(Reporte r: listaMueblesInterior)
        {
          if( r.nombre.equals(nombre))
          {
             r.cantidad=r.cantidad+ cantidad;
             r.costeTotal = r.cantidad*r.costeUnitario;
             nuevo = false;
             break;
          }
        }
        if(nuevo)
        {
          double costeTotal= cu*cantidad;
          Reporte nuevoReporte = new Reporte(nombre,cantidad,cu,costeTotal);
        }      
        
    }
    
    public ArrayList<Compra> getListaCompras(Date ini,Date fin, String ciudad)
    {
     ArrayList<Cliente> listaClientes = ServicioClientesMock.darServicioClientesMock().darClienteByCiudad(ciudad);
     ArrayList<Compra>  newListaCompras = new ArrayList<Compra>();
    
      IServicioHistorico servicioHistorico = ServicioHistoricoMock.getInstance();
       
       ArrayList<Compra> listaCompras = servicioHistorico.getCompras();
       
       for(Compra c: listaCompras)
       {
         if ( c.getFechaCompra().before(fin) && c.getFechaCompra().after(ini))
         {
             for (Cliente cl:listaClientes  )
             {
                if(c.getUserName().equals(cl.getUsuario().getNombre()))
                {
                newListaCompras.add(c);
                }
             }
         }
         
       }
       
     
     return newListaCompras;
    }

    
            
     public class Reporte implements Serializable {

        private String nombre;
        private int cantidad;
        private double costeUnitario;
        private double costeTotal;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public Double getCosteTotal() {
            return costeTotal;
        }

        public void setCosteTotal(Double costeTotal) {
            this.costeTotal = costeTotal;
        }

        public Reporte(String nombre,int cantidad, Double costeUnitario, Double costeTotal) {
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.costeUnitario = costeUnitario;
            this.costeTotal = costeTotal;
        }

       
      
    }

}
