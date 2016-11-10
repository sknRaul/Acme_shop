/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelSuppliers;
import views.ViewEditSuppliers;
import jdda.ConnectionDB;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Raúl
 */
public class ControlEditSuppliers implements ActionListener {
    ModelSuppliers mas = new ModelSuppliers();
    ViewEditSuppliers ves = new ViewEditSuppliers();
    ConnectionDB cb = new ConnectionDB();
    ResultSet rs;
    
    public ControlEditSuppliers(ModelSuppliers mas, ViewEditSuppliers vas){
        this.mas = mas;
        this.ves = vas;
        
        inView();
        this.ves.jbtn_sent.addActionListener(this);
    }
    
    public void inView(){
        this.ves.setVisible(true);
    }
    
    public void showEditableData(){
        int editable = this.mas.getEditer();
        cb.Connection("acme_shop", "root", "1234");
        String query = "Select * from proveedores where id_proveedor = "+editable;
        try {
            rs = cb.query(query);
            while(rs.next()){
                this.ves.jtf_name.setText(rs.getString("nombre"));
                this.ves.jtf_RFC.setText(rs.getString("rfc"));
                this.ves.jtf_streed.setText(rs.getString("calle"));
                this.ves.jtf_hood.setText(rs.getString("colonia"));
                this.ves.jtf_city.setText(rs.getString("ciudad"));
                this.ves.jcb_states.setSelectedItem(rs.getString("estado"));
                this.ves.jtf_contact.setText(rs.getString("nombre_contacto"));
                this.ves.jtf_phone.setText(rs.getString("telefono"));
                this.ves.jtf_email.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void edit(){
        String name = this.ves.jtf_name.getText();
        String rfc = this.ves.jtf_RFC.getText();
        String streed = this.ves.jtf_streed.getText();
        String hood = this.ves.jtf_hood.getText();
        String city = this.ves.jtf_city.getText();
        String state = (String) this.ves.jcb_states.getSelectedItem();
        String contact = this.ves.jtf_contact.getText();
        String phone = this.ves.jtf_phone.getText();
        String email = this.ves.jtf_email.getText();
        String query = "Update proveedores set nombre ="+"'"+name+"'"+", rfc ="+"'"+rfc+"'"+", calle = " +"'"+streed+"'"+", colonia = " +"'"+hood +"'"+", ciudad = "+"'"+city+"'"+", estado = "+"'"+state+"'"+", nombre_contacto = "+"'"+contact+"'"+", telefono =" +"'"+phone+"'"+", email = "+"'"+email+"'"+" where id_proveedor = "+this.mas.getEditer();
        this.mas.add(query);
        if(this.mas.getError()==0)
            JOptionPane.showMessageDialog(ves, "Los datos se han guardado correctamente");
        else
            JOptionPane.showMessageDialog(ves, "El telefono se escribe con números\nen diez digitos");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.ves.jbtn_sent){
            System.out.print(""+this.ves.jcb_states.getSelectedItem());
            edit();
        }
    }
}
