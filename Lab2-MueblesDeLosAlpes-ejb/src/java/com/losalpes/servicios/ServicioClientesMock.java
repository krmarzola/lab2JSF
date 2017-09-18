/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.TipoDocumento;
import com.losalpes.bos.TipoUsuario;
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
      listaClientes.add(new Cliente("johan",TipoDocumento.cc,"1","colombia","cundinamarca","bogota","xyz","ingeniero","johan@gmail.com","1","1",new Usuario("johan","123456",TipoUsuario.CLIENTE)));
      listaClientes.add(new Cliente("kevin",TipoDocumento.cc,"2","colombia","cundinamarca","bogota","xyz","ingeniero","kevin@gmail.com","1","1",new Usuario("kevin","123456",TipoUsuario.CLIENTE)));
      listaClientes.add(new Cliente("carlos",TipoDocumento.cc,"3","colombia","cundinamarca","bogota","xyz","ingeniero","carlos@gmail.com","1","1",new Usuario("carlos","123456",TipoUsuario.CLIENTE)));
      listaClientes.add(new Cliente("pedro",TipoDocumento.cc,"4","colombia","cundinamarca","bogota","xyz","ingeniero","pedro@gmail.com","1","1",new Usuario("Cliente 1","123456",TipoUsuario.CLIENTE)));
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

      
     
     
     
      
         
            
             
      private String telefonoResidencia;
      private String telefonoCelular;
   
  @Override
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

  @Override
    public Cliente darClienteByUserName(String userName)
    {
    for(Cliente c : this.listaClientes)
       {
           
        if(c.getUsuario().getNombre().equals(userName) )
        {
         return c;
        }
       }
       return null;
    }
  
  @Override
    public ArrayList<Cliente> darClienteByDocumento(String documento) {
        ArrayList<Cliente> tempList = new ArrayList<Cliente>(); 
         for(Cliente c : this.listaClientes)
       {
        if(c.getNumeroDocumento().equals(documento))
        {
         tempList.add(c);
        }
       }
       return tempList;
    }

   
  @Override
    public ArrayList<Cliente> darClienteByNombre(String nombre) {
        ArrayList<Cliente> tempList = new ArrayList<Cliente>();
          for(Cliente c : this.listaClientes)
       {
        if(c.getNombre().equals(nombre))
        {
         tempList.add(c);
        }
       }
      return tempList;
    }

    
  @Override
    public ArrayList<Cliente> darClienteByEmail(String email) {
         ArrayList<Cliente> tempList = new ArrayList<Cliente>();
              for(Cliente c : this.listaClientes)
       {
        if(c.getNombre().equals(email))
        {
          tempList.add(c);
        }
       }
       return tempList;
    }
    
  @Override
    public ArrayList<Cliente> darClienteByTipoDocumento(String tipoDocumento) {
         ArrayList<Cliente> tempList = new ArrayList<Cliente>();
              for(Cliente c : this.listaClientes)
       {
        if(c.getTipoDocumento().equals(tipoDocumento))
        {
          tempList.add(c);
        }
       }
       return tempList;
    }
    
  @Override
    public ArrayList<Cliente> darClienteByPais(String pais) {
         ArrayList<Cliente> tempList = new ArrayList<Cliente>();
              for(Cliente c : this.listaClientes)
       {
        if(c.getPais().equals(pais))
        {
          tempList.add(c);
        }
       }
       return tempList;
    }
    
  @Override
    public ArrayList<Cliente> darClienteByDepartamento(String departamento) {
         ArrayList<Cliente> tempList = new ArrayList<Cliente>();
              for(Cliente c : this.listaClientes)
       {
        if(c.getDepartamento().equals(departamento))
        {
          tempList.add(c);
        }
       }
       return tempList;
    }
    
  @Override
    public ArrayList<Cliente> darClienteByCiudad(String ciudad) {
         ArrayList<Cliente> tempList = new ArrayList<Cliente>();
              for(Cliente c : this.listaClientes)
       {
        if(c.getCiudadResidencia().equals(ciudad))
        {
          tempList.add(c);
        }
       }
       return tempList;
    }
    
  @Override
    public ArrayList<Cliente> darClienteByDireccion(String direcccion) {
         ArrayList<Cliente> tempList = new ArrayList<Cliente>();
              for(Cliente c : this.listaClientes)
       {
        if(c.getDireccion().equals(direcccion))
        {
          tempList.add(c);
        }
       }
       return tempList;
    }
    
  @Override
    public ArrayList<Cliente> darClienteByProfesion(String profesion) {
         ArrayList<Cliente> tempList = new ArrayList<Cliente>();
              for(Cliente c : this.listaClientes)
       {
        if(c.getProfesion().equals(profesion))
        {
          tempList.add(c);
        }
       }
       return tempList;
    }
    
  @Override
     public ArrayList<Cliente> darClienteByTelefono(String telefono) {
         ArrayList<Cliente> tempList = new ArrayList<Cliente>();
              for(Cliente c : this.listaClientes)
       {
        if(c.getTelefonoResidencia().equals(telefono))
        {
          tempList.add(c);
        }
       }
       return tempList;
    }
     
  @Override
      public ArrayList<Cliente> darClienteByCelular(String celular) {
         ArrayList<Cliente> tempList = new ArrayList<Cliente>();
              for(Cliente c : this.listaClientes)
       {
        if(c.getTelefonoCelular().equals(celular))
        {
          tempList.add(c);
        }
       }
       return tempList;
    }
     @Override
    public void deleteCliente(Cliente cliente)
    {
        this.listaClientes.remove(cliente);
    }
     @Override
    public void updateCliente(Cliente cliente)
    {
        for(int i=0; i < this.listaClientes.size(); i++)
        {
          if (this.listaClientes.get(i).getUsuario().getNombre() == cliente.getUsuario().getNombre())
          {
           this.listaClientes.set(i, cliente);
          }
        }
    }
    
    }

        
