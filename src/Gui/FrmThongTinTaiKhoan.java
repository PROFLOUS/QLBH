package Gui;

import dao.ImageHelper;
import dao.NhanVienDao;
import dao.TaiKhoanDao;
import entity.NhanVien;
import entity.TaiKhoan;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;

/**
 * Hiển thị Giao diện Form Thông tin tài khoản của nhân viên đăng nhập vào hệ
 * thống
 *
 */
public class FrmThongTinTaiKhoan extends javax.swing.JPanel {

    public Border default_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 153, 153));
    public Border active_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 204, 255));
    /**
     * Creates new form FrmThongTinTaiKhoan
     */
    NhanVienDao nhanvienDao = new NhanVienDao();

    public FrmThongTinTaiKhoan() {
        initComponents();
        renderData();
        setButtonBorder(btn_tab_TTTK);
    }

    public void setButtonBorder(JButton button) {
        button.setBorder(active_border);
        button.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_FormTTTaiKhoan = new javax.swing.JPanel();
        lbl_text_TTTK = new javax.swing.JLabel();
        pnl_menuTab_TTTK = new javax.swing.JPanel();
        btn_tab_TTTK = new javax.swing.JButton();
        pnl_tab_FormTTTK = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jpImage = new javax.swing.JPanel();
        lblImg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        lblNgaySinh = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        lblNgayVaoLam = new javax.swing.JLabel();
        txtNgayVaoLam = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JTextField();
        btnDoiMK = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1090, 700));

        pnl_FormTTTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        pnl_FormTTTaiKhoan.setPreferredSize(new java.awt.Dimension(1300, 700));
        pnl_FormTTTaiKhoan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_TTTK.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_TTTK.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_TTTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_TTTK.setText("Thông Tin Tài Khoản");
        pnl_FormTTTaiKhoan.add(lbl_text_TTTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 30));

        pnl_menuTab_TTTK.setBackground(new java.awt.Color(255, 255, 255));

        btn_tab_TTTK.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_TTTK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_TTTK.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_TTTK.setText("Thông Tin Tài Khoản");
        btn_tab_TTTK.setBorder(null);
        btn_tab_TTTK.setContentAreaFilled(false);
        btn_tab_TTTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_TTTKMouseClicked(evt);
            }
        });
        btn_tab_TTTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_TTTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_TTTKLayout = new javax.swing.GroupLayout(pnl_menuTab_TTTK);
        pnl_menuTab_TTTK.setLayout(pnl_menuTab_TTTKLayout);
        pnl_menuTab_TTTKLayout.setHorizontalGroup(
            pnl_menuTab_TTTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_TTTKLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_TTTK)
                .addContainerGap(871, Short.MAX_VALUE))
        );
        pnl_menuTab_TTTKLayout.setVerticalGroup(
            pnl_menuTab_TTTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_tab_TTTK, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnl_FormTTTaiKhoan.add(pnl_menuTab_TTTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 50));

        pnl_tab_FormTTTK.setBackground(new java.awt.Color(0, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpImageLayout = new javax.swing.GroupLayout(jpImage);
        jpImage.setLayout(jpImageLayout);
        jpImageLayout.setHorizontalGroup(
            jpImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpImageLayout.setVerticalGroup(
            jpImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        jLabel2.setText("Tên nhân viên:");

        jLabel3.setText("Mã nhân viên:");

        lblSDT.setText("Số điện thoại");

        jLabel4.setText("Tài khoan:");

        jLabel5.setText("Mật khẩu");

        txtTen.setText("Nguyễn Văn Anh");

        txtMaNV.setBackground(new java.awt.Color(211, 228, 205));
        txtMaNV.setText("19444531");
        txtMaNV.setEnabled(false);

        txtSDT.setText("0397530256");

        txtUser.setBackground(new java.awt.Color(211, 228, 205));
        txtUser.setText("19444531");

        txtMatKhau.setEditable(false);
        txtMatKhau.setBackground(new java.awt.Color(211, 228, 205));

        lblDiaChi.setText("Địa chỉ:");

        txtDiaChi.setText("127 D2");

        lblNgaySinh.setText("Ngày Sinh:");

        txtNgaySinh.setEditable(false);
        txtNgaySinh.setBackground(new java.awt.Color(211, 228, 205));
        txtNgaySinh.setText("14/10/2000");

        lblNgayVaoLam.setText("Ngày vào làm:");

        txtNgayVaoLam.setEditable(false);
        txtNgayVaoLam.setBackground(new java.awt.Color(211, 228, 205));
        txtNgayVaoLam.setText("20/10/2020");

        jLabel10.setText("Chức vụ:");

        txtChucVu.setEditable(false);
        txtChucVu.setBackground(new java.awt.Color(211, 228, 205));
        txtChucVu.setText("Nhân viên");

        btnDoiMK.setBackground(new java.awt.Color(21, 151, 229));
        btnDoiMK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDoiMK.setForeground(java.awt.Color.white);
        btnDoiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/refresh (3).png"))); // NOI18N
        btnDoiMK.setText("Đổi mật khẩu");
        btnDoiMK.setToolTipText("");
        btnDoiMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(21, 151, 229));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setForeground(java.awt.Color.white);
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/system-update.png"))); // NOI18N
        btnUpdate.setText("Cập nhật");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jpImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDoiMK))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(471, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUpdate)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jpImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_tab_FormTTTKLayout = new javax.swing.GroupLayout(pnl_tab_FormTTTK);
        pnl_tab_FormTTTK.setLayout(pnl_tab_FormTTTKLayout);
        pnl_tab_FormTTTKLayout.setHorizontalGroup(
            pnl_tab_FormTTTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormTTTKLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_tab_FormTTTKLayout.setVerticalGroup(
            pnl_tab_FormTTTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormTTTKLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_FormTTTaiKhoan.add(pnl_tab_FormTTTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1090, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormTTTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormTTTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tab_TTTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_TTTKMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_TTTKMouseClicked

    private void btn_tab_TTTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_TTTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_TTTKActionPerformed

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        new FrmDoiMK().setVisible(true);
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        //su kien cap nhat thong tin nhan vien
        int tb = JOptionPane.showConfirmDialog(null, "Bạn có chắc cập nhật lại không?", "Update", JOptionPane.YES_NO_OPTION);
        if (tb == JOptionPane.YES_OPTION) {
            String tenNV = txtTen.getText().trim();
            String maNV = txtMaNV.getText();
            String DiaChi = txtDiaChi.getText().trim();
            String sdt = txtSDT.getText().trim();
            //JOptionPane.showMessageDialog(txtMaNV, "Đang nâng cấp!!");
            NhanVien nv = new NhanVien(tenNV, sdt, DiaChi);
            if (nhanvienDao.updateNhanVien(maNV, nv)) {
                JOptionPane.showMessageDialog(txtMaNV, "Cập nhật thành công!!");
            } else {
                JOptionPane.showMessageDialog(txtMaNV, "Đang nâng cấp!!");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * Kiểm tra dữ liệu nhập
     */
    public boolean checkValue() {
        String tenNV = txtTen.getText().trim();

        String DiaChi = txtDiaChi.getText().trim();
        String sdt = txtSDT.getText().trim();
        String regexMail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";//check mail
        String regexPhone = "^[0-9]{10}";
        if (tenNV.length() <= 0) {
            JOptionPane.showMessageDialog(txtDiaChi, "Tên Nhân viên không được để trống");
            return false;
        }
        if (DiaChi.length() <= 0) {
            JOptionPane.showMessageDialog(txtDiaChi, "Địa chỉ NCC không được để trống");
            return false;
        }
        if (!sdt.matches(regexPhone)) {
            JOptionPane.showMessageDialog(txtDiaChi, "Số điện thoại có 10 số");
            return false;
        }
        return true;
    }

    /**
     * Đọc dữ liệu thông tiên nhân viên lên giao diện
     */
    public void renderData() {
        NhanVienDao nvDao = new NhanVienDao();
        NhanVien nv = nvDao.getNVByMaTrangThai("online");
        // System.out.println("Gui.FrmThongTinTaiKhoan.renderData()"+nv);
        if (nv != null) {
            txtTen.setText(nv.getTenNV());
            txtMaNV.setText(nv.getMaNV());
            txtSDT.setText(nv.getSdt());
            txtDiaChi.setText(nv.getDiaChi());
            txtNgaySinh.setText(nv.getNgaySinh().toString());
            txtNgayVaoLam.setText(nv.getNgayVaoLam().toString());

            txtChucVu.setText(nv.getChucVu().getTenCV());

            //lay ra tai khoan
            TaiKhoanDao tkDao = new TaiKhoanDao();
            TaiKhoan tk = tkDao.findTKByMaNV(nv.getMaNV());
            txtUser.setText(tk.getTenTaiKhoan());
            txtMatKhau.setText(tk.getMatKhau());

            txtUser.setEnabled(false);

            //set img
            if (nv.getImg() != null) {
                try {

                    Image img = ImageHelper.createImgFromByArray(nv.getImg(), "jpg");
                    Image imgResize = ImageHelper.resize(img, 150, 200);

                    lblImg.setIcon(new ImageIcon(imgResize));
                    employeeImg = nv.getImg();
                } catch (IOException ex) {
                    Logger.getLogger(FrmDsNV.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/new-arrival.png"))); // NOI18N
                employeeImg = nv.getImg();
            }

        }

    }
    private byte[] employeeImg;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btn_tab_TTTK;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpImage;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblNgayVaoLam;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lbl_text_TTTK;
    private javax.swing.JPanel pnl_FormTTTaiKhoan;
    private javax.swing.JPanel pnl_menuTab_TTTK;
    private javax.swing.JPanel pnl_tab_FormTTTK;
    private javax.swing.JTextField txtChucVu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNV;
    public static javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNgayVaoLam;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
