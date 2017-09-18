/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.TipoDocumento;
import com.losalpes.bos.Usuario;
import com.losalpes.servicios.ServicioClientesMock;
import com.losalpes.servicios.ServicioHistoricoMock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class AdminClientesBean {

    private final static List<String> VALID_COLUMN_KEYS = Arrays.asList("nombre", "tipoDocumento", "numeroDocumento", "pais", "departamento", "ciudadResidencia", "direccion", "profesion", "email", "telefonoResidencia", "telefonoCelular");
    private ArrayList<ColumnModel> columns;
    private ArrayList<ColumnModel> columnsEdicion;
    private ArrayList<String> listaParametros;
    private ArrayList<String> listaParametrosEdicion;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Cliente> listaClientesEdicion;
    private ArrayList<Cliente> listaCliatesFiltro;
    private Cliente selectedCliente;
    private String parametroConsulta = "";
    private String valorParametroConsulta = "";
    private String parametroConsultaEdicion = "";
    private String valorParametroConsultaEdicion = "";

    public ArrayList<ColumnModel> getColumnsEdicion() {
        return columnsEdicion;
    }

    public void setColumnsEdicion(ArrayList<ColumnModel> columnsEdicion) {
        this.columnsEdicion = columnsEdicion;
    }

    public ArrayList<String> getListaParametrosEdicion() {
        return listaParametrosEdicion;
    }

    public void setListaParametrosEdicion(ArrayList<String> listaParametrosEdicion) {
        this.listaParametrosEdicion = listaParametrosEdicion;
    }

    public ArrayList<Cliente> getListaClientesEdicion() {
        return listaClientesEdicion;
    }

    public void setListaClientesEdicion(ArrayList<Cliente> listaClientesEdicion) {
        this.listaClientesEdicion = listaClientesEdicion;
    }

    public String getParametroConsultaEdicion() {
        return parametroConsultaEdicion;
    }

    public void setParametroConsultaEdicion(String parametroConsultaEdicion) {
        this.parametroConsultaEdicion = parametroConsultaEdicion;
    }

    public String getValorParametroConsultaEdicion() {
        return valorParametroConsultaEdicion;
    }

    public void setValorParametroConsultaEdicion(String valorParametroConsultaEdicion) {
        this.valorParametroConsultaEdicion = valorParametroConsultaEdicion;
    }

    public ArrayList<String> getListaParametros() {
        return listaParametros;
    }

    public void setListaParametros(ArrayList<String> listaParametros) {
        this.listaParametros = listaParametros;
    }

    public String getParametroConsulta() {
        return parametroConsulta;
    }

    public void setParametroConsulta(String parametroConsulta) {
        this.parametroConsulta = parametroConsulta;
    }

    public String getValorParametroConsulta() {
        return valorParametroConsulta;
    }

    public void setValorParametroConsulta(String valorParametroConsulta) {
        this.valorParametroConsulta = valorParametroConsulta;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public ArrayList<Cliente> getListaCliatesFiltro() {
        return listaCliatesFiltro;
    }

    public void setListaCliatesFiltro(ArrayList<Cliente> listaCliatesFiltro) {
        this.listaCliatesFiltro = listaCliatesFiltro;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public AdminClientesBean() {
        createDynamicColumnsConsulta();
        createDynamicColumnsConsultaEdicion();
    }

    public ArrayList<ColumnModel> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<ColumnModel> columns) {
        this.columns = columns;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private void createDynamicColumnsConsulta() {

        columns = new ArrayList<ColumnModel>();
        listaParametros = new ArrayList<String>();
        for (Map.Entry columKeyValue : columnasValoresTabla().entrySet()) {
            columns.add(new ColumnModel(columKeyValue.getKey().toString(), columKeyValue.getValue().toString()));
            listaParametros.add(columKeyValue.getKey().toString());
        }
    }

    private void createDynamicColumnsConsultaEdicion() {

        columnsEdicion = new ArrayList<ColumnModel>();
        listaParametrosEdicion = new ArrayList<String>();
        for (Map.Entry columKeyValue : columnasValoresTablaEdicion().entrySet()) {
            columnsEdicion.add(new ColumnModel(columKeyValue.getKey().toString(), columKeyValue.getValue().toString()));
            listaParametrosEdicion.add(columKeyValue.getKey().toString());
        }
    }

    static public class ColumnModel implements Serializable {

        private String header;
        private String property;

        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }

        public String getHeader() {
            return header;
        }

        public String getProperty() {
            return property;
        }
    }

    public void deleteCliente() {

        if (this.selectedCliente != null) {

            if(ServicioHistoricoMock.getInstance().getComprasByUserName(this.selectedCliente.getUsuario().getNombre()).isEmpty())
            { ServicioClientesMock.darServicioClientesMock().deleteCliente(this.selectedCliente);

            this.consultarClientesEdicion();
            this.consultarClientes();
            addMessage("Confirmación", "Se elimino el cliente");
            }
            else
            {
                addMessage("System Error", "No se pueden eliminar clientes con compras");
            }
        } else {
            addMessage("System Error", "No se seleccionado ningun cliente");
        }

    }

    public String updateValuaes() {
        if (this.selectedCliente != null) {
            return "actualizarValores";
        } else {
            addMessage("System Error", "No se seleccionado ningun cliente");
            return "";
        }
    }

    public String updateCliente() {
        if (this.selectedCliente != null) 
        {
            ServicioClientesMock.darServicioClientesMock().updateCliente(selectedCliente);
            return  returnEdit();
        } else 
        {
            addMessage("System Error", "No se seleccionado ningun cliente");
            return "";
        }
    }

    public String returnEdit() {
        return "editClientes";
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void consultarClientes() {
        if (this.valorParametroConsulta.equals("")) {
            System.out.println("consulta vacia");
            listaClientes = ServicioClientesMock.darServicioClientesMock().darClientes();
        } else {
                 
                switch (this.parametroConsulta) {
                    case "Nombre":                        
                            listaClientes= ServicioClientesMock.darServicioClientesMock().darClienteByNombre(this.valorParametroConsulta);
                            break;
                    case "Tipo Docuemnto":
                        listaClientes= ServicioClientesMock.darServicioClientesMock().darClienteByTipoDocumento(this.valorParametroConsulta);
                        break;
                    case "Docuemnto":
                        listaClientes= ServicioClientesMock.darServicioClientesMock().darClienteByDocumento(this.valorParametroConsulta);
                        break;
                    case "Pais":
                        listaClientes= ServicioClientesMock.darServicioClientesMock().darClienteByPais(this.valorParametroConsulta);
                        break;

                    case "Departamento":
                         listaClientes= ServicioClientesMock.darServicioClientesMock().darClienteByDepartamento(this.valorParametroConsulta);
                        break;

                    case "Ciudad":
                        listaClientes= ServicioClientesMock.darServicioClientesMock().darClienteByCiudad(this.valorParametroConsulta);
                        break;
                    case "Direccion":
                        listaClientes= ServicioClientesMock.darServicioClientesMock().darClienteByDireccion(this.valorParametroConsulta);
                        break;

                    case "Profesion":
                         listaClientes= ServicioClientesMock.darServicioClientesMock().darClienteByProfesion(this.valorParametroConsulta);
                        break;

                    case "Email":
                        listaClientes= ServicioClientesMock.darServicioClientesMock().darClienteByEmail(this.valorParametroConsulta);
                        break;
                    case "Telefono":
                         listaClientes= ServicioClientesMock.darServicioClientesMock().darClienteByTelefono(this.valorParametroConsulta);
                        break;
                    case "Celular":
                         listaClientes= ServicioClientesMock.darServicioClientesMock().darClienteByCelular(this.valorParametroConsulta);
                        break;
                }

            

        }
    }

    public void consultarClientesEdicion() {
        if (!this.valorParametroConsultaEdicion.equals("")) {

                       
                switch (this.parametroConsultaEdicion) {
                    case "Nombre":
                        listaClientesEdicion= ServicioClientesMock.darServicioClientesMock().darClienteByNombre(this.valorParametroConsultaEdicion);
                            break;                        

                    case "Docuemnto":
                        listaClientesEdicion= ServicioClientesMock.darServicioClientesMock().darClienteByDocumento(this.valorParametroConsultaEdicion);
                        break;

                    case "Email":
                        listaClientesEdicion= ServicioClientesMock.darServicioClientesMock().darClienteByEmail(this.valorParametroConsultaEdicion);
                        break;

                }               

        }
        else
        {listaClientesEdicion = new ArrayList<Cliente>();
                
                
                }
    }

    public LinkedHashMap<String, String> columnasValoresTabla() {
        LinkedHashMap<String, String> mapColumns = new LinkedHashMap<String, String>();

        mapColumns.put("Nombre", "nombre");
        mapColumns.put("Tipo Docuemnto", "tipoDocumento");
        mapColumns.put("Docuemnto", "numeroDocumento");
        mapColumns.put("Pais", "pais");
        mapColumns.put("Departamento", "departamento");
        mapColumns.put("Ciudad", "ciudadResidencia");
        mapColumns.put("Direccion", "direccion");
        mapColumns.put("Profesion", "profesion");
        mapColumns.put("Email", "email");
        mapColumns.put("Telefono Residencia", "telefonoResidencia");
        mapColumns.put("Celular", "telefonoCelular");
        return mapColumns;
    }

    public LinkedHashMap<String, String> columnasValoresTablaEdicion() {
        LinkedHashMap<String, String> mapColumns = new LinkedHashMap<String, String>();

        mapColumns.put("Nombre", "nombre");
        mapColumns.put("Docuemnto", "numeroDocumento");
        mapColumns.put("Email", "email");

        return mapColumns;
    }

    public void validateUniqueDocument(FacesContext context, UIComponent toValidate, Object value) {
        ArrayList<Cliente> listaClientes = ServicioClientesMock.darServicioClientesMock().darClientes();

        for (Cliente pcliente : listaClientes) {
            if (!pcliente.getUsuario().getNombre().equals(this.selectedCliente.getUsuario().getNombre())) {
                if (value.equals(pcliente.getNumeroDocumento())) {
                    ((UIInput) toValidate).setValid(false);
                    FacesMessage message = new FacesMessage("El docuemto ya existe en la base de datos");
                    context.addMessage(toValidate.getClientId(context), message);
                    return;
                }
            }
        }
    }
    
    public String volverMenu()
    {
      return "adminMenu";    
    }
}
