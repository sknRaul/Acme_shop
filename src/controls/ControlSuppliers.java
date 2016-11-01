/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.ViewSuppliers;

import models.ModelSuppliers;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import java.sql.ResultSet;
import jdda.ConnectionDB;
/**
 *
 * @author panda
 */
public class ControlSuppliers implements ActionListener {
    private ResultSet rs = null;
    private ConnectionDB cb = new ConnectionDB();
    private ModelSuppliers modelSuppliers;
    public ViewSuppliers viewSuppliers;
    private Object controls[] = new Object[2];
    ControlAddSupplier cas;
    ControlEditSuppliers ces;
    
    public ControlSuppliers(ModelSuppliers modelSuppliers, ViewSuppliers viewSuppliers,Object controls[]){
        this.controls = controls;
        this.modelSuppliers = modelSuppliers;
        this.viewSuppliers = viewSuppliers;
        
        cas = (ControlAddSupplier) controls[0];
        ces = (ControlEditSuppliers) controls[1];
        
        this.viewSuppliers.jbtn_back.addActionListener(this);
        this.viewSuppliers.jmi_add.addActionListener(this);
        this.viewSuppliers.jmi_main.addActionListener(this);
        this.viewSuppliers.jbtn_delete.addActionListener(this);
        this.viewSuppliers.jbtn_edit.addActionListener(this);
        this.viewSuppliers.jmi_id.addActionListener(this);
        this.viewSuppliers.jmi_name.addActionListener(this);
        this.viewSuppliers.jmi_RFC.addActionListener(this);
        this.viewSuppliers.jmi_streed.addActionListener(this);
        this.viewSuppliers.jmi_hood.addActionListener(this);
        this.viewSuppliers.jmi_city.addActionListener(this);
        this.viewSuppliers.jmi_state.addActionListener(this);
        this.viewSuppliers.jmi_contact.addActionListener(this);
        this.viewSuppliers.jmi_phone.addActionListener(this);
        this.viewSuppliers.jmi_email.addActionListener(this);
    }
     
    public void inView(){
        this.viewSuppliers.setTitle("Proveedores");
        this.viewSuppliers.setVisible(true);
        this.viewSuppliers.setLocationRelativeTo(null);
        showData("Select * from provedores");
    }
    
    public void add(){
        this.viewSuppliers.setContentPane(cas.vas);
        this.viewSuppliers.revalidate();
        this.viewSuppliers.repaint();
        this.viewSuppliers.pack();
    }
    
    public void back(){
        this.viewSuppliers.setContentPane(this.viewSuppliers.jp_barckGround);
        this.viewSuppliers.revalidate();
        this.viewSuppliers.repaint();
        this.viewSuppliers.setSize(this.viewSuppliers.getSize());
        clean();
        showData("Select * from provedores");
    }
    
    public void delete(){
        cb.Connection("acme_shop", "root", "1234");
        int colum = this.viewSuppliers.jt_suppliers.getSelectedColumn();
        int row = this.viewSuppliers.jt_suppliers.getSelectedRow();
        try {
            int value = (int) this.viewSuppliers.jt_suppliers.getValueAt(row, 0);
            cb.delete("delete from provedores where id_provedor ="+value);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("En el controlSuppliers");
        }
        clean();
        showData("Select * from provedores");
    }
    
    public void edit(){
        this.viewSuppliers.setContentPane(ces.ves);
        this.viewSuppliers.revalidate();
        this.viewSuppliers.repaint();
        this.viewSuppliers.pack();
        
        int row = this.viewSuppliers.jt_suppliers.getSelectedRow();
        int editer = (int)this.viewSuppliers.jt_suppliers.getValueAt(row, 0);
        this.ces.mas.setEditer(editer);
        this.ces.showEditableData();
    }
    
    public void clean(){
        DefaultTableModel tblSuppliers = (DefaultTableModel) this.viewSuppliers.jt_suppliers.getModel();
        while(tblSuppliers.getRowCount()>0)
            tblSuppliers.removeRow(0);
        this.viewSuppliers.jt_suppliers.setModel(tblSuppliers);
    }
    
    public void showData(String query){
        cb.Connection("acme_shop", "root", "1234");
        clean();
        DefaultTableModel tblSuppliers = (DefaultTableModel) this.viewSuppliers.jt_suppliers.getModel();
        this.viewSuppliers.jt_suppliers.setModel(tblSuppliers);
        try {
            rs = cb.query(query);
            while(rs.next()){
                tblSuppliers.addRow(new Object[]{rs.getInt("id_provedor"),rs.getString("nombre"), rs.getString("rfc"), rs.getString("calle"), rs.getString("colonia"), rs.getString("ciudad"),rs.getString("estado"), rs.getString("nombre_contacto"), rs.getString("telefono"), rs.getString("email")});
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        this.viewSuppliers.jt_suppliers.setModel(tblSuppliers);
    }
    
    public void seach(String factor, String message){
        String field;
        try {
            field = JOptionPane.showInputDialog(viewSuppliers, "Escribe "+message+"que buscas");
            showData("Select * from provedores where "+ factor +" = "+ "'"+field+"'");
        } catch (Exception e) {
            System.err.println("Error en ControlSupliers metodo seach");
        }
    }
            
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.viewSuppliers.jmi_add)
            add();
        else if(ae.getSource() == this.viewSuppliers.jmi_main)
            back();
        else if(ae.getSource() == this.viewSuppliers.jbtn_delete)
            delete();
        else if (ae.getSource() == this.viewSuppliers.jbtn_edit)
            edit();
        else if(ae.getSource() == this.viewSuppliers.jmi_id)
            seach("id_provedor","el id");
        else if(ae.getSource() == this.viewSuppliers.jmi_RFC)
            seach("rfc","el rfc");
        else if(ae.getSource() == this.viewSuppliers.jmi_name)
            seach("nombre","el nombre");
        else if(ae.getSource() == this.viewSuppliers.jmi_streed)
            seach("calle","la calle");
        else if(ae.getSource() == this.viewSuppliers.jmi_hood)
            seach("colonia","la colonia");
        else if(ae.getSource() == this.viewSuppliers.jmi_city)
            seach("ciudad","la ciudad");
        else if(ae.getSource() == this.viewSuppliers.jmi_state)
            seach("estado","el estado");
        else if(ae.getSource() == this.viewSuppliers.jmi_contact)
            seach("nombre_contacto","el contacto");
        else if(ae.getSource() == this.viewSuppliers.jmi_phone)
            seach("telefono","el telefono");
        else if(ae.getSource() == this.viewSuppliers.jmi_email)
            seach("email","el email");
        else if(ae.getSource() == this.viewSuppliers.jbtn_back)
            this.viewSuppliers.setVisible(false);
    }
    
}
