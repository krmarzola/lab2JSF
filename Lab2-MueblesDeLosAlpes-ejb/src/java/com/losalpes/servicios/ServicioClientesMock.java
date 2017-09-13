/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.Usuario;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ServicioClientesMock implements IServicioClientes{

  private static ServicioClientesMock esteServicioClientesMock=null;
  private ArrayList<Cliente> listaClientes;
  private ServicioClientesMock()
  {
      listaClientes= new ArrayList<Cliente>(); 
  }
  
  public static ServicioClientesMock darServicioClientesMock()
  {
   if (esteServicioClientesMock==null)
   {
    esteServicioClientesMock= new ServicioClientesMock();
   }
      return esteServicioClientesMock;
  }
  
    public void agregarCliente(Cliente cliente) {
     
        this.listaClientes.add(cliente);
    }

    
    public ArrayList<Cliente> darClientes() {
       return this.listaClientes;
    }

    
    public Cliente darClienteByUsuario(Usuario usuario) {
        
       for(Cliente c : this.listaClientes)
       {
           
        if(c.getUsuario().getNombre().equals(usuario.getNombre()) && c.getUsuario().getContraseña().equals(usuario.getContraseña()))
        {
         return c;
        }
       }
       return null;
    }

  
    public Cliente darClienteByDocumento(String documento) {
         for(Cliente c : this.listaClientes)
       {
        if(c.getNumerodocumento().equals(documento))
        {
         return c;
        }
       }
       return null;
    }

   
    public Cliente darClienteByNombre(String nombre) {
          for(Cliente c : this.listaClientes)
       {
        if(c.getNombre().equals(nombre))
        {
         return c;
        }
       }
       return null;
    }

    
    public Cliente darClienteByEmail(String email) {
              for(Cliente c : this.listaClientes)
       {
        if(c.getNombre().equals(email))
        {
         return c;
        }
       }
       return null;
    }
    }

        
