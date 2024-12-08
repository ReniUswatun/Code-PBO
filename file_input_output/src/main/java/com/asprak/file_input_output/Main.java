/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.asprak.file_input_output;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author rizalanggoro
 */
public class Main extends javax.swing.JFrame {
    private UserRepository userRepository = new UserRepository(); 

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        
        this.labelLoading.setVisible(false);
        
        this.loadData(); 
    }
    
    private void loadData() {
        new Thread(() -> {
            this.labelLoading.setVisible(true);
            List<User> users = this.userRepository.getAllUsers(); 

            DefaultListModel<String> listModel = new DefaultListModel<>(); 
            for (User user : users) {
                listModel.addElement(user.getName());
            }

            this.list.setModel(listModel);
            this.labelTotalUsers.setText("Total users: " + users.size());
            
            this.labelLoading.setVisible(false);
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        buttonAdd = new javax.swing.JButton();
        textFieldName = new javax.swing.JTextField();
        labelLoading = new javax.swing.JLabel();
        buttonDeleteAll = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonAddMore = new javax.swing.JButton();
        labelTotalUsers = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportView(list);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        buttonAdd.setText("Tambah");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        labelLoading.setText("memuat...");

        buttonDeleteAll.setText("Hapus Semua");
        buttonDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteAllActionPerformed(evt);
            }
        });

        buttonDelete.setText("Hapus");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonAddMore.setText("Tambah Banyak");
        buttonAddMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddMoreActionPerformed(evt);
            }
        });

        labelTotalUsers.setText("Total: 0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(textFieldName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(buttonAddMore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotalUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelLoading)
                        .addGap(0, 241, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDeleteAll)
                .addGap(25, 25, 25))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdd)
                    .addComponent(buttonDeleteAll)
                    .addComponent(buttonDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddMore)
                    .addComponent(labelLoading)
                    .addComponent(labelTotalUsers))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
        String name = this.textFieldName.getText(); 
        if (name.trim().length() > 0) {
            new Thread(() -> {
                this.labelLoading.setVisible(true);
                User user = new User(name); 
                
                if (userRepository.addUser(user)) {
                    System.out.println("berhasil menambahkan user baru");
                    this.loadData();
                } else {
                    System.out.println("gagal menambahkan user baru");
                }
                this.labelLoading.setVisible(false);
            }).start();
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteAllActionPerformed
        // TODO add your handling code here:
        new Thread(() -> {
            this.labelLoading.setVisible(true);
            if (userRepository.deleteAllUsers())
                this.loadData();
            else 
                System.out.println("gagal menghapus data semua user");
            this.labelLoading.setVisible(false);
        }).start();
    }//GEN-LAST:event_buttonDeleteAllActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // TODO add your handling code here:
        new Thread(() -> {
            this.labelLoading.setVisible(true);
            if (userRepository.deleteLastUser())
                this.loadData();
            else 
                System.out.println("gagal menghapus data user terakhir");
            this.labelLoading.setVisible(false);
        }).start();
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonAddMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddMoreActionPerformed
        // TODO add your handling code here:
        String name = this.textFieldName.getText(); 
        if (name.trim().length() > 0) {
            new Thread(() -> {
                this.labelLoading.setVisible(true);
                
                ArrayList<User> newUsers = new ArrayList<>(); 
                for (int a = 0; a < 100000; a++) 
                    newUsers.add(new User(name + " " + a));  
                
                if (userRepository.addUsers(newUsers)) {
                    System.out.println("berhasil menambahkan banyak user baru");
                    this.loadData();
                } else {
                    System.out.println("gagal menambahkan banyak user baru");
                }

                this.labelLoading.setVisible(false);
            }).start();
        }
    }//GEN-LAST:event_buttonAddMoreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonAddMore;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonDeleteAll;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelLoading;
    private javax.swing.JLabel labelTotalUsers;
    private javax.swing.JList<String> list;
    private javax.swing.JTextField textFieldName;
    // End of variables declaration//GEN-END:variables
}
