/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import jdda.ConnectionDB;

/**
 *
 * @author panda
 */
public class ModelProducts {
     ConnectionDB cb = new ConnectionDB();
    
    private int editar;
    private int errores;
    
    
    public void add(String insert){
        cb.Connection("acme_shop", "root", "1234");
        cb.add(insert);
    }

    /**
     * @return the editar
     */
    public int getEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(int editar) {
        this.editar = editar;
    }

    /**
     * @return the errores
     */
    public int getErrores() {
        return errores;
    }

    /**
     * @param errores the errores to set
     */
    public void setErrores(int errores) {
        this.errores = errores;
    }
}

   