/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Connect.connect;
import dao.CaLamDao;
import dao.ChucVuDao;
import dao.LuongDao;
import dao.NhanVienDao;
import entity.CaLam;
import entity.ChucVu;
import entity.Luong;
import entity.NhanVien;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class FrmNhanVien extends javax.swing.JPanel {
    public  Border default_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,153,153));
   public Border active_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,204,255));
   public JButton [] buttons;
   private DefaultTableModel dfCL_Model;
   private DefaultTableModel dfNV2_Model;
   private DefaultTableModel dfLuong_Model;
   ArrayList<CaLam> dsCa;
   ArrayList<NhanVien> dsNv;
    ArrayList<Luong> dsLuong;
    ArrayList<ChucVu> dsCv;
    CaLamDao ca_dao;
    NhanVienDao nv_dao;
    LuongDao l_dao;
    ChucVuDao cv_dao;

    /**
     * Creates new form FrmNhanVien
     */
    public FrmNhanVien() {
        initComponents();
        addBorder();
        dsCa = new ArrayList<CaLam>();
        ca_dao = new CaLamDao();
        nv_dao = new NhanVienDao();
        dsNv = new ArrayList<NhanVien>();
        dsLuong = new ArrayList<Luong>();
        dsCv = new ArrayList<ChucVu>();
        cv_dao = new ChucVuDao();
        l_dao = new LuongDao();
        upTblCaLam();
        upTblNV2();
        upCbo_NV();
        upTblLuong();
        upCbo_CV();
//        LuongNhanVien();
        
        txt_MaCa.setEnabled(false);
//        upCbo_Buoi();

    }
    //tìm tên chúc vụ trong bảng lương
    public  void TKCV(){
        l_dao = new LuongDao();
        String ten = cbo_TkCv_Luong.getSelectedItem().toString();
       
        if(ten.equals("Tất Cả")){
            dsLuong.removeAll(dsLuong);
            xoaModelLuong();
            upTblLuong();
        }else{
            ArrayList<Luong> list = l_dao.searchTenCV(ten);
        
        if(!list.isEmpty()){
            for (Luong luong : list) {
                dfLuong_Model.addRow(new Object[]{
                    luong.getMaNV().getMaNV(),luong.getMaNV().getTenNV(),luong.getMaCV().getTenCV(),
                    luong.getMaCV().getHsLuong(),luong.getSoCa(),luong.getLuong()
                });
            }
//            JOptionPane.showMessageDialog(this, "Đã tìm thấy ");
        }else{
            JOptionPane.showMessageDialog(this, " Khống có chức vụ nào ");
        }
        }
    }
    //doc du lieu len cbo chuc vu
    public  void upCbo_CV(){
        dsCv = cv_dao.getAllCV();
        for (ChucVu cv : dsCv) {
            cbo_TkCv_Luong.addItem(cv.getTenCV());
        }
    }
    //Hiển thị lương nhan viên lên bảng
    public void upTblLuong() {
        dfLuong_Model = (DefaultTableModel) tbl_Luong.getModel();
        dsLuong = l_dao.getAllLuong();
        for (Luong luong : dsLuong) {
            dfLuong_Model.addRow(new Object[]{
                luong.getMaNV().getMaNV(),luong.getMaNV().getTenNV(),luong.getMaCV().getTenCV(),
                luong.getMaCV().getHsLuong(),luong.getSoCa(),luong.getLuong()
            });
        }

    }
    //xóa model luong
    public void xoaModelLuong(){
        DefaultTableModel del = (DefaultTableModel) tbl_Luong.getModel();
        del.getDataVector().removeAllElements();
    }
    //xóa model ca làm
    public void xoaModelCa(){
        DefaultTableModel del = (DefaultTableModel) tbl_CaLam.getModel();
        del.getDataVector().removeAllElements();
    }
    //láy dữ liệu từ textfield
    public CaLam restText(){
        String maCa = txt_MaCa.getText().toString();
        String maNv = cbo_MaNv.getSelectedItem().toString();
        String buoi = cbo_Buoi.getSelectedItem().toString();
        NhanVien nv = nv_dao.getNVByMaNV(maNv);
        
        return new CaLam(maCa, nv, buoi);
    }
   
    //xoá rổng textfield ca làm
    public void xoaRongTextCa(){
        txt_MaCa.setText("");
        
    }
    
    //đọc dữ liệu lên bảg nhân viên 2
    public void upTblNV2(){
        dfNV2_Model = (DefaultTableModel) tbl_NV_2.getModel();
        dsNv = nv_dao.getAllNV();
        for (NhanVien nv : dsNv){
            dfNV2_Model.addRow(new Object[]{
                nv.getMaNV(),nv.getTenNV(),nv.getChucVu().getTenCV()
            });
        }
    }
    //đọc dữ liệu lên bảng ca làm
    public void upTblCaLam(){
        dfCL_Model = (DefaultTableModel) tbl_CaLam.getModel();
        dsCa = ca_dao.getAllCaLam();
        for (CaLam ca : dsCa) {
            dfCL_Model.addRow(new Object[]{
                ca.getMaCa(),ca.getNV().getMaNV(),ca.getNV().getTenNV(),ca.getBuoi()
            });
        }
        
    }
    //dọc dữ liêu lên cbo nhân vien
    public  void upCbo_NV(){
        
        for (NhanVien nv : dsNv) {
            cbo_MaNv.addItem(nv.getMaNV());
        }
    }
    
    public void addBorder(){
        buttons = new JButton[3];
        
          buttons[0] =btn_tab_NV;
        buttons[1] =btn_tab_CaLam;
        buttons[2] = btn_tab_Luong;
        
        
        setButtonBorder(btn_tab_NV);
        
   
        

        addAction();
    }
        //set border active
    public void setButtonBorder(JButton button){
//        for (JButton btn : buttons) {
//            btn.setBorder(default_border);
//            btn.setForeground(new Color(153,153,153));
//        }
        button.setBorder(active_border);
        button.setForeground(Color.black);
    }
    //add even
    public void addAction(){
        for (JButton button : buttons) {
            button.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (JButton btn : buttons) {
            btn.setBorder(default_border);
            btn.setForeground(new Color(153,153,153));
        }
        button.setBorder(active_border);
        button.setForeground(Color.black);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                   
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    
                }
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_FormNhanVien = new javax.swing.JPanel();
        lbl_text_NhanVien = new javax.swing.JLabel();
        pnl_menuTab_NhanVien = new javax.swing.JPanel();
        btn_tab_NV = new javax.swing.JButton();
        btn_tab_CaLam = new javax.swing.JButton();
        btn_tab_Luong = new javax.swing.JButton();
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
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_NV = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtSearch1 = new javax.swing.JTextField();
        btnTimKiem1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        btnCapNhat1 = new javax.swing.JButton();
        btnShow1 = new javax.swing.JButton();
        btnLuu1 = new javax.swing.JButton();
        btnThem1 = new javax.swing.JButton();
        pnl_tab_FormCaLam = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_CaLam = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_ThemCa = new javax.swing.JButton();
        btn_LuuCa = new javax.swing.JButton();
        btn_SuaCa = new javax.swing.JButton();
        btn_XoaCa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_NV_2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        lbl_MaCa = new javax.swing.JLabel();
        txt_MaCa = new javax.swing.JTextField();
        lbl_MauSac1 = new javax.swing.JLabel();
        cbo_MaNv = new javax.swing.JComboBox<>();
        lbl_DanhMuc = new javax.swing.JLabel();
        cbo_Buoi = new javax.swing.JComboBox<>();
        pnl_tab_FormLuong = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Luong = new javax.swing.JTable();
        btn_TinhLuong = new javax.swing.JButton();
        btn_CapNhat_Luong = new javax.swing.JToggleButton();
        jPanel7 = new javax.swing.JPanel();
        cbo_TkCv_Luong = new javax.swing.JComboBox<>();
        dt_From = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dt_To = new com.toedter.calendar.JDateChooser();
        btnTkLuong = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        pnl_FormNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        pnl_FormNhanVien.setMinimumSize(new java.awt.Dimension(1090, 700));
        pnl_FormNhanVien.setPreferredSize(new java.awt.Dimension(1090, 700));
        pnl_FormNhanVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_NhanVien.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_NhanVien.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_NhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_NhanVien.setText("Nhân Viên");
        pnl_FormNhanVien.add(lbl_text_NhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_menuTab_NhanVien.setBackground(new java.awt.Color(255, 255, 255));

        btn_tab_NV.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_NV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_NV.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_NV.setText("Thông Tin Nhân Viên");
        btn_tab_NV.setBorder(null);
        btn_tab_NV.setContentAreaFilled(false);
        btn_tab_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_NVMouseClicked(evt);
            }
        });
        btn_tab_NV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_NVActionPerformed(evt);
            }
        });

        btn_tab_CaLam.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_CaLam.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_CaLam.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_CaLam.setText("Ca Làm");
        btn_tab_CaLam.setBorder(null);
        btn_tab_CaLam.setContentAreaFilled(false);
        btn_tab_CaLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_CaLamMouseClicked(evt);
            }
        });

        btn_tab_Luong.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_Luong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_Luong.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_Luong.setText("Lương");
        btn_tab_Luong.setBorder(null);
        btn_tab_Luong.setContentAreaFilled(false);
        btn_tab_Luong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_LuongMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_NhanVienLayout = new javax.swing.GroupLayout(pnl_menuTab_NhanVien);
        pnl_menuTab_NhanVien.setLayout(pnl_menuTab_NhanVienLayout);
        pnl_menuTab_NhanVienLayout.setHorizontalGroup(
            pnl_menuTab_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_NhanVienLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_NV)
                .addGap(58, 58, 58)
                .addComponent(btn_tab_CaLam)
                .addGap(65, 65, 65)
                .addComponent(btn_tab_Luong)
                .addContainerGap(664, Short.MAX_VALUE))
        );
        pnl_menuTab_NhanVienLayout.setVerticalGroup(
            pnl_menuTab_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_tab_CaLam, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(btn_tab_Luong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_tab_NV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_FormNhanVien.add(pnl_menuTab_NhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 50));

        pnl_tab_FormTTNhanVien.setBackground(new java.awt.Color(243, 244, 237));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblMaNCC1.setText("Mã Nhân Viên: ");

        txtTenNV.setForeground(new java.awt.Color(173, 194, 169));
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

        txtDiaChiNV.setForeground(new java.awt.Color(173, 194, 169));
        txtDiaChiNV.setText("Nhập địa chỉ...");
        txtDiaChiNV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiaChiNVFocusGained(evt);
            }
        });

        lblSDT1.setText("SĐT:");

        txtMaNV.setForeground(new java.awt.Color(173, 194, 169));
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

        txtSDTNV.setForeground(new java.awt.Color(173, 194, 169));
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

        lblDiaChi3.setText("Ngày Vào Làm:");

        lblDiaChi4.setText("Chức Vụ");

        cbo_CV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_CVActionPerformed(evt);
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenNV)
                    .addComponent(txtMaNV)
                    .addComponent(txtSDTNV, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblDiaChi1)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDiaChi2)
                            .addComponent(lblDiaChi3))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dt_NgVaoLam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDiaChiNV, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(dt_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(lblDiaChi4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_CV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiaChi1)
                            .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiaChi4)
                            .addComponent(cbo_CV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(dt_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dt_NgVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lblDiaChi3))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaNCC1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenNCC1)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiaChi2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSDT1)
                            .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tbl_NV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ", "Số Điện Thoại", "Địa Chỉ", "Ngày Sinh", "Ngày Vào Làm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_NV.setRowHeight(25);
        jScrollPane4.setViewportView(tbl_NV);

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tác Vụ"));
        jPanel5.setForeground(java.awt.Color.white);

        txtSearch1.setForeground(new java.awt.Color(173, 194, 169));
        txtSearch1.setText("Nhập mã, tên, sđt....");
        txtSearch1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearch1FocusGained(evt);
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
        btnTimKiem1.setEnabled(false);
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

        btnCapNhat1.setBackground(new java.awt.Color(21, 151, 229));
        btnCapNhat1.setForeground(java.awt.Color.white);
        btnCapNhat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/system-update.png"))); // NOI18N
        btnCapNhat1.setText("Cập nhật");
        btnCapNhat1.setToolTipText("Chọn 1 NCC để cập nhập");
        btnCapNhat1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapNhat1MouseClicked(evt);
            }
        });

        btnShow1.setBackground(new java.awt.Color(21, 151, 229));
        btnShow1.setForeground(java.awt.Color.white);
        btnShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/clipboard.png"))); // NOI18N
        btnShow1.setText("Hiển thị DS");
        btnShow1.setToolTipText("Hiển thị lại DS NCC");
        btnShow1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShow1.setEnabled(false);
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
        btnLuu1.setEnabled(false);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuu1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShow1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnTimKiem1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhat1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLuu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_tab_FormTTNhanVienLayout = new javax.swing.GroupLayout(pnl_tab_FormTTNhanVien);
        pnl_tab_FormTTNhanVien.setLayout(pnl_tab_FormTTNhanVienLayout);
        pnl_tab_FormTTNhanVienLayout.setHorizontalGroup(
            pnl_tab_FormTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_FormTTNhanVienLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(pnl_tab_FormTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                    .addGroup(pnl_tab_FormTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

        pnl_FormNhanVien.add(pnl_tab_FormTTNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1090, 620));

        pnl_tab_FormCaLam.setBackground(new java.awt.Color(243, 244, 237));

        tbl_CaLam.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tbl_CaLam.setForeground(new java.awt.Color(0, 0, 0));
        tbl_CaLam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Ca Làm", "Mã Nhân Viên", "Tên Nhân Viên", "Buổi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_CaLam.setRowHeight(35);
        tbl_CaLam.setSelectionBackground(new java.awt.Color(102, 153, 255));
        tbl_CaLam.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_CaLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CaLamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_CaLam);
        if (tbl_CaLam.getColumnModel().getColumnCount() > 0) {
            tbl_CaLam.getColumnModel().getColumn(3).setMaxWidth(100);
            tbl_CaLam.getColumnModel().getColumn(3).setHeaderValue("Buổi");
        }

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 51), null), "Tác Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        btn_ThemCa.setBackground(new java.awt.Color(21, 151, 229));
        btn_ThemCa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_ThemCa.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThemCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/plus (2).png"))); // NOI18N
        btn_ThemCa.setText("Thêm ");
        btn_ThemCa.setBorder(null);
        btn_ThemCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ThemCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemCaMouseClicked(evt);
            }
        });

        btn_LuuCa.setBackground(new java.awt.Color(21, 151, 229));
        btn_LuuCa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_LuuCa.setForeground(new java.awt.Color(255, 255, 255));
        btn_LuuCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/clipboard.png"))); // NOI18N
        btn_LuuCa.setText("Lưu ");
        btn_LuuCa.setBorder(null);
        btn_LuuCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LuuCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LuuCaMouseClicked(evt);
            }
        });
        btn_LuuCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuCaActionPerformed(evt);
            }
        });

        btn_SuaCa.setBackground(new java.awt.Color(21, 151, 229));
        btn_SuaCa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_SuaCa.setForeground(new java.awt.Color(255, 255, 255));
        btn_SuaCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/system-update.png"))); // NOI18N
        btn_SuaCa.setText("Cập Nhật");
        btn_SuaCa.setBorder(null);
        btn_SuaCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SuaCa.setEnabled(false);
        btn_SuaCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SuaCaMouseClicked(evt);
            }
        });
        btn_SuaCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaCaActionPerformed(evt);
            }
        });

        btn_XoaCa.setBackground(new java.awt.Color(255, 102, 102));
        btn_XoaCa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_XoaCa.setForeground(new java.awt.Color(255, 255, 255));
        btn_XoaCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/close (1).png"))); // NOI18N
        btn_XoaCa.setText("Xóa");
        btn_XoaCa.setBorder(null);
        btn_XoaCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_XoaCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaCaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ThemCa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btn_LuuCa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btn_SuaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btn_XoaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThemCa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_SuaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_LuuCa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_XoaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        tbl_NV_2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tbl_NV_2.setForeground(new java.awt.Color(0, 0, 0));
        tbl_NV_2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Tên Chức Vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_NV_2.setRowHeight(35);
        tbl_NV_2.setSelectionBackground(new java.awt.Color(102, 153, 255));
        tbl_NV_2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_NV_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NV_2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_NV_2);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        lbl_MaCa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MaCa.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MaCa.setText("Mã Ca Làm");

        txt_MaCa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_MaCa.setForeground(new java.awt.Color(0, 0, 0));
        txt_MaCa.setToolTipText("");

        lbl_MauSac1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MauSac1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MauSac1.setText("Mã Nhân Viên");

        cbo_MaNv.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_MaNv.setForeground(new java.awt.Color(0, 0, 0));

        lbl_DanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_DanhMuc.setForeground(new java.awt.Color(0, 0, 0));
        lbl_DanhMuc.setText("Buổi");

        cbo_Buoi.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_Buoi.setForeground(new java.awt.Color(0, 0, 0));
        cbo_Buoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sáng", "Chiều", "Tối" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbl_DanhMuc)
                        .addGap(101, 101, 101)
                        .addComponent(cbo_Buoi, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbl_MaCa)
                        .addGap(56, 56, 56)
                        .addComponent(txt_MaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addComponent(lbl_MauSac1)
                .addGap(34, 34, 34)
                .addComponent(cbo_MaNv, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_MaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_MaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_MauSac1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_MaNv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbl_DanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbo_Buoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pnl_tab_FormCaLamLayout = new javax.swing.GroupLayout(pnl_tab_FormCaLam);
        pnl_tab_FormCaLam.setLayout(pnl_tab_FormCaLamLayout);
        pnl_tab_FormCaLamLayout.setHorizontalGroup(
            pnl_tab_FormCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnl_tab_FormCaLamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(pnl_tab_FormCaLamLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(pnl_tab_FormCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnl_tab_FormCaLamLayout.setVerticalGroup(
            pnl_tab_FormCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormCaLamLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(pnl_tab_FormCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_FormNhanVien.add(pnl_tab_FormCaLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1090, 620));

        pnl_tab_FormLuong.setBackground(new java.awt.Color(243, 244, 237));

        tbl_Luong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ", "Hệ Số Lương", "Số Ca", "Lương"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_Luong.setRowHeight(35);
        tbl_Luong.setSelectionBackground(new java.awt.Color(102, 153, 255));
        tbl_Luong.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_Luong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_LuongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_Luong);

        btn_TinhLuong.setBackground(new java.awt.Color(21, 151, 229));
        btn_TinhLuong.setForeground(java.awt.Color.white);
        btn_TinhLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/salary.png"))); // NOI18N
        btn_TinhLuong.setText("Tính Lương");
        btn_TinhLuong.setToolTipText("");
        btn_TinhLuong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_TinhLuong.setEnabled(false);
        btn_TinhLuong.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_TinhLuongMouseDragged(evt);
            }
        });
        btn_TinhLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TinhLuongMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_TinhLuongMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_TinhLuongMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_TinhLuongMousePressed(evt);
            }
        });
        btn_TinhLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TinhLuongActionPerformed(evt);
            }
        });

        btn_CapNhat_Luong.setBackground(new java.awt.Color(21, 151, 229));
        btn_CapNhat_Luong.setForeground(java.awt.Color.white);
        btn_CapNhat_Luong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/system-update.png"))); // NOI18N
        btn_CapNhat_Luong.setText("Cập nhật");
        btn_CapNhat_Luong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CapNhat_Luong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CapNhat_LuongMouseClicked(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jPanel7.setForeground(new java.awt.Color(204, 204, 204));

        cbo_TkCv_Luong.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_TkCv_Luong.setForeground(new java.awt.Color(0, 0, 0));
        cbo_TkCv_Luong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả" }));
        cbo_TkCv_Luong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_TkCv_LuongItemStateChanged(evt);
            }
        });
        cbo_TkCv_Luong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_TkCv_LuongMouseClicked(evt);
            }
        });
        cbo_TkCv_Luong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_TkCv_LuongActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Từ Ngày:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Từ Ngày:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cbo_TkCv_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(dt_From, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dt_To, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbo_TkCv_Luong, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt_From, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt_To, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        btnTkLuong.setBackground(new java.awt.Color(21, 151, 229));
        btnTkLuong.setForeground(java.awt.Color.white);
        btnTkLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search_1.png"))); // NOI18N
        btnTkLuong.setText("Tìm kiếm");
        btnTkLuong.setToolTipText("Nhập mã. tên NCC để tìm kiếm");
        btnTkLuong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTkLuong.setEnabled(false);
        btnTkLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTkLuongMouseClicked(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(21, 151, 229));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/history.png"))); // NOI18N
        jToggleButton1.setToolTipText("Chọn Để Xem Lịch Sử Nhân Viên Nhận Lương");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_tab_FormLuongLayout = new javax.swing.GroupLayout(pnl_tab_FormLuong);
        pnl_tab_FormLuong.setLayout(pnl_tab_FormLuongLayout);
        pnl_tab_FormLuongLayout.setHorizontalGroup(
            pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormLuongLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnl_tab_FormLuongLayout.createSequentialGroup()
                            .addComponent(btnTkLuong)
                            .addGap(18, 18, 18)
                            .addComponent(btn_CapNhat_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_TinhLuong)
                            .addGap(26, 26, 26)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        pnl_tab_FormLuongLayout.setVerticalGroup(
            pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_FormLuongLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_TinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_CapNhat_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTkLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pnl_FormNhanVien.add(pnl_tab_FormLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1090, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tab_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_NVMouseClicked
        // TODO add your handling code here:
        pnl_tab_FormTTNhanVien.setVisible(true);
        pnl_tab_FormCaLam.setVisible(false);
        pnl_tab_FormLuong.setVisible(false);
        
    }//GEN-LAST:event_btn_tab_NVMouseClicked

    private void btn_tab_NVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_NVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_NVActionPerformed

    private void btn_tab_CaLamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_CaLamMouseClicked
        // TODO add your handling code here:
        pnl_tab_FormTTNhanVien.setVisible(false);
        pnl_tab_FormCaLam.setVisible(true);
        pnl_tab_FormLuong.setVisible(false);
        
    }//GEN-LAST:event_btn_tab_CaLamMouseClicked

    private void btn_tab_LuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_LuongMouseClicked
        // TODO add your handling code here:
        pnl_tab_FormTTNhanVien.setVisible(false);
        pnl_tab_FormCaLam.setVisible(false);
        pnl_tab_FormLuong.setVisible(true);
        
    }//GEN-LAST:event_btn_tab_LuongMouseClicked

    private void btn_ThemCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemCaMouseClicked
        xoaRongTextCa();
//        btn_SuaAnh.setEnabled(true);
    }//GEN-LAST:event_btn_ThemCaMouseClicked

    private void btn_LuuCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LuuCaMouseClicked
        CaLam ca = restText();
        if(ca_dao.themCa(ca)){
            dfCL_Model.addRow(new Object[]{
                ca.getMaCa(),ca.getNV().getMaNV(),ca.getNV().getTenNV(),ca.getBuoi()
            });
            dsCa.removeAll(dsCa);
            xoaRongTextCa();
            xoaModelCa();
            upTblCaLam();
            xoaModelLuong();
            upTblLuong();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        }else{
            JOptionPane.showMessageDialog(null, " đã có vui lòng nhập lại ");
        }
        
    }//GEN-LAST:event_btn_LuuCaMouseClicked

    private void btn_LuuCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LuuCaActionPerformed

    private void btn_SuaCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SuaCaMouseClicked
//        int r = tbl_Sp.getSelectedRow();
//        btn_SuaAnh.setEnabled(true);
//        if (r != -1) {
//            btn_SuaAnh.setVisible(true);
//            String maSP = dfSP_Model.getValueAt(r, 0).toString();
//            System.out.println(maSP);
//            String tenSP = txt_TenSp.getText().trim();
//            String tenDm = cbo_Dm.getSelectedItem().toString();
//            String mau = txt_MauSac.getText().trim();
//            String hinh = lbl_HinhAnh.getIcon().toString();
//            //System.out.println(hinh);
//            String size = txt_Size.getText().trim();
//            int sl = Integer.parseInt(txt_SlKho.getText().trim());
//            double dg = Double.parseDouble(txt_DonGia.getText().trim());
//            DanhMucSP dm = dm_dao.getDMByTen(tenDm);
//            SanPham sp = new SanPham(dm, maSP, tenSP, dg, sl, hinh, size, mau);
//            //System.out.println(sp.toString());
//            if (sp_dao.updateSP(maSP, sp)) {
//                xoaRongTextSp();
//                dfSP_Model.setRowCount(0);
//                dsSP = sp_dao.getAllSP();
//                for (SanPham it : dsSP) {
//                    dfSP_Model.addRow(new Object[]{
//                        it.getMaSP(), it.getTenSP(), it.getDmsp().getTenLoai(),
//                        it.getMauSac(), it.getSize(), it.getSoLuong(),
//                        it.getDonGia(), it.getHinhAnh()
//                    });
//                }
//                dsSP.removeAll(dsSP);
//                xoaRongTextSp();
//                xoaModelSP();
//                upTblSP();
//                xoaModelTksp();
//                upTblTkSP();
//                upCbo_DM();
//                JOptionPane.showMessageDialog(this, "Cập nhật danh sách thành công");
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng nào!");
//        }
    }//GEN-LAST:event_btn_SuaCaMouseClicked

    private void btn_XoaCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaCaMouseClicked
        int r = tbl_CaLam.getSelectedRow();
        String id = dfCL_Model.getValueAt(r, 0).toString();
        if (r != -1) {
            int tb = JOptionPane.showConfirmDialog(null, "Bạn  chắc chắn muốn xóa dòng này không?", "Detele", JOptionPane.YES_NO_OPTION);
            if (tb == JOptionPane.YES_OPTION) {
                dfCL_Model.removeRow(r);
                ca_dao.xoaCa(id);
                dsCa.removeAll(dsCa);
                xoaRongTextCa();
                xoaModelCa();
                upTblCaLam();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
        }
        
    }//GEN-LAST:event_btn_XoaCaMouseClicked

    private void tbl_CaLamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CaLamMouseClicked
        int r = tbl_CaLam.getSelectedRow();
        btn_SuaCa.setEnabled(true);
        txt_MaCa.setText(dfCL_Model.getValueAt(r, 0).toString());
        cbo_MaNv.setSelectedItem(dfCL_Model.getValueAt(r, 1).toString());
        cbo_Buoi.setSelectedItem(dfCL_Model.getValueAt(r, 3));
        
    }//GEN-LAST:event_tbl_CaLamMouseClicked

    private void tbl_NV_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NV_2MouseClicked
        int r = tbl_NV_2.getSelectedRow();
        cbo_MaNv.setSelectedItem(dfNV2_Model.getValueAt(r, 0).toString());
    }//GEN-LAST:event_tbl_NV_2MouseClicked

    private void btn_TinhLuongMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TinhLuongMouseDragged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btn_TinhLuongMouseDragged

    private void btn_TinhLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TinhLuongMouseClicked
       int r = tbl_Luong.getSelectedRow();
        String id = dfLuong_Model.getValueAt(r, 0).toString();
        if (r != -1) {
                dfLuong_Model.removeRow(r);
                l_dao.tinhLuong(id);
                  dsCa.removeAll(dsCa);
                  xoaModelCa();
                  upTblCaLam();
//                xoaModelCa();
//                upTblCaLam();
//                dsCa.removeAll(dsCa);
//                xoaRongTextCa();
//                xoaModelCa();
//                upTblCaLam();
                JOptionPane.showMessageDialog(null, "Nhân viên "+id+" đã nhận lương");
        } else {
            //JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
        }
    }//GEN-LAST:event_btn_TinhLuongMouseClicked

    private void btn_TinhLuongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TinhLuongMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TinhLuongMouseEntered

    private void btn_TinhLuongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TinhLuongMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_TinhLuongMouseExited

    private void btn_TinhLuongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TinhLuongMousePressed
        // TODO add your handling code here:

       
    }//GEN-LAST:event_btn_TinhLuongMousePressed

    private void btn_TinhLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TinhLuongActionPerformed
        
    }//GEN-LAST:event_btn_TinhLuongActionPerformed

    private void cbo_TkCv_LuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_TkCv_LuongActionPerformed
        
    }//GEN-LAST:event_cbo_TkCv_LuongActionPerformed

    private void cbo_TkCv_LuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_TkCv_LuongMouseClicked
        
    }//GEN-LAST:event_cbo_TkCv_LuongMouseClicked

    private void cbo_TkCv_LuongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_TkCv_LuongItemStateChanged
         if (evt.getStateChange() == ItemEvent.SELECTED) {
             dfLuong_Model.setRowCount(0);
                  TKCV();
         }
    }//GEN-LAST:event_cbo_TkCv_LuongItemStateChanged

    private void btn_CapNhat_LuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CapNhat_LuongMouseClicked
        dsLuong.removeAll(dsLuong);
        xoaModelLuong();
        upTblLuong();
    }//GEN-LAST:event_btn_CapNhat_LuongMouseClicked

    private void tbl_LuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_LuongMouseClicked
        btn_TinhLuong.setEnabled(true);
    }//GEN-LAST:event_tbl_LuongMouseClicked

    private void txtTenNVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenNVFocusGained
        // TODO add your handling code here:
        //   txtTenNCC.setText("");
        txtTenKH.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtTenNVFocusGained

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void txtDiaChiNVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiNVFocusGained
        // txtDiaChiNCC.setText("");
        txtDiaChiKH.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtDiaChiNVFocusGained

    private void txtMaNVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNVFocusGained
        // TODO add your handling code here:
        ///txtMaNCC1.setTe txtMaNCC1.setForeground(new java.awt.Color(26, 25, 25));xt("");
        txtMaKH.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtMaNVFocusGained

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void txtSDTNVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTNVFocusGained
        //txtSDTNCC2.setText("");
        txtSDTKH.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtSDTNVFocusGained

    private void txtSDTNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTNVActionPerformed

    private void cbo_CVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_CVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_CVActionPerformed

    private void txtSearch1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch1FocusGained
        // TODO add your handling code here:
        //        txtSearch.setText("");
        //        txtSearch.setForeground(new java.awt.Color(26, 25, 25));
        //        btnTimKiem.setEnabled(true);
    }//GEN-LAST:event_txtSearch1FocusGained

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void btnTimKiem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiem1MouseClicked
        //        String query =  txtSearch.getText();
        //
        //        if(query.length() > 0){
            //            ArrayList<NhaCC> arr = SearchNCC(query);
            //            if(arr != null){
                //                renderDsNCC(SearchNCC(query));
                //                btnShow.setEnabled(true);
                //            }
            //
            //        }
        //        else{
            //            JOptionPane.showMessageDialog(btnTimKiem, "Bạn chưa nhập Mã, Tên, SĐT NCC");
            //            btnTimKiem.setEnabled(false);
            //            btnShow.setEnabled(false);
            //        }
    }//GEN-LAST:event_btnTimKiem1MouseClicked

    private void btnXoa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoa1MouseClicked
        //        JOptionPane.showMessageDialog(btnTimKiem, "Hệ thống đang nâng cấp");
    }//GEN-LAST:event_btnXoa1MouseClicked

    private void btnCapNhat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhat1MouseClicked
        //        if(checkValue()){
            //            String MaNcc = txtMaNCC1.getText();
            //            String TenNCC = txtTenNCC.getText();
            //            String sdt = txtSDTNCC2.getText();
            //            String email = txtEmail.getText();
            //            String DiaChi = txtDiaChiNCC.getText();
            //
            //            NhaCC ncc = new NhaCC(MaNcc, TenNCC, sdt, email, DiaChi);
            //            if(nccDao.updateNCC(ncc)){
                //                String[] title = { "MaHD", "Ngày Tạo", "Khách Hàng", "Số lượng", "Tổng Tiền", "Tiền Khách Đưa", "Nhân Viên", "Ghi Chú"};
                //                modelTBNcc = new DefaultTableModel(title,0);
                //                tbNhaCC.setModel(modelTBNcc);
                //                NhaCCDao nccdao = new NhaCCDao();
                //                ArrayList<NhaCC> list = nccdao.getDsNcc();
                //                renderDsNCC(list);
                //                JOptionPane.showMessageDialog(btnTimKiem, "Cập nhật thành công!!");
                //            }
            //        }
    }//GEN-LAST:event_btnCapNhat1MouseClicked

    private void btnShow1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShow1MouseClicked
        // TODO add your handling code here:
        //        renderDsNCC(listNCC);
        //        btnShow.setEnabled(false);
        //        btnTimKiem.setEnabled(false);
        //        txtSearch.setText("Nhập mã, tên, sđt  NCC...");
        //        txtSearch.setForeground(new java.awt.Color(173, 194, 169));
    }//GEN-LAST:event_btnShow1MouseClicked

    private void btnLuu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuu1MouseClicked
        //        if(checkValue() && checkMaNCC()){
            //            btnLuu.setEnabled(false);
            //            NhaCC ncc = new NhaCC(txtMaNCC1.getText().toUpperCase(),
                //                txtTenNCC.getText().toLowerCase(), txtSDTNCC2.getText().toLowerCase(),
                //                txtEmail.getText().toLowerCase(), txtDiaChiNCC.getText().toLowerCase());
            //
            //            if(nccDao.createNCC(ncc)){
                //                Object[] row = {txtMaNCC1.getText(),
                    //                    txtTenNCC.getText(), txtSDTNCC2.getText(), txtEmail.getText(), txtDiaChiNCC.getText()};
                //                modelTBNcc.addRow(row);
                //                JOptionPane.showMessageDialog(btnLuu, "Lưu thành công");
                //
                //            }
            //
            //        }
    }//GEN-LAST:event_btnLuu1MouseClicked

    private void btnThem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThem1MouseClicked
        //        xoaRongInput();
        //        txtMaNCC1.setEnabled(true);
        //        btnLuu.setEnabled(true);
    }//GEN-LAST:event_btnThem1MouseClicked

    private void btn_SuaCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SuaCaActionPerformed

    private void btnTkLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTkLuongMouseClicked
//        String query =  txtSearch.getText();
//
//        if(query.length() > 0){
//            ArrayList<NhaCC> arr = SearchNCC(query);
//            if(arr != null){
//                renderDsNCC(SearchNCC(query));
//                btnShow.setEnabled(true);
//            }
//
//        }
//        else{
//            JOptionPane.showMessageDialog(btnTimKiem, "Bạn chưa nhập Mã, Tên, SĐT NCC");
//            btnTimKiem.setEnabled(false);
//            btnShow.setEnabled(false);
//        }

    }//GEN-LAST:event_btnTkLuongMouseClicked

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        new FrmLichSuLuong().setVisible(true);
    }//GEN-LAST:event_jToggleButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnCapNhat1;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnLuu1;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnShow1;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiem1;
    private javax.swing.JButton btnTkLuong;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JToggleButton btn_CapNhat_Luong;
    private javax.swing.JButton btn_LuuCa;
    private javax.swing.JButton btn_SuaCa;
    private javax.swing.JButton btn_ThemCa;
    private javax.swing.JButton btn_TinhLuong;
    private javax.swing.JButton btn_XoaCa;
    private javax.swing.JButton btn_tab_CaLam;
    private javax.swing.JButton btn_tab_Luong;
    private javax.swing.JButton btn_tab_NV;
    private javax.swing.JComboBox<String> cbo_Buoi;
    private javax.swing.JComboBox<String> cbo_CV;
    private javax.swing.JComboBox<String> cbo_MaNv;
    private javax.swing.JComboBox<String> cbo_TkCv_Luong;
    private com.toedter.calendar.JDateChooser dt_From;
    private com.toedter.calendar.JDateChooser dt_NgVaoLam;
    private com.toedter.calendar.JDateChooser dt_NgaySinh;
    private com.toedter.calendar.JDateChooser dt_To;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblDiaChi1;
    private javax.swing.JLabel lblDiaChi2;
    private javax.swing.JLabel lblDiaChi3;
    private javax.swing.JLabel lblDiaChi4;
    private javax.swing.JLabel lblMaNCC;
    private javax.swing.JLabel lblMaNCC1;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblSDT1;
    private javax.swing.JLabel lblTenNCC;
    private javax.swing.JLabel lblTenNCC1;
    private javax.swing.JLabel lbl_DanhMuc;
    private javax.swing.JLabel lbl_MaCa;
    private javax.swing.JLabel lbl_MauSac1;
    private javax.swing.JLabel lbl_text_NhanVien;
    private javax.swing.JPanel pnl_FormNhanVien;
    private javax.swing.JPanel pnl_menuTab_NhanVien;
    private javax.swing.JPanel pnl_tab_FormCaLam;
    private javax.swing.JPanel pnl_tab_FormLuong;
    private javax.swing.JPanel pnl_tab_FormTTNhanVien;
    private javax.swing.JTable tbl_CaLam;
    private javax.swing.JTable tbl_Luong;
    private javax.swing.JTable tbl_NV;
    private javax.swing.JTable tbl_NV_2;
    private javax.swing.JTextField txtDiaChiKH;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDTKH;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txt_MaCa;
    // End of variables declaration//GEN-END:variables
}
