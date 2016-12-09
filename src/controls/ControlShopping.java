/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import models.ModelShopping;
import views.ViewShopping;
import stringTo.StringTo;
import jdda.ConnectionDB;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author Raúl
 */
public class ControlShopping implements ActionListener {
    ModelShopping ms;
    ViewShopping vs;
    StringTo st = new StringTo();
    ConnectionDB cb = new ConnectionDB();
    ResultSet rs;
    Object con = cb.Connection("acme_shop", "root", "1234");
    DefaultTableModel tbl;
    
    public ControlShopping(ModelShopping ms, ViewShopping vs){
        this.ms = ms;
        this.vs = vs;
        
        inView();
        enableShop(false);
        this.vs.jbtn_suppliersSearch.addActionListener(this);
        this.vs.jbtn_addProduct.addActionListener(this);
        this.vs.jbtn_productSearch.addActionListener(this);
        this.vs.jbtn_addQuantity.addActionListener(this);
        this.vs.jbtn_deleteShop.addActionListener(this);
        this.vs.jbtn_cancel.addActionListener(this);
        this.vs.jbtn_shop.addActionListener(this);
    }
    
    public void enableShop(boolean boo){      
        this.vs.jbtn_addProduct.setEnabled(boo);
        this.vs.jbtn_productSearch.setEnabled(boo);
        this.vs.jbtn_addQuantity.setEnabled(boo);
        this.vs.jbtn_deleteShop.setEnabled(boo);
        this.vs.jbtn_cancel.setEnabled(boo);
        this.vs.jtf_idProduct.setEnabled(boo);
        this.vs.jtf_quantity.setEnabled(boo);
        
        this.vs.jbtn_suppliersSearch.setEnabled(!boo);
        this.vs.jtf_idSupplier.setEditable(!boo);
        this.vs.jbtn_addSupplier.setEnabled(!boo);
    }
    
    public void inView(){
        this.ms.setPrice_product(0);
        this.vs.setVisible(true);
        this.vs.jtf_date.setText(this.ms.getDate());
    }
    
    public void getSupplier(){
        this.ms.setId_supplier(""+st.stringToInt(this.vs.jtf_idSupplier.getText()));
        this.ms.supplier();
        this.vs.jtf_nameSupplier.setText(this.ms.getName_supplier());
    }
    
    public void getProduct(){
        this.ms.setId_product(""+st.stringToInt(this.vs.jtf_idProduct.getText()));
        ms.product();
        this.vs.jtf_nameProduct.setText(this.ms.getName_product());
        this.vs.jtf_priceProduct.setText(""+this.ms.getPrice_product());
    }
    
    public boolean addShop(){
        boolean left = true;
        tbl = (DefaultTableModel) this.vs.jt_shopping.getModel();
        for(int i = 0; tbl.getRowCount()>i; i++){
            int id_product = st.stringToInt( (String) tbl.getValueAt(i, 0));
            if(id_product == st.stringToInt(this.vs.jtf_idProduct.getText()))
                left = false;
            else
                left = true;
        }
        return left;
    }
    
    public void insertTable(){
        if(addShop() && !this.vs.jtf_quantity.getText().equals("")){
            this.ms.setId_product(""+st.stringToInt(this.vs.jtf_idProduct.getText()));
            this.ms.setPrice_product(st.stringToDouble(this.vs.jtf_priceProduct.getText()));
            this.ms.setQuantity(st.stringToInt(this.vs.jtf_quantity.getText()));
            ms.showSubTotal();
            DecimalFormat no = new DecimalFormat("0.00");
            this.vs.jtf_subtotal.setText(""+this.ms.getSubtotal());
            showData();
            this.vs.jtf_iva.setText(""+this.ms.getIva());
            this.vs.jtf_total.setText(""+no.format(this.ms.getTotal()));
            fillDetail();
        }else if(this.vs.jtf_quantity.getText().equals("")){
            JOptionPane.showMessageDialog(this.vs, "Inserta una cantidad por favor");
        }else{
            JOptionPane.showMessageDialog(this.vs, "El producto ya fue agregado a esta compra");
        }
        
    }
    
    public void fillDetail(){
        try {
            rs = cb.query("Select max(id_compra) from compras");
            rs.next();
            this.ms.setId_shop(rs.getInt("max(id_compra)"));
            cb.add("insert into detalle_compras(id_compra, id_producto, cantidad, total_producto, precio) values ('"+this.ms.getId_shop()+"','"+ms.getId_product()+"','"+ms.getQuantity()+"','"+ms.getTotalProduct()+"','"+ms.getPrice_product()+"')");
            rs.close();
            rs = cb.query("Select existencias from productos where id_producto="+ms.getId_product());
            rs.next();
            int quantity = this.ms.getQuantity()+rs.getInt("existencias");
            cb.upDate("update productos set existencias = "+quantity+" where id_producto = "+this.ms.getId_product());
        } catch (Exception e) {
            System.err.println(e.getMessage()+"\nControlShopping.fillDetail");
        }
    }
    
    public void showData(){
        tbl = (DefaultTableModel) this.vs.jt_shopping.getModel();
        try {
            int id = st.stringToInt(this.vs.jtf_idProduct.getText());
            String query = "Select * from productos where id_producto = "+id;
            rs = cb.query(query);
            rs.next();
            tbl.addRow(new Object[]{rs.getString("id_producto"), rs.getString("producto"),rs.getString("precio_compra"),ms.getQuantity(),ms.getTotalProduct()});
        } catch (Exception e) {
            System.err.println(e.getMessage()+"\n showData controlShopping");
        }
        this.vs.jt_shopping.setModel(tbl);
    }
    
    public void delete(){
        int row = this.vs.jt_shopping.getSelectedRow();
        DefaultTableModel tbl = (DefaultTableModel) this.vs.jt_shopping.getModel();
        if(JOptionPane.showConfirmDialog(this.vs, "Deseas borrar el producto de la compra") == 0){
            try {
                double value = (double) this.vs.jt_shopping.getValueAt(row, 4);
                this.ms.setSubtotal(this.ms.getSubtotal()-value);
                this.vs.jtf_subtotal.setText(""+this.ms.getSubtotal());
                this.ms.deleteProduct();
                this.vs.jtf_total.setText(""+this.ms.getTotal());
                tbl.removeRow(row);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.out.println("En el controlSuppliers");
            }
        }
    }
    
    public void shop(){   
        if(this.vs.jbtn_shop.getText().equals("Comprar") && JOptionPane.showConfirmDialog(this.vs, "Desea terminar la operación") == 0){
            this.vs.jbtn_shop.setText("Iniciar Compra");
            enableShop(false);
            this.cb.add("update compras set subtotal ="+this.ms.getSubtotal()+", total = "+this.ms.getTotal()+"where id_compra = "+this.ms.getId_shop());
            this.cb.query("Commit");
            clean();
            this.ms.clean();
        }else if(this.vs.jbtn_shop.getText().equals("Iniciar Compra") && !this.vs.jtf_nameSupplier.getText().equals("")){
            this.vs.jbtn_shop.setText("Comprar");
            enableShop(true);
            this.cb.query("Start transaction");
            try {
                cb.upDate("Insert into compras (id_proveedor, fecha, subtotal, iva, total) values ('"+this.ms.getId_supplier()+"',now(),'"+this.ms.getSubtotal()+"','"+this.ms.getIva()+"','"+this.ms.getTotal()+"')");
            } catch (Exception e) {
                System.err.println(e.getMessage()+"\ncontrolShopping.shop");
            }
        }else if (this.vs.jtf_nameSupplier.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Introduce el proveedor al que se le esta comprando");
        }
    }
    
    public void clean(){
        tbl = (DefaultTableModel)this.vs.jt_shopping.getModel();
        while(tbl.getRowCount()>0)
            tbl.removeRow(0);
        this.vs.jt_shopping.setModel(tbl);
        this.ms.setTotal(0);
        this.ms.setSubtotal(0);
        this.ms.setId_supplier(null);
        this.vs.jtf_nameSupplier.setText("");
        this.vs.jtf_idProduct.setText("");
        this.vs.jtf_idProduct.setText("");
        this.vs.jtf_nameProduct.setText("");
        this.vs.jtf_priceProduct.setText("");
        this.vs.jtf_quantity.setText("");
        this.vs.jtf_subtotal.setText("");
        this.vs.jtf_idSupplier.setText("");
        this.vs.jtf_total.setText("");
    }

    public void cancelShop(){
        if(JOptionPane.showConfirmDialog(this.vs, "Deseas cancelar la compra") == 0){
            cb.query("rollback");
            clean();
            this.ms.clean();
            enableShop(false);
            this.vs.jbtn_shop.setText("Iniciar Compra");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vs.jbtn_suppliersSearch)
            getSupplier();
        if(e.getSource()== this.vs.jbtn_productSearch)
            getProduct();
        if(e.getSource() == this.vs.jbtn_addQuantity)
            insertTable();
        if(e.getSource() == this.vs.jbtn_deleteShop)
            delete();
        if(e.getSource() == this.vs.jbtn_cancel)
            cancelShop();
        if(e.getSource() == this.vs.jbtn_shop)
            shop();
    }
}
