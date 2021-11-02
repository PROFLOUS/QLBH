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
public class FrmHeThong extends javax.swing.JPanel {
public  Border default_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,153,153));
   public Border active_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,204,255));
   public JButton [] buttons;
    /**
     * Creates new form FrmHeThong
     */
    public FrmHeThong() {
        initComponents();
        //addBorder();
        setButtonBorder(btn_tab_HeThong);
    }

//    public void addBorder(){
//        buttons = new JButton[2];
//        
//        //Form san pham
//        buttons[0] = btn_tab_dsncc;
//        buttons[1] = btn_tab_tkncc;
//        
//   
//        setButtonBorder(btn_tab_HeThong);
//
//        addAction();
//    }
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

        pnl_FormHeThong = new javax.swing.JPanel();
        lbl_text_HeThong = new javax.swing.JLabel();
        pnl_menuTab_HeThong = new javax.swing.JPanel();
        btn_tab_HeThong = new javax.swing.JButton();
        pnl_tab_FormHeThong = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1090, 700));

        pnl_FormHeThong.setBackground(new java.awt.Color(255, 255, 255));
        pnl_FormHeThong.setPreferredSize(new java.awt.Dimension(1090, 700));
        pnl_FormHeThong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_HeThong.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_HeThong.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_HeThong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_HeThong.setText("Hệ Thống");
        pnl_FormHeThong.add(lbl_text_HeThong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_menuTab_HeThong.setBackground(new java.awt.Color(255, 255, 255));

        btn_tab_HeThong.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_HeThong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_HeThong.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_HeThong.setText("Phân Quyền Người Dùng");
        btn_tab_HeThong.setBorder(null);
        btn_tab_HeThong.setContentAreaFilled(false);
        btn_tab_HeThong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_HeThongMouseClicked(evt);
            }
        });
        btn_tab_HeThong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_HeThongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_HeThongLayout = new javax.swing.GroupLayout(pnl_menuTab_HeThong);
        pnl_menuTab_HeThong.setLayout(pnl_menuTab_HeThongLayout);
        pnl_menuTab_HeThongLayout.setHorizontalGroup(
            pnl_menuTab_HeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_HeThongLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_HeThong)
                .addContainerGap(853, Short.MAX_VALUE))
        );
        pnl_menuTab_HeThongLayout.setVerticalGroup(
            pnl_menuTab_HeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_HeThongLayout.createSequentialGroup()
                .addComponent(btn_tab_HeThong, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_FormHeThong.add(pnl_menuTab_HeThong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 50));

        pnl_tab_FormHeThong.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout pnl_tab_FormHeThongLayout = new javax.swing.GroupLayout(pnl_tab_FormHeThong);
        pnl_tab_FormHeThong.setLayout(pnl_tab_FormHeThongLayout);
        pnl_tab_FormHeThongLayout.setHorizontalGroup(
            pnl_tab_FormHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        pnl_tab_FormHeThongLayout.setVerticalGroup(
            pnl_tab_FormHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        pnl_FormHeThong.add(pnl_tab_FormHeThong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1090, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormHeThong, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormHeThong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tab_HeThongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_HeThongMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_HeThongMouseClicked

    private void btn_tab_HeThongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_HeThongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_HeThongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tab_HeThong;
    private javax.swing.JLabel lbl_text_HeThong;
    private javax.swing.JPanel pnl_FormHeThong;
    private javax.swing.JPanel pnl_menuTab_HeThong;
    private javax.swing.JPanel pnl_tab_FormHeThong;
    // End of variables declaration//GEN-END:variables
}
