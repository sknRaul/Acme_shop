/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.ViewMain;
import models.ModelMain;

/**
 *
 * @author panda
 */
public class ControlMain implements ActionListener {

    private ModelMain modelMain;
    private ViewMain viewMain;
    private Object controls[];
    
    ControlSuppliers cs;
    ControlCustomers cc;
    ControllerProductos cProducts;
    ControlSales cSales;
    ControlShopping cShopping;

    public ControlMain(ModelMain modelMain, ViewMain viewMain, Object controls[]) {
        this.viewMain = viewMain;
        this.modelMain = modelMain;
        this.controls = controls;

        inView();

        cs = (ControlSuppliers) controls[0];
        cc = (ControlCustomers) controls[1];
        cSales = (ControlSales) controls[2];
        cProducts = (ControllerProductos) controls[3];
        cShopping = (ControlShopping) controls[4];

        this.viewMain.jmi_Customers.addActionListener(this);
        this.viewMain.jmi_suppliers.addActionListener(this);
        this.viewMain.jmi_sales.addActionListener(this);
        this.cs.viewSuppliers.jbtn_back.addActionListener(this);
        this.cc.viewCustomers.jbtn_back.addActionListener(this);
        this.cSales.viewSales.jbtn_back.addActionListener(this);
        this.viewMain.jmi_sales.addActionListener(this);
        this.viewMain.jm_products.addActionListener(this);
        this.viewMain.jmi_products.addActionListener(this);
        this.cProducts.viewProducts.jbtn_back.addActionListener(this);
        this.viewMain.jmi_customersReport.addActionListener(this);
        this.viewMain.jmi_productsReport.addActionListener(this);
        this.viewMain.jmi_salesReport.addActionListener(this);
        this.viewMain.jmi_suppliersReport.addActionListener(this);
        this.viewMain.jmi_shopping.addActionListener(this);
        this.cShopping.vs.jbtn_addSupplier.addActionListener(this);
        this.cs.cas.vas.jbtn_back.addActionListener(this);
        this.cShopping.vs.jbtn_addProduct.addActionListener(this);
        this.cProducts.cnp.vnp.jbtn_back.addActionListener(this);
    }

    public void inView() {
        this.viewMain.setTitle("Principal");
        this.viewMain.setVisible(true);
        this.viewMain.setLocationRelativeTo(null);
    }

    public void inViewC() {
        this.viewMain.setTitle("Principal");
        this.viewMain.setVisible(true);
        cc.viewCustomers.setVisible(false);
        this.viewMain.setLocationRelativeTo(null);
    }

    public void suppliers() {
        this.viewMain.setVisible(false);
        cs.inView();
    }

    public void customers() {
        this.viewMain.setVisible(false);
        cc.inView();
    }

    public void products() {
        this.viewMain.setVisible(false);
        cProducts.init_view();
    }

    public void sales() {
        this.viewMain.setContentPane(cSales.viewSales);
        this.viewMain.revalidate();
        this.viewMain.repaint();
        this.viewMain.setSize(cSales.viewSales.jp_size.getSize());
        this.viewMain.setLocationRelativeTo(null);
        cSales.chooseASeller(JOptionPane.showInputDialog(viewMain, "¡ BIENVENIDO !\n Introduzca Clave Vendedor"));
    }
    
    public void shopping(){
        this.viewMain.setContentPane(cShopping.vs);
        this.viewMain.revalidate();
        this.viewMain.repaint();
        this.viewMain.setSize(847, 527);
        this.viewMain.setLocationRelativeTo(null);
    }
    
    public void addSupplierShop(){
        this.viewMain.setContentPane(cs.cas.vas);
        this.viewMain.revalidate();
        this.viewMain.repaint();
        this.viewMain.pack();
        this.viewMain.setLocationRelativeTo(null);
    }
    
    public void addProductsShop(){
        this.viewMain.setContentPane(cProducts.cnp.vnp);
        this.viewMain.revalidate();
        this.viewMain.repaint();
        this.viewMain.setSize(788, 500);
        this.viewMain.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.viewMain.jmi_suppliers) {
            suppliers();
        } else if (e.getSource() == this.viewMain.jmi_Customers) {
            customers();
        } else if (e.getSource() == this.viewMain.jmi_products) {
            products();
        } else if (e.getSource() == this.cs.viewSuppliers.jbtn_back) {
            inView();
        } else if (e.getSource() == this.viewMain.jmi_sales) {
            sales();
        } else if (e.getSource().equals(this.cc.viewCustomers.jbtn_back)) {
            inViewC();
        } else if (e.getSource().equals(this.cSales.viewSales.jbtn_back)) {
            this.cSales.viewSales.setVisible(false);
            inView();
        }
        else if(e.getSource() == this.cProducts.viewProducts.jbtn_back){
            this.cProducts.viewProducts.setVisible(false);
            inView();
        }
        else if(e.getSource() == this.viewMain.jmi_suppliersReport)
            this.modelMain.generate("src\\reports\\SuppliersReport.jrxml",this.viewMain);
        else if (e.getSource() == this.viewMain.jmi_customersReport)
            this.modelMain.generate("src\\reports\\CustomersReport.jrxml",this.viewMain);
        else if (e.getSource() == this.viewMain.jmi_productsReport)
            this.modelMain.generate("src\\reports\\ProductsReport.jrxml",this.viewMain);
        else if (e.getSource() == this.viewMain.jmi_salesReport)
           this.modelMain.generate("src\\reports\\SalesReport.jrxml",this.viewMain);
        else if(e.getSource()== this.viewMain.jmi_shopping || e.getSource()== this.cs.cas.vas.jbtn_back || e.getSource() == this.cProducts.cnp.vnp.jbtn_back)
            shopping();
        else if(e.getSource() == this.cShopping.vs.jbtn_addSupplier)
            addSupplierShop();
        else if(e.getSource() == this.cShopping.vs.jbtn_addProduct)
            addProductsShop();
    }
}
