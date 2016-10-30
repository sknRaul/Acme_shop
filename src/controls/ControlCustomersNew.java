/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelCustomersNewEdit;
import views.ViewNewCustomers;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import jdda.*;

/**
 *
 * @author Danni
 */

public class ControlCustomersNew implements ActionListener{
    
    ConnectionDB conDB = new ConnectionDB();
    private Connection conexion;
    private Statement st;
    private int counter=5;
    
    ViewNewCustomers viewNewCustomers;
    ModelCustomersNewEdit modelCustomersNewEdit;
    
    public ControlCustomersNew(ModelCustomersNewEdit modelCustomersNewEdit, ViewNewCustomers viewNewCustomers){
        this.modelCustomersNewEdit = modelCustomersNewEdit;
        this.viewNewCustomers = viewNewCustomers;
        conexion = conDB.Connection("acme_shop", "root", "1234");
        try{
            st = conexion.createStatement();
        }catch(SQLException esql){
            System.out.println("Erros"+esql.getMessage());
        }
        
        this.viewNewCustomers.jbtn_accept.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.viewNewCustomers.jbtn_accept))
            jbtnAcceptActionPerformed();
    }
       
    public void jbtnAcceptActionPerformed(){
        insertValues();            
        counter++;
    }
    
    public void setValues(){
        this.modelCustomersNewEdit.setName(this.viewNewCustomers.jtf_name.getText());
        this.modelCustomersNewEdit.setAp_pat(this.viewNewCustomers.jtf_lastNameP.getText());
        this.modelCustomersNewEdit.setAp_ma(this.viewNewCustomers.jtf_lastNameM.getText());
        this.modelCustomersNewEdit.setNumber(this.viewNewCustomers.jtf_tNumber.getText());
        this.modelCustomersNewEdit.setEmail(this.viewNewCustomers.jtf_email.getText());
        this.modelCustomersNewEdit.setNick(this.viewNewCustomers.jtf_nick.getText());
        this.modelCustomersNewEdit.setStreet(this.viewNewCustomers.jtf_street.getText());
        this.modelCustomersNewEdit.setNo(Integer.parseInt(this.viewNewCustomers.jtf_no.getText()));
        this.modelCustomersNewEdit.setSuburb(this.viewNewCustomers.jtf_suburb.getText());
        this.modelCustomersNewEdit.setCity(this.viewNewCustomers.jtf_city.getText());
        this.modelCustomersNewEdit.setState(""+this.viewNewCustomers.jcb_states.getSelectedItem());
    }
    
    public void insertValues(){
        try{
            setValues();
            st.executeUpdate("INSERT INTO clientes (id_cliente,nombre,ap_paterno,ap_materno,no,calle,colonia,ciudad,estado,nombre_contacto,telefono,email)"
                    +" VALUES ('"+ counter +"','"
                    + this.modelCustomersNewEdit.getName() +"','"
                    + this.modelCustomersNewEdit.getAp_pat() +"','"
                    + this.modelCustomersNewEdit.getAp_ma()+"','"
                    + this.modelCustomersNewEdit.getNo()+"','"
                    + this.modelCustomersNewEdit.getStreet()+"','"
                    + this.modelCustomersNewEdit.getSuburb()+"','"
                    + this.modelCustomersNewEdit.getCity()+"','"
                    + this.modelCustomersNewEdit.getState()+"','"
                    + this.modelCustomersNewEdit.getNick()+"','"
                    + this.modelCustomersNewEdit.getNumber()+"','"
                    + this.modelCustomersNewEdit.getEmail()+"');");
            System.out.println("Listo");
        }catch(SQLException esql){
            System.out.println("NOOOO"+ esql.getMessage());
        }
    }
     
}
    
