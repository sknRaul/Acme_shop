/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import controls.*;
import javax.swing.JPanel;
import models.*;
import views.*;
/**
 *
 * @author panda
 */
public class Main {
    
    public static ViewCustomers viewCustomers;
    public static ModelCustomers modelCustomers;
    public static ControlCustomers controlCustomers;
    public static ViewEditCustomers viewEditCustomer;
    public static ModelCustomersNewEdit modelCustomersNewEdit;
    public static ControlCustomersEdit controlCustomerEdit;  
    public static ViewNewCustomers viewNewCustomer;
    public static ControlCustomersNew controlCustomersNew;
    
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
        vs.setVisible(false);
        viewEditCustomer = new ViewEditCustomers();
        modelCustomersNewEdit = new ModelCustomersNewEdit();
        controlCustomerEdit = new ControlCustomersEdit(modelCustomersNewEdit, viewEditCustomer);
        
        viewNewCustomer = new ViewNewCustomers();
        controlCustomersNew = new ControlCustomersNew(modelCustomersNewEdit, viewNewCustomer);
                
        viewCustomers = new ViewCustomers();
        modelCustomers = new ModelCustomers();
        
        
        JPanel views[] = new JPanel[2];
        views[0] = viewNewCustomer;
        views[1] = viewEditCustomer;
        
        controlCustomers = new ControlCustomers(modelCustomersNewEdit, viewCustomers, views);
        viewCustomers.setVisible(false);
        
        ViewMain vm = new ViewMain();
        ModelMain mm = new ModelMain();
        
        Object controlsMain[] = new Object[2];
        controlsMain[0] = cs;
        controlsMain[1] = controlCustomers;
        
        ControlMain cm = new ControlMain(mm, vm, controlsMain);
    }
}
