/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import java.sql.ResultSet;
import jdda.ConnectionDB;
import views.ViewProducts;
import models.ModelProducts;
/**
 *
 * @author Diego
 */
public class ControllerProductos implements ActionListener {
    private ResultSet rs = null;
    private ConnectionDB cb = new ConnectionDB();
    private ModelProducts modelProducts;
    public ViewProducts viewProducts;
    private Object controls[] = new Object[2];
    ControllerNewProducts cnp;//cas;
    ControllerEditProducts cep;//ces;
    
    public ControllerProductos(ModelProducts modelProducts, ViewProducts viewProducts,Object controls[]){
        this.controls = controls;
        this.modelProducts = modelProducts;
        this.viewProducts = viewProducts;
        
        cnp = (ControllerNewProducts) controls[0];
        cep = (ControllerEditProducts) controls[1];
        
        this.viewProducts.jbtn_borrar.addActionListener(this);
        this.viewProducts.jbtn_edit.addActionListener(this);
        this.viewProducts.jm_agregar.addActionListener(this);
        this.viewProducts.jm_buscar.addActionListener(this);
        this.viewProducts.jmi_descricionProducto.addActionListener(this);
        this.viewProducts.jmi_noProducto.addActionListener(this);
        this.viewProducts.jmi_nombreProducto.addActionListener(this);
        this.viewProducts.jmi_nuevoProducto.addActionListener(this);
       
        
    }
    
    public void init_view(){
        this.viewProducts.setTitle("Productos");
        this.viewProducts.setVisible(true);
        this.viewProducts.setLocationRelativeTo(null);
        showData("Select * from productos");
    }
    
   
    
    public void add(){
        this.viewProducts.setContentPane(cnp.vnp);
        this.viewProducts.revalidate();
        this.viewProducts.repaint();
        this.viewProducts.pack();
    }
    
    public void back(){
        this.viewProducts.setContentPane(this.viewProducts.jp_BackGround);
        this.viewProducts.revalidate();
        this.viewProducts.repaint();
        this.viewProducts.setSize(this.viewProducts.getSize());
        clean();
        showData("Select * from provedores");
    }
    
    public void delete(){
        cb.Connection("acme_shop", "root", "1234");
        int colum = this.viewProducts.jt_productos.getSelectedColumn();
        int row = this.viewProducts.jt_productos.getSelectedRow();
        try {
            int value = (int) this.viewProducts.jt_productos.getValueAt(row, 0);
            cb.delete("delete from productos where id_producto ="+value);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("En el controllerProducts");
        }
        clean();
        showData("Select * from productos");
    }
    
    
    public void edit(){
        this.viewProducts.setContentPane(cep.vep);
        this.viewProducts.revalidate();
        this.viewProducts.repaint();
        this.viewProducts.pack();
        
        int row = this.viewProducts.jt_productos.getSelectedRow();
        int editer = (int)this.viewProducts.jt_productos.getValueAt(row, 0);
        this.cep.mep.setEditer(editer);
        this.cep.showEditableData();
    }
    
    public void clean(){
        DefaultTableModel tblProducts = (DefaultTableModel) this.viewProducts.jt_productos.getModel();
        while(tblProducts.getRowCount()>0)
            tblProducts.removeRow(0);
        this.viewProducts.jt_productos.setModel(tblProducts);
    }
    
    public void showData(String query){
        cb.Connection("acme_shop", "root", "1234");
        clean();
        DefaultTableModel tblProducts = (DefaultTableModel) this.viewProducts.jt_productos.getModel();
        this.viewProducts.jt_productos.setModel(tblProducts);
        try {
            rs = cb.query(query);
            while(rs.next()){
                tblProducts.addRow(new Object[]{rs.getInt("id_producto"),rs.getString("producto"), rs.getString("descripcion"), rs.getString("precio_compra"), rs.getString("precio_venta"), rs.getString("existencias")});
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        this.viewProducts.jt_productos.setModel(tblProducts);
    }
    
    public void seach(String factor, String message){
        String field;
        try {
            field = JOptionPane.showInputDialog(viewProducts, "Escribe "+message+"que buscas");
            showData("Select * from productos where "+ factor +" = "+ "'"+field+"'");
        } catch (Exception e) {
            System.err.println("Error en ControllerProducts metodo seach");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == this.viewProducts.jmi_nuevoProducto)
            add();
        else if(e.getSource() == this.viewProducts.jbtn_borrar)
            delete();
        else if (e.getSource() == this.viewProducts.jbtn_edit)
            edit();
        else if(e.getSource() == this.viewProducts.jmi_noProducto)
            seach("id_producto","el id");
        else if(e.getSource() == this.viewProducts.jmi_nombreProducto)
            seach("producto","el prodcuto");
        else if(e.getSource() == this.viewProducts.jmi_descricionProducto)
            seach("descripcion","la descripcion");
        
    }
    
    
    
}
