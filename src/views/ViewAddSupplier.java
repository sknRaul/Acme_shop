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
public class ViewAddSupplier extends javax.swing.JPanel {

    /**
     * Creates new form ViewAddSupplier
     */
    public ViewAddSupplier() {
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

        jPanel1 = new javax.swing.JPanel();
        jl_titleEdit = new javax.swing.JLabel();
        jp_Container = new javax.swing.JPanel();
        jl_name = new javax.swing.JLabel();
        jtf_name = new javax.swing.JTextField();
        jtf_RFC = new javax.swing.JTextField();
        jl_RFC = new javax.swing.JLabel();
        jtf_streed = new javax.swing.JTextField();
        jl_Streed = new javax.swing.JLabel();
        jl_hood = new javax.swing.JLabel();
        jtf_hood = new javax.swing.JTextField();
        jtf_city = new javax.swing.JTextField();
        jl_city = new javax.swing.JLabel();
        jtf_contact = new javax.swing.JTextField();
        jl_contact = new javax.swing.JLabel();
        jcb_state = new javax.swing.JComboBox<>();
        jbtn_sent = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jtf_phone = new javax.swing.JTextField();
        jl_phone = new javax.swing.JLabel();
        jtf_email = new javax.swing.JTextField();
        jl_email = new javax.swing.JLabel();
        jl_backGround = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        jl_titleEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/title_addSupplier.png"))); // NOI18N
        jPanel1.add(jl_titleEdit);
        jl_titleEdit.setBounds(100, 20, 370, 81);

        jp_Container.setBackground(new java.awt.Color(255, 255, 255));

        jl_name.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_name.setText("Nombre");

        jtf_name.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jtf_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nameActionPerformed(evt);
            }
        });

        jtf_RFC.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        jl_RFC.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_RFC.setText("RFC");

        jtf_streed.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        jl_Streed.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_Streed.setText("Calle");

        jl_hood.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_hood.setText("Colonia");

        jtf_hood.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        jtf_city.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        jl_city.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_city.setText("Ciudad");

        jtf_contact.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jtf_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_contactActionPerformed(evt);
            }
        });

        jl_contact.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_contact.setText("Contacto");

        jcb_state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "CDMX", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
        jcb_state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_stateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_ContainerLayout = new javax.swing.GroupLayout(jp_Container);
        jp_Container.setLayout(jp_ContainerLayout);
        jp_ContainerLayout.setHorizontalGroup(
            jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_ContainerLayout.createSequentialGroup()
                        .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_ContainerLayout.createSequentialGroup()
                                .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_hood)
                                    .addComponent(jl_city))
                                .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_ContainerLayout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jtf_city))
                                    .addGroup(jp_ContainerLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jtf_hood))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_ContainerLayout.createSequentialGroup()
                                .addComponent(jl_contact)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_contact)
                                    .addGroup(jp_ContainerLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jcb_state, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(jp_ContainerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_ContainerLayout.createSequentialGroup()
                                .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_name)
                                    .addComponent(jl_RFC))
                                .addGap(15, 15, 15))
                            .addGroup(jp_ContainerLayout.createSequentialGroup()
                                .addComponent(jl_Streed)
                                .addGap(38, 38, 38)))
                        .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtf_streed, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_RFC, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jp_ContainerLayout.setVerticalGroup(
            jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_name)
                    .addComponent(jtf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_RFC)
                    .addComponent(jtf_RFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Streed)
                    .addComponent(jtf_streed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_hood)
                    .addComponent(jtf_hood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_city)
                    .addComponent(jtf_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcb_state, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jp_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_contact)
                    .addComponent(jtf_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jp_Container);
        jp_Container.setBounds(10, 80, 250, 290);

        jbtn_sent.setBackground(new java.awt.Color(204, 204, 0));
        jbtn_sent.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jbtn_sent.setText("Enviar");
        jPanel1.add(jbtn_sent);
        jbtn_sent.setBounds(320, 230, 110, 40);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jtf_phone.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        jl_phone.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_phone.setText("Telefono");

        jtf_email.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        jl_email.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jl_email.setText("E-mail");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_phone)
                    .addComponent(jl_email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_email, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jtf_phone))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_phone)
                    .addComponent(jtf_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_email)
                    .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(280, 100, 270, 90);

        jl_backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/suppliers.jpg"))); // NOI18N
        jPanel1.add(jl_backGround);
        jl_backGround.setBounds(0, 10, 600, 380);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nameActionPerformed

    private void jtf_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_contactActionPerformed

    private void jcb_stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_stateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_stateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JButton jbtn_sent;
    public javax.swing.JComboBox<String> jcb_state;
    public javax.swing.JLabel jl_RFC;
    public javax.swing.JLabel jl_Streed;
    public javax.swing.JLabel jl_backGround;
    public javax.swing.JLabel jl_city;
    public javax.swing.JLabel jl_contact;
    private javax.swing.JLabel jl_email;
    public javax.swing.JLabel jl_hood;
    public javax.swing.JLabel jl_name;
    private javax.swing.JLabel jl_phone;
    public javax.swing.JLabel jl_titleEdit;
    public javax.swing.JPanel jp_Container;
    public javax.swing.JTextField jtf_RFC;
    public javax.swing.JTextField jtf_city;
    public javax.swing.JTextField jtf_contact;
    public javax.swing.JTextField jtf_email;
    public javax.swing.JTextField jtf_hood;
    public javax.swing.JTextField jtf_name;
    public javax.swing.JTextField jtf_phone;
    public javax.swing.JTextField jtf_streed;
    // End of variables declaration//GEN-END:variables
}
