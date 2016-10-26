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
import java.sql.ResultSet;

/**
 *
 * @author Raúl
 */
public class ControlEditSuppliers implements ActionListener {
    ModelSuppliers mas = new ModelSuppliers();
    ViewEditSuppliers vas = new ViewEditSuppliers();
    ConnectionDB cb = new ConnectionDB();
    ResultSet rs;
    
    public ControlEditSuppliers(ModelSuppliers mas, ViewEditSuppliers vas){
        this.mas = mas;
        this.vas = vas;
        
        inView();
        this.vas.jbtn_sent.addActionListener(this);
    }
    
    public void inView(){
        this.vas.setVisible(true);
        showEditableData();
    }
    
    public void showEditableData(){
        int editable = this.mas.getEditer();
        cb.Connection("acme_shop", "root", "1234");
        String query = "Select * from provedores where id_provedor = "+editable;
        System.out.println(query);
        try {
            rs = cb.query(query);
            while(rs.next()){
                this.vas.jtf_name.setText(rs.getString("nombre"));
                this.vas.jtf_RFC.setText(rs.getString("rfc"));
                this.vas.jtf_streed.setText(rs.getString("calle"));
                this.vas.jtf_hood.setText(rs.getString("colonia"));
                this.vas.jtf_city.setText(rs.getString("ciudad"));
                this.vas.jtf_contact.setText(rs.getString("nombre_contacto"));
                this.vas.jtf_phone.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void edit(){
        String name = this.vas.jtf_name.getText();
        String rfc = this.vas.jtf_RFC.getText();
        String streed = this.vas.jtf_streed.getText();
        String hood = this.vas.jtf_hood.getText();
        String city = this.vas.jtf_city.getText();
        String state = (String) this.vas.jcb_states.getSelectedItem();
        String contact = this.vas.jtf_contact.getText();
        String phone = this.vas.jtf_phone.getText();
        String email = this.vas.jtf_email.getText();
        
        String query = "Update porvedores set nombre ="+name+ ", rfc ="+rfc+", calle = " +streed+", colonia = " +hood +", ciudad = "+city+", estado = "+state+", nombre_contacto = "+contact+", telefono =" +phone+", email = "+email+" where id_provedor = "+this.mas.getEditer();
        this.mas.add(query);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vas.jbtn_sent){
            System.out.print(""+this.vas.jcb_states.getSelectedItem());
            edit();
        }
    }
}
