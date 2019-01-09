/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstwn;

import javax.swing.JOptionPane;

/**
 *
 * @author Dwi Setiawan
 */
public class MainActivity extends javax.swing.JFrame {

    public MainActivity() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtPlain = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtChiper = new javax.swing.JTextArea();
        txtKey = new javax.swing.JTextField();
        btnEnkrip = new javax.swing.JButton();
        btnDkrip = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chaesar Chiper");

        txtPlain.setColumns(20);
        txtPlain.setRows(5);
        jScrollPane1.setViewportView(txtPlain);

        txtChiper.setColumns(20);
        txtChiper.setRows(5);
        jScrollPane2.setViewportView(txtChiper);

        btnEnkrip.setText("Enkripsi");
        btnEnkrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnkripActionPerformed(evt);
            }
        });

        btnDkrip.setText("Dekripsi");
        btnDkrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDkripActionPerformed(evt);
            }
        });

        jLabel1.setText("Kunci");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setText("CHAESAR CHIPER");

        jLabel3.setText("Dwi Setiawan - 18520241011");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(btnDkrip)
                    .addComponent(btnEnkrip)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnEnkrip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDkrip)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnkripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnkripActionPerformed

        String key = txtKey.getText();
        String textPlain = (key.length()+key+txtPlain.getText());
        String out="";

        for(int i=0; i<textPlain.length();i++){
            int index = textPlain.charAt(i);
            char a = (char)(index+1);
            out = out + String.valueOf(a);
        }
        txtChiper.setText(out);
        txtPlain.setText("");
        txtKey.setText("");
       
    }//GEN-LAST:event_btnEnkripActionPerformed

    private void btnDkripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDkripActionPerformed
        String textPlain = txtChiper.getText();
        char u = (char)(textPlain.charAt(0));
        String kunci = "",out = "";
        
        int jum = Integer.parseInt(String.valueOf(u))-1;
        
        for(int i = 1 ; i <= jum ;i++){
            int index = textPlain.charAt(i);
            char s = (char)(index-1);
            kunci = kunci + String.valueOf(s);
        }
        if(kunci.equals(txtKey.getText())){
            for (int i = (jum+1); i < textPlain.length();i++){
                int index = textPlain.charAt(i);
                char s = (char)(index-1);
                out = out + String.valueOf(s);
            }
            txtPlain.setText(out);
        }else{
            JOptionPane.showMessageDialog(null, "key tidak cocok, silahkan coba lagi");
        }
    }//GEN-LAST:event_btnDkripActionPerformed

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainActivity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDkrip;
    private javax.swing.JButton btnEnkrip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtChiper;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextArea txtPlain;
    // End of variables declaration//GEN-END:variables
}
