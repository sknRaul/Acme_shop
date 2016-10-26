/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import views.ViewProducts;
import views.products.ViewProductsT;
import models.ModelProducts;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author panda
 */
public class ControlProducts implements ActionListener{
        private final ViewProducts viewProducts;
        private final ViewProductsT viewProductsT;
        private final ModelProducts modelProducts;
        public ControlProducts(ViewProducts viewProducts,ViewProductsT viewProductsT, ModelProducts modelProducts){
            this.modelProducts = modelProducts;
            this.viewProducts = viewProducts;
            this.viewProductsT = viewProductsT;
            this.viewProducts.jm_agregar.addActionListener(this);
            this.viewProducts.jmi_nuevoProducto.addActionListener(this);
            this.viewProducts.jm_buscar.addActionListener(this);
            this.viewProducts.jmi_noProducto.addActionListener(this);
            init_view();
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewProducts.jm_agregar){
        if(e.getSource()==viewProducts.jmi_nuevoProducto){
            Add();
        }
        }else if(e.getSource()== viewProducts.jm_buscar){
            if(e.getSource()== viewProducts.jmi_noProducto){
                //JOptionPane.showInternalConfirmDialog(viewProducts, e, "Ingrese el numero", 0, 0);
                JOptionPane.showInternalMessageDialog(viewProducts, e, "Ingrese el nombre", 0);
                        }
        }
        
    }
    public void Add(){
    this.viewProducts.setContentPane(viewProductsT);
        this.viewProducts.revalidate();
        this.viewProducts.repaint();
        this.viewProducts.setVisible(false);
    }
    public void init_view(){
        this.viewProducts.setTitle("Calculos de area, perimetro y volumen de figuras");
        this.viewProducts.setLocationRelativeTo(null);
        this.viewProducts.setVisible(true);
        
            
        }
}
