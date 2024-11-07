/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import config.KoneksiDB;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows 10 Pro
 */
public class FormBiodata extends javax.swing.JFrame {

    private Statement st;
    private ResultSet rs;
    private Connection conn;
    private PreparedStatement pst;

    private void tampilData() {
        DefaultTableModel kolomtabel = new DefaultTableModel();
        kolomtabel.addColumn("No.");
        kolomtabel.addColumn("Nama");
        kolomtabel.addColumn("NIM");
        kolomtabel.addColumn("TTL");
        kolomtabel.addColumn("Jenis Kelamin");
        kolomtabel.addColumn("Prodi");
        kolomtabel.addColumn("No. Telepon");
        kolomtabel.addColumn("Alamat");

        try {
            int nomor = 1;
            st = conn.createStatement();
            String sql = "Select * FROM tbl_biodata";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                kolomtabel.addRow(new Object[]{
                    ("" + nomor++),
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("ttl"),
                    rs.getString("jekel"),
                    rs.getString("prodi"),
                    rs.getString("notelp"),
                    rs.getString("alamat"),});
                tabel_biodata.setModel(kolomtabel);
                tabel_biodata.enable(true);
                tfNama.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data.\n" + e.getMessage());
        }
    }

    private void hapusData() {
        int row = tabel_biodata.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan di hapus !");
            return;
        }
        int jawab = JOptionPane.showOptionDialog(this,
                "Apakah Anda ingin menghapus data ini?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (jawab == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM tbl_biodata WHERE nim='" + tfNIM.getText() + "' ";
                pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
                clearForm();
                tampilData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            clearForm();
            tampilData();

        }
    }

    private void clearForm() {
        tfNama.setText("");
        tfNIM.setText("");
        tfTTL.setText("");
        buttonGroup1.clearSelection();
        cmbProdi.setSelectedItem("-- Program Studi --");
        tfNomorTelepon.setText("");
        taAlamat.setText("");
        tfNama.requestFocus();
    }

    /**
     * Creates new form FormBiodata
     */
    public FormBiodata() {
        initComponents();
        conn = KoneksiDB.getKoneksi();
        tampilData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        tfNIM = new javax.swing.JTextField();
        tfTTL = new javax.swing.JTextField();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        cmbProdi = new javax.swing.JComboBox<>();
        tfNomorTelepon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAlamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_biodata = new javax.swing.JTable();
        btnSubmit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Biodata");

        jLabel2.setText("Nama Mahasiswa/i   :");

        jLabel3.setText("NIM :");

        jLabel4.setText("Tempat dan Tgl. Lahir :");

        jLabel5.setText("Jenis Kelamin :");

        jLabel6.setText("Prodi");

        jLabel7.setText("Nomor Telp :");

        jLabel8.setText("Alamat :");

        tfNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbLaki);
        rbLaki.setText("Laki - Laki");

        buttonGroup1.add(rbPerempuan);
        rbPerempuan.setText("Perempuan");

        cmbProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Prodi---", "Teknik Informatika", "Teknik Industri", "Teknik Arsitektur", "Teknik Mesin", "Teknik Lingkungan" }));

        taAlamat.setColumns(20);
        taAlamat.setRows(5);
        jScrollPane1.setViewportView(taAlamat);

        tabel_biodata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Nama", "NIM", "TTL", "Jenis Kelamin", "Prodi", "Nomor telepon", "Alamat"
            }
        ));
        tabel_biodata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_biodataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_biodata);

        btnSubmit.setText("submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");

        btnExit.setText("Exit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSubmit)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfNIM, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTTL, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbProdi, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfNomorTelepon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(rbLaki)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbPerempuan))
                            .addComponent(tfNama))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfTTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rbLaki)
                            .addComponent(rbPerempuan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfNomorTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnExit))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (tfNama.getText().equals("")
                || tfNIM.getText().equals("")
                || tfTTL.getText().equals("")
                || tfNomorTelepon.getText().equals("")
                || taAlamat.getText().equals("")
                || buttonGroup1.isSelected(null)
                || cmbProdi.getSelectedItem().equals("-- Program Studi --")) {
            JOptionPane.showMessageDialog(this, "Field harap di isi !",
                    "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String cekDB = "SELECT * FROM tbl_biodata WHERE nim = '"
                    + tfNIM.getText() + "' ";
            rs = st.executeQuery(cekDB);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "NIM sudah tersedia !");
            } else {
                st = conn.createStatement();
                String jekel;
                if (rbLaki.isSelected()) {
                    jekel = "Laki - Laki";
                } else {
                    jekel = "Perempuan";
                }
//aksi simpan data (Submit/Save/Add)
                String sql = "INSERT INTO tbl_biodata VALUES ('"
                        + tfNama.getText()
                        + "', '" + tfNIM.getText()
                        + "', '" + tfTTL.getText()
                        + "', '" + jekel
                        + "', '" + cmbProdi.getSelectedItem()
                        + "', '" + tfNomorTelepon.getText()
                        + "', '" + taAlamat.getText()
                        + "') ";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Apakah anda ingin menghapus data ini");
                tampilData();
                clearForm();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        hapusData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tabel_biodataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_biodataMouseClicked
        // TODO add your handling code here:
        int row = tabel_biodata.getSelectedRow();
        if (tabel_biodata.getValueAt(row, 4).equals("Laki-laki")) {
            rbLaki.setSelected(true);
        } else if (tabel_biodata.getValueAt(row, 4).equals("Perempuan")) {
            rbPerempuan.setSelected(true);
        }
        tfNama.setText(tabel_biodata.getValueAt(row, 1).toString());
        tfNIM.setText(tabel_biodata.getValueAt(row, 2).toString());
        tfTTL.setText(tabel_biodata.getValueAt(row, 3).toString());
        cmbProdi.setSelectedItem(tabel_biodata.getValueAt(row, 5).toString());
        tfNomorTelepon.setText(tabel_biodata.getValueAt(row, 6).toString());
        taAlamat.setText(tabel_biodata.getValueAt(row, 7).toString());
    }//GEN-LAST:event_tabel_biodataMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(FormBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBiodata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbProdi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextArea taAlamat;
    private javax.swing.JTable tabel_biodata;
    private javax.swing.JTextField tfNIM;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNomorTelepon;
    private javax.swing.JTextField tfTTL;
    // End of variables declaration//GEN-END:variables
}
