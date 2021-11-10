/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Connect.connect;
import dao.*;
import entity.HoaDonBanHang;
import entity.NhaCC;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class FrmNhaCungCap extends javax.swing.JPanel {
    private ArrayList<NhaCC> listNCC = new ArrayList<NhaCC>();
    private NhaCCDao nccDao = new NhaCCDao();
   
        private javax.swing.table.DefaultTableModel modelTBNcc;
        public  Border default_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,153,153));
        public Border active_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,204,255));
        public JButton [] buttons;
    /**
     * Creates new form FrmNhaCungCap
     */
    public FrmNhaCungCap() throws SQLException {
      
        try {
             initComponents();
             addBorder();
             listNCC = nccDao.getDsNcc();
             connect.getInstance().connect();
        
          renderDsNCC(listNCC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBorder(){
        buttons = new JButton[2];
        
        //Form san pham
        buttons[0] = btn_tab_dsncc;
     
        
   
        setButtonBorder(btn_tab_dsncc);
     

        //addAction();
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

        pnl_FormNhaCungCap = new javax.swing.JPanel();
        lbl_text_NhaCungCap = new javax.swing.JLabel();
        pnl_menuTab_NCC = new javax.swing.JPanel();
        btn_tab_dsncc = new javax.swing.JButton();
        pnl_tab_FormTKNCC = new javax.swing.JPanel();
        pnl_tab_Form_DSNCC = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblMaNCC = new javax.swing.JLabel();
        txtTenNCC = new javax.swing.JTextField();
        lblTenNCC = new javax.swing.JLabel();
        txtDiaChiNCC = new javax.swing.JTextField();
        lblSDT = new javax.swing.JLabel();
        txtMaNCC1 = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmailNCC = new javax.swing.JLabel();
        txtSDTNCC2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNhaCC = new javax.swing.JTable();

        pnl_FormNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));
        pnl_FormNhaCungCap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_NhaCungCap.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_NhaCungCap.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_NhaCungCap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_NhaCungCap.setText("Nhà Cung Cấp");
        pnl_FormNhaCungCap.add(lbl_text_NhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_menuTab_NCC.setBackground(new java.awt.Color(255, 255, 255));

        btn_tab_dsncc.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_dsncc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_dsncc.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_dsncc.setText("Danh Sách Nhà Cung Cấp");
        btn_tab_dsncc.setBorder(null);
        btn_tab_dsncc.setContentAreaFilled(false);
        btn_tab_dsncc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tab_dsncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_dsnccMouseClicked(evt);
            }
        });
        btn_tab_dsncc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_dsnccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_NCCLayout = new javax.swing.GroupLayout(pnl_menuTab_NCC);
        pnl_menuTab_NCC.setLayout(pnl_menuTab_NCCLayout);
        pnl_menuTab_NCCLayout.setHorizontalGroup(
            pnl_menuTab_NCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_NCCLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_tab_dsncc)
                .addContainerGap(886, Short.MAX_VALUE))
        );
        pnl_menuTab_NCCLayout.setVerticalGroup(
            pnl_menuTab_NCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_menuTab_NCCLayout.createSequentialGroup()
                .addComponent(btn_tab_dsncc, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_FormNhaCungCap.add(pnl_menuTab_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 50));

        pnl_tab_FormTKNCC.setBackground(new java.awt.Color(204, 204, 255));

        pnl_tab_Form_DSNCC.setBackground(new java.awt.Color(243, 244, 237));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblMaNCC.setText("Mã NCC: ");

        txtTenNCC.setForeground(new java.awt.Color(173, 194, 169));
        txtTenNCC.setText("Nhập tên NCC...");
        txtTenNCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenNCCFocusGained(evt);
            }
        });
        txtTenNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNCCActionPerformed(evt);
            }
        });

        lblTenNCC.setText("Tên NCC: ");

        txtDiaChiNCC.setForeground(new java.awt.Color(173, 194, 169));
        txtDiaChiNCC.setText("Nhập địa chỉ...");
        txtDiaChiNCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiaChiNCCFocusGained(evt);
            }
        });

        lblSDT.setText("SĐT:");

        txtMaNCC1.setForeground(new java.awt.Color(173, 194, 169));
        txtMaNCC1.setText("Nhập mã NCC...");
        txtMaNCC1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaNCC1FocusGained(evt);
            }
        });
        txtMaNCC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNCC1ActionPerformed(evt);
            }
        });

        lblDiaChi.setText("Địa chỉ:");

        txtEmail.setForeground(new java.awt.Color(173, 194, 169));
        txtEmail.setText("Nhập email...");
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
        });

        lblEmailNCC.setText("Email:");

        txtSDTNCC2.setForeground(new java.awt.Color(173, 194, 169));
        txtSDTNCC2.setText("Nhập số điện thoại...");
        txtSDTNCC2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSDTNCC2FocusGained(evt);
            }
        });
        txtSDTNCC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTNCC2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTenNCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMaNCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblSDT)
                        .addGap(18, 18, 18)
                        .addComponent(txtSDTNCC2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDiaChi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDiaChiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(lblEmailNCC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDTNCC2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSDT)
                            .addComponent(txtMaNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaNCC))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaChiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiaChi)
                            .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenNCC)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmailNCC)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tác Vụ"));
        jPanel2.setForeground(java.awt.Color.white);

        txtSearch.setForeground(new java.awt.Color(173, 194, 169));
        txtSearch.setText("Nhập mã, tên, sđt  NCC..");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(21, 151, 229));
        btnTimKiem.setForeground(java.awt.Color.white);
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search_1.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setToolTipText("Nhập mã. tên NCC để tìm kiếm");
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.setEnabled(false);
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(21, 151, 229));
        btnXoa.setForeground(java.awt.Color.white);
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/close2.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setToolTipText("Chọn 1 NCC để xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(21, 151, 229));
        btnCapNhat.setForeground(java.awt.Color.white);
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/system-update.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setToolTipText("Chọn 1 NCC để cập nhập");
        btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapNhatMouseClicked(evt);
            }
        });

        btnShow.setBackground(new java.awt.Color(21, 151, 229));
        btnShow.setForeground(java.awt.Color.white);
        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/clipboard.png"))); // NOI18N
        btnShow.setText("Hiển thị DS");
        btnShow.setToolTipText("Hiển thị lại DS NCC");
        btnShow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShow.setEnabled(false);
        btnShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowMouseClicked(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(21, 151, 229));
        btnLuu.setForeground(java.awt.Color.white);
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/clipboard.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLuu.setEnabled(false);
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuMouseClicked(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(21, 151, 229));
        btnThem.setForeground(java.awt.Color.white);
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnShow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShow, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tbNhaCC.setAutoCreateRowSorter(true);
        tbNhaCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbNhaCC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbNhaCC.setRowHeight(26);
        tbNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhaCCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbNhaCC);

        javax.swing.GroupLayout pnl_tab_Form_DSNCCLayout = new javax.swing.GroupLayout(pnl_tab_Form_DSNCC);
        pnl_tab_Form_DSNCC.setLayout(pnl_tab_Form_DSNCCLayout);
        pnl_tab_Form_DSNCCLayout.setHorizontalGroup(
            pnl_tab_Form_DSNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_Form_DSNCCLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnl_tab_Form_DSNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(406, Short.MAX_VALUE))
        );
        pnl_tab_Form_DSNCCLayout.setVerticalGroup(
            pnl_tab_Form_DSNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_Form_DSNCCLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_tab_FormTKNCCLayout = new javax.swing.GroupLayout(pnl_tab_FormTKNCC);
        pnl_tab_FormTKNCC.setLayout(pnl_tab_FormTKNCCLayout);
        pnl_tab_FormTKNCCLayout.setHorizontalGroup(
            pnl_tab_FormTKNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormTKNCCLayout.createSequentialGroup()
                .addComponent(pnl_tab_Form_DSNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_tab_FormTKNCCLayout.setVerticalGroup(
            pnl_tab_FormTKNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_tab_Form_DSNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_FormNhaCungCap.add(pnl_tab_FormTKNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1300, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tab_dsnccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_dsnccMouseClicked
        pnl_tab_Form_DSNCC.setVisible(true);
        pnl_tab_FormTKNCC.setVisible(false);
    }//GEN-LAST:event_btn_tab_dsnccMouseClicked

    private void btn_tab_dsnccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_dsnccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_dsnccActionPerformed

    private void txtSDTNCC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTNCC2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTNCC2ActionPerformed

    private void txtMaNCC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNCC1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNCC1ActionPerformed

    private void txtMaNCC1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNCC1FocusGained
        // TODO add your handling code here:
        ///txtMaNCC1.setTe txtMaNCC1.setForeground(new java.awt.Color(26, 25, 25));xt("");
         txtMaNCC1.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtMaNCC1FocusGained

    private void txtTenNCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenNCCFocusGained
        // TODO add your handling code here:
      //   txtTenNCC.setText("");
         txtTenNCC.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtTenNCCFocusGained

    private void txtSDTNCC2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTNCC2FocusGained
        //txtSDTNCC2.setText("");
         txtSDTNCC2.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtSDTNCC2FocusGained

    private void txtDiaChiNCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiNCCFocusGained
      // txtDiaChiNCC.setText("");
         txtDiaChiNCC.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtDiaChiNCCFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
       // txtEmail.setText("");
         txtEmail.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        // TODO add your handling code here:
        txtSearch.setText("");
         txtSearch.setForeground(new java.awt.Color(26, 25, 25));
         btnTimKiem.setEnabled(true);
    }//GEN-LAST:event_txtSearchFocusGained

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        String query =  txtSearch.getText();
      
       if(query.length() > 0){
           ArrayList<NhaCC> arr = SearchNCC(query);
          if(arr != null){
              renderDsNCC(SearchNCC(query));
             btnShow.setEnabled(true);
          }
         
       }
       else{
           JOptionPane.showMessageDialog(btnTimKiem, "Bạn chưa nhập Mã, Tên, SĐT NCC");
           btnTimKiem.setEnabled(false);
           btnShow.setEnabled(false);
       }
     
       
       
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btnShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowMouseClicked
        // TODO add your handling code here:
        renderDsNCC(listNCC);
        btnShow.setEnabled(false);
        btnTimKiem.setEnabled(false);
        txtSearch.setText("Nhập mã, tên, sđt  NCC...");
         txtSearch.setForeground(new java.awt.Color(173, 194, 169));
    }//GEN-LAST:event_btnShowMouseClicked

    private void txtTenNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNCCActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    
    
    private void tbNhaCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhaCCMouseClicked
                int row = tbNhaCC.getSelectedRow();
               if(row != -1){
                    setColorInput();
                     txtMaNCC1.setEnabled(false);
                    txtMaNCC1.setText(tbNhaCC.getValueAt(row, 0).toString());
                    txtTenNCC.setText(tbNhaCC.getValueAt(row, 1).toString());
                    txtSDTNCC2.setText(tbNhaCC.getValueAt(row, 2).toString());
                    txtEmail.setText(tbNhaCC.getValueAt(row, 3).toString());
                    txtDiaChiNCC.setText(tbNhaCC.getValueAt(row, 4).toString());
               }
		
                
		
    }//GEN-LAST:event_tbNhaCCMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        xoaRongInput();
        txtMaNCC1.setEnabled(true);
        btnLuu.setEnabled(true);
       
    }//GEN-LAST:event_btnThemMouseClicked

    
    //click vao Luu
    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        if(checkValue() && checkMaNCC()){
          btnLuu.setEnabled(false);
             NhaCC ncc = new NhaCC(txtMaNCC1.getText().toUpperCase(),
                     txtTenNCC.getText().toLowerCase(), txtSDTNCC2.getText().toLowerCase(),
                     txtEmail.getText().toLowerCase(), txtDiaChiNCC.getText().toLowerCase());
          
                 if(nccDao.createNCC(ncc)){
                    Object[] row = {txtMaNCC1.getText(),
                     txtTenNCC.getText(), txtSDTNCC2.getText(), txtEmail.getText(), txtDiaChiNCC.getText()};
                    modelTBNcc.addRow(row);
                    JOptionPane.showMessageDialog(btnLuu, "Lưu thành công");
            
        }     
      
             
         }    
    }//GEN-LAST:event_btnLuuMouseClicked

    //clck vao capnhat de cap nhat lai NCC
    private void btnCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseClicked
           if(checkValue()){
            String MaNcc = txtMaNCC1.getText();
            String TenNCC = txtTenNCC.getText();
            String sdt = txtSDTNCC2.getText();
            String email = txtEmail.getText();
            String DiaChi = txtDiaChiNCC.getText();
            
            NhaCC ncc = new NhaCC(MaNcc, TenNCC, sdt, email, DiaChi);
            if(nccDao.updateNCC(ncc)){
                 String[] title = { "MaHD", "Ngày Tạo", "Khách Hàng", "Số lượng", "Tổng Tiền", "Tiền Khách Đưa", "Nhân Viên", "Ghi Chú"};
		 modelTBNcc = new DefaultTableModel(title,0);
                 tbNhaCC.setModel(modelTBNcc);
                NhaCCDao nccdao = new NhaCCDao();
                ArrayList<NhaCC> list = nccdao.getDsNcc();
                renderDsNCC(list);
                JOptionPane.showMessageDialog(btnTimKiem, "Cập nhật thành công!!");
            }
           }
    }//GEN-LAST:event_btnCapNhatMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
       JOptionPane.showMessageDialog(btnTimKiem, "Hệ thống đang nâng cấp");
    }//GEN-LAST:event_btnXoaMouseClicked

    
    
        //set color cho the input
        public void setColorInput(){
             txtMaNCC1.setForeground(new java.awt.Color(26, 25, 25));
             txtTenNCC.setForeground(new java.awt.Color(26, 25, 25));
             txtSDTNCC2.setForeground(new java.awt.Color(26, 25, 25));
             txtEmail.setForeground(new java.awt.Color(26, 25, 25));
             txtDiaChiNCC.setForeground(new java.awt.Color(26, 25, 25));
             
             
        }
        
         //xoa rong cac input
        public void xoaRongInput(){
            
             txtMaNCC1.setText("");
             txtTenNCC.setText("");
             txtSDTNCC2.setText("");
             txtEmail.setText("");
             txtDiaChiNCC.setText("");
             
             
        }
     //dua du lieu NCC len Table
	private void renderDsNCC(ArrayList<NhaCC> arr) {
		
                 String[] title = { "MaNCC", "Tên NCC", "Số điện thooại", "Email", "Địa chỉ"};
		 
                modelTBNcc = new DefaultTableModel(title,0);
		for(NhaCC s : arr) {
			String[] rowData = {
				s.getMaNCC(),s.getTenNCC(), s.getSdt(), s.getMail(), s.getDiaChi()
			};
                       
			modelTBNcc.addRow(rowData);
		}
               
		tbNhaCC.setModel(modelTBNcc);
           
	}
        
        //kiem tra du lieu dau vao
        public boolean checkMaNCC(){
            String MaNcc = txtMaNCC1.getText();
             AtomicBoolean check = new AtomicBoolean(true);
            listNCC.forEach(val ->{
                if(val.getMaNCC().toUpperCase().equals(MaNcc.toUpperCase())){
                   check.set(false);
                }
            });
            if(check.get() == false){
                JOptionPane.showMessageDialog(btnLuu, "Mã NCC đã tồn tại trong hệ thống. Vui lòng nhập lại mã khác");
                return false;
            }
            
            return true;
        }
        public boolean checkValue(){
            String MaNcc = txtMaNCC1.getText();
            String TenNCC = txtTenNCC.getText();
            String sdt = txtSDTNCC2.getText();
            String email = txtEmail.getText();
            String DiaChi = txtDiaChiNCC.getText();
            
            String regexMail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";//check mail
            String regexPhone = "^[0-9]{10}";
           
            
           
            if (!(MaNcc.length() > 0 && MaNcc.matches("^NCC[0-9]{3}"))) {
		JOptionPane.showMessageDialog(btnLuu, "Mã NCC không đúng định dạng NCCxxx");
		return false;
            }
           if(TenNCC.length()<=0) {
		JOptionPane.showMessageDialog(btnLuu, "Tên NCC không được để trống");			
		return false;
            }
           if(DiaChi.length() <=0){
		JOptionPane.showMessageDialog(btnLuu, "Địa chỉ NCC không được để trống");			
		return false;             
           }
//            if(!email.matches(regexMail)){
//		JOptionPane.showMessageDialog(btnLuu, "Email không đúng định dạng");			
//		return false;             
//           }
             if(!sdt.matches(regexPhone)){
		JOptionPane.showMessageDialog(btnLuu, "Số điện thoại có 10 số");			
		return false;             
           }
            
           
            return true;
        }
        
        /**
         *@param String MaNCC or TenNCC
         * @return ArrayList NhaCC
         */
        public ArrayList<NhaCC> SearchNCC(String query){
            ArrayList<NhaCC> arrNCC = new ArrayList<NhaCC>();
            AtomicBoolean check = new AtomicBoolean();
            
            //tim kiem theo MaNCC
            listNCC.forEach(ncc ->{
                if(ncc.getMaNCC().toLowerCase().equals(query.toLowerCase())){
                    arrNCC.add(ncc);
                    check.set(true);
                }
            });
            
            //timKiem theo Ten NCC
             listNCC.forEach(ncc ->{
                if(ncc.getTenNCC().toLowerCase().contains(query.toLowerCase())){
                    arrNCC.add(ncc);
                    check.set(true);
                }
            });
             
              //timKiem theo sdt
             listNCC.forEach(ncc ->{
                if(ncc.getSdt().contains(query)){
                    arrNCC.add(ncc);
                    check.set(true);
                }
            });
            
            if(check.get() == true){
                return arrNCC;
            }
           
            JOptionPane.showMessageDialog(btnTimKiem, "Không tìm thấy  "+query+"");
            return null;
        }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btn_tab_dsncc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmailNCC;
    private javax.swing.JLabel lblMaNCC;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenNCC;
    private javax.swing.JLabel lbl_text_NhaCungCap;
    private javax.swing.JPanel pnl_FormNhaCungCap;
    private javax.swing.JPanel pnl_menuTab_NCC;
    private javax.swing.JPanel pnl_tab_FormTKNCC;
    private javax.swing.JPanel pnl_tab_Form_DSNCC;
    private javax.swing.JTable tbNhaCC;
    private javax.swing.JTextField txtDiaChiNCC;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNCC1;
    private javax.swing.JTextField txtSDTNCC2;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenNCC;
    // End of variables declaration//GEN-END:variables
}
