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
    
    public Cliente darClienteByDocumento(String documento);
    
    public Cliente darClienteByNombre(String nombre);
    
    public Cliente darClienteByEmail(String email);
    
    
}
