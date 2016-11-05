/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import models.ModelSales;
import views.ViewSales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdda.ConnectionDB;

/**
 *
 * @author Danni
 */
public class ControlSales implements ActionListener {
    ConnectionDB con = new ConnectionDB();
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    Object [] fila = new Object[5];    
    double res;
    
    private DefaultTableModel model;
    
    ModelSales modelSales;
    public ViewSales viewSales;
    
    public ControlSales(ModelSales modelSales, ViewSales viewSales){
        
        this.modelSales = modelSales;
        this.viewSales = viewSales;
        conexion = con.Connection("acme_shop", "root", "1234");
        
        try{
            st = conexion.createStatement();
        }catch(SQLException esql){
            System.out.println("Error"+esql.getMessage());
        }
        
        this.viewSales.jbtn_add.addActionListener(this);
        this.viewSales.jbtn_cancelSale.addActionListener(this);
        this.viewSales.jbtn_closeSale.addActionListener(this);
        this.viewSales.jbtn_newSale.addActionListener(this);
        this.viewSales.jbtn_searchByName.addActionListener(this);
        this.viewSales.jbtn_searchCustomer.addActionListener(this);
        this.viewSales.jbtn_searchProduct.addActionListener(this);
        inView();
    }
    
    public void inView(){
        this.viewSales.setVisible(true);
    }
    
    public void cargarInterface(){
        String data[][] = {};
        String col[] = {"ID.","Producto","Precio","Cantidad","Total"};
        model = new DefaultTableModel(data, col);
        this.viewSales.jt_sale.setModel(model);
        this.viewSales.jtf_taxes.setText("$16.00");
    }
    
    public void llenarFilas(){
        fila[0] = con.getColumn()[1];
        fila[1] = con.getColumn()[2];
        fila[2] = con.getColumn()[4];
        fila[3] = "1";
        fila[4] = con.getColumn()[4];
        model.addRow(fila);
    }
    
    public void jmiByName(){
        this.modelSales.setName(JOptionPane.showInputDialog(viewSales, "Introduzca el nombre del producto."));
        con.basicConsult("productos", "nombre",this.modelSales.getName());
        llenarFilas();        
    }
    
    public void jmiByID(){
        this.modelSales.setIdProduct(this.viewSales.jtf_idProduct.getText());
        con.basicConsult("productos", "id_producto", this.modelSales.getIdProduct());
        llenarFilas();
        double total = Double.parseDouble(con.getColumn()[4]);
        res = total + res;
        this.viewSales.jtf_total.setText("$"+res);
    }
    
    public void jbtnSearchCustomerActionPerformed(){
        this.modelSales.setIdCustomer(this.viewSales.jtf_idCustomer.getText());
        con.basicConsult("clientes", "id_cliente", this.modelSales.getIdCustomer());
        this.viewSales.jtf_customer.setText(""+con.getColumn()[1]+" "+con.getColumn()[2]+" "+con.getColumn()[3]);
        this.viewSales.jtf_rfc.setText(""+con.getColumn()[9]);
    }
    
    public void jbtnCloseSaleActionPerformed(){
        double resF = (res*.16) + res;
        this.viewSales.jtf_totalN.setText("$"+resF);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.viewSales.jbtn_searchProduct))
            jmiByID();
        else if(ae.getSource().equals(this.viewSales.jbtn_newSale))
            cargarInterface();
        else if(ae.getSource().equals(this.viewSales.jbtn_searchByName))
            jmiByName();
        else if(ae.getSource().equals(this.viewSales.jbtn_searchCustomer))
            jbtnSearchCustomerActionPerformed();
        else if(ae.getSource().equals(this.viewSales.jbtn_closeSale))
            jbtnCloseSaleActionPerformed();
    }
}
