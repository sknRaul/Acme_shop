/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import models.ModelSales;
import views.ViewSales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdda.ConnectionDB;
import java.util.Calendar;
import javax.swing.JPasswordField;
import models.ModelCustomersNewEdit;

/**
 *
 * @author Danni
 */
public class ControlSales implements ActionListener {
    ConnectionDB con = new ConnectionDB();
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private ResultSet rs1;
    Object [] fila = new Object[5];   
    Calendar cal = Calendar.getInstance();
    int counter;
    int res;
    String fecha=cal.get(cal.YEAR)+"/"+(cal.get(cal.MONTH)+1)+"/"+cal.get(cal.DATE);
    
    private DefaultTableModel model;
    
    ModelSales modelSales;
    ViewSales viewSales;
    ModelCustomersNewEdit modelCustomersNewEdit;
    
    public ControlSales(ModelSales modelSales, ViewSales viewSales){
        
        this.modelSales = modelSales;
        this.viewSales = viewSales;
        conexion = con.Connection("acme_shop", "root", "1234");
        
        this.modelCustomersNewEdit = new ModelCustomersNewEdit();
        
        try{
            st = conexion.createStatement();
        }catch(SQLException esql){
            System.out.println("Error"+esql.getMessage());
        }
        
        this.viewSales.jbtn_cancelSale.addActionListener(this);
        this.viewSales.jbtn_newSale.addActionListener(this);
        this.viewSales.jbtn_searchByName.addActionListener(this);        
        this.viewSales.jbtn_searchProduct.addActionListener(this);
        inView();
    }
    
    public void inView(){
        this.viewSales.setVisible(true);
        this.viewSales.jl_dateFormat.setText(fecha);
        deshabilitar();
    }
    
    public void deshabilitar(){
        this.viewSales.jbtn_cancelSale.setEnabled(false);
        this.viewSales.jbtn_searchByName.setEnabled(false);
        this.viewSales.jbtn_searchProduct.setEnabled(false);
    }
    public void habilitar(){
        this.viewSales.jbtn_cancelSale.setEnabled(true);
        this.viewSales.jbtn_searchByName.setEnabled(true);
        this.viewSales.jbtn_searchProduct.setEnabled(true);
    }
    
    public void tabla(){
        String data[][] = {};
        String col[] = {"ID.","Producto","Precio","Cantidad","Total"};
        model = new DefaultTableModel(data, col);
        this.viewSales.jt_sale.setModel(model);
        this.viewSales.jl_customer1.setText("");
        this.viewSales.jl_idCustomer1.setText("");
        this.viewSales.jl_rfc1.setText("");
        this.viewSales.jtf_total.setText("");
        this.viewSales.jtf_totalN.setText("");
    }
    
    public void cargarInterface(){
        tabla();
        this.viewSales.jtf_taxes.setText(".16%");
        jbtnSearchCustomerActionPerformed();
        this.viewSales.jbtn_newSale.setText("Terminar Venta");
        this.viewSales.jtf_total.setText("");
        this.viewSales.jtf_totalN.setText("");
        try{
            st.executeQuery("Start transaction");
        }catch(SQLException e){
            System.err.println("No, algo salió mal con Start Transaction"+e.getMessage());
        }
    }
    
    public void insertVenta(){
        try{
            st.executeUpdate("INSERT INTO ventas (id_cliente,fecha,subtotal,iva,total)"
            +" VALUES ('"+this.modelSales.getIdCustomer()+"','"
            + fecha +"','"
            + 0 +"','"
            + this.modelSales.getIva() +"','"
            + 0 +"');");
            System.out.println("Ventas creada.");
        }catch(SQLException e){
            System.err.println("No jaló"+e.getMessage());
        }
    }
    
    public void llenarFilas(){
        this.modelSales.setTotal(Integer.parseInt(con.getColumn()[4])*this.modelSales.getNumber());
        fila[0] = con.getColumn()[1];
        fila[1] = con.getColumn()[2];
        fila[2] = con.getColumn()[4];
        fila[3] = this.modelSales.getNumber();
        fila[4] = this.modelSales.getTotal();
        model.addRow(fila);
             
        try{
            System.err.println(counter);
            rs1 = st.executeQuery("Select id_venta from ventas");
            rs1.next();
            st.executeUpdate("INSERT INTO detalle_ventas (id_venta,id_producto,id_usuario,id_cliente,cantidad,total_producto,precio)"
            +" VALUES ('"+rs1.getString("id_venta")+"','"
            + con.getColumn()[0] +"','"
            + Integer.parseInt(this.viewSales.jl_idSeller1.getText()) +"','"
            + Integer.parseInt(this.modelSales.getIdCustomer()) +"','"
            + this.modelSales.getNumber() +"','"
            + this.modelSales.getTotal() +"','"
            + Integer.parseInt(""+fila[2])+"');");
           
        }catch(SQLException e){
            System.err.println("NO jalo el detalle_venta"+e.getMessage());
        }
//        System.err.println(counter);
//        counter++;
    }
    
    public void jmiByName(){
        this.modelSales.setName(JOptionPane.showInputDialog(viewSales, "Introduzca el nombre del producto."));
        con.basicConsult("productos", "nombre",this.modelSales.getName());
        this.modelSales.setNumber(Integer.parseInt(JOptionPane.showInputDialog(viewSales, "Introduzca la cantindad")));
        if(this.modelSales.getNumber() <= Integer.parseInt(con.getColumn()[5])){
            int existencia = Integer.parseInt(con.getColumn()[5]) - this.modelSales.getNumber() ;
            llenarFilas();
            try{
                st.executeUpdate("update productos set existencias = '"+existencia+"' where id_producto ='"+con.getColumn()[0]+"'");
                System.out.println("Actuaizado");
            }catch(SQLException e){
                System.err.println("Falló la actualzación de las existencias");
            }
            res = (int) (res + this.modelSales.getTotal());
            this.viewSales.jtf_total.setText(""+res);
        }else{
            JOptionPane.showMessageDialog(viewSales, "¡ ADVERTENCIA !\n No existen suficientes productos en inventario.");
        }      
    }
    
    public void jmiByID(){
        this.modelSales.setIdProduct(this.viewSales.jtf_idProduct.getText());
        this.modelSales.setNumber(Integer.parseInt(JOptionPane.showInputDialog(viewSales, "Introduzca la cantindad")));
        con.basicConsult("productos", "id_producto", this.modelSales.getIdProduct());
        if(this.modelSales.getNumber() <= Integer.parseInt(con.getColumn()[5])){
            int existencia = Integer.parseInt(con.getColumn()[5]) - this.modelSales.getNumber() ;
            llenarFilas();
            try{
                st.executeUpdate("update productos set existencias = '"+existencia+"' where id_producto ='"+con.getColumn()[0]+"'");
                System.out.println("Actuaizado");
            }catch(SQLException e){
                System.err.println("Falló la actualzación de las existencias");
            }
            res = (int) (res + this.modelSales.getTotal());
            this.viewSales.jtf_total.setText(""+res);
        }else{
            JOptionPane.showMessageDialog(viewSales, "¡ ADVERTENCIA !\n No existen suficientes productos en inventario.");
        }
    }
    
    public void jbtnSearchCustomerActionPerformed(){
        this.modelSales.setIdCustomer(JOptionPane.showInputDialog(viewSales, "Introduzca el numero del cliente."));
        con.basicConsult("clientes", "id_cliente", this.modelSales.getIdCustomer());
        this.viewSales.jl_customer1.setText(""+con.getColumn()[1]+" "+con.getColumn()[2]+" "+con.getColumn()[3]);
        this.viewSales.jl_idCustomer1.setText(""+con.getColumn()[0]);
        this.viewSales.jl_rfc1.setText(""+con.getColumn()[12]);
        
    }
    
    public void jbtnCloseSaleActionPerformed(){
        this.modelSales.setTotalN(res + (res*.16));
        this.viewSales.jtf_totalN.setText("$"+this.modelSales.getTotalN());
        System.err.println("Total Neto: "+this.modelSales.getTotalN());
        double usMoney = Double.parseDouble(JOptionPane.showInputDialog(viewSales, "Introduzca el dinero del cliente"));
        double cambio = usMoney - this.modelSales.getTotalN();
        JOptionPane.showMessageDialog(viewSales, "Total a pagar: "+this.modelSales.getTotalN()+"\nDinero del Cliente: "+usMoney+"\nCambio a devolver: "+cambio);
//        cargarInterface();
    }
    
    public void jbtnCancelSaleActionPerformed(){
        JPasswordField jpd = new JPasswordField();
        String options[] = new String[]{"Aceptar"};
        
        String pass = ""+JOptionPane.showOptionDialog(viewSales, jpd, "Contraseña de Administrador",
                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                         null ,options, options[0]);
        if(pass.equals("0")){
            int resp = JOptionPane.showConfirmDialog(viewSales, "¿Esta seguro de querer cancelar la venta?", "Cancelar Venta", JOptionPane.YES_NO_OPTION);        
            if(resp == 0){
                JOptionPane.showMessageDialog(viewSales, "Venta Cancelada");
                this.viewSales.jl_customer1.setText("");
                this.viewSales.jl_idCustomer1.setText("");
                this.viewSales.jl_rfc1.setText("");
                this.viewSales.jbtn_newSale.setText("Nueva Venta");
                try{
                    st.executeQuery("rollback");
                }catch(SQLException e){
                    System.err.println("No, algo salió mal con el Rollback");
                }
                tabla();
                this.viewSales.jtf_total.setText("");
                this.viewSales.jtf_totalN.setText("");
            }   
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(this.viewSales.jbtn_searchProduct)) {
            jmiByID();
        } else if (ae.getSource().equals(this.viewSales.jbtn_newSale)) {
            if(this.viewSales.jbtn_newSale.getText().equals("Nueva Venta")){
                cargarInterface();
                insertVenta();
                habilitar();
            }else if(this.viewSales.jbtn_newSale.getText().equals("Terminar Venta")){
                commit();
                this.viewSales.jbtn_newSale.setText("Nueva Venta");
                deshabilitar();
                tabla();
                JOptionPane.showMessageDialog(viewSales, "Compra realizada con exito.");
            }
        }
        else if(ae.getSource().equals(this.viewSales.jbtn_searchByName))
            jmiByName();
        else if(ae.getSource().equals(this.viewSales.jbtn_cancelSale))
            jbtnCancelSaleActionPerformed();
    }
    
    public void commit(){
        try{
            jbtnCloseSaleActionPerformed();
            rs1 = st.executeQuery("Select id_venta from ventas");
            while(rs1.next()){
                this.modelSales.setIdSold(rs1.getString("id_venta"));
            }
            System.err.println("TotalN commit: "+(int)this.modelSales.getTotalN());
            System.out.println("ID_ventas: "+this.modelSales.getIdSold());
            st.executeUpdate("update ventas set subtotal ='"+Integer.parseInt(this.viewSales.jtf_total.getText())+
                    "', total='"+(int)this.modelSales.getTotalN()+"' where id_venta = '"+this.modelSales.getIdSold()+"';");
            
            st.executeQuery("commit");
            this.modelSales.setIdSold("");
        }catch(SQLException e){
            System.err.println("No, algo salió mal con el commit."+e.getMessage());
        }
    }
    
    public void chooseASeller(String id){
        String h = id;
        switch(id){
            case "0":
                viewSales.jl_sellerName.setText("Administrador");
                viewSales.jl_idSeller1.setText("0");
                break;
            case "1":
                viewSales.jl_sellerName.setText("Juan Daniel Dimas Amador");
                viewSales.jl_idSeller1.setText("1");
                break;
        }
    }    
}
