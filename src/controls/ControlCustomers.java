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
        this.viewCustomers.jbtn_back.addActionListener(this);
        this.viewCustomers.jm_add.addActionListener(this);
        this.viewCustomers.jm_search.addActionListener(this);
        this.viewCustomers.jmi_byName.addActionListener(this);
        this.viewCustomers.jmi_byNick.addActionListener(this);
        this.viewCustomers.jmi_byState.addActionListener(this);
        this.viewCustomers.jmi_byID.addActionListener(this);
//        this.viewCustomers.jmi_sales.addActionListener(this);
        this.viewCustomers.jmi_newCustomer.addActionListener(this);
        this.viewCustomers.jmi_comeBack.addActionListener(this);
        
    }
    
    public void inView(){
        this.viewCustomers.setLocationRelativeTo(null);
        this.viewCustomers.setVisible(true);
        this.viewCustomers.setTitle("Clientes");
        //cargarInterface();
        cargarInterface();
        cargarTabla("Select * From clientes");
    }       
    
    public void cargarInterface(){
        String data[][] = {};
        String col[] = {"No.","Nombre","A. Paterno","A. Materno","Estado","RFC","Teléfono","E-mail"};
        model = new DefaultTableModel(data, col);
        //con.basicConsult("clientes", "id_cliente", "1");
        //llenarFilas();
        this.viewCustomers.jt_infoCustomer.setModel(model);
    }
    
    public void validatePasswordAdd(){
        String pass = JOptionPane.showInputDialog(viewCustomers, "Introduzca la contraseña de usuario");
        if(pass.equals(this.modelCustomersNewEdit.getPass())){
            jmiAddActionPerformed();
        }else{
            JOptionPane.showMessageDialog(viewCustomers, "Contraseña Incorrecta.\nPor favor intentelo de nuevo. ");
        }
    }
    public void validatePasswordEdit(){
        String pass = JOptionPane.showInputDialog(viewCustomers, "Introduzca la contraseña de usuario");
        if(pass.equals(this.modelCustomersNewEdit.getPass())){
            jbtnEditActionPerformed();
        }else{
            JOptionPane.showMessageDialog(viewCustomers, "Contraseña Incorrecta.\nPor favor intentelo de nuevo. ");
        }
    }
       public void validatePasswordDelete(){
        String pass = JOptionPane.showInputDialog(viewCustomers, "Introduzca la contraseña de usuario");
        if(pass.equals(this.modelCustomersNewEdit.getPass())){
            jbtnDeleteActionPerformed();
        }else{
            JOptionPane.showMessageDialog(viewCustomers, "Contraseña Incorrecta.\nPor favor intentelo de nuevo. ");
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.viewCustomers.jmi_newCustomer)){
            validatePasswordAdd();
        }else if(ae.getSource().equals(this.viewCustomers.jbtn_edit)){
            validatePasswordEdit();
        }else if(ae.getSource().equals(this.viewCustomers.jmi_byName)){
            jmiByName();
        }else if(ae.getSource().equals(this.viewCustomers.jmi_byNick)){
            jmiByRfc();
        }else if(ae.getSource().equals(this.viewCustomers.jmi_byState)){
            jmiByState();
        }else if(ae.getSource().equals(this.viewCustomers.jmi_byID)){
            jmiByID();
        }else if(ae.getSource().equals(this.viewCustomers.jbtn_delete)){
            validatePasswordDelete();
        }else if(ae.getSource().equals(this.viewCustomers.jmi_comeBack)){
            back();
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
        fila[5] = con.getColumn()[12];
        fila[6] = con.getColumn()[10];
        fila[7] = con.getColumn()[11];
        model.addRow(fila);
    }
    
    public void cargarTabla(String sql){
        try{
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            String prueba[] = new String[13];
            
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
            prueba[12] = rs.getString(13);
            
            fila[0] = prueba[0];
            fila[1] = prueba[1];
            fila[2] = prueba[2];
            fila[3] = prueba[3];
            fila[4] = prueba[8];
            fila[5] = prueba[12];
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
            JOptionPane.showMessageDialog(viewCustomers, "No seleccionaste ningun registro de la tabla.");
        }
    }
    
    public void clean(){
        DefaultTableModel tblSuppliers = (DefaultTableModel) this.viewCustomers.jt_infoCustomer.getModel();
        while(tblSuppliers.getRowCount()>0)
            tblSuppliers.removeRow(0);
        this.viewCustomers.jt_infoCustomer.setModel(tblSuppliers);
    }
    
    public void jmiByName(){
        this.modelCustomersNewEdit.setData(JOptionPane.showInputDialog(viewCustomers, "Introduzca el nombre del cliente."));
        clean();     
        cargarTabla("SELECT * FROM clientes WHERE nombre = '"+ this.modelCustomersNewEdit.getData() +"'");
    }
    
    public void jmiByID(){
        this.modelCustomersNewEdit.setData(JOptionPane.showInputDialog(viewCustomers, "Introduzca el ID del cliente."));
        clean();
        cargarTabla("SELECT * FROM clientes WHERE id_cliente = '"+ this.modelCustomersNewEdit.getData() +"'");
        
    }
    
    public void jmiByState(){
        this.modelCustomersNewEdit.setData(JOptionPane.showInputDialog(viewCustomers, "Introduzca el Estado del cliente."));
        clean();
        cargarTabla("SELECT * FROM clientes WHERE estado = '"+ this.modelCustomersNewEdit.getData() +"'");
    }
    
    public void jmiByRfc(){
        this.modelCustomersNewEdit.setData(JOptionPane.showInputDialog(viewCustomers, "Introduzca el Contacto del cliente."));
        clean();
        cargarTabla("SELECT * FROM clientes WHERE id_cliente = '"+ this.modelCustomersNewEdit.getData() +"'");
    }
    
    public void jbtnDeleteActionPerformed(){
        int row = this.viewCustomers.jt_infoCustomer.getSelectedRow();
        int resp = JOptionPane.showConfirmDialog(viewCustomers, "¿Esta seguro de querer eliminar al cliente de los registros?", "Eliminar", JOptionPane.YES_NO_OPTION);        
        if(resp == 0){
            try{
                this.modelCustomersNewEdit.setEditableValues(this.viewCustomers.jt_infoCustomer.getValueAt(row, 0));            
                st.executeUpdate("DELETE FROM `clientes` WHERE `clientes`.`id_cliente` = "+this.modelCustomersNewEdit.getEditableValues()+"");
                clean();
                cargarTabla("Select * From clientes");
            }catch(SQLException e){
                System.out.println("NOOOO"+ e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(viewCustomers, "Ningun cliente ha sido eliminado.");
        }
    }
        
}