/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelCustomersNewEdit;
import views.ViewEditCustomers;

/**
 *
 * @author Danni
 */
public class ControlCustomersEdit implements ActionListener {
    
    ModelCustomersNewEdit modelCustomersNewEdit;
    ViewEditCustomers viewEditCustomer;
    
    public ControlCustomersEdit(ModelCustomersNewEdit modelCustomersNewEdit, ViewEditCustomers viewEditCustomer){
        this.modelCustomersNewEdit = modelCustomersNewEdit;
        this.viewEditCustomer = viewEditCustomer;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
