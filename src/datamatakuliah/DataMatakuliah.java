/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 * Program GUI Java untuk melakukan operasi CRUD data Matakuliah
 * 
 * @author Samuel Lekatompessy
 * @version 1.0
 * @since 2022-02-22
 * 
 * Copyright 2022 Samuel Lekatompessy
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package datamatakuliah;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DataMatakuliah extends javax.swing.JFrame {
    private DefaultTableModel DftTblModel_matakuliah;
    private static List<Matakuliah> matakuliahs;

    /**
     * Method ini digunakan untuk membentuk tampilan JFrameMatakuliah.
     * Method listData() juga dipanggil pada method ini.
     */
    public DataMatakuliah() {
        initComponents();
        this.listData();
    }

    /**
     * Method ini digunakan untuk menyusun model tampil data Matakuliah.
     */
    public void listData() {
        this.listData("");
    }

    /**
     * Method ini digunakan untuk menyusun model tampil data Matakuliah
     * dengan parameter keyword.
     * 
     * @param keyword Ini adalah parameter pertama untuk method listData
     */
    public void listData(String keyword) {
        DftTblModel_matakuliah = new DefaultTableModel();
        DftTblModel_matakuliah.addColumn("No.");
        DftTblModel_matakuliah.addColumn("Kode");
        DftTblModel_matakuliah.addColumn("Nama");
        DftTblModel_matakuliah.addColumn("SKS");
        DftTblModel_matakuliah.addColumn("Kode Prasyarat");
        jTable_Matkul.setModel(DftTblModel_matakuliah);

        try {
            matakuliahs = new DBMatakuliah().list(keyword);
            int index = 1;
            for (Matakuliah data : matakuliahs) {
                DftTblModel_matakuliah.addRow(new Object[] {
                        index,
                        data.getKode(),
                        data.getNama(),
                        data.getSks(),
                        data.getKodePrasyarat()
                });
                ++index;
            }
            DftTblModel_matakuliah.setRowCount(index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method ini digunakan untuk menyusun model tambah data Matakuliah.
     */
    public void addData() {
        String kode = jTextField_MatkulKode.getText();
        String nama = jTextField_MatkulNama.getText();
        String sks = jTextField_MatkulSks.getText();
        String kode_prasyarat = jTextField_MatkulKodePrasyarat.getText();
        try {
            new DBMatakuliah().add(kode, nama, sks, kode_prasyarat);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            this.listData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * MeMethod ini digunakan untuk menyusun model ubah data Matakuliah.
     */
    public void editData() {
        String kode = jTextField_MatkulKode.getText();
        String nama = jTextField_MatkulNama.getText();
        String sks = jTextField_MatkulSks.getText();
        String kode_prasyarat = jTextField_MatkulKodePrasyarat.getText();
        try {
            new DBMatakuliah().edit(kode, nama, sks, kode_prasyarat);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            this.listData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method ini digunakan untuk menyusun model hapus data Matakuliah.
     */
    public void deleteData() {
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data tersebut?",
                "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == 0) {
            String kode = jTextField_MatkulKode.getText();
            try {
                new DBMatakuliah().delete(kode);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                this.listData();
                jTextField_MatkulKode.setText("");
                jTextField_MatkulNama.setText("");
                jTextField_MatkulSks.setText("");
                jTextField_MatkulKodePrasyarat.setText("");
                jTextField_MatkulKode.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus" + e.getMessage(), "Pesan",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    /**
     * Method ini digunakan untuk mereset semua text field.
     */
    public void cleanField() {
        jTextField_MatkulKode.setText("");
        jTextField_MatkulNama.setText("");
        jTextField_MatkulSks.setText("");
        jTextField_MatkulKodePrasyarat.setText("");
        jTextField_Pencarian.setText("");
        jTextField_MatkulKode.requestFocus();

        this.listData();
    }

    /**
     * Method ini digunakan untuk mencari data Matakuliah.
     */
    public void searchData() {
        String keyword = jTextField_Pencarian.getText();
        this.listData(keyword);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_MatkulKode = new javax.swing.JTextField();
        jTextField_MatkulNama = new javax.swing.JTextField();
        jTextField_MatkulSks = new javax.swing.JTextField();
        jTextField_MatkulKodePrasyarat = new javax.swing.JTextField();
        jButton_MatkulTambah = new javax.swing.JButton();
        jButton_MatkulUbah = new javax.swing.JButton();
        jButton_MatkulHapus = new javax.swing.JButton();
        jButton_MatkulBersih = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Matkul = new javax.swing.JTable();
        jTextField_Pencarian = new javax.swing.JTextField();
        jButton_Pencarian = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".:: Form Entri Data Matakuliah ::.");
        setMaximumSize(new java.awt.Dimension(480, 450));
        setPreferredSize(new java.awt.Dimension(480, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form Entri Data Matakuliah");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kode Matakuliah");
        jLabel2.setPreferredSize(new java.awt.Dimension(110, 16));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("SKS");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Kode Prasyarat");

        jTextField_MatkulKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MatkulKodeActionPerformed(evt);
            }
        });

        jTextField_MatkulNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MatkulNamaActionPerformed(evt);
            }
        });

        jTextField_MatkulSks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MatkulSksActionPerformed(evt);
            }
        });
        jTextField_MatkulSks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_MatkulSksKeyPressed(evt);
            }
        });

        jTextField_MatkulKodePrasyarat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MatkulKodePrasyaratActionPerformed(evt);
            }
        });

        jButton_MatkulTambah.setText("Tambah");
        jButton_MatkulTambah.setMaximumSize(null);
        jButton_MatkulTambah.setMinimumSize(null);
        jButton_MatkulTambah.setPreferredSize(new java.awt.Dimension(90, 25));
        jButton_MatkulTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MatkulTambahActionPerformed(evt);
            }
        });

        jButton_MatkulUbah.setText("Ubah");
        jButton_MatkulUbah.setPreferredSize(new java.awt.Dimension(80, 25));
        jButton_MatkulUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MatkulUbahActionPerformed(evt);
            }
        });

        jButton_MatkulHapus.setText("Hapus");
        jButton_MatkulHapus.setPreferredSize(new java.awt.Dimension(80, 25));
        jButton_MatkulHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MatkulHapusActionPerformed(evt);
            }
        });

        jButton_MatkulBersih.setText("Reset");
        jButton_MatkulBersih.setPreferredSize(new java.awt.Dimension(80, 25));
        jButton_MatkulBersih.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_MatkulBersihMouseClicked(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 350));

        jTable_Matkul.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jTable_Matkul.setMaximumSize(null);
        jTable_Matkul.setMinimumSize(null);
        jTable_Matkul.setPreferredSize(null);
        jTable_Matkul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_MatkulMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Matkul);

        jTextField_Pencarian.setToolTipText("");
        jTextField_Pencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PencarianActionPerformed(evt);
            }
        });
        jTextField_Pencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_PencarianKeyPressed(evt);
            }
        });

        jButton_Pencarian.setText("Cari");
        jButton_Pencarian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_PencarianMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 483,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(jTextField_MatkulKode,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(jTextField_MatkulNama,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(jTextField_MatkulSks,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(jTextField_MatkulKodePrasyarat,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addComponent(jButton_MatkulTambah,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)
                                                .addComponent(jButton_MatkulUbah,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)
                                                .addComponent(jButton_MatkulHapus,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)
                                                .addComponent(jButton_MatkulBersih,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField_Pencarian,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton_Pencarian)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(15, 15, 15)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextField_MatkulKode, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel3))
                                        .addComponent(jTextField_MatkulNama, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel4))
                                        .addComponent(jTextField_MatkulSks, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel5))
                                        .addComponent(jTextField_MatkulKodePrasyarat,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton_MatkulTambah, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_MatkulUbah, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_MatkulHapus, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_MatkulBersih, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField_Pencarian, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_Pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_MatkulBersihMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton_MatkulBersihMouseClicked
        // TODO add your handling code here:
        this.cleanField();
    }// GEN-LAST:event_jButton_MatkulBersihMouseClicked

    private void jTable_MatkulMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable_MatkulMouseClicked
        // TODO add your handling code here:
        try {
            int baris = jTable_Matkul.getSelectedRow();
            jTextField_MatkulKode.setText(DftTblModel_matakuliah.getValueAt(baris, 1).toString());
            jTextField_MatkulNama.setText(DftTblModel_matakuliah.getValueAt(baris, 2).toString());
            jTextField_MatkulSks.setText(DftTblModel_matakuliah.getValueAt(baris, 3).toString());
            jTextField_MatkulKodePrasyarat.setText(DftTblModel_matakuliah.getValueAt(baris, 4).toString());
        } catch (Exception e) {
            e.getMessage();
        }
    }// GEN-LAST:event_jTable_MatkulMouseClicked

    private void jTextField_PencarianActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField_PencarianActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField_PencarianActionPerformed

    private void jButton_PencarianMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton_PencarianMouseClicked
        // TODO add your handling code here:
        this.searchData();
    }// GEN-LAST:event_jButton_PencarianMouseClicked

    private void jTextField_PencarianKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField_PencarianKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            this.searchData();
        }
    }// GEN-LAST:event_jTextField_PencarianKeyPressed

    private void jButton_MatkulUbahActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_MatkulUbahActionPerformed
        // TODO add your handling code here:
        this.editData();
    }// GEN-LAST:event_jButton_MatkulUbahActionPerformed

    private void jButton_MatkulTambahActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.addData();
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton_MatkulHapusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.deleteData();
    }// GEN-LAST:event_jButton3ActionPerformed

    private void jTextField_MatkulKodeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField_MatkulNamaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField_MatkulSksActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField_MatkulKodePrasyaratActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField_MatkulSksKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField3KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataMatakuliah.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataMatakuliah.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataMatakuliah.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataMatakuliah.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataMatakuliah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_MatkulBersih;
    private javax.swing.JButton jButton_MatkulHapus;
    private javax.swing.JButton jButton_MatkulTambah;
    private javax.swing.JButton jButton_MatkulUbah;
    private javax.swing.JButton jButton_Pencarian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Matkul;
    private javax.swing.JTextField jTextField_MatkulKode;
    private javax.swing.JTextField jTextField_MatkulKodePrasyarat;
    private javax.swing.JTextField jTextField_MatkulNama;
    private javax.swing.JTextField jTextField_MatkulSks;
    private javax.swing.JTextField jTextField_Pencarian;
    // End of variables declaration//GEN-END:variables
}
