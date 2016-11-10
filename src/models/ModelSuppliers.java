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
public class ModelSuppliers {
    ConnectionDB cb = new ConnectionDB();
    
    private int editer;
    private int error;
    
    public void add(String insert){
        cb.Connection("acme_shop", "root", "1234");
        setError(cb.add(insert));
    }

    /**
     * @return the editer
     */
    public int getEditer() {
        return editer;
    }

    /**
     * @param editer the editer to set
     */
    public void setEditer(int editer) {
        this.editer = editer;
    }

    /**
     * @return the error
     */
    public int getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(int error) {
        this.error = error;
    }
}
