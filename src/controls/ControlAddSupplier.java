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
        
        String query = "Insert into provedores (nombre, rfc, calle, colonia, ciudad, estado, nombre_contacto, telefono, email)"+ "values('"+name+"','"+rfc+"','"+streed+"','"+hood+"','"+city+"','"+state+"','"+contact+"','"+phone+"','"+email+"');";
        this.mas.add(query);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vas.jbtn_sent)
            add();
    }
}
