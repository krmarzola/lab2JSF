/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioSeguridad.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.servicios;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.TipoUsuario;
import com.losalpes.bos.Usuario;
import com.losalpes.excepciones.AutenticacionException;
import com.losalpes.servicios.ServicioClientesMock;
import java.util.ArrayList;

/**
 * Clase que se encarga de la autenticación de un usuario en el sistema
 * 
 */
public class ServicioSeguridadMock implements IServicioSeguridad
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Arreglo con los usuarios del sistema
     */
    private ArrayList<Usuario> usuarios;
    private static ServicioSeguridadMock esteServicioSeguridadMock=null;
    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     *
     */
    private ServicioSeguridadMock()
    {
        //Inicializa el arreglo que contiene los usuarios
        usuarios=new ArrayList<Usuario>();

        //Agrega usuarios al sistema
        usuarios.add(new Usuario("admin","adminadmin",TipoUsuario.ADMINISTRADOR));
        usuarios.add(new Usuario("client","clientclient",TipoUsuario.CLIENTE));
         ArrayList<Cliente> listaClientes = ServicioClientesMock.darServicioClientesMock().darClientes();
         
       
        
       
        
    }
    
    private void crearListaDeUsuarios()
    {
        usuarios=new ArrayList<Usuario>();

        //Agrega usuarios al sistema
        usuarios.add(new Usuario("admin","adminadmin",TipoUsuario.ADMINISTRADOR));
        usuarios.add(new Usuario("client","clientclient",TipoUsuario.CLIENTE));
         ArrayList<Cliente> listaClientes = ServicioClientesMock.darServicioClientesMock().darClientes();
         
         for(Cliente cliente: listaClientes)
         {
             usuarios.add(cliente.getUsuario());
         }
    }
    
    public static ServicioSeguridadMock darServicioSeguridadMock()
    {
     if (esteServicioSeguridadMock==null)
     {
         esteServicioSeguridadMock=new ServicioSeguridadMock();

     }
     return esteServicioSeguridadMock;
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Registra el ingreso de un usuario al sistema.
     * @param nombre Login del usuario que quiere ingresar al sistema.
     * @param contraseña Contraseña del usuario que quiere ingresar al sistema.
     * @return usuario Retorna el objeto que contiene la información del usuario que ingreso al sistema.
     */
    @Override
    public Usuario login(String nombre, String contraseña) throws AutenticacionException
    {
        crearListaDeUsuarios();
        Usuario u=null;

        boolean termino=false;

        for (int i = 0; i < usuarios.size() && !termino; i++)
        {
            u=usuarios.get(i);

            if(u.getNombre().equals(nombre)&& u.getContraseña().equals(contraseña))
            {
               termino=true;
            }
            else if(i==usuarios.size()-1)
            {
                throw new AutenticacionException("Usuario Inválido");
            }
        }

        return u;
    }
    
    public void adicionarUsuario(Usuario usuario)
    {
     this.usuarios.add(usuario);
    }
    

}
