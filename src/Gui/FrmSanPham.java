/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import javax.swing.JButton;

import javax.swing.border.Border;


/**
 *
 * @author HP
 */
public class FrmSanPham extends javax.swing.JPanel {

    public Border default_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 153, 153));
    public Border active_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 204, 255));
    public JButton[] buttons;
//    public FrmBanHang frbh;
//    ArrayList<DanhMucSP> dsDmSP;
//    ArrayList<SanPham> dsSP;
//    DanhMucSPDao dm_dao;
//    SanPhamDao sp_dao;
//    private DefaultTableModel dfSP_Model;
//    private DefaultTableModel dfTkSP_Model;
//    private DefaultTableModel dfDmSP_Model;
//    private ArrayList<SanPham> dsTkSP;
//    final JFileChooser fileDialog = new JFileChooser();
//    JFrame cha = new JFrame();
//    ImageIcon icon;

    /**
     * Creates new form FrmSanPham
     */
    public FrmSanPham() {
        initComponents();
        
        addBorder();
        
//        frbh = new FrmBanHang();
//        dsSP = new ArrayList<SanPham>();
//        dsDmSP = new ArrayList<DanhMucSP>();
//        dsTkSP = new ArrayList<SanPham>();
//        dm_dao = new DanhMucSPDao();
//        sp_dao = new SanPhamDao();
//        upTblSP();
//        upTblDM();
//        upCbo_DM();
//        Hide();

    }

//    //láy thông tin trên textfield sản phẩm
//    public SanPham restText() {
//        String maSp = lbl_GetSp.getText().toString();
//        String tenSp = txt_TenSp.getText().toString();
//        String tenDm = cbo_Dm.getSelectedItem().toString();
//        DanhMucSP dm = dm_dao.getDMByTen(tenDm);
//        String mau = txt_MauSac.getText().toString();
//        String size = txt_Size.getText().toString();
//        int slKho = Integer.parseInt(txt_SlKho.getText());
//        double donGia = Double.parseDouble(txt_DonGia.getText());
//        String hinh = lbl_HinhAnh.getIcon().toString();
//
//        return new SanPham(dm, maSp, tenSp, donGia, slKho, hinh, size, mau);
//    }

    //láy thông tin trên textfield danh mục
//    public DanhMucSP restTextDM() {
//        String maDm = txt_MaDm.getText().toString();
//        String tenDm = txt_TenDm.getText().toString();
//
//        return new DanhMucSP(maDm, tenDm);
//
//    }

    //kiểm tra du liệu nhập danh mục
//    public boolean kiemTraDataDM() {
//        String tenDM = txt_TenDm.getText().trim();
//        // Tên danh mục phải là chữ
//        if (!(tenDM.length() > 0 && tenDM.matches("[A-Za-z]+"))) {
//            JOptionPane.showMessageDialog(this, "Tên Danh Mục phải là chữ");
//            return false;
//        }
//        return true;
//    }

    //Kiểm tra dữ liệu nhập
//    public boolean kiemTraData() {
//
//        String tenSP = txt_TenSp.getText().trim();
//        String mau = txt_MauSac.getText().trim();
//        String size = txt_Size.getText().trim();
//        String slKho = txt_SlKho.getText().trim();
//        
//        String donGia = txt_DonGia.getText().trim();
//
//        // Tên sản phẩm phải là chữ
//        if (!(tenSP.length() > 0 && tenSP.matches("[A-Za-z]+"))) {
//            JOptionPane.showMessageDialog(this, "Tên Sản Phẩm phải là chữ");
//            return false;
//        }
//
//        //Mau phải là chữ
//        if (!(mau.length() > 0 && mau.matches("[A-Za-z]+"))) {
//            JOptionPane.showMessageDialog(this, "Mầu sắc phải là chữ");
//            return false;
//        }
//        //size ko am
//        if (!(size.length() > 0 && size.matches("[A-Za-z0-9 ]+"))) {
//            JOptionPane.showMessageDialog(this, "Size sản phẩm không được là số âm");
//            return false;
//        }
//        //sl kho số ko âm
//        if (slKho.length() > 0) {
//            try {
//                int x = Integer.parseInt(slKho);
//                if (x <= 0) {
//                    JOptionPane.showMessageDialog(this, "Số lượng phải nhập số nguyên dương");
//                    return false;
//                }
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(this, "Số lượng phải nhập số nguyên dương");
//                return false;
//            }
//        }
//        //sl số ko âm
//        
//        //Đơn giá số ko âm
//        if (donGia.length() > 0) {
//            try {
//                int x = Integer.parseInt(donGia);
//                if (x <= 0) {
//                    JOptionPane.showMessageDialog(this, "Đơn Giá phải nhập số nguyên dương");
//                    return false;
//                }
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(this, "Đơn Giá phải nhập số nguyên dương");
//                return false;
//            }
//        }
//
//        return true;
//    }

    //xoa combobox
//    public void xoaCBB() {
//        int itCount = cbo_Dm.getItemCount();
//        for (int i = 0; i < itCount; i++) {
//            cbo_Dm.removeItemAt(0);
//        }
//
//    }

    //xoa model sản phẩm
//    public void xoaModelSP() {
//        DefaultTableModel del = (DefaultTableModel) tbl_Sp.getModel();
//        del.getDataVector().removeAllElements();
//    }

    //xóa model danh mục
//    public void xoaModelDM() {
//        DefaultTableModel del = (DefaultTableModel) tbl_DanhMuc.getModel();
//        del.getDataVector().removeAllElements();
//    }

//    //xóa rong textfield danh mục
//    public void xoaRongTextDm() {
//
//        txt_MaDm.setText("");
//        txt_TenDm.setText("");
//        txt_TenDm.requestFocus();
//    }
    //xóa rong textfield sản phẩm
//    public void xoaRongTextSp() {
//        
//        txt_SlKho.setText("");
//
//        txt_TenSp.setText("");
//        txt_DonGia.setText("");
//        txt_Size.setText("");
//        txt_MauSac.setText("");
//        lbl_GetSp.setText("");
//        lbl_HinhAnh.setIcon(null);
//        txt_TenSp.requestFocus();
//
//    }
    //ẩn bớt cái nút
//    public void Hide() {
////        cbb_TkGia.setEnabled(false);
////        cbb_TkDM.setEnabled(false);
////        txt_TkTenSp.setEnabled(false);
//        btn_SuaDm.setEnabled(false);
//        txt_MaDm.setEditable(false);
////        btn_SuaAnh.setVisible(false);
//    }
    //đọc dữ liệu lên combobox danh mục
//    public void upCbo_DM() {
//
//        for (DanhMucSP dm : dsDmSP) {
//            cbo_Dm.addItem(dm.getTenLoai());
////            cbb_TkDM.addItem(dm.getTenLoai());
//
//        }
//    }
    //đọc dữ liệu lên bảng sản phẩm
//    public void upTblSP() {
//        //bang san pham
//        dfSP_Model = (DefaultTableModel) tbl_Sp.getModel();
//
//        dsSP = sp_dao.getAllSP();
//        for (SanPham sp : dsSP) {
//            dfSP_Model.addRow(new Object[]{
//                sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
//                sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
//                sp.getDonGia(), sp.getHinhAnh()
//            });
//        }
//
//    }
    
    //đọc dữ liệu lên bảng danh mục
//    public void upTblDM() {
//        dfDmSP_Model = (DefaultTableModel) tbl_DanhMuc.getModel();
//
//        dsDmSP = dm_dao.getAllDM();
//        for (DanhMucSP dm : dsDmSP) {
//            dfDmSP_Model.addRow(new Object[]{
//                dm.getMaloai(), dm.getTenLoai()
//            });
//        }
//    }
    
    public void addBorder() {
        buttons = new JButton[3];
        //Form san pham
        buttons[0] = btn_tab_SanPham1;
        buttons[1] = btn_tab_DMSanPham1;
        buttons[2] = btn_tab_NhapHang;
        
        setButtonBorder(btn_tab_SanPham1);
        addAction();
    }
//    //set border active
//
    public void setButtonBorder(JButton button) {
        button.setBorder(active_border);
        button.setForeground(Color.black);
    }
//
//    //add even
    public void addAction() {
        for (JButton button : buttons) {
            button.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (JButton btn : buttons) {
                        btn.setBorder(default_border);
                        btn.setForeground(new Color(153, 153, 153));
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

        pnl_Tab = new javax.swing.JPanel();
        lbl_text_SanPham1 = new javax.swing.JLabel();
        pnl_menuTab_SanPham1 = new javax.swing.JPanel();
        btn_tab_SanPham1 = new javax.swing.JButton();
        btn_tab_DMSanPham1 = new javax.swing.JButton();
        btn_tab_NhapHang = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        try {
            frmDsSp1 = new Gui.FrmDsSp();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        }
        frmDmSp1 = new Gui.FrmDmSp();
        frmNhapHang1 = new Gui.FrmNhapHang();

        setPreferredSize(new java.awt.Dimension(1090, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Tab.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Tab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_SanPham1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_SanPham1.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_SanPham1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_SanPham1.setText("Sản Phẩm");
        pnl_Tab.add(lbl_text_SanPham1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_menuTab_SanPham1.setBackground(new java.awt.Color(255, 255, 255));

        btn_tab_SanPham1.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_SanPham1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_SanPham1.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_SanPham1.setText("Sản Phẩm");
        btn_tab_SanPham1.setBorder(null);
        btn_tab_SanPham1.setContentAreaFilled(false);
        btn_tab_SanPham1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_SanPham1MouseClicked(evt);
            }
        });
        btn_tab_SanPham1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_SanPham1ActionPerformed(evt);
            }
        });

        btn_tab_DMSanPham1.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_DMSanPham1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_DMSanPham1.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_DMSanPham1.setText("Danh Mục Sản Phẩm");
        btn_tab_DMSanPham1.setBorder(null);
        btn_tab_DMSanPham1.setContentAreaFilled(false);
        btn_tab_DMSanPham1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_DMSanPham1MouseClicked(evt);
            }
        });
        btn_tab_DMSanPham1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_DMSanPham1ActionPerformed(evt);
            }
        });

        btn_tab_NhapHang.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_NhapHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_NhapHang.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_NhapHang.setText("Nhập Hàng");
        btn_tab_NhapHang.setBorder(null);
        btn_tab_NhapHang.setContentAreaFilled(false);
        btn_tab_NhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_NhapHangMouseClicked(evt);
            }
        });
        btn_tab_NhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_NhapHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_SanPham1Layout = new javax.swing.GroupLayout(pnl_menuTab_SanPham1);
        pnl_menuTab_SanPham1.setLayout(pnl_menuTab_SanPham1Layout);
        pnl_menuTab_SanPham1Layout.setHorizontalGroup(
            pnl_menuTab_SanPham1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_SanPham1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_SanPham1)
                .addGap(59, 59, 59)
                .addComponent(btn_tab_DMSanPham1)
                .addGap(64, 64, 64)
                .addComponent(btn_tab_NhapHang)
                .addContainerGap(612, Short.MAX_VALUE))
        );
        pnl_menuTab_SanPham1Layout.setVerticalGroup(
            pnl_menuTab_SanPham1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_SanPham1Layout.createSequentialGroup()
                .addGroup(pnl_menuTab_SanPham1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tab_SanPham1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btn_tab_NhapHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tab_DMSanPham1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_Tab.add(pnl_menuTab_SanPham1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 40));

        add(pnl_Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("tab1", frmDsSp1);
        jTabbedPane1.addTab("tab2", frmDmSp1);
        jTabbedPane1.addTab("tab3", frmNhapHang1);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 1090, 830));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tab_SanPham1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_SanPham1MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btn_tab_SanPham1MouseClicked

    private void btn_tab_SanPham1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_SanPham1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_SanPham1ActionPerformed

    private void btn_tab_DMSanPham1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_DMSanPham1MouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btn_tab_DMSanPham1MouseClicked

    private void btn_tab_DMSanPham1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_DMSanPham1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_DMSanPham1ActionPerformed

    private void btn_tab_NhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_NhapHangMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btn_tab_NhapHangMouseClicked

    private void btn_tab_NhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_NhapHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_NhapHangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tab_DMSanPham1;
    private javax.swing.JButton btn_tab_NhapHang;
    private javax.swing.JButton btn_tab_SanPham1;
    private Gui.FrmDmSp frmDmSp1;
    private Gui.FrmDsSp frmDsSp1;
    private Gui.FrmNhapHang frmNhapHang1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_text_SanPham1;
    private javax.swing.JPanel pnl_Tab;
    private javax.swing.JPanel pnl_menuTab_SanPham1;
    // End of variables declaration//GEN-END:variables
}
