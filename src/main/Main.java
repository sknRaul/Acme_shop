/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import controls.*;
import models.*;
import views.*;
/**
 *
 * @author panda
 */
public class Main {
    public static void main(String[] DDR) {
        ViewAddSupplier vas = new ViewAddSupplier();
        ModelSuppliers mas = new ModelSuppliers();
        ControlAddSupplier cas = new ControlAddSupplier(mas, vas);
        
        ViewEditSuppliers ves = new ViewEditSuppliers();
        ModelSuppliers mes = new ModelSuppliers();
        ControlEditSuppliers ces = new ControlEditSuppliers(mes, ves);
        
        Object controls[] = new Object[2];
        controls[0] = cas;
        controls[1] = ces;
        
        ViewSuppliers vs = new ViewSuppliers();
        ModelSuppliers ms = new ModelSuppliers();
        ControlSuppliers cs = new ControlSuppliers(mes, vs, controls);
    }
}
