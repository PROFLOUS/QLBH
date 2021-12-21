/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Gui.FrmThongTinTaiKhoan.txtMatKhau;
import dao.NhanVienDao;
import dao.TaiKhoanDao;
import entity.NhanVien;
import entity.TaiKhoan;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Hiển thị Giao diện Form Đổi mật khẩu
 *
 */
public class FrmDoiMK extends javax.swing.JFrame {

    /**
     * Creates new form FrmDoiMK
     */
    public FrmDoiMK() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\imgVSicon\\icon.png");
        this.setIconImage(icon);
        //setResizable(false);
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Đổi mật khẩu");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMKCu = new javax.swing.JTextField();
        txtMKMoi = new javax.swing.JTextField();
        txtMKMoi2 = new javax.swing.JTextField();
        btnHuy = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel2.setText("Mật khẩu cũ:");

        jLabel3.setText("Mật khẩu mới:");

        jLabel4.setText("Nhập lại mật khẩu mới:");

        btnHuy.setBackground(new java.awt.Color(21, 151, 229));
        btnHuy.setForeground(java.awt.Color.white);
        btnHuy.setText("Hủy");
        btnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXacNhan.setBackground(new java.awt.Color(21, 151, 229));
        btnXacNhan.setForeground(java.awt.Color.white);
        btnXacNhan.setText("Xách nhân");
        btnXacNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMKCu, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtMKMoi)
                    .addComponent(txtMKMoi2))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMKCu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMKMoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        //doi mat khau
        String mkMoi = txtMKMoi.getText();
        if (checkValu()) {
            //cap nhat lai mk theo ma NV
            NhanVienDao nvDao = new NhanVienDao();
            NhanVien nv = nvDao.getNVByMaTrangThai("online");
            //  System.out.println(nv.toString());
            //lay ra tai khoan
            TaiKhoanDao tkDao = new TaiKhoanDao();

            if (tkDao.updateMKByMaNV(nv.getMaNV(), mkMoi)) {
                JOptionPane.showMessageDialog(rootPane, "Cập nhật mật khẩu thành công!!");
                txtMKCu.setText("");
                txtMKMoi.setText("");
                txtMKMoi2.setText("");
                txtMatKhau.setText(mkMoi);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Hệ thống đang lỗi. Hãy quay lại đổi mk sau!!");
            }

        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    /**
     * Kiểm tra dữ liệu vào
     *
     */
    public boolean checkValu() {
        String mkCu = txtMKCu.getText();
        String mkMoi2 = txtMKMoi2.getText();
        String mkMoi = txtMKMoi.getText();
        NhanVienDao nvDao = new NhanVienDao();
        NhanVien nv = nvDao.getNVByMaTrangThai("online");
        //lay ra tai khoan
        TaiKhoanDao tkDao = new TaiKhoanDao();
        TaiKhoan tk = tkDao.findTKByMaNV(nv.getMaNV());
        //System.out.println(tk.toString());
        if (!tk.getMatKhau().equals(mkCu)) {
            JOptionPane.showMessageDialog(rootPane, "Mật khẩu cũ không chính xác. Xin hãy nhập lại!!");
            return false;
        } else if (mkMoi.length() == 0 || mkMoi2.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mật khẩu mới!!");
            return false;
        } else if (!mkMoi.equals(mkMoi2)) {

            JOptionPane.showMessageDialog(rootPane, "Nhập lại mật khẩu mới không trùng nhau!!");
            return false;
        } else if (!mkMoi.matches("^[a-z0-9_-]{6,18}$")) {
            JOptionPane.showMessageDialog(rootPane, "Mật khẩu 6-18 ký tự và không chứa ký tự đặc biệt");
            return false;
        }

        return true;
    }

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
            java.util.logging.Logger.getLogger(FrmDoiMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDoiMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDoiMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            //    java.util.logging.Logger.getLogger(FrmDoiMK.class.getName()btnHuyva.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDoiMK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtMKCu;
    private javax.swing.JTextField txtMKMoi;
    private javax.swing.JTextField txtMKMoi2;
    // End of variables declaration//GEN-END:variables
}
