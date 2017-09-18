/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.TipoDocumento;
import com.losalpes.bos.TipoMueble;
import com.losalpes.bos.Usuario;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import com.losalpes.servicios.ServicioClientesMock;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ja.rianoh
 */
@ManagedBean
public class RegistroBean {

    
     private Cliente cliente;
     
     private UIInput paswordComponet;

    public UIInput getPaswordComponet() {
        return paswordComponet;
    }

    public void setPaswordComponet(UIInput paswordComponet) {
        this.paswordComponet = paswordComponet;
    }

  
    public Cliente getCliente() {
        return cliente;
        
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
     
      private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
       
    
    /**
     * Creates a new instance of ReristroBean
     */
    public RegistroBean()
    {
        this.cliente= new Cliente();
        this.paswordComponet=null;
        
    }
    
     public SelectItem[] getTiposDocumento()
    {
        TipoDocumento[] tiposdoc=  TipoDocumento.values();
        SelectItem[] sitems = new SelectItem[tiposdoc.length];
        
        for (int i = 0; i < sitems.length; i++)
        {
             sitems[i] = new SelectItem(tiposdoc[i]);
        }
        return sitems;
    }
     
     public void validateSamePassword(FacesContext context, UIComponent toValidate,Object value)
     {
         
         if (!value.equals(this.paswordComponet.getValue()))
         {
              ((UIInput) toValidate).setValid(false);
        FacesMessage message = new FacesMessage("Las Contraseñas no coincide");
        context.addMessage(toValidate.getClientId(context), message);
         }
     
     }
     
     public void validateUniqueUserName(FacesContext context, UIComponent toValidate,Object value)
     { ArrayList<Cliente> listaClientes = ServicioClientesMock.darServicioClientesMock().darClientes();
     
      for (Cliente cliente : listaClientes)
      {
      if (value.equals(cliente.getUsuario().getNombre()))
         {
              ((UIInput) toValidate).setValid(false);
        FacesMessage message = new FacesMessage("El nombre de usuario ya existe");
        context.addMessage(toValidate.getClientId(context), message);
        return;
         }
      }
     }
     
       public void validateUniqueDocument(FacesContext context, UIComponent toValidate,Object value)
     { ArrayList<Cliente> listaClientes = ServicioClientesMock.darServicioClientesMock().darClientes();
     
      for (Cliente pcliente : listaClientes)
      {
      if (value.equals(pcliente.getNumeroDocumento()))
         {
              ((UIInput) toValidate).setValid(false);
        FacesMessage message = new FacesMessage("El docuemto ya existe en la base de datos");
        context.addMessage(toValidate.getClientId(context), message);
         return;
         }
      }
     }
       
       public String registrarCliente()
       {
           ServicioClientesMock.darServicioClientesMock().darClientes().add(this.cliente);
           mensajeConfirmacion();
           limpiar();
           return "login";
       
       }
     public void limpiar()
             
     {
         this.cliente= new Cliente();
     }
     public String loginReturn()
     {
         limpiar();
         return "login";
     }
     
      public void MensajeCreacion() {
        addMessage("Creación de Usuario","Usuario Credo Con exito");
    }
     
      
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void mensajeConfirmacion() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información",
                "Usuario Credo Con exito");
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
}
