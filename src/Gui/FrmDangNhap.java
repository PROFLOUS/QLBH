/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Connect.connect;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import dao.NhanVienDao;
import dao.TaiKhoanDao;
import entity.TaiKhoan;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Hiển thị Giao diện Form Đăng nhập
 *
 */
public class FrmDangNhap extends javax.swing.JFrame {

    //dem so lan dang nhap sai
    //neu sai 3 lan se bi khoa tai khoan
    private int countErroLogin = 0;
    public static String quyen;
  
    /**
     * Creates new form FrmDangNhap
     */
    public FrmDangNhap() {
        try {
            connect.getInstance().connect();
        } catch (SQLException ex) {
            Logger.getLogger(FrmDangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\imgVSicon\\icon.png");
//       jProgressBar1.setBackground(new Color(255, 255, 255, 0));
//       jProgressBar1.setForeground(new Color(74,136,199));
        this.setIconImage(icon);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Đăng Nhập");
        String user = txtUser.getText().trim();
        TaiKhoanDao tkDao = new TaiKhoanDao();
        TaiKhoan tk = tkDao.findTKByUserName(user);
        String pass = tk.getMatKhau();
        passMK.setText(pass);
//        jLabel2.setIcon(new ImageIcon("src\\imgVSicon\\icon.png"));

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FrmQuenMK = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        FrmMatKhau = new javax.swing.JFrame();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        passMK = new javax.swing.JPasswordField();
        lblQuenMK = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mã nhân viên:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("So dien thoai:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Quên mat khau");

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Lay lai mat khau");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Quay lai dang nhap!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FrmQuenMKLayout = new javax.swing.GroupLayout(FrmQuenMK.getContentPane());
        FrmQuenMK.getContentPane().setLayout(FrmQuenMKLayout);
        FrmQuenMKLayout.setHorizontalGroup(
            FrmQuenMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FrmQuenMKLayout.setVerticalGroup(
            FrmQuenMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrmQuenMKLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FrmMatKhauLayout = new javax.swing.GroupLayout(FrmMatKhau.getContentPane());
        FrmMatKhau.getContentPane().setLayout(FrmMatKhauLayout);
        FrmMatKhauLayout.setHorizontalGroup(
            FrmMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        FrmMatKhauLayout.setVerticalGroup(
            FrmMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("Đăng Nhập");

        txtUser.setBackground(new java.awt.Color(244, 244, 242));
        txtUser.setForeground(java.awt.Color.black);
        txtUser.setText("19444531");
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        passMK.setBackground(new java.awt.Color(244, 244, 242));
        passMK.setForeground(java.awt.Color.black);
        passMK.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        passMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passMKActionPerformed(evt);
            }
        });

        lblQuenMK.setText("Quên mật khẩu?");
        lblQuenMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuenMK.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblQuenMKMouseMoved(evt);
            }
        });
        lblQuenMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMKMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/iconwww.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnExit.setBackground(new java.awt.Color(254, 168, 47));
        btnExit.setForeground(java.awt.Color.white);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/close_1.png"))); // NOI18N
        btnExit.setText("Thoát");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(254, 168, 47));
        btnLogin.setForeground(java.awt.Color.white);
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/login (1).png"))); // NOI18N
        btnLogin.setText("Đăng nhập");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnLogin)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(passMK, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(119, 119, 119))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblQuenMK)
                        .addGap(130, 130, 130))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passMK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblQuenMK)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void passMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passMKActionPerformed
        login();
    }//GEN-LAST:event_passMKActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void lblQuenMKMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMKMouseMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_lblQuenMKMouseMoved

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);

    }//GEN-LAST:event_btnExitMouseClicked

    //click vao dang nhap
    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked

        // login();
    }//GEN-LAST:event_btnLoginMouseClicked

    private void lblQuenMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMKMouseClicked

       setVisible(false);
         dispose();
        new FrmQuenMatKhau().setVisible(true);
    }                                      
/**
 * Kiểm tra thông tin tải khoản <p>
 * Hợp lệ đăng nhập vào hệ thống
 *
 */
    public void login(){
           String user = txtUser.getText().trim();

        String passText = new String(passMK.getPassword());

        TaiKhoanDao tkDao = new TaiKhoanDao();
        TaiKhoan tk = tkDao.findTKByUserName(user);
        String khoa = "đã khóa";
        quyen =tk.getTenQuyen().toString();
        if (tk != null) {
            String mk = tk.getMatKhau();

            if (passText.length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mật khẩu!!");
            } else {
                if (tk.getTrangThai().toLowerCase().equals(khoa)) {

                    JOptionPane.showMessageDialog(rootPane, "Tài khoản của bạn đang bị khóa.\n Liên hệ quản lý để mở khóa tài khoản.");
                } else {
                    if (passText.equals(mk) && !tk.getTrangThai().toLowerCase().equals("đã khóa")) {

                        NhanVienDao nvDao = new NhanVienDao();
                        nvDao.upadateTrangThai("online", tk.getNhanVien().getMaNV());
                        this.setVisible(false);
                        FrmLoading ld = new FrmLoading();
                        ld.setVisible(true);

                    } else if (!passText.equals(mk)) {
                        countErroLogin++;
                        JOptionPane.showMessageDialog(rootPane, "Mật khẩu không chính xác!!\n Đăng nhập sai 3 lần tài khoản sẽ bị khóa.\n Bạn đã nhập sai " + countErroLogin + " lần.");

                        if (countErroLogin == 3) {
                            JOptionPane.showMessageDialog(rootPane, "Tài khoản đã bị khóa do đăng nhập sai quá 3 lần.\n Liên hệ quản lý để mở lại Tài khoản.");
                            //cap nhat lai trangthai thanh đã khóa.
                            tk.setTrangThai("đã khóa");
                            tkDao.updateTaiKhoan(tk);
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tên đăng nhập không chính xác!!");
        }

        
    }//GEN-LAST:event_lblQuenMKMouseClicked

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
            java.util.logging.Logger.getLogger(FrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatLightFlatIJTheme.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new FrmDangNhap().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrmMatKhau;
    private javax.swing.JFrame FrmQuenMK;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblQuenMK;
    private javax.swing.JPasswordField passMK;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
