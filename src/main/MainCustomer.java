/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import views.ViewCustomers;
import views.ViewEditCustomers;
import views.ViewNewCustomers;
import models.ModelCustomers;
import models.ModelCustomersNewEdit;
import controls.ControlCustomersEdit;
import controls.ControlCustomersNew;
import controls.ControlCustomers;
import javax.swing.JPanel;
/**
 *
 * @author Danni
 */
public class MainCustomer {
    private static ViewCustomers viewCustomers;
    private static ModelCustomers modelCustomers;
    private static ControlCustomers controlCustomers;
    private static ViewEditCustomers viewEditCustomer;
    private static ModelCustomersNewEdit modelCustomersNewEdit;
    private static ControlCustomersEdit controlCustomerEdit;  
    private static ViewNewCustomers viewNewCustomer;
    private static ControlCustomersNew controlCustomersNew;

    public static void main(String[] jdda) {
        viewEditCustomer = new ViewEditCustomers();
        modelCustomersNewEdit = new ModelCustomersNewEdit();
        controlCustomerEdit = new ControlCustomersEdit(modelCustomersNewEdit, viewEditCustomer);
        
        viewNewCustomer = new ViewNewCustomers();
        controlCustomersNew = new ControlCustomersNew();
                
        viewCustomers = new ViewCustomers();
        modelCustomers = new ModelCustomers();
        
        JPanel views[] = new JPanel[2];
        views[0] = viewNewCustomer;
        views[1] = viewEditCustomer;

        controlCustomers = new ControlCustomers(modelCustomers, viewCustomers, views);

    }
}
