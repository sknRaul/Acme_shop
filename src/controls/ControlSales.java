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
import java.util.Calendar;
import models.ModelCustomersNewEdit;

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
    Calendar cal = Calendar.getInstance();
    double res;
    String fecha=cal.get(cal.DATE)+"/"+(cal.get(cal.MONTH)+1)+"/"+cal.get(cal.YEAR);
    
    private DefaultTableModel model;
    
    ModelSales modelSales;
    ViewSales viewSales;
    ModelCustomersNewEdit modelCustomersNewEdit;
    
    public ControlSales(ModelSales modelSales, ViewSales viewSales){
        
        this.modelSales = modelSales;
        this.viewSales = viewSales;
        conexion = con.Connection("acme_shop", "root", "1234");
        
        this.modelCustomersNewEdit = new ModelCustomersNewEdit();
        
        try{
            st = conexion.createStatement();
        }catch(SQLException esql){
            System.out.println("Error"+esql.getMessage());
        }
        
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
        this.modelSales.setTotal(Integer.parseInt(con.getColumn()[4])*this.modelSales.getNumber());
        fila[0] = con.getColumn()[1];
        fila[1] = con.getColumn()[2];
        fila[2] = con.getColumn()[4];
        fila[3] = this.modelSales.getNumber();
        fila[4] = this.modelSales.getTotal();
        model.addRow(fila);
    }
    
    public void jmiByName(){
        this.modelSales.setName(JOptionPane.showInputDialog(viewSales, "Introduzca el nombre del producto."));
        con.basicConsult("productos", "nombre",this.modelSales.getName());
        this.modelSales.setNumber(Integer.parseInt(JOptionPane.showInputDialog(viewSales, "Introduzca la cantindad")));
        llenarFilas();        
    }
    
    public void jmiByID(){
        this.modelSales.setIdProduct(this.viewSales.jtf_idProduct.getText());
        this.modelSales.setNumber(Integer.parseInt(JOptionPane.showInputDialog(viewSales, "Introduzca la cantindad")));
        con.basicConsult("productos", "id_producto", this.modelSales.getIdProduct());
        llenarFilas();
        
        res = res + this.modelSales.getTotal();
        this.viewSales.jtf_total.setText("$"+res);
    }
    
    public void jbtnSearchCustomerActionPerformed(){
        this.modelSales.setIdCustomer(this.viewSales.jtf_idCustomer.getText());
        con.basicConsult("clientes", "id_cliente", this.modelSales.getIdCustomer());
        this.viewSales.jtf_customer.setText(""+con.getColumn()[1]+" "+con.getColumn()[2]+" "+con.getColumn()[3]);
        this.viewSales.jtf_rfc.setText(""+con.getColumn()[12]);
    }
    
    public void jbtnCloseSaleActionPerformed(){
        this.modelSales.setTotalN(res + (res*.16));
        this.viewSales.jtf_totalN.setText("$"+this.modelSales.getTotalN());
        double usMoney = Double.parseDouble(JOptionPane.showInputDialog(viewSales, "Introduzca el dinero del cliente"));
        double cambio = this.modelSales.getTotalN() - usMoney;
        JOptionPane.showMessageDialog(viewSales, "Total a pagar: "+this.modelSales.getTotalN()+"\nDinero del Cliente: "+usMoney+"\nCambio a devolver: "+cambio);
        cargarInterface();
    }
    
    public void jbtnCancelSaleActionPerformed(){
        String pass = JOptionPane.showInputDialog(viewSales,"Contraseña de Administrador");
        if(pass.equals(this.modelCustomersNewEdit.getPass())){
            int resp = JOptionPane.showConfirmDialog(viewSales, "¿Esta seguro de querer cancelar la venta?", "Cancelar Venta", JOptionPane.YES_NO_OPTION);        
            if(resp == 0){
                JOptionPane.showMessageDialog(viewSales, "Venta Cancelada");
                cargarInterface();
                this.viewSales.jtf_customer.setText("");
                this.viewSales.jtf_idCustomer.setText("");
            }   
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(this.viewSales.jbtn_searchProduct)) {
            jmiByID();
        } else if (ae.getSource().equals(this.viewSales.jbtn_newSale)) {
            cargarInterface();
            this.viewSales.jtf_seller.setText("Vendedor / ADMIN");
            this.viewSales.jtf_idSeller.setText("1");
            this.viewSales.jl_dateFormat.setText(fecha);
        }
        else if(ae.getSource().equals(this.viewSales.jbtn_searchByName))
            jmiByName();
        else if(ae.getSource().equals(this.viewSales.jbtn_searchCustomer))
            jbtnSearchCustomerActionPerformed();
        else if(ae.getSource().equals(this.viewSales.jbtn_closeSale))
            jbtnCloseSaleActionPerformed();
        else if(ae.getSource().equals(this.viewSales.jbtn_cancelSale))
            jbtnCancelSaleActionPerformed();
    }
    
}
