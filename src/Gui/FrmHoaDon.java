/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Gui;

import Connect.connect;
import dao.HoaDonDao;
import entity.HoaDonBanHang;
import java.awt.Color;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 * Hiển thị Giao diện Form Hóa Đơn
 *
 */
public class FrmHoaDon extends javax.swing.JPanel {

    public Border default_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 153, 153));
    public Border active_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 204, 255));
    public JButton[] buttons;
    // ArrayList<HoaDonBanHang> listHoaDon = new ArrayList<HoaDonBanHang>();
    private javax.swing.table.DefaultTableModel modelTBHoaDon;

    /**
     * Creates new form FrmHoaDon
     */
    public FrmHoaDon() throws SQLException {
        initComponents();
        addBorder();
    }

    public void addBorder() {
        buttons = new JButton[2];
        //Form san pham
        buttons[0] = btn_tab_SanPham1;
        buttons[1] = btn_tab_DMSanPham1;
//        buttons[2] = btn_tab_DMSanPham2;

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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        try {
            frmHoaDonDatHang1 = new Gui.FrmHoaDonDatHang();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        }
        try {
            frmHoaDonNhapHang1 = new Gui.FrmHoaDonNhapHang();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        }
        try {
            frmHoaDonBanHang1 = new Gui.FrmHoaDonBanHang();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        }

        setBackground(new java.awt.Color(243, 244, 237));
        setPreferredSize(new java.awt.Dimension(1090, 708));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Tab.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Tab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_SanPham1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_SanPham1.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_SanPham1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_SanPham1.setText("Hóa Đơn");
        pnl_Tab.add(lbl_text_SanPham1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_menuTab_SanPham1.setBackground(new java.awt.Color(255, 255, 255));

        btn_tab_SanPham1.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_SanPham1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_SanPham1.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_SanPham1.setText("Hóa Đơn Bán Hàng");
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
        btn_tab_DMSanPham1.setText("Hóa Đơn Nhập Hàng");
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

        javax.swing.GroupLayout pnl_menuTab_SanPham1Layout = new javax.swing.GroupLayout(pnl_menuTab_SanPham1);
        pnl_menuTab_SanPham1.setLayout(pnl_menuTab_SanPham1Layout);
        pnl_menuTab_SanPham1Layout.setHorizontalGroup(
            pnl_menuTab_SanPham1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_SanPham1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_SanPham1)
                .addGap(59, 59, 59)
                .addComponent(btn_tab_DMSanPham1)
                .addContainerGap(689, Short.MAX_VALUE))
        );
        pnl_menuTab_SanPham1Layout.setVerticalGroup(
            pnl_menuTab_SanPham1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_SanPham1Layout.createSequentialGroup()
                .addGroup(pnl_menuTab_SanPham1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tab_SanPham1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btn_tab_DMSanPham1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_Tab.add(pnl_menuTab_SanPham1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 40));

        add(pnl_Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane1.addTab("tab3", frmHoaDonDatHang1);
        jTabbedPane1.addTab("tab2", frmHoaDonNhapHang1);
        jTabbedPane1.addTab("tab1", frmHoaDonBanHang1);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 29, 1090, 910));
    }// </editor-fold>//GEN-END:initComponents


    private void jDateChoiseHDInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDateChoiseHDInputMethodTextChanged
        System.out.println(evt.getText());
    }//GEN-LAST:event_jDateChoiseHDInputMethodTextChanged

    private void jDateChoiseHDCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDateChoiseHDCaretPositionChanged
        // TODO add your handling code here:
        System.out.println(evt.getText());
    }//GEN-LAST:event_jDateChoiseHDCaretPositionChanged

    private void jDateChoiseHDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateChoiseHDFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jDateChoiseHDFocusLost

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tab_DMSanPham1;
    private javax.swing.JButton btn_tab_SanPham1;
    private Gui.FrmHoaDonBanHang frmHoaDonBanHang1;
    private Gui.FrmHoaDonDatHang frmHoaDonDatHang1;
    private Gui.FrmHoaDonNhapHang frmHoaDonNhapHang1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_text_SanPham1;
    private javax.swing.JPanel pnl_Tab;
    private javax.swing.JPanel pnl_menuTab_SanPham1;
    // End of variables declaration//GEN-END:variables
/**
     * Tải lại danh sách hoá đơn nhập hàng
     *
     */
    public void renderAgianHDnhap() {
        frmHoaDonNhapHang1.renderListHoaDon();
    }

    /**
     * Tải lại danh sách hoá đơn Bán hàng
     *
     */
    public void renderAgian() {
        frmHoaDonBanHang1.renderListHoaDon();
    }

    /**
     * Tải lại danh sách hoá đơn Đặt hàng
     *
     */
    public void renderAgianHD() {
        frmHoaDonDatHang1.renderListHoaDon();
    }

}
