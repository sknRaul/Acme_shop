package controls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import jdda.ConnectionDB;
import views.ViewCustomers;
import models.ModelCustomers;


/**
 *
 * @author panda
 */
public class ControlMenuCustomers implements ActionListener {
    ConnectionDB con = new ConnectionDB();
    JPanel [] views;
    private DefaultTableModel model;
    
    ModelCustomers modelCustomers;
    ViewCustomers viewCustomers;
    
    public ControlMenuCustomers(ModelCustomers modelCustomers, ViewCustomers viewCustomers, JPanel[] views){
        
        this.modelCustomers = modelCustomers;
        this.viewCustomers = viewCustomers;
        this.views = views;
        
        this.viewCustomers.jbtn_edit.addActionListener(this);
        this.viewCustomers.jbtn_edit.addActionListener(this);
        this.viewCustomers.jm_add.addActionListener(this);
        this.viewCustomers.jm_search.addActionListener(this);
        this.viewCustomers.jmi_byName.addActionListener(this);
        this.viewCustomers.jmi_byNick.addActionListener(this);
        this.viewCustomers.jmi_byState.addActionListener(this);
        this.viewCustomers.jmi_newCustomer.addActionListener(this);
        
        initView();
    }
    
    private void initView(){
        this.viewCustomers.setLocationRelativeTo(null);
        this.viewCustomers.setVisible(true);
        this.viewCustomers.setResizable(false);
        this.viewCustomers.setTitle("Clientes");
        //con.Connection("acme_shop", "root", "");
        carfarInterface();
    }
    
    public void carfarInterface(){
        String data[][] = {};
        String col[] = {"NO.","Nombre","Apellido P.","Apellido M.","Contacto"};
        model = new DefaultTableModel(data, col);
        this.viewCustomers.jt_infoCustomer.setModel(model);
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
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.viewCustomers.jmi_newCustomer))
            jmiAddActionPerformed();
        else if(ae.getSource().equals(this.viewCustomers.jbtn_edit))
            jbtnEditActionPerformed();
    }
    
}

