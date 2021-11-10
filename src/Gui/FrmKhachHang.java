/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author HP
 */
public class FrmKhachHang extends javax.swing.JPanel {
   public  Border default_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,153,153));
   public Border active_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,204,255));
   public JButton [] buttons;
    /**
     * Creates new form FrmKhachHang
     */
    public FrmKhachHang() {
        initComponents();
        tbl_KH.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 13));
        tbl_KH.getTableHeader().setOpaque(false);
        tbl_KH.setRowHeight(25);
        addBorder();
    }

    public void addBorder(){
        buttons = new JButton[1];
        
        //Form san pham
        
        buttons[0] = btn_tab_KhachHang;
        
        setButtonBorder(btn_tab_KhachHang);
        
   
        

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

        pnl_FormKhachHang = new javax.swing.JPanel();
        lbl_text_KhachHang = new javax.swing.JLabel();
        pnl_menuTab_KhachHang = new javax.swing.JPanel();
        btn_tab_KhachHang = new javax.swing.JButton();
        pnl_tab_FormKhachHang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KH = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblMaNCC = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        lblTenNCC = new javax.swing.JLabel();
        txtDiaChiKH = new javax.swing.JTextField();
        lblSDT = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtSDTKH = new javax.swing.JTextField();

        pnl_FormKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnl_FormKhachHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_KhachHang.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_KhachHang.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_KhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_KhachHang.setText("Khách Hàng");
        pnl_FormKhachHang.add(lbl_text_KhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_menuTab_KhachHang.setBackground(new java.awt.Color(255, 255, 255));

        btn_tab_KhachHang.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_KhachHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_KhachHang.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_KhachHang.setText("Thông Tin Khách Hàng");
        btn_tab_KhachHang.setBorder(null);
        btn_tab_KhachHang.setContentAreaFilled(false);
        btn_tab_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_KhachHangMouseClicked(evt);
            }
        });
        btn_tab_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_KhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_KhachHangLayout = new javax.swing.GroupLayout(pnl_menuTab_KhachHang);
        pnl_menuTab_KhachHang.setLayout(pnl_menuTab_KhachHangLayout);
        pnl_menuTab_KhachHangLayout.setHorizontalGroup(
            pnl_menuTab_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_KhachHangLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_KhachHang)
                .addContainerGap(870, Short.MAX_VALUE))
        );
        pnl_menuTab_KhachHangLayout.setVerticalGroup(
            pnl_menuTab_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_menuTab_KhachHangLayout.createSequentialGroup()
                .addComponent(btn_tab_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_FormKhachHang.add(pnl_menuTab_KhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 40));

        pnl_tab_FormKhachHang.setBackground(new java.awt.Color(243, 244, 237));

        tbl_KH.setBackground(new java.awt.Color(255, 255, 255));
        tbl_KH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_KH.setForeground(new java.awt.Color(0, 0, 0));
        tbl_KH.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Mã Kh", "Tên KH", "Số Điện Thoại", "Địa Chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_KH.setFocusable(false);
        tbl_KH.setRowHeight(25);
        tbl_KH.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tbl_KH);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tác Vụ"));
        jPanel2.setForeground(java.awt.Color.white);

        txtSearch.setForeground(new java.awt.Color(173, 194, 169));
        txtSearch.setText("Nhập mã, tên, sđt....");
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

        btnXoa.setBackground(new java.awt.Color(255, 102, 102));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
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

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblMaNCC.setText("Mã Khách Hàng: ");

        txtTenKH.setForeground(new java.awt.Color(173, 194, 169));
        txtTenKH.setText("Nhập tên NCC...");
        txtTenKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenKHFocusGained(evt);
            }
        });
        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        lblTenNCC.setText("Tên Khách Hàng ");

        txtDiaChiKH.setForeground(new java.awt.Color(173, 194, 169));
        txtDiaChiKH.setText("Nhập địa chỉ...");
        txtDiaChiKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiaChiKHFocusGained(evt);
            }
        });

        lblSDT.setText("SĐT:");

        txtMaKH.setForeground(new java.awt.Color(173, 194, 169));
        txtMaKH.setText("Mã Khách Hàng");
        txtMaKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaKHFocusGained(evt);
            }
        });
        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        lblDiaChi.setText("Địa chỉ:");

        txtSDTKH.setForeground(new java.awt.Color(173, 194, 169));
        txtSDTKH.setText("Nhập số điện thoại...");
        txtSDTKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSDTKHFocusGained(evt);
            }
        });
        txtSDTKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaNCC)
                    .addComponent(lblTenNCC))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiaChi)
                    .addComponent(lblSDT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSDT)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaNCC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenNCC)
                    .addComponent(lblDiaChi)
                    .addComponent(txtDiaChiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout pnl_tab_FormKhachHangLayout = new javax.swing.GroupLayout(pnl_tab_FormKhachHang);
        pnl_tab_FormKhachHang.setLayout(pnl_tab_FormKhachHangLayout);
        pnl_tab_FormKhachHangLayout.setHorizontalGroup(
            pnl_tab_FormKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_tab_FormKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        pnl_tab_FormKhachHangLayout.setVerticalGroup(
            pnl_tab_FormKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormKhachHangLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_FormKhachHang.add(pnl_tab_FormKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1090, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tab_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_KhachHangMouseClicked
//        pnl_tab_FormTKKhachHang.setVisible(false);
//        pnl_tab_FormKhachHang.setVisible(true);
    }//GEN-LAST:event_btn_tab_KhachHangMouseClicked

    private void btn_tab_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_KhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_KhachHangActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        // TODO add your handling code here:
//        txtSearch.setText("");
//        txtSearch.setForeground(new java.awt.Color(26, 25, 25));
//        btnTimKiem.setEnabled(true);
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
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

    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
//        JOptionPane.showMessageDialog(btnTimKiem, "Hệ thống đang nâng cấp");
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseClicked
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
    }//GEN-LAST:event_btnCapNhatMouseClicked

    private void btnShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowMouseClicked
        // TODO add your handling code here:
//        renderDsNCC(listNCC);
//        btnShow.setEnabled(false);
//        btnTimKiem.setEnabled(false);
//        txtSearch.setText("Nhập mã, tên, sđt  NCC...");
//        txtSearch.setForeground(new java.awt.Color(173, 194, 169));
    }//GEN-LAST:event_btnShowMouseClicked

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
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
    }//GEN-LAST:event_btnLuuMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
//        xoaRongInput();
//        txtMaNCC1.setEnabled(true);
//        btnLuu.setEnabled(true);

    }//GEN-LAST:event_btnThemMouseClicked

    private void txtTenKHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenKHFocusGained
        // TODO add your handling code here:
        //   txtTenNCC.setText("");
        txtTenKH.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtTenKHFocusGained

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtDiaChiKHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiKHFocusGained
        // txtDiaChiNCC.setText("");
        txtDiaChiKH.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtDiaChiKHFocusGained

    private void txtMaKHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaKHFocusGained
        // TODO add your handling code here:
        ///txtMaNCC1.setTe txtMaNCC1.setForeground(new java.awt.Color(26, 25, 25));xt("");
        txtMaKH.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtMaKHFocusGained

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void txtSDTKHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTKHFocusGained
        //txtSDTNCC2.setText("");
        txtSDTKH.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtSDTKHFocusGained

    private void txtSDTKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTKHActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btn_tab_KhachHang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblMaNCC;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenNCC;
    private javax.swing.JLabel lbl_text_KhachHang;
    private javax.swing.JPanel pnl_FormKhachHang;
    private javax.swing.JPanel pnl_menuTab_KhachHang;
    private javax.swing.JPanel pnl_tab_FormKhachHang;
    private javax.swing.JTable tbl_KH;
    private javax.swing.JTextField txtDiaChiKH;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDTKH;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
