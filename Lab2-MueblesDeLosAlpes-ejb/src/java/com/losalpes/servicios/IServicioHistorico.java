/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Compra;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface IServicioHistorico {
    public ArrayList<Compra> getCompras();
    public void agregarCompra(Compra compra);
}
