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
public class FrmNhaCungCap extends javax.swing.JPanel {
    public  Border default_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,153,153));
   public Border active_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,204,255));
   public JButton [] buttons;
    /**
     * Creates new form FrmNhaCungCap
     */
    public FrmNhaCungCap() {
        initComponents();
        addBorder();
    }

    public void addBorder(){
        buttons = new JButton[2];
        
        //Form san pham
        buttons[0] = btn_tab_dsncc;
        buttons[1] = btn_tab_tkncc;
        
   
        setButtonBorder(btn_tab_dsncc);
     

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

        pnl_FormNhaCungCap = new javax.swing.JPanel();
        lbl_text_NhaCungCap = new javax.swing.JLabel();
        pnl_menuTab_NCC = new javax.swing.JPanel();
        btn_tab_dsncc = new javax.swing.JButton();
        btn_tab_tkncc = new javax.swing.JButton();
        pnl_tab_Form_DSNCC = new javax.swing.JPanel();
        pnl_tab_FormTKNCC = new javax.swing.JPanel();

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

        btn_tab_tkncc.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_tkncc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_tkncc.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_tkncc.setText("Tìm Kiếm Nhà Cung Cấp");
        btn_tab_tkncc.setActionCommand("Tìm Kiếm Hóa Đơn");
        btn_tab_tkncc.setBorder(null);
        btn_tab_tkncc.setContentAreaFilled(false);
        btn_tab_tkncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_tknccMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_NCCLayout = new javax.swing.GroupLayout(pnl_menuTab_NCC);
        pnl_menuTab_NCC.setLayout(pnl_menuTab_NCCLayout);
        pnl_menuTab_NCCLayout.setHorizontalGroup(
            pnl_menuTab_NCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_NCCLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_dsncc)
                .addGap(44, 44, 44)
                .addComponent(btn_tab_tkncc)
                .addContainerGap(636, Short.MAX_VALUE))
        );
        pnl_menuTab_NCCLayout.setVerticalGroup(
            pnl_menuTab_NCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_menuTab_NCCLayout.createSequentialGroup()
                .addGroup(pnl_menuTab_NCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_tab_dsncc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btn_tab_tkncc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_FormNhaCungCap.add(pnl_menuTab_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 50));

        pnl_tab_Form_DSNCC.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout pnl_tab_Form_DSNCCLayout = new javax.swing.GroupLayout(pnl_tab_Form_DSNCC);
        pnl_tab_Form_DSNCC.setLayout(pnl_tab_Form_DSNCCLayout);
        pnl_tab_Form_DSNCCLayout.setHorizontalGroup(
            pnl_tab_Form_DSNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        pnl_tab_Form_DSNCCLayout.setVerticalGroup(
            pnl_tab_Form_DSNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pnl_FormNhaCungCap.add(pnl_tab_Form_DSNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1300, 720));

        pnl_tab_FormTKNCC.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout pnl_tab_FormTKNCCLayout = new javax.swing.GroupLayout(pnl_tab_FormTKNCC);
        pnl_tab_FormTKNCC.setLayout(pnl_tab_FormTKNCCLayout);
        pnl_tab_FormTKNCCLayout.setHorizontalGroup(
            pnl_tab_FormTKNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        pnl_tab_FormTKNCCLayout.setVerticalGroup(
            pnl_tab_FormTKNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pnl_FormNhaCungCap.add(pnl_tab_FormTKNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1300, 720));

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
            .addGap(0, 800, Short.MAX_VALUE)
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

    private void btn_tab_tknccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_tknccMouseClicked
        pnl_tab_Form_DSNCC.setVisible(false);
        pnl_tab_FormTKNCC.setVisible(true);
    }//GEN-LAST:event_btn_tab_tknccMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tab_dsncc;
    private javax.swing.JButton btn_tab_tkncc;
    private javax.swing.JLabel lbl_text_NhaCungCap;
    private javax.swing.JPanel pnl_FormNhaCungCap;
    private javax.swing.JPanel pnl_menuTab_NCC;
    private javax.swing.JPanel pnl_tab_FormTKNCC;
    private javax.swing.JPanel pnl_tab_Form_DSNCC;
    // End of variables declaration//GEN-END:variables
}
