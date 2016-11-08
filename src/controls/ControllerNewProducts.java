/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelProducts;
import views.ViewNewProducts;
/**
 *
 * @author Diego
 */
public class ControllerNewProducts implements  ActionListener{
     ModelProducts mnp = new ModelProducts();
    ViewNewProducts vnp = new ViewNewProducts();
    public ControllerNewProducts(ModelProducts mnp, ViewNewProducts vnp){
        this.mnp = mnp;
        this.vnp = vnp;
      this.vnp.jtf_existencias.addActionListener(this);
      this.vnp.jtf_idProducto.addActionListener(this);
      this.vnp.jtf_idProducto.addActionListener(this);
      this.vnp.jtf_precioCompra.addActionListener(this);
      this.vnp.jtf_precioVenta.addActionListener(this);
      this.vnp.jtf_producto.addActionListener(this);
      this.vnp.jbtn_save.addActionListener(this);
      this.vnp.jbtn_back.addActionListener(this);
      init_view();
      
    } 
    
    public void init_view(){
        this.vnp.setVisible(true);
    }

    public void nuevo(){
        int existencias = Integer.parseInt(this.vnp.jtf_existencias.getText());
        String descripcion = this.vnp.jta_descripcion.getText();
        String precioCompra = this.vnp.jtf_precioCompra.getText();
        String precioVenta = this.vnp.jtf_precioVenta.getText();
        String producto = this.vnp.jtf_producto.getText();
        
        String query = "Insert into productos (producto, descripcion, precio_compra, precio_venta, existencias)"+ "values('"+producto+"','"+descripcion+"','"+precioCompra+"','"+precioVenta+"','"+existencias+"');";
        this.mnp.add(query);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vnp.jbtn_save)
            nuevo();
    }
}
