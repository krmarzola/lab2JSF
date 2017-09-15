

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

package com.losalpes.servicios;

import com.losalpes.bos.Articulo;
import com.losalpes.bos.Compra;
import com.losalpes.bos.Pago;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Implementacion de los servicios del catalogo de muebles que se le prestan al sistema. [Mock Object]
 * 
 */

public class ServicioHistoricoMock implements IServicioHistorico
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Arreglo con las compras del sistema
     */
    private ArrayList<Compra> compras;

	private static ServicioHistoricoMock instance = null;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    protected ServicioHistoricoMock()
    {

        //Inicializa el arreglo de los Compras
        compras=new ArrayList<Compra>();

		//Datos de prueba 1 Compra
		Compra compra = new Compra();
		compra.setFechaCompra(Calendar.getInstance().getTime());
		compra.setNumeroOrden(1);
		compra.setUserName("Cliente 1");

		ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
		ServicioCatalogoMock catalogoMuebles = new ServicioCatalogoMock();
		listaArticulos.add(new Articulo(catalogoMuebles.darMuebles().get(0)));
		listaArticulos.add(new Articulo(catalogoMuebles.darMuebles().get(1)));
		listaArticulos.add(new Articulo(catalogoMuebles.darMuebles().get(2)));
		compra.setArticulos(listaArticulos);

		compra.setTotalCompras(10.0);
		compra.setDescripcionCompra("Prueba descripción");

		Pago pago = new Pago("123",1100,Calendar.getInstance().getTime(),10,"Crédito");
		compra.setPago(pago);

		compras.add(compra);
		// Fin de dato de prueba

    }


    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
	 /**
     * Instancia singleton
     */
	public static ServicioHistoricoMock getInstance() {
		if(instance == null) {
			instance = new ServicioHistoricoMock();
		}
		return instance;
	}

    /**
     * Obtiene la lista de compras
    */
	@Override
	public ArrayList<Compra> getCompras(){
		return compras;
	}

	/**
     * Agregar compra
	 * @param compra Nueva compra
    */
	@Override
	public void agregarCompra(Compra compra){
		compras.add(compra);
	}

}
