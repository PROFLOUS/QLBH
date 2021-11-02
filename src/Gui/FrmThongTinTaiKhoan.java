/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author HP
 */
public class FrmThongTinTaiKhoan extends javax.swing.JPanel {
public  Border default_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,153,153));
   public Border active_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,204,255));
    /**
     * Creates new form FrmThongTinTaiKhoan
     */
    public FrmThongTinTaiKhoan() {
        initComponents();
        setButtonBorder(btn_tab_TTTK);
    }

    public void setButtonBorder(JButton button){
//        for (JButton btn : buttons) {
//            btn.setBorder(default_border);
//            btn.setForeground(new Color(153,153,153));
//        }
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
        jButton1 = new javax.swing.JButton();

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
                .addContainerGap(886, Short.MAX_VALUE))
        );
        pnl_menuTab_TTTKLayout.setVerticalGroup(
            pnl_menuTab_TTTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_tab_TTTK, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnl_FormTTTaiKhoan.add(pnl_menuTab_TTTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 50));

        pnl_tab_FormTTTK.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setText("jButton1");

        javax.swing.GroupLayout pnl_tab_FormTTTKLayout = new javax.swing.GroupLayout(pnl_tab_FormTTTK);
        pnl_tab_FormTTTK.setLayout(pnl_tab_FormTTTKLayout);
        pnl_tab_FormTTTKLayout.setHorizontalGroup(
            pnl_tab_FormTTTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormTTTKLayout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(jButton1)
                .addContainerGap(871, Short.MAX_VALUE))
        );
        pnl_tab_FormTTTKLayout.setVerticalGroup(
            pnl_tab_FormTTTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormTTTKLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jButton1)
                .addContainerGap(491, Short.MAX_VALUE))
        );

        pnl_FormTTTaiKhoan.add(pnl_tab_FormTTTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1300, 720));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tab_TTTK;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbl_text_TTTK;
    private javax.swing.JPanel pnl_FormTTTaiKhoan;
    private javax.swing.JPanel pnl_menuTab_TTTK;
    private javax.swing.JPanel pnl_tab_FormTTTK;
    // End of variables declaration//GEN-END:variables
}
