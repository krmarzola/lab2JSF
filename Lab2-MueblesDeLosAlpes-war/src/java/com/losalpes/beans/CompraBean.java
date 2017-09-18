/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioCatalogoMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.beans;

import com.losalpes.bos.Articulo;
import com.losalpes.bos.Compra;
import com.losalpes.bos.Mueble;
import com.losalpes.bos.Pago;
import com.losalpes.bos.TipoPago;
import com.losalpes.excepciones.AutenticacionException;
import com.losalpes.servicios.IServicioCarrito;
import com.losalpes.servicios.IServicioGeneradorReferencia;
import com.losalpes.servicios.IServicioHistorico;
import com.losalpes.servicios.IServicioInventario;
import com.losalpes.servicios.ServicioCarritoMock;
import com.losalpes.servicios.ServicioCatalogoMock;
import com.losalpes.servicios.ServicioGeneradorReferenciaMock;
import com.losalpes.servicios.ServicioHistoricoMock;
import com.losalpes.servicios.ServicioInventarioMock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;

/**
 * ManagedBean para manejar la compra de la aplicación con alcance de sesión
 */
@ManagedBean
@SessionScoped
public class CompraBean {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Servicio generador de orden de compra
     */
    private IServicioGeneradorReferencia servicioGeneradorReferencia;

    /**
     * Servicio de carrito de compras
     */
    private IServicioCarrito servicioCarrito;

    /**
     * Servicio de registro al histórico
     */
    private IServicioHistorico servicioHistorico;

    /**
     * Servicio de inventario
     */
    private IServicioInventario servicioInventario;

    /**
     * Nombre del usuario
     */
    private String userName;

    /**
     * Nombre y apellido del cliente
     */
    private String nombresApellidos;

    /**
     * Compra que se va a realizar
     */
    private Compra compra;

    /**
     * Información del detalle de la compra
     */
    private Pago pago;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase principal
     */
    public CompraBean() {

        servicioCarrito = new ServicioCarritoMock();
        servicioInventario = new ServicioInventarioMock();
        this.userName = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName");
    }

    @PostConstruct
    public void init() {
        this.pago = new Pago();
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * @return the nombresApellidos
     */
    public String getNombresApellidos() {
        return nombresApellidos;
    }

    /**
     * @param nombresApellidos the nombresApellidos to set
     */
    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    /**
     * Devuelve la lista de artículos comprados actualmente
     * @return lista de los artículos comprados
     */
    public List<Articulo> getArticulos() {
        return servicioCarrito.darArticulos();
    }

    /**
     * Devuelve el total de la compra
     * @return total de la compra
     */
    public Double getTotalCompra() {
        return servicioCarrito.darTotal();
    }

    /**
     * Agrega un artículo al carrito de compras
     * @param mueble mueble que va a ser agregado al carrito
     * @return retorna la página de navegación
     */
    public String agregarArticulo(Mueble mueble) {
        if (this.userName == null) {
            return null;
        } else {
            servicioCarrito.agregarArticulo(mueble);
            return "carrito.xhtml";
        }
    }

    /**
     * Valida que el usuario esté autenticado
     */
    public void validarSesion() {
        this.userName = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName");
        if (this.userName == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe registrarse o iniciar sesión.");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        }
    }

    /**
     * Verifica que los artículos solicitados se encuentren en el inventario
     */
    public void verificarInventario() {
        String respuestaInventario = servicioInventario.verificarExistencia(getArticulos());
        if (respuestaInventario.length() > 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", respuestaInventario);
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        }
    }

    /**
     * mensaje de coonfirmación de la compra
     */
    public void mensajeConfirmacion() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información",
                "La compra ha sido registrada correctamente. Su número de orden es: " + String.valueOf(compra.getNumeroOrden()));
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

    /**
     * Realiza la compra 
     * @return Página de navegación
     */
    public String comprar() {

        String respuestaInventario = servicioInventario.verificarExistencia(getArticulos());

        if (respuestaInventario.length() > 0) {
            return null;
        } else {

            servicioGeneradorReferencia = ServicioGeneradorReferenciaMock.getInstance();
            compra = new Compra();
            compra.setUserName(this.userName);
            int numeroOrden = servicioGeneradorReferencia.generarReferencia();
            compra.setNumeroOrden(numeroOrden);
            compra.setDescripcionCompra(obtenerDescripcionCompra());
            compra.setTotalCompras(servicioCarrito.darTotal());
            compra.setFechaCompra(new Date());
            compra.setPago(this.pago);
            compra.setArticulos((ArrayList<Articulo>) getArticulos());

            servicioInventario.actualizarInventario(getArticulos());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "co", null);
            return "pagar";
        }
    }

    /**
     * Devuelve la compra realizada
     * @return compra realizada
     */
    public Compra getCompra() {
        return compra;
    }

    /**
     * Devuelve el usuario autenticado
     * @return 
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Realiza el proceso de pago de la compra
     * @return Página de navegación
     */
    public String pagar() {

        servicioHistorico = ServicioHistoricoMock.getInstance();
        servicioHistorico.agregarCompra(compra);
        servicioCarrito.reiniciarCarrito();

        compra = new Compra();
        pago = new Pago();
        return "principal.xhtml";
    }

    /**
     * Devuelve la descripción de la compra
     * @return descripción de la compra
     */
    private String obtenerDescripcionCompra() {
        String descripcion = "";
        for (Articulo articulo : getArticulos()) {
            descripcion += String.valueOf(articulo.getCantidad()) + " Mueble(s) - Referencia " + articulo.getMueble().getReferencia() + ", ";
        }
        return descripcion.substring(0, descripcion.length() - 2);
    }

    /**
     * Devuelve los tipos de muebles
     *
     * @return sitems Tipos de muebles en el sistema
     */
    public SelectItem[] getTiposPago() {
        TipoPago[] tipos = TipoPago.values();
        SelectItem[] sitems = new SelectItem[tipos.length];

        for (int i = 0; i < sitems.length; i++) {
            sitems[i] = new SelectItem(tipos[i]);
        }
        return sitems;
    }

}
