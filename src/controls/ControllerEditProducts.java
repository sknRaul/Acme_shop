/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelProducts;
import views.ViewEditProducts;
import jdda.ConnectionDB;
import java.sql.ResultSet;
/**
 *
 * @author Diego
 */
public class ControllerEditProducts implements ActionListener {
    ModelProducts mep = new ModelProducts();
    ViewEditProducts vep = new ViewEditProducts();
    ConnectionDB cb = new ConnectionDB();
    ResultSet rs;
public ControllerEditProducts(ModelProducts mp,ViewEditProducts vep){
        this.mep = mp;
        this.vep = vep;
        
        init_view();
        this.vep.jbtn_savee.addActionListener(this);
        this.vep.jbtn_back.addActionListener(this);
        
    }

public void init_view(){
        this.vep.setVisible(true);
    }

public void showEditableData(){
        int editable = this.mep.getEditer();
        cb.Connection("acme_shop", "root", "1234");
        String query = "Select * from productos where id_producto = "+editable;
        try {
            rs = cb.query(query);
            while(rs.next()){
                this.vep.jtf_idProductoe.setText(rs.getString("id_producto"));
                this.vep.jtf_productoe.setText(rs.getString("producto"));
                this.vep.jta_descripcione.setText(rs.getString("descripcion"));
                this.vep.jtf_precioComprae.setText(rs.getString("precio_compra"));
                this.vep.jtf_precioVentae.setText(rs.getString("precio_venta"));
                this.vep.jtf_existenciase.setText(rs.getString("existencias"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

        public void edit_save(){
        String producto = this.vep.jtf_productoe.getText();
        String precioCompra = this.vep.jtf_precioComprae.getText();
        String precioVenta = this.vep.jtf_precioVentae.getText();
        String existencias = this.vep.jtf_existenciase.getText();
        String descripcion = this.vep.jta_descripcione.getText();
        String query = "Update producto set producto ="+"'"+producto+"'"+", descripcion ="+"'"+descripcion+"'"+", precio_compra = " +"'"+precioCompra+"'"+", precio_venta = " +"'"+precioVenta +"'"+", existencias = "+"'"+existencias+"'"+" where id_provedor = "+this.mep.getEditer();
        this.mep.add(query);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==this.vep.jbtn_savee)
         edit_save();
    }
    
}
