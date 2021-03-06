/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author Raúl
 */
public class ViewShopping extends javax.swing.JPanel {

    /**
     * Creates new form ViewShopping
     */
    public ViewShopping() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_title = new javax.swing.JLabel();
        jl_supplier = new javax.swing.JLabel();
        jl_date = new javax.swing.JLabel();
        jbtn_addSupplier = new javax.swing.JButton();
        jtf_date = new javax.swing.JTextField();
        jbtn_shop = new javax.swing.JButton();
        jtf_nameSupplier = new javax.swing.JTextField();
        jtf_idSupplier = new javax.swing.JTextField();
        jbtn_suppliersSearch = new javax.swing.JButton();
        jbtn_deleteShop = new javax.swing.JButton();
        jtf_quantity = new javax.swing.JTextField();
        jl_product = new javax.swing.JLabel();
        jtf_total = new javax.swing.JTextField();
        jl_price = new javax.swing.JLabel();
        jbtn_cancel = new javax.swing.JButton();
        jl_quantity = new javax.swing.JLabel();
        jtf_nameProduct = new javax.swing.JTextField();
        jtf_subtotal = new javax.swing.JTextField();
        jbtn_addQuantity = new javax.swing.JButton();
        jbtn_productSearch = new javax.swing.JButton();
        jtf_iva = new javax.swing.JTextField();
        jbtn_addProduct = new javax.swing.JButton();
        jl_total = new javax.swing.JLabel();
        jtf_idProduct = new javax.swing.JTextField();
        jl_iva = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_shopping = new javax.swing.JTable();
        jl_subtotal = new javax.swing.JLabel();
        jtf_priceProduct = new javax.swing.JTextField();
        jl_background = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(847, 486));
        setLayout(null);

        jl_title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/compradores.png"))); // NOI18N
        add(jl_title);
        jl_title.setBounds(260, 10, 340, 80);

        jl_supplier.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_supplier.setText("Proveedor");
        add(jl_supplier);
        jl_supplier.setBounds(30, 120, 90, 20);

        jl_date.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_date.setText("Fecha");
        add(jl_date);
        jl_date.setBounds(30, 60, 70, 19);

        jbtn_addSupplier.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jbtn_addSupplier.setText("+");
        jbtn_addSupplier.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtn_addSupplier.setContentAreaFilled(false);
        add(jbtn_addSupplier);
        jbtn_addSupplier.setBounds(260, 120, 73, 25);

        jtf_date.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jtf_date.setEnabled(false);
        add(jtf_date);
        jtf_date.setBounds(110, 60, 110, 31);

        jbtn_shop.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jbtn_shop.setForeground(new java.awt.Color(0, 153, 0));
        jbtn_shop.setText("Iniciar Compra");
        jbtn_shop.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtn_shop.setContentAreaFilled(false);
        jbtn_shop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_shopActionPerformed(evt);
            }
        });
        add(jbtn_shop);
        jbtn_shop.setBounds(480, 137, 160, 30);

        jtf_nameSupplier.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jtf_nameSupplier.setEnabled(false);
        add(jtf_nameSupplier);
        jtf_nameSupplier.setBounds(350, 120, 120, 30);

        jtf_idSupplier.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        add(jtf_idSupplier);
        jtf_idSupplier.setBounds(120, 120, 60, 31);

        jbtn_suppliersSearch.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jbtn_suppliersSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        jbtn_suppliersSearch.setBorder(null);
        jbtn_suppliersSearch.setBorderPainted(false);
        jbtn_suppliersSearch.setContentAreaFilled(false);
        jbtn_suppliersSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_suppliersSearchActionPerformed(evt);
            }
        });
        add(jbtn_suppliersSearch);
        jbtn_suppliersSearch.setBounds(190, 110, 60, 50);

        jbtn_deleteShop.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jbtn_deleteShop.setForeground(new java.awt.Color(255, 0, 0));
        jbtn_deleteShop.setText("x");
        jbtn_deleteShop.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtn_deleteShop.setContentAreaFilled(false);
        add(jbtn_deleteShop);
        jbtn_deleteShop.setBounds(580, 330, 50, 40);

        jtf_quantity.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jtf_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_quantityActionPerformed(evt);
            }
        });
        add(jtf_quantity);
        jtf_quantity.setBounds(460, 230, 60, 31);

        jl_product.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_product.setText("Producto");
        add(jl_product);
        jl_product.setBounds(30, 180, 90, 19);

        jtf_total.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jtf_total.setEnabled(false);
        add(jtf_total);
        jtf_total.setBounds(410, 430, 60, 31);

        jl_price.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_price.setText("Precio $");
        add(jl_price);
        jl_price.setBounds(218, 232, 90, 19);

        jbtn_cancel.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jbtn_cancel.setForeground(new java.awt.Color(204, 0, 0));
        jbtn_cancel.setText("Cancelar comprar");
        jbtn_cancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtn_cancel.setContentAreaFilled(false);
        add(jbtn_cancel);
        jbtn_cancel.setBounds(430, 180, 170, 25);

        jl_quantity.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_quantity.setText("Cantidad");
        add(jl_quantity);
        jl_quantity.setBounds(370, 230, 90, 19);

        jtf_nameProduct.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jtf_nameProduct.setEnabled(false);
        jtf_nameProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nameProductActionPerformed(evt);
            }
        });
        add(jtf_nameProduct);
        jtf_nameProduct.setBounds(20, 230, 180, 31);

        jtf_subtotal.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jtf_subtotal.setEnabled(false);
        add(jtf_subtotal);
        jtf_subtotal.setBounds(110, 430, 60, 31);

        jbtn_addQuantity.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jbtn_addQuantity.setText("+");
        jbtn_addQuantity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtn_addQuantity.setContentAreaFilled(false);
        add(jbtn_addQuantity);
        jbtn_addQuantity.setBounds(530, 230, 60, 25);

        jbtn_productSearch.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jbtn_productSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        jbtn_productSearch.setBorder(null);
        jbtn_productSearch.setBorderPainted(false);
        jbtn_productSearch.setContentAreaFilled(false);
        jbtn_productSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_productSearchActionPerformed(evt);
            }
        });
        add(jbtn_productSearch);
        jbtn_productSearch.setBounds(180, 170, 60, 50);

        jtf_iva.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jtf_iva.setEnabled(false);
        add(jtf_iva);
        jtf_iva.setBounds(250, 430, 60, 31);

        jbtn_addProduct.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jbtn_addProduct.setText("+");
        jbtn_addProduct.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtn_addProduct.setContentAreaFilled(false);
        add(jbtn_addProduct);
        jbtn_addProduct.setBounds(250, 180, 73, 25);

        jl_total.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_total.setText("Total");
        add(jl_total);
        jl_total.setBounds(350, 430, 60, 19);

        jtf_idProduct.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        add(jtf_idProduct);
        jtf_idProduct.setBounds(120, 180, 50, 31);

        jl_iva.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_iva.setText("IVA");
        add(jl_iva);
        jl_iva.setBounds(210, 430, 30, 19);

        jt_shopping.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Cantidad", "Total"
            }
        ));
        jScrollPane1.setViewportView(jt_shopping);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 280, 550, 130);

        jl_subtotal.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_subtotal.setText("Subtotal");
        add(jl_subtotal);
        jl_subtotal.setBounds(30, 430, 100, 19);

        jtf_priceProduct.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jtf_priceProduct.setEnabled(false);
        jtf_priceProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_priceProductActionPerformed(evt);
            }
        });
        add(jtf_priceProduct);
        jtf_priceProduct.setBounds(280, 230, 80, 31);

        jl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flash.jpg"))); // NOI18N
        add(jl_background);
        jl_background.setBounds(0, 0, 847, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_shopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_shopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_shopActionPerformed

    private void jbtn_suppliersSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_suppliersSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_suppliersSearchActionPerformed

    private void jtf_priceProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_priceProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_priceProductActionPerformed

    private void jbtn_productSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_productSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_productSearchActionPerformed

    private void jtf_nameProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nameProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nameProductActionPerformed

    private void jtf_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_quantityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtn_addProduct;
    public javax.swing.JButton jbtn_addQuantity;
    public javax.swing.JButton jbtn_addSupplier;
    public javax.swing.JButton jbtn_cancel;
    public javax.swing.JButton jbtn_deleteShop;
    public javax.swing.JButton jbtn_productSearch;
    public javax.swing.JButton jbtn_shop;
    public javax.swing.JButton jbtn_suppliersSearch;
    public javax.swing.JLabel jl_background;
    public javax.swing.JLabel jl_date;
    public javax.swing.JLabel jl_iva;
    public javax.swing.JLabel jl_price;
    public javax.swing.JLabel jl_product;
    public javax.swing.JLabel jl_quantity;
    public javax.swing.JLabel jl_subtotal;
    public javax.swing.JLabel jl_supplier;
    public javax.swing.JLabel jl_title;
    public javax.swing.JLabel jl_total;
    public javax.swing.JTable jt_shopping;
    public javax.swing.JTextField jtf_date;
    public javax.swing.JTextField jtf_idProduct;
    public javax.swing.JTextField jtf_idSupplier;
    public javax.swing.JTextField jtf_iva;
    public javax.swing.JTextField jtf_nameProduct;
    public javax.swing.JTextField jtf_nameSupplier;
    public javax.swing.JTextField jtf_priceProduct;
    public javax.swing.JTextField jtf_quantity;
    public javax.swing.JTextField jtf_subtotal;
    public javax.swing.JTextField jtf_total;
    // End of variables declaration//GEN-END:variables
}
