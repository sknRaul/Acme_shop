/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.ViewSuppliers;
import models.ModelSuppliers;
/**
 *
 * @author panda
 */
public class ControlSuppliers implements ActionListener {

    private ModelSuppliers modelSuppliers;
    private ViewSuppliers viewSuppliers;
    
    public ControlSuppliers(ModelSuppliers modelSuppliers, ViewSuppliers viewSuppliers){
        this.modelSuppliers = modelSuppliers;
        this.viewSuppliers = viewSuppliers;
        
        inView();
        
    }
    
    public void inView(){
        this.viewSuppliers.setTitle("Proveedores");
        this.viewSuppliers.setVisible(true);
        this.viewSuppliers.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
