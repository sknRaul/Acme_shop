package controls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import jdda.*;
import views.*;
import models.ModelCustomersNewEdit;

/**
 *
 * @author Danni
 */

public class ControlCustomers implements ActionListener {
    ConnectionDB con = new ConnectionDB();
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    Object [] fila = new Object[8];
        
    JPanel [] views;
    
    private DefaultTableModel model;
    
    ModelCustomersNewEdit modelCustomersNewEdit;
    ViewCustomers viewCustomers;
   
    public ControlCustomers(ModelCustomersNewEdit modelCustomersNewEdit, ViewCustomers viewCustomers, JPanel[] views){
        
        this.modelCustomersNewEdit = modelCustomersNewEdit;
        this.viewCustomers = viewCustomers;
        this.views = views;
        conexion = con.Connection("acme_shop", "root", "1234");
        try{
            st = conexion.createStatement();
        }catch(SQLException esql){
            System.out.println("Error"+esql.getMessage());
        }
        
        this.viewCustomers.jbtn_edit.addActionListener(this);
        this.viewCustomers.jbtn_delete.addActionListener(this);
        this.viewCustomers.jm_add.addActionListener(this);
        this.viewCustomers.jm_search.addActionListener(this);
        this.viewCustomers.jmi_byName.addActionListener(this);
        this.viewCustomers.jmi_byNick.addActionListener(this);
        this.viewCustomers.jmi_byState.addActionListener(this);
        this.viewCustomers.jmi_byID.addActionListener(this);
        this.viewCustomers.jmi_sales.addActionListener(this);
        this.viewCustomers.jmi_newCustomer.addActionListener(this);
        this.viewCustomers.jmi_comeBack.addActionListener(this);
    }
    
    public void inView(){
        this.viewCustomers.setLocationRelativeTo(null);
        this.viewCustomers.setVisible(true);
        this.viewCustomers.setResizable(true);
        this.viewCustomers.setTitle("Clientes");
        //cargarInterface();
        cargarInterface();
        cargarTabla();
    }       
    
    public void cargarInterface(){
        String data[][] = {};
        String col[] = {"No.","Nombre","A. Paterno","A. Materno","Estado","Contacto","Teléfono","E-mail"};
        model = new DefaultTableModel(data, col);
        //con.basicConsult("clientes", "id_cliente", "1");
        //llenarFilas();
        this.viewCustomers.jt_infoCustomer.setModel(model);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.viewCustomers.jmi_newCustomer)){
            jmiAddActionPerformed();
        }else if(ae.getSource().equals(this.viewCustomers.jbtn_edit)){
            jbtnEditActionPerformed();
        }else if(ae.getSource().equals(this.viewCustomers.jmi_byName)){
            jmiByName();
        }else if(ae.getSource().equals(this.viewCustomers.jmi_byNick)){
            jmiByNick();
        }else if(ae.getSource().equals(this.viewCustomers.jmi_byState)){
            jmiByState();
        }else if(ae.getSource().equals(this.viewCustomers.jmi_byID)){
            jmiByID();
        }else if(ae.getSource().equals(this.viewCustomers.jbtn_delete)){
            jbtnDeleteActionPerformed();
        }else if(ae.getSource().equals(this.viewCustomers.jmi_comeBack)){
            back();
        }else if(ae.getSource().equals(this.viewCustomers.jmi_sales)){
            jmiSalesActionPerformed();
        }
    }
    
    public void back(){
        this.viewCustomers.setContentPane(this.viewCustomers.jp_backGround);
        this.viewCustomers.revalidate();
        this.viewCustomers.repaint();
        this.viewCustomers.setSize(this.viewCustomers.getSize());
        inView();
    }
    
    public void llenarFilas(){
        fila[0] = con.getColumn()[0];
        fila[1] = con.getColumn()[1];
        fila[2] = con.getColumn()[2];
        fila[3] = con.getColumn()[3];
        fila[4] = con.getColumn()[8];
        fila[5] = con.getColumn()[9];
        fila[6] = con.getColumn()[10];
        fila[7] = con.getColumn()[11];
        model.addRow(fila);
    }
    
    public void cargarTabla(){
        
        try{
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM clientes");
            
            String prueba[] = new String[12];
            
        while(rs.next()){
            prueba[0] = rs.getString(1);
            prueba[1] = rs.getString(2);
            prueba[2] = rs.getString(3);
            prueba[3] = rs.getString(4);
            prueba[4] = rs.getString(5);
            prueba[5] = rs.getString(6);
            prueba[6] = rs.getString(7);
            prueba[7] = rs.getString(8);
            prueba[8] = rs.getString(9);
            prueba[9] = rs.getString(10);
            prueba[10] = rs.getString(11);
            prueba[11] = rs.getString(12);
            fila[0] = prueba[0];
            fila[1] = prueba[1];
            fila[2] = prueba[2];
            fila[3] = prueba[3];
            fila[4] = prueba[8];
            fila[5] = prueba[9];
            fila[6] = prueba[10];
            fila[7] = prueba[11];
            model.addRow(fila);
        }
   
        this.viewCustomers.jt_infoCustomer.setModel(model);
        }catch(SQLException e){
            System.out.println("No "+e.getMessage());
        }
    }
    
    
    public void jmiAddActionPerformed(){
        this.viewCustomers.setContentPane(views[0]);
        this.viewCustomers.revalidate();
        this.viewCustomers.repaint();
    }    
    
    public void jbtnEditActionPerformed(){   
        this.viewCustomers.setContentPane(views[1]);
        this.viewCustomers.revalidate();
        this.viewCustomers.repaint();
        int row = this.viewCustomers.jt_infoCustomer.getSelectedRow();
        try{
            this.modelCustomersNewEdit.setEditableValues(this.viewCustomers.jt_infoCustomer.getValueAt(row, 0));            
        }catch(Exception e){
            System.out.println("NO se que pasa: "+ e.getMessage());
        }
    }
    
    public void jmiSalesActionPerformed(){
        this.viewCustomers.setContentPane(views[2]);
        this.viewCustomers.revalidate();
        this.viewCustomers.repaint();
        //this.viewCustomers.pack();
        this.viewCustomers.setSize(this.viewCustomers.getSize());
        
    }
    
    public void jmiByName(){
        this.modelCustomersNewEdit.setData(JOptionPane.showInputDialog(viewCustomers, "Introduzca el nombre del cliente."));
        con.basicConsult("clientes", "nombre",this.modelCustomersNewEdit.getData());
        llenarFilas();        
    }
    
    public void jmiByID(){
        this.modelCustomersNewEdit.setData(JOptionPane.showInputDialog(viewCustomers, "Introduzca el ID del cliente."));
        con.basicConsult("clientes", "id_cliente", this.modelCustomersNewEdit.getData());
        llenarFilas();
    }
    
    public void jmiByState(){
        this.modelCustomersNewEdit.setData(JOptionPane.showInputDialog(viewCustomers, "Introduzca el Estado del cliente."));
        con.basicConsult("clientes", "estado", this.modelCustomersNewEdit.getData());
        llenarFilas();
    }
    
    public void jmiByNick(){
        this.modelCustomersNewEdit.setData(JOptionPane.showInputDialog(viewCustomers, "Introduzca el Contacto del cliente."));
        con.basicConsult("clientes", "nombre_contacto", this.modelCustomersNewEdit.getData());
        llenarFilas();
    }
    
    public void jbtnDeleteActionPerformed(){
        int row = this.viewCustomers.jt_infoCustomer.getSelectedRow();
        try{
            this.modelCustomersNewEdit.setEditableValues(this.viewCustomers.jt_infoCustomer.getValueAt(row, 0));            
            st.executeUpdate("DELETE FROM `clientes` WHERE `clientes`.`id_cliente` = "+this.modelCustomersNewEdit.getEditableValues()+"");
            System.out.println("Listo");
        }catch(SQLException e){
            System.out.println("NOOOO"+ e.getMessage());
        }
    }
    
}