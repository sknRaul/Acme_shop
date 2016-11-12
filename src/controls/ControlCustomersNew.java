/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import models.ModelCustomersNewEdit;
import views.ViewNewCustomers;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import jdda.*;
import sun.security.rsa.RSACore;
/**
 *
 * @author Danni
 */

public class ControlCustomersNew implements ActionListener{
    
    ConnectionDB conDB = new ConnectionDB();
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private int counter;
    
    ViewNewCustomers viewNewCustomers;
    ModelCustomersNewEdit modelCustomersNewEdit;
        
    public ControlCustomersNew(ModelCustomersNewEdit modelCustomersNewEdit, ViewNewCustomers viewNewCustomers){
        this.modelCustomersNewEdit = modelCustomersNewEdit;
        this.viewNewCustomers = viewNewCustomers;
        
        validateFields();
                        
        conexion = conDB.Connection("acme_shop", "root", "1234");
        try{
            st = conexion.createStatement();
            rs = st.executeQuery("Select id_cliente from clientes");
            while(rs.next()){
                counter = Integer.parseInt(rs.getString(1));
        }

        }catch(SQLException esql){
            System.out.println("Error"+esql.getMessage());
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
    }
    
    public void validateFields(){
        justLetters(this.viewNewCustomers.jtf_name);
        justLetters(this.viewNewCustomers.jtf_lastNameP);
        justLetters(this.viewNewCustomers.jtf_lastNameM);
        justNumbers(this.viewNewCustomers.jtf_tNumber);
        justNumbers(this.viewNewCustomers.jtf_no);
        justLetters(this.viewNewCustomers.jtf_suburb);
        justLetters(this.viewNewCustomers.jtf_city);
    }
    
    public void setValues(){
        this.modelCustomersNewEdit.setName(this.viewNewCustomers.jtf_name.getText());
        this.modelCustomersNewEdit.setAp_pat(this.viewNewCustomers.jtf_lastNameP.getText());
        this.modelCustomersNewEdit.setAp_ma(this.viewNewCustomers.jtf_lastNameM.getText());
        this.modelCustomersNewEdit.setNumber(Integer.parseInt(this.viewNewCustomers.jtf_tNumber.getText()));
        this.modelCustomersNewEdit.setEmail(this.viewNewCustomers.jtf_email.getText());
        this.modelCustomersNewEdit.setNick(this.viewNewCustomers.jtf_nick.getText());
        this.modelCustomersNewEdit.setStreet(this.viewNewCustomers.jtf_street.getText());
        this.modelCustomersNewEdit.setNo(Integer.parseInt(this.viewNewCustomers.jtf_no.getText()));
        this.modelCustomersNewEdit.setSuburb(this.viewNewCustomers.jtf_suburb.getText());
        this.modelCustomersNewEdit.setCity(this.viewNewCustomers.jtf_city.getText());
        this.modelCustomersNewEdit.setRfc(this.viewNewCustomers.jtf_rfc.getText());
        this.modelCustomersNewEdit.setState(""+this.viewNewCustomers.jcb_states.getSelectedItem());
    }
    public void cleanFields(){
        this.viewNewCustomers.jtf_name.setText("");
        this.viewNewCustomers.jtf_lastNameP.setText("");
        this.viewNewCustomers.jtf_lastNameM.setText("");
        this.viewNewCustomers.jtf_tNumber.setText("");
        this.viewNewCustomers.jtf_email.setText("");
        this.viewNewCustomers.jtf_nick.setText("");
        this.viewNewCustomers.jtf_street.setText("");;
        this.viewNewCustomers.jtf_no.setText("");
        this.viewNewCustomers.jtf_suburb.setText("");
        this.viewNewCustomers.jtf_city.setText("");
        this.viewNewCustomers.jtf_rfc.setText("");
        this.viewNewCustomers.jcb_states.setSelectedIndex(0);  
    }
    
    public void insertValues(){
        try{
            try{
                setValues();
            }catch(Exception e){
                JOptionPane.showMessageDialog(viewNewCustomers, "Asegurate de haber llenado los campos.");
            }
            st.executeUpdate("INSERT INTO clientes (id_cliente,nombre,ap_paterno,ap_materno,no,calle,colonia,ciudad,estado,nombre_contacto,telefono,email,rfc)"
                    +" VALUES ('"+ (counter+1) +"','"
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
                    + this.modelCustomersNewEdit.getEmail()+"','"
                    + this.modelCustomersNewEdit.getRfc()+"');");
            JOptionPane.showMessageDialog(viewNewCustomers, "¡Carga Exitosa!\n EL registro se ha guardado correctamente");
            cleanFields();
        }catch(SQLException esql){
            JOptionPane.showMessageDialog(viewNewCustomers, "Asegurate de que todos los campos esten llenados correctamente."+esql.getMessage());
        }
          
    }
    
    public void justLetters(JTextField a){
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c)){                 
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                }
            }
        });
    }
    public void justNumbers(JTextField a){
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){                 
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                }
            }
        });
    }     
}
    
