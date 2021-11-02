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
public class FrmNhanVien extends javax.swing.JPanel {
    public  Border default_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,153,153));
   public Border active_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,204,255));
   public JButton [] buttons;

    /**
     * Creates new form FrmNhanVien
     */
    public FrmNhanVien() {
        initComponents();
        addBorder();
    }

    public void addBorder(){
        buttons = new JButton[4];
        
          buttons[0] =btn_tab_NV;
        buttons[1] =btn_tab_CaLam;
        buttons[2] = btn_tab_Luong;
        buttons[3] = btn_tab_TkNV;
        
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
        btn_tab_TkNV = new javax.swing.JButton();
        pnl_tab_FormTTNhanVien = new javax.swing.JPanel();
        pnl_tab_FormCaLam = new javax.swing.JPanel();
        pnl_tab_FormLuong = new javax.swing.JPanel();
        pnl_tab_FormTKNV = new javax.swing.JPanel();

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

        btn_tab_TkNV.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_TkNV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_TkNV.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_TkNV.setText("Tìm Kiếm Nhân Viên");
        btn_tab_TkNV.setBorder(null);
        btn_tab_TkNV.setContentAreaFilled(false);
        btn_tab_TkNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_TkNVMouseClicked(evt);
            }
        });
        btn_tab_TkNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_TkNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_NhanVienLayout = new javax.swing.GroupLayout(pnl_menuTab_NhanVien);
        pnl_menuTab_NhanVien.setLayout(pnl_menuTab_NhanVienLayout);
        pnl_menuTab_NhanVienLayout.setHorizontalGroup(
            pnl_menuTab_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_NhanVienLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_NV)
                .addGap(65, 65, 65)
                .addComponent(btn_tab_TkNV)
                .addGap(65, 65, 65)
                .addComponent(btn_tab_CaLam)
                .addGap(65, 65, 65)
                .addComponent(btn_tab_Luong)
                .addContainerGap(451, Short.MAX_VALUE))
        );
        pnl_menuTab_NhanVienLayout.setVerticalGroup(
            pnl_menuTab_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_NhanVienLayout.createSequentialGroup()
                .addGroup(pnl_menuTab_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_menuTab_NhanVienLayout.createSequentialGroup()
                        .addComponent(btn_tab_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_tab_CaLam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tab_Luong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tab_TkNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_FormNhanVien.add(pnl_menuTab_NhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 50));

        pnl_tab_FormTTNhanVien.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout pnl_tab_FormTTNhanVienLayout = new javax.swing.GroupLayout(pnl_tab_FormTTNhanVien);
        pnl_tab_FormTTNhanVien.setLayout(pnl_tab_FormTTNhanVienLayout);
        pnl_tab_FormTTNhanVienLayout.setHorizontalGroup(
            pnl_tab_FormTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        pnl_tab_FormTTNhanVienLayout.setVerticalGroup(
            pnl_tab_FormTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        pnl_FormNhanVien.add(pnl_tab_FormTTNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1300, 620));

        pnl_tab_FormCaLam.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout pnl_tab_FormCaLamLayout = new javax.swing.GroupLayout(pnl_tab_FormCaLam);
        pnl_tab_FormCaLam.setLayout(pnl_tab_FormCaLamLayout);
        pnl_tab_FormCaLamLayout.setHorizontalGroup(
            pnl_tab_FormCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        pnl_tab_FormCaLamLayout.setVerticalGroup(
            pnl_tab_FormCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        pnl_FormNhanVien.add(pnl_tab_FormCaLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1300, 620));

        pnl_tab_FormLuong.setBackground(new java.awt.Color(153, 153, 0));

        javax.swing.GroupLayout pnl_tab_FormLuongLayout = new javax.swing.GroupLayout(pnl_tab_FormLuong);
        pnl_tab_FormLuong.setLayout(pnl_tab_FormLuongLayout);
        pnl_tab_FormLuongLayout.setHorizontalGroup(
            pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        pnl_tab_FormLuongLayout.setVerticalGroup(
            pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        pnl_FormNhanVien.add(pnl_tab_FormLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1300, 620));

        pnl_tab_FormTKNV.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout pnl_tab_FormTKNVLayout = new javax.swing.GroupLayout(pnl_tab_FormTKNV);
        pnl_tab_FormTKNV.setLayout(pnl_tab_FormTKNVLayout);
        pnl_tab_FormTKNVLayout.setHorizontalGroup(
            pnl_tab_FormTKNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        pnl_tab_FormTKNVLayout.setVerticalGroup(
            pnl_tab_FormTKNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        pnl_FormNhanVien.add(pnl_tab_FormTKNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1300, 620));

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
        pnl_tab_FormTKNV.setVisible(false);
    }//GEN-LAST:event_btn_tab_NVMouseClicked

    private void btn_tab_NVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_NVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_NVActionPerformed

    private void btn_tab_CaLamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_CaLamMouseClicked
        // TODO add your handling code here:
        pnl_tab_FormTTNhanVien.setVisible(false);
        pnl_tab_FormCaLam.setVisible(true);
        pnl_tab_FormLuong.setVisible(false);
        pnl_tab_FormTKNV.setVisible(false);
    }//GEN-LAST:event_btn_tab_CaLamMouseClicked

    private void btn_tab_LuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_LuongMouseClicked
        // TODO add your handling code here:
        pnl_tab_FormTTNhanVien.setVisible(false);
        pnl_tab_FormCaLam.setVisible(false);
        pnl_tab_FormLuong.setVisible(true);
        pnl_tab_FormTKNV.setVisible(false);
    }//GEN-LAST:event_btn_tab_LuongMouseClicked

    private void btn_tab_TkNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_TkNVMouseClicked
        pnl_tab_FormTKNV.setVisible(true);
        pnl_tab_FormTTNhanVien.setVisible(false);
        pnl_tab_FormCaLam.setVisible(false);
        pnl_tab_FormLuong.setVisible(false);
    }//GEN-LAST:event_btn_tab_TkNVMouseClicked

    private void btn_tab_TkNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_TkNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_TkNVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tab_CaLam;
    private javax.swing.JButton btn_tab_Luong;
    private javax.swing.JButton btn_tab_NV;
    private javax.swing.JButton btn_tab_TkNV;
    private javax.swing.JLabel lbl_text_NhanVien;
    private javax.swing.JPanel pnl_FormNhanVien;
    private javax.swing.JPanel pnl_menuTab_NhanVien;
    private javax.swing.JPanel pnl_tab_FormCaLam;
    private javax.swing.JPanel pnl_tab_FormLuong;
    private javax.swing.JPanel pnl_tab_FormTKNV;
    private javax.swing.JPanel pnl_tab_FormTTNhanVien;
    // End of variables declaration//GEN-END:variables
}
