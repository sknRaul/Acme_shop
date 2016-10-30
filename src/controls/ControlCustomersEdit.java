package controls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import jdda.ConnectionDB;
import models.ModelCustomersNewEdit;
import views.ViewEditCustomers;
/**
 *
 * @author Danni
 */
public class ControlCustomersEdit implements ActionListener {
    
    ConnectionDB conDB = new ConnectionDB();

    private Connection conexion;
    private Statement st;
    private int counter=10;
    
    ModelCustomersNewEdit modelCustomersNewEdit;
    ViewEditCustomers viewEditCustomer;
    
    public ControlCustomersEdit(ModelCustomersNewEdit modelCustomersNewEdit, ViewEditCustomers viewEditCustomer){
        this.modelCustomersNewEdit = modelCustomersNewEdit;
        this.viewEditCustomer = viewEditCustomer;
        conexion = conDB.Connection("acme_shop", "root", "1234");
        
        try{
            st = conexion.createStatement();
        }catch(SQLException esql){
            System.out.println("Error"+esql.getMessage());
        }
        
        this.viewEditCustomer.jbtn_accept.addActionListener(this);
        
    }

   @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.viewEditCustomer.jbtn_accept))
            jbtnAcceptActionPerformed();
            
    }
           
    public void jbtnAcceptActionPerformed(){
        deleteValue();
        insertValues();
        //setValues();
        counter++;
    }
    
    public void getValues(){
        conDB.basicConsult("clientes", "id_cliente", this.modelCustomersNewEdit.getData());
        this.viewEditCustomer.jtf_name.setText(this.conDB.getColumn()[1]);
        this.viewEditCustomer.jtf_lastNameP.setText(this.conDB.getColumn()[2]);
        this.viewEditCustomer.jtf_lastNameM.setText(this.conDB.getColumn()[3]);
        this.viewEditCustomer.jtf_no.setText(this.conDB.getColumn()[4]);
        this.viewEditCustomer.jtf_street.setText(this.conDB.getColumn()[5]);
        this.viewEditCustomer.jtf_suburb.setText(this.conDB.getColumn()[6]);
        this.viewEditCustomer.jtf_city.setText(this.conDB.getColumn()[7]);
        this.viewEditCustomer.jtf_nick.setText(this.conDB.getColumn()[9]);
        this.viewEditCustomer.jtf_tNumber.setText(this.conDB.getColumn()[10]);
        this.viewEditCustomer.jtf_email.setText(this.conDB.getColumn()[11]);   
    }
    
    public void setValues(){
        this.modelCustomersNewEdit.setName(this.viewEditCustomer.jtf_name.getText());
        this.modelCustomersNewEdit.setAp_pat(this.viewEditCustomer.jtf_lastNameP.getText());
        this.modelCustomersNewEdit.setAp_ma(this.viewEditCustomer.jtf_lastNameM.getText());
        this.modelCustomersNewEdit.setNumber(this.viewEditCustomer.jtf_tNumber.getText());
        this.modelCustomersNewEdit.setEmail(this.viewEditCustomer.jtf_email.getText());
        this.modelCustomersNewEdit.setNick(this.viewEditCustomer.jtf_nick.getText());
        this.modelCustomersNewEdit.setStreet(this.viewEditCustomer.jtf_street.getText());
        this.modelCustomersNewEdit.setNo(Integer.parseInt(this.viewEditCustomer.jtf_no.getText()));
        this.modelCustomersNewEdit.setSuburb(this.viewEditCustomer.jtf_suburb.getText());
        this.modelCustomersNewEdit.setCity(this.viewEditCustomer.jtf_city.getText());
        this.modelCustomersNewEdit.setState(""+this.viewEditCustomer.jcb_states.getSelectedItem());
    }
    
    public void insertValues(){
        try{
            st = conexion.createStatement();
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
    public void deleteValue(){
        try{
            st.executeUpdate("DELETE FROM `clientes` WHERE `clientes`.`id_cliente` = "+this.modelCustomersNewEdit.getData()+"");
            System.out.println("Listo");
        }catch(SQLException e){
            System.out.println("NOOOO"+ e.getMessage());
        }
    }
}
