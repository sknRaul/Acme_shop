/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelSuppliers;
import views.ViewAddSupplier;
import javax.swing.JOptionPane;
/**
 *
 * @author Raúl
 */
public class ControlAddSupplier implements ActionListener{
    
    ModelSuppliers mas = new ModelSuppliers();
    ViewAddSupplier vas = new ViewAddSupplier();
    
    public ControlAddSupplier(ModelSuppliers mas, ViewAddSupplier vas){
        this.mas = mas;
        this.vas = vas;
        
        inView();
        this.vas.jbtn_sent.addActionListener(this);
        this.vas.jcb_state.addActionListener(this);
    }
    
    public void inView(){
        this.vas.setVisible(true);
    }
    
    public void clean(){
        this.vas.jtf_name.setText("");
        this.vas.jtf_RFC.setText("");
        this.vas.jtf_streed.setText("");
        this.vas.jtf_hood.setText("");
        this.vas.jtf_city.setText("");
        this.vas.jcb_state.setSelectedIndex(0);
        this.vas.jtf_contact.setText("");
        this.vas.jtf_phone.setText("");
        this.vas.jtf_email.setText("");
    }
    
    public void add(){
        String name = this.vas.jtf_name.getText();
        String rfc = this.vas.jtf_RFC.getText();
        String streed = this.vas.jtf_streed.getText();
        String hood = this.vas.jtf_hood.getText();
        String city = this.vas.jtf_city.getText();
        String state = (String) this.vas.jcb_state.getSelectedItem();
        String contact = this.vas.jtf_contact.getText();
        String phone = this.vas.jtf_phone.getText();
        String email = this.vas.jtf_email.getText();
        String query = "Insert into proveedores (nombre, rfc, calle, colonia, ciudad, estado, nombre_contacto, telefono, email)"+ "values('"+name+"','"+rfc+"','"+streed+"','"+hood+"','"+city+"','"+state+"','"+contact+"','"+phone+"','"+email+"');";
        this.mas.add(query);
        JOptionPane.showMessageDialog(vas, "El proveedor se a guardado correctamente");
        clean();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vas.jbtn_sent)
            add();
    }
}
