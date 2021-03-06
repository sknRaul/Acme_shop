package controls;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
    private ResultSet rs;
    
    ModelCustomersNewEdit modelCustomersNewEdit;
    ViewEditCustomers viewEditCustomer;
    
    public ControlCustomersEdit(ModelCustomersNewEdit modelCustomersNewEdit, ViewEditCustomers viewEditCustomer){
        this.modelCustomersNewEdit = modelCustomersNewEdit;
        this.viewEditCustomer = viewEditCustomer;
        conexion = conDB.Connection("acme_shop", "root", "1234");  
        
        this.viewEditCustomer.jbtn_accept.setEnabled(false);
        validateFields();
        
        try{
            st = conexion.createStatement();
        }catch(SQLException esql){
            System.out.println("Error"+esql.getMessage());
        }
        
        this.viewEditCustomer.jbtn_accept.addActionListener(this);
        this.viewEditCustomer.jbtn_charge.addActionListener(this);
    }

   @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.viewEditCustomer.jbtn_accept))
            jbtnAcceptActionPerformed();    
        else if(ae.getSource().equals(this.viewEditCustomer.jbtn_charge))
            jbtnChargeActionPerformed();
    }
           
    public void jbtnAcceptActionPerformed(){
        updateValues();
    }
    
    public void jbtnChargeActionPerformed(){
        showData();
    }
    
    public void showData(){
    String query = "SELECT * from clientes WHERE id_cliente = "+this.modelCustomersNewEdit.getEditableValues();
    try {
        rs = st.executeQuery(query);
        while(rs.next()){
            this.viewEditCustomer.jtf_name.setText(rs.getString(2));
            this.viewEditCustomer.jtf_lastNameP.setText(rs.getString(3));
            this.viewEditCustomer.jtf_lastNameM.setText(rs.getString(4));
            this.viewEditCustomer.jtf_tNumber.setText(rs.getString(11));
            this.viewEditCustomer.jtf_email.setText(rs.getString(12));
            this.viewEditCustomer.jtf_nick.setText(rs.getString(10));
            this.viewEditCustomer.jtf_street.setText(rs.getString(6));
            this.viewEditCustomer.jtf_no.setText(rs.getString(5));
            this.viewEditCustomer.jtf_suburb.setText(rs.getString(7));
            this.viewEditCustomer.jtf_city.setText(rs.getString(8));
            this.viewEditCustomer.jtf_rfc.setText(rs.getString(13));
            this.viewEditCustomer.jcb_states.setSelectedItem(rs.getString(9));
            }
        this.viewEditCustomer.jbtn_accept.setEnabled(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void setValues(){
        try{
            this.modelCustomersNewEdit.setName(this.viewEditCustomer.jtf_name.getText());
            this.modelCustomersNewEdit.setAp_pat(this.viewEditCustomer.jtf_lastNameP.getText());
            this.modelCustomersNewEdit.setAp_ma(this.viewEditCustomer.jtf_lastNameM.getText());
            this.modelCustomersNewEdit.setNumber(Integer.parseInt(this.viewEditCustomer.jtf_tNumber.getText()));
            this.modelCustomersNewEdit.setEmail(this.viewEditCustomer.jtf_email.getText());
            this.modelCustomersNewEdit.setNick(this.viewEditCustomer.jtf_nick.getText());
            this.modelCustomersNewEdit.setStreet(this.viewEditCustomer.jtf_street.getText());
            this.modelCustomersNewEdit.setNo(Integer.parseInt(this.viewEditCustomer.jtf_no.getText()));
            this.modelCustomersNewEdit.setSuburb(this.viewEditCustomer.jtf_suburb.getText());
            this.modelCustomersNewEdit.setCity(this.viewEditCustomer.jtf_city.getText());
            this.modelCustomersNewEdit.setRfc(this.viewEditCustomer.jtf_rfc.getText());
            this.modelCustomersNewEdit.setState(""+this.viewEditCustomer.jcb_states.getSelectedItem());
        }catch(Exception e){
            JOptionPane.showMessageDialog(viewEditCustomer, "NOPE");
        }
    }
    
    public void cleanFields(){
        this.viewEditCustomer.jtf_name.setText("");
        this.viewEditCustomer.jtf_lastNameP.setText("");
        this.viewEditCustomer.jtf_lastNameM.setText("");
        this.viewEditCustomer.jtf_tNumber.setText("");
        this.viewEditCustomer.jtf_email.setText("");
        this.viewEditCustomer.jtf_nick.setText("");
        this.viewEditCustomer.jtf_street.setText("");;
        this.viewEditCustomer.jtf_no.setText("");
        this.viewEditCustomer.jtf_suburb.setText("");
        this.viewEditCustomer.jtf_city.setText("");
        this.viewEditCustomer.jtf_rfc.setText("");
        this.viewEditCustomer.jcb_states.setSelectedIndex(0);  
        this.viewEditCustomer.jbtn_accept.setEnabled(false);
    }
    public void validateFields(){
        justLetters(this.viewEditCustomer.jtf_name);
        justLetters(this.viewEditCustomer.jtf_lastNameP);
        justLetters(this.viewEditCustomer.jtf_lastNameM);
        justNumbers(this.viewEditCustomer.jtf_tNumber);
        justNumbers(this.viewEditCustomer.jtf_no);
        justLetters(this.viewEditCustomer.jtf_suburb);
        justLetters(this.viewEditCustomer.jtf_city);
    }
    
    public void updateValues(){
        try{
            setValues();
            st.executeUpdate("UPDATE clientes SET nombre ="+"'"+this.modelCustomersNewEdit.getName()+"'"
                    +", ap_paterno ="+"'"+this.modelCustomersNewEdit.getAp_pat()+"'"
                    +", ap_materno ="+"'"+this.modelCustomersNewEdit.getAp_ma()+"'"
                    +", no ="+"'"+this.modelCustomersNewEdit.getNo()+"'"
                    +", calle ="+"'"+this.modelCustomersNewEdit.getStreet()+"'"
                    +", colonia ="+"'"+this.modelCustomersNewEdit.getSuburb()+"'"
                    +", ciudad ="+"'"+this.modelCustomersNewEdit.getCity()+"'"
                    +", estado ="+"'"+this.modelCustomersNewEdit.getState()+"'"
                    +", nombre_contacto ="+"'"+this.modelCustomersNewEdit.getNick()+"'"
                    +", telefono ="+"'"+this.modelCustomersNewEdit.getNumber()+"'"
                    +", email ="+"'"+this.modelCustomersNewEdit.getEmail()+"'"
                    +", rfc ="+"'"+this.modelCustomersNewEdit.getRfc()+"'"
                    +" WHERE id_cliente = "+this.modelCustomersNewEdit.getEditableValues());
            
            JOptionPane.showMessageDialog(viewEditCustomer, "¡Actualización Exitosa!\nSu cliente ha sido actualizado.");
            cleanFields();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(viewEditCustomer, "Asegurese de llenar todos los campos correctamente.");
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
