/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.toedter.calendar.JTextFieldDateEditor;
import dao.ChucVuDao;
import dao.ImageHelper;
import dao.NhanVienDao;
import entity.CaLam;
import entity.ChucVu;
import entity.NhanVien;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author HP
 */
public class FrmDsNV extends javax.swing.JPanel {
private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
private DefaultTableModel dfNV_Model;
ArrayList<NhanVien> dsNv;
ArrayList<ChucVu> dsCv;
NhanVienDao nv_dao;
ChucVuDao cv_dao;
    public FrmDsNV() {
        initComponents();
        txtMaNV.setEditable(false);
        
        nv_dao = new NhanVienDao();
        cv_dao = new ChucVuDao();
        dsNv = new ArrayList<NhanVien>();
        dsCv = new ArrayList<ChucVu>();
        upCbo_CV();
        upTblNV();
        Date date = new  Date();
        dt_NgVaoLam.setDate(date);
        dt_NgaySinh.setDate(date);
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dt_NgVaoLam.getDateEditor();
        editor.setEditable(false);
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) dt_NgaySinh.getDateEditor();
        editor2.setEditable(false);
    }

    //doc du lieu len cbo chuc vu
    public  void upCbo_CV(){
        dsCv = cv_dao.getAllCV();
        for (ChucVu cv : dsCv) {
            cbo_CV.addItem(cv.getTenCV());
        }
    }
    //đọc dữ liệu lên bảg nhân viên 
    public void upTblNV() {
        dfNV_Model = (DefaultTableModel) tbl_NV.getModel();
        dsNv = nv_dao.getAllNV();
        for (NhanVien nv : dsNv) {
            dfNV_Model.addRow(new Object[]{
                nv.getMaNV(), nv.getTenNV(), nv.getChucVu().getTenCV(),
                nv.getSdt(),nv.getDiaChi(),nv.getNgaySinh(),nv.getNgayVaoLam(),
                nv.getEmail()
            });
        }
    }
    
    //xoa combobox
    public void xoaCBB() {
        int itCount = cbo_CV.getItemCount();
        for (int i = 0; i < itCount; i++) {
            cbo_CV.removeItemAt(0);
        }

    }
    //xóa model Nhân Viên
    public void xoaModelNV() {
        DefaultTableModel del = (DefaultTableModel) tbl_NV.getModel();
        del.getDataVector().removeAllElements();
    }
    //kiem tra dữ liệu nhập
     // boolean kiemTraNgayVaoLam(){
//           DateFormat formatter = new SimpleDateFormat("yyyyMMdd"); 
//            Date dateNgaySinh = dt_NgaySinh.getDate();
//            Date date = new Date();
//           Date dateNgayLam = dt_NgVaoLam.getDate();
//        if ((dateNgayLam.getTime() <date.getTime())) {
//            JOptionPane.showMessageDialog(this, "Ngày vào làm phải sau ngày hiện tại!");
//            return false;
//        }
//         return true;
    // }
    public boolean kiemTraData() {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd"); 
        String tenNv = txtTenNV.getText().trim();
        String sdt = txtSDTNV.getText().trim();
        String diaChi = txtDiaChiNV.getText().trim();
//        Date dateNgayLam = dt_NgVaoLam.getDate();
        Date dateNgaySinh = dt_NgaySinh.getDate();
        Date date = new Date();
        int d1 = Integer.parseInt(formatter.format(dateNgaySinh)); 
      //  System.out.println("age1: "+d1);
        int d2 = Integer.parseInt(formatter.format(date)); 
       // System.out.println("age2: "+d2);
        int age =(d2-d1)/10000;
      //  System.out.println("age: "+age);
        
        //tên nhân viên 
        if (!(tenNv.length() > 0)) {
            JOptionPane.showMessageDialog(this, "Tên Nhân Viên không được để trống");
            return false;
        }
        if (!(sdt.length() > 0 && sdt.matches("^[0-9]{10}"))) {
            JOptionPane.showMessageDialog(this, "Số điện thoại có 10 số");
            return false;
        }
        //Địa chỉ
        if (!(diaChi.length() > 0 )) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống");
            return false;
        }
//        if ((dateNgayLam.getTime() <date.getTime())) {
//            JOptionPane.showMessageDialog(this, "Ngày vào làm phải sau ngày hiện tại!");
//            return false;
//        }
        if (!(age>18)) {
            System.out.println("aggg"+age);
            JOptionPane.showMessageDialog(this, "Nhân Viên Phải Đủ 18 Tuổi Trở Lên!");
            return false;
        }
        return true;
    }
    //xóa rôngr textfiled
    public void xoaRongTextNv(){
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtSDTNV.setText("");
        txtDiaChiNV.setText("");
        txtEmail.setText("");
         lblImgNv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/new-arrival.png"))); // NOI18N
              employeeImg = null;
        
    }
    //láy dữ liệu từ textfiled
    public NhanVien restText(){
        String maNv = txtMaNV.getText().toString();
        String tenNv = txtTenNV.getText().toString();
        String sdt = txtSDTNV.getText().toString();
        String diaChi = txtDiaChiNV.getText().toString();
        String ngaySinh = (String) formatter.format(dt_NgaySinh.getDate());
        String ngayLam = (String) formatter.format(dt_NgVaoLam.getDate());
        String tenCv = cbo_CV.getSelectedItem().toString();
        String trangThai="offline";
        ChucVu cv = cv_dao.getCVByTen(tenCv);
        String email= txtEmail.getText();
        NhanVien nv = new NhanVien(maNv, tenNv, sdt, diaChi, java.sql.Date.valueOf(ngaySinh), java.sql.Date.valueOf(ngayLam), trangThai,employeeImg, cv);
        nv.setEmail(email);
        return nv;

    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_tab_FormTTNhanVien = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblMaNCC1 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        lblTenNCC1 = new javax.swing.JLabel();
        txtDiaChiNV = new javax.swing.JTextField();
        lblSDT1 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        lblDiaChi1 = new javax.swing.JLabel();
        txtSDTNV = new javax.swing.JTextField();
        lblDiaChi2 = new javax.swing.JLabel();
        dt_NgaySinh = new com.toedter.calendar.JDateChooser();
        dt_NgVaoLam = new com.toedter.calendar.JDateChooser();
        lblDiaChi3 = new javax.swing.JLabel();
        lblDiaChi4 = new javax.swing.JLabel();
        cbo_CV = new javax.swing.JComboBox<>();
        jpImg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblImgNv = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_NV = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtSearch1 = new javax.swing.JTextField();
        btnTimKiem1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        btnShow1 = new javax.swing.JButton();
        btnLuu1 = new javax.swing.JButton();
        btnThem1 = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();

        pnl_tab_FormTTNhanVien.setBackground(new java.awt.Color(243, 244, 237));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblMaNCC1.setText("Mã Nhân Viên: ");

        txtTenNV.setForeground(new java.awt.Color(0, 0, 0));
        txtTenNV.setText("Nhập Tên....");
        txtTenNV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenNVFocusGained(evt);
            }
        });
        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        lblTenNCC1.setText("Tên Nhân Viên");

        txtDiaChiNV.setForeground(new java.awt.Color(0, 0, 0));
        txtDiaChiNV.setText("Nhập địa chỉ...");
        txtDiaChiNV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiaChiNVFocusGained(evt);
            }
        });
        txtDiaChiNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiNVActionPerformed(evt);
            }
        });

        lblSDT1.setText("SĐT:");

        txtMaNV.setForeground(new java.awt.Color(0, 0, 0));
        txtMaNV.setText("Mã Nhân Viên");
        txtMaNV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaNVFocusGained(evt);
            }
        });
        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        lblDiaChi1.setText("Địa chỉ:");

        txtSDTNV.setForeground(new java.awt.Color(0, 0, 0));
        txtSDTNV.setText("Nhập số điện thoại...");
        txtSDTNV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSDTNVFocusGained(evt);
            }
        });
        txtSDTNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTNVActionPerformed(evt);
            }
        });

        lblDiaChi2.setText("Ngày Sinh:");

        dt_NgaySinh.setDateFormatString("yyyy-MM-dd");

        dt_NgVaoLam.setDateFormatString("yyyy-MM-dd");

        lblDiaChi3.setText("Ngày Vào Làm:");

        lblDiaChi4.setText("Chức Vụ");

        cbo_CV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_CVActionPerformed(evt);
            }
        });

        jpImg.setBackground(new java.awt.Color(21, 151, 229));

        lblImgNv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/new-arrival.png"))); // NOI18N
        lblImgNv.setToolTipText("Ấn để tải ảnh");
        lblImgNv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImgNv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImgNvMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImgNv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImgNv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpImgLayout = new javax.swing.GroupLayout(jpImg);
        jpImg.setLayout(jpImgLayout);
        jpImgLayout.setHorizontalGroup(
            jpImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpImgLayout.setVerticalGroup(
            jpImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setText("Email");

        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setText("Nhập email...");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaNCC1)
                    .addComponent(lblTenNCC1)
                    .addComponent(lblSDT1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDTNV, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiaChi3)
                    .addComponent(lblDiaChi2)
                    .addComponent(lblDiaChi1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dt_NgVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDiaChi4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_CV, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jpImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbo_CV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDiaChi4))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(dt_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dt_NgVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblMaNCC1)
                                .addComponent(lblDiaChi1))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTenNCC1)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblSDT1)
                                .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDiaChi3)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tbl_NV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ", "Số Điện Thoại", "Địa Chỉ", "Ngày Sinh", "Ngày Vào Làm", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_NV.setRowHeight(25);
        tbl_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NVMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_NV);

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tác Vụ"));
        jPanel5.setForeground(java.awt.Color.white);

        txtSearch1.setForeground(new java.awt.Color(0, 0, 0));
        txtSearch1.setText("Nhập mã, tên, sđt....");
        txtSearch1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearch1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearch1FocusLost(evt);
            }
        });
        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });

        btnTimKiem1.setBackground(new java.awt.Color(21, 151, 229));
        btnTimKiem1.setForeground(java.awt.Color.white);
        btnTimKiem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search_1.png"))); // NOI18N
        btnTimKiem1.setText("Tìm kiếm");
        btnTimKiem1.setToolTipText("Nhập mã. tên NCC để tìm kiếm");
        btnTimKiem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiem1MouseClicked(evt);
            }
        });

        btnXoa1.setBackground(new java.awt.Color(255, 102, 102));
        btnXoa1.setForeground(java.awt.Color.white);
        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/close2.png"))); // NOI18N
        btnXoa1.setText("Xóa");
        btnXoa1.setToolTipText("Chọn 1 NCC để xóa");
        btnXoa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoa1MouseClicked(evt);
            }
        });

        btnShow1.setBackground(new java.awt.Color(21, 151, 229));
        btnShow1.setForeground(java.awt.Color.white);
        btnShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/clipboard.png"))); // NOI18N
        btnShow1.setText("Hiển thị DS");
        btnShow1.setToolTipText("Hiển thị lại DS NCC");
        btnShow1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShow1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShow1MouseClicked(evt);
            }
        });

        btnLuu1.setBackground(new java.awt.Color(21, 151, 229));
        btnLuu1.setForeground(java.awt.Color.white);
        btnLuu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/clipboard.png"))); // NOI18N
        btnLuu1.setText("Lưu");
        btnLuu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLuu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuu1MouseClicked(evt);
            }
        });

        btnThem1.setBackground(new java.awt.Color(21, 151, 229));
        btnThem1.setForeground(java.awt.Color.white);
        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/add.png"))); // NOI18N
        btnThem1.setText("Thêm");
        btnThem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThem1MouseClicked(evt);
            }
        });
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(21, 151, 229));
        btnCapNhat.setForeground(java.awt.Color.white);
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/system-update.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapNhatMouseClicked(evt);
            }
        });
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnShow1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuu1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCapNhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShow1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLuu1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_tab_FormTTNhanVienLayout = new javax.swing.GroupLayout(pnl_tab_FormTTNhanVien);
        pnl_tab_FormTTNhanVien.setLayout(pnl_tab_FormTTNhanVienLayout);
        pnl_tab_FormTTNhanVienLayout.setHorizontalGroup(
            pnl_tab_FormTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_FormTTNhanVienLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(pnl_tab_FormTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        pnl_tab_FormTTNhanVienLayout.setVerticalGroup(
            pnl_tab_FormTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormTTNhanVienLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1108, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_tab_FormTTNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_tab_FormTTNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenNVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenNVFocusGained
        // TODO add your handling code here:
        //   txtTenNCC.setText("");
    
    }//GEN-LAST:event_txtTenNVFocusGained

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void txtDiaChiNVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiNVFocusGained
        // txtDiaChiNCC.setText("");
       
    }//GEN-LAST:event_txtDiaChiNVFocusGained

    private void txtMaNVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNVFocusGained
        // TODO add your handling code here:
        ///txtMaNCC1.setTe txtMaNCC1.setForeground(new java.awt.Color(26, 25, 25));xt("");
      
    }//GEN-LAST:event_txtMaNVFocusGained

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void txtSDTNVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTNVFocusGained
        //txtSDTNCC2.setText("");
      
    }//GEN-LAST:event_txtSDTNVFocusGained

    private void txtSDTNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTNVActionPerformed

    private void cbo_CVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_CVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_CVActionPerformed

    private void txtSearch1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch1FocusGained
        txtSearch1.setText("");
    }//GEN-LAST:event_txtSearch1FocusGained

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed
        xoaModelNV();
        xoaRongTextNv();
        String text = txtSearch1.getText().trim().toLowerCase();
        List<NhanVien> list = nv_dao.SearchMaOrTenOrSdt(text);
        for (NhanVien nv : list) {
                dfNV_Model.addRow(new Object[]{
                nv.getMaNV(), nv.getTenNV(),nv.getChucVu().getTenCV(), nv.getSdt(),
                nv.getDiaChi(),nv.getNgaySinh(),nv.getNgayVaoLam(),nv.getTrangThai()
            });
        }
    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void btnTimKiem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiem1MouseClicked
        xoaModelNV();
        xoaRongTextNv();
        String text = txtSearch1.getText().trim().toLowerCase();
        List<NhanVien> list = nv_dao.SearchMaOrTenOrSdt(text);
        System.out.println("Gui.FrmDsNV.btnTimKiem1MouseClicked()"+list);
        for (NhanVien nv : list) {
                dfNV_Model.addRow(new Object[]{
                nv.getMaNV(), nv.getTenNV(),nv.getChucVu().getTenCV(), nv.getSdt(),
                nv.getDiaChi(),nv.getNgaySinh(),nv.getNgayVaoLam(),nv.getEmail()
            });
        }
    }//GEN-LAST:event_btnTimKiem1MouseClicked

    private void btnXoa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoa1MouseClicked
        int r = tbl_NV.getSelectedRow();
         String id = dfNV_Model.getValueAt(r, 0).toString();
         if (r != -1) {
            int tb = JOptionPane.showConfirmDialog(null, "Bạn  chắc chắn muốn xóa Nhân Viên này không?", "Detele", JOptionPane.YES_NO_OPTION);
            if (tb == JOptionPane.YES_OPTION) {
                dfNV_Model.removeRow(r);
                nv_dao.xoaNV(id);
                dsNv.removeAll(dsNv);
                xoaRongTextNv();
                xoaModelNV();
                upTblNV();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
        }
    }//GEN-LAST:event_btnXoa1MouseClicked

    private void btnShow1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShow1MouseClicked
        dsNv.removeAll(dsNv);
        xoaModelNV();
        upTblNV();
    }//GEN-LAST:event_btnShow1MouseClicked

    private void btnLuu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuu1MouseClicked
        if(kiemTraData()){
            NhanVien nv = restText();
            System.out.println("Gui.FrmDsNV.btnLuu1MouseClicked()"+nv);
            if(nv_dao.themNV(nv)){
                dfNV_Model.addRow(new Object[]{
                nv.getMaNV(), nv.getTenNV(),nv.getChucVu().getTenCV(), nv.getSdt(),
                nv.getDiaChi(),nv.getNgaySinh(),nv.getNgayVaoLam(),nv.getTrangThai()
                });
                dsNv.removeAll(dsNv);
                xoaRongTextNv();
                xoaModelNV();
                upTblNV();
                 JOptionPane.showMessageDialog(null, "Thêm thành công");
            }
        }
        
    }//GEN-LAST:event_btnLuu1MouseClicked

    private void btnThem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThem1MouseClicked
        xoaRongTextNv();
        txtTenNV.requestFocus();
    }//GEN-LAST:event_btnThem1MouseClicked

    private void tbl_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NVMouseClicked
         int r = tbl_NV.getSelectedRow();
         txtMaNV.setText(dfNV_Model.getValueAt(r, 0).toString());
         txtTenNV.setText(dfNV_Model.getValueAt(r, 1).toString());
         txtSDTNV.setText(dfNV_Model.getValueAt(r, 3).toString());
         cbo_CV.setSelectedItem(dfNV_Model.getValueAt(r, 2).toString());
         txtDiaChiNV.setText(dfNV_Model.getValueAt(r, 4).toString());
           txtEmail.setText(dfNV_Model.getValueAt(r, 7).toString());
         try {
            Date ngaySinh=new SimpleDateFormat("yyyy-MM-dd").parse(dfNV_Model.getValueAt(r, 5).toString() );
            // System.out.println("ngay sinh "+ngaySinh);
            Date ngayLam= new SimpleDateFormat("yyyy-MM-dd").parse(dfNV_Model.getValueAt(r, 6).toString() );
            
            dt_NgVaoLam.setDate(ngayLam);
            dt_NgaySinh.setDate(ngaySinh);
         } catch (Exception e) {
             e.printStackTrace();
        }
         
         //load img khi click
        if(dsNv.get(r).getImg() != null){
             try {
                 
                 Image img = ImageHelper.createImgFromByArray(dsNv.get(r).getImg(), "jpg");
                 lblImgNv.setIcon(new ImageIcon(img));
                 employeeImg = dsNv.get(r).getImg();
             } catch (IOException ex) {
                 Logger.getLogger(FrmDsNV.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        else{
             lblImgNv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/new-arrival.png"))); // NOI18N
              employeeImg = dsNv.get(r).getImg();
        }
         
         
    }//GEN-LAST:event_tbl_NVMouseClicked

    private void txtSearch1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch1FocusLost
        txtSearch1.setText("");
    }//GEN-LAST:event_txtSearch1FocusLost

    private void lblImgNvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImgNvMouseClicked
         JFileChooser choose =new JFileChooser();
        choose.setFileFilter(new FileFilter(){
            @Override
            public boolean accept(File f) {
               if(f.isDirectory()){
                   return true;
               }
               else{
                   return f.getName().toLowerCase().endsWith(".jpg");
               }
            }

            @Override
            public String getDescription() {
                return "Image File(*.jpg)";
            }
        });
        if(choose.showOpenDialog(jpImg) == JFileChooser.CANCEL_OPTION){
            return;
        }
        
        File file = choose.getSelectedFile();
        try {
            ImageIcon icons = new ImageIcon(file.getPath());
            Image img = ImageHelper.resize(icons.getImage(), 129, 140);
            ImageIcon resizeIcon = new ImageIcon(img);
            lblImgNv.setIcon(resizeIcon);
            employeeImg = ImageHelper.toByteArr(img, "jpg");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(choose, "Chức năng đang lỗi");
        }
    }//GEN-LAST:event_lblImgNvMouseClicked

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhatMouseClicked

    //cap nhat nhan vien
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        //System.out.println("Gui.FrmDsNV.btnCapNhatActionPerformed()" + "chu zo");
       
        if(kiemTraData()){
               int tb = JOptionPane.showConfirmDialog(null, "Bạn  chắc chắn muốn cập nhật Nhân Viên này không?", "Cập nhật nhân viên", JOptionPane.YES_NO_OPTION);
            if (tb == JOptionPane.YES_OPTION) {
                 NhanVien nv = restText();
            if(nv_dao.updateNV(nv.getMaNV(), nv)){
                dfNV_Model.addRow(new Object[]{
                nv.getMaNV(), nv.getTenNV(),nv.getChucVu().getTenCV(), nv.getSdt(),
                nv.getDiaChi(),nv.getNgaySinh(),nv.getNgayVaoLam(),nv.getEmail()
                });
                dsNv.removeAll(dsNv);
                xoaRongTextNv();
                xoaModelNV();
                upTblNV();
                 JOptionPane.showMessageDialog(null, "Thêm thành công");
            }
            }
           
        }
        
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void txtDiaChiNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiNVActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

     private byte[] employeeImg;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu1;
    private javax.swing.JButton btnShow1;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnTimKiem1;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JComboBox<String> cbo_CV;
    private com.toedter.calendar.JDateChooser dt_NgVaoLam;
    private com.toedter.calendar.JDateChooser dt_NgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpImg;
    private javax.swing.JLabel lblDiaChi1;
    private javax.swing.JLabel lblDiaChi2;
    private javax.swing.JLabel lblDiaChi3;
    private javax.swing.JLabel lblDiaChi4;
    private javax.swing.JLabel lblImgNv;
    private javax.swing.JLabel lblMaNCC1;
    private javax.swing.JLabel lblSDT1;
    private javax.swing.JLabel lblTenNCC1;
    private javax.swing.JPanel pnl_tab_FormTTNhanVien;
    private javax.swing.JTable tbl_NV;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
