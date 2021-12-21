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
 * Hiển thị Giao diện Form san pham
 *
 */
public class FrmSanPham extends javax.swing.JPanel {

    public Border default_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 153, 153));
    public Border active_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 204, 255));
    public JButton[] buttons;

    /**
     * Creates new form FrmSanPham
     */
    public FrmSanPham() {
        initComponents();
        addBorder();
    }

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

    public void renderAgian() {
        frmDsSp1.reLoad();
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
