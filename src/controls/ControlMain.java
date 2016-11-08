/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.ViewMain;
import models.ModelMain;
/**
 *
 * @author panda
 */
public class ControlMain implements ActionListener{
    private ModelMain modelMain;
    private ViewMain viewMain;
    private Object controls[];
    ControlSuppliers cs;
    ControlCustomers cc;
    ControllerProductos cProducts;
    ControlSales cSales;
    
    public ControlMain(ModelMain modelMain, ViewMain viewMain, Object controls[]){
        this.viewMain = viewMain;
        this.modelMain = modelMain;
        this.controls = controls;
        
        inView();
        
        cs = (ControlSuppliers) controls[0];
        cc = (ControlCustomers) controls[1];
        cSales = (ControlSales) controls[2];
        cProducts = (ControllerProductos) controls[3];
        
        this.viewMain.jmi_Customers.addActionListener(this);
        this.viewMain.jmi_suppliers.addActionListener(this);
        this.viewMain.jmi_sales.addActionListener(this);
        this.cs.viewSuppliers.jbtn_back.addActionListener(this);
        this.viewMain.jmi_sales.addActionListener(this);
        this.viewMain.jm_products.addActionListener(this);
        this.viewMain.jmi_products.addActionListener(this);
    }
    
    public void inView(){
        this.viewMain.setTitle("Principal");
        this.viewMain.setVisible(true);
        this.viewMain.setLocationRelativeTo(null);
    }
    
    public void suppliers(){
        this.viewMain.setVisible(false);
        cs.inView();
    }
    
    public void customers(){
        this.viewMain.setVisible(false);
        cc.inView();
    }
    public void products(){
        this.viewMain.setVisible(false);
        cProducts.init_view();
    }
        
    public void sales(){
        this.viewMain.setContentPane(cSales.viewSales);
        this.viewMain.revalidate();
        this.viewMain.repaint();
        this.viewMain.setSize(cSales.viewSales.jp_size.getSize());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.viewMain.jmi_suppliers)
            suppliers();
        else if(e.getSource() == this.viewMain.jmi_Customers)
            customers();
        else if(e.getSource() == this.viewMain.jmi_products)
            products();
        else if(e.getSource() == this.cs.viewSuppliers.jbtn_back)
            inView();
       else if(e.getSource() == this.viewMain.jmi_sales)
            sales();
    }
}
