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
public interface IServicioClientes {
    
    public void agregarCliente(Cliente cliente);
    
    public ArrayList<Cliente> darClientes();
    
    public Cliente darClienteByUsuario(Usuario usuario);
    public Cliente darClienteByUserName(String userName);
   public ArrayList<Cliente> darClienteByNombre(String nombre);
 
    
   public ArrayList<Cliente> darClienteByEmail(String email);
    public ArrayList<Cliente> darClienteByPais(String pais);
     public ArrayList<Cliente> darClienteByDepartamento(String departamento);
     public ArrayList<Cliente> darClienteByCiudad(String ciudad);
     public ArrayList<Cliente> darClienteByDireccion(String direcccion);
      public ArrayList<Cliente> darClienteByProfesion(String profesion);
       public ArrayList<Cliente> darClienteByTelefono(String telefono);
        public ArrayList<Cliente> darClienteByCelular(String celular);
        public ArrayList<Cliente> darClienteByTipoDocumento(String tipoDocumento);
        public void deleteCliente(Cliente cliente);
        public void updateCliente(Cliente cliente);
        public ArrayList<Cliente> darClienteByDocumento(String documento);
    
    
}
