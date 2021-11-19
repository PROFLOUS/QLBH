/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SanPham;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RAVEN
 */
public class Search_Item extends javax.swing.JPanel {
    private DefaultTableModel dfsp_model;
  
    public Search_Item(SanPham data) {
        initComponents();
        setData(data);
    }

    private void setData(SanPham data) {
        addEventMouse(this);
        addEventMouse(lbl_TenSp);
//        addEventMouse(lbRemove);
//        ImageIcon image = new ImageIcon(data.getHinhAnh());
////        lbl_ImgSp = new JLabel( image, JLabel.CENTER);
//        Image img = image.getImage();
//        Image newImg = img.getScaledInstance(lbl_ImgSp.getWidth(), lbl_ImgSp.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon newImc = new ImageIcon(newImg);
//        lbl_ImgSp.setIcon(newImc);
//        lbl_ImgSp.setIcon(new ImageIcon(getClass().getResource("D:ImgSp\\quanJean_daibang.jpg")));
        
//        lbl_ImgSp.setIcon(new javax.swing.ImageIcon(getClass().getResource(data.getHinhAnh()))); // NOI18N
        lbl_ImgSp.setIcon(new ImageIcon(new ImageIcon(data.getHinhAnh()).getImage().getScaledInstance(77, 73, Image.SCALE_DEFAULT)));
        lbl_TenSp.setText(data.getTenSP());
        lbl_MauSac.setText(data.getMauSac());
        lbl_Gia.setText(data.getDonGia().toString());
        lbl_SoLuong.setText("sl: "+Integer.toString(data.getSoLuong()));
        lbl_size.setText(data.getSize());
        lbl_MaSp.setText(data.getMaSP());
        lbl_SoLuong1.setText(data.getGiaNhap().toString());
        
        
    }

    private void addEventMouse(Component com) {
        com.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                //hover
                setBackground(new Color(215, 216, 216));
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(Color.WHITE);
            }

        });
    }

    private ActionListener eventClick;
    

    public void addEvent(ActionListener eventClick) {
        this.eventClick = eventClick;
    }
    
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_TenSp = new javax.swing.JLabel();
        lbl_ImgSp = new javax.swing.JLabel();
        lbl_Gia = new javax.swing.JLabel();
        lbl_SoLuong = new javax.swing.JLabel();
        lbl_MauSac = new javax.swing.JLabel();
        lbl_size = new javax.swing.JLabel();
        lbl_MaSp = new javax.swing.JLabel();
        lbl_SoLuong1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 153, 255)));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lbl_TenSp.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_TenSp.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TenSp.setText("Text ...");
        lbl_TenSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_TenSpMouseClicked(evt);
            }
        });

        lbl_ImgSp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ImgSp.setPreferredSize(new java.awt.Dimension(77, 69));

        lbl_Gia.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_Gia.setForeground(new java.awt.Color(102, 153, 255));
        lbl_Gia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_Gia.setText("200000");

        lbl_SoLuong.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_SoLuong.setForeground(new java.awt.Color(51, 51, 51));
        lbl_SoLuong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_SoLuong.setText("99");

        lbl_MauSac.setBackground(new java.awt.Color(153, 153, 153));
        lbl_MauSac.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_MauSac.setForeground(new java.awt.Color(51, 51, 51));
        lbl_MauSac.setText("Color");

        lbl_size.setBackground(new java.awt.Color(153, 153, 153));
        lbl_size.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_size.setForeground(new java.awt.Color(51, 51, 51));
        lbl_size.setText("size");

        lbl_MaSp.setForeground(new java.awt.Color(255, 255, 255));

        lbl_SoLuong1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_SoLuong1.setForeground(new java.awt.Color(51, 51, 51));
        lbl_SoLuong1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_SoLuong1.setText("99");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_ImgSp, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_size, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_MaSp))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_TenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_SoLuong1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lbl_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_TenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_Gia))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_SoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_MauSac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_SoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_size, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_MaSp)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_ImgSp, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_TenSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TenSpMouseClicked
//         System.out.println("ok");
    }//GEN-LAST:event_lbl_TenSpMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
//        System.out.println("click");
        eventClick.actionPerformed(null);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_Gia;
    private javax.swing.JLabel lbl_ImgSp;
    private javax.swing.JLabel lbl_MaSp;
    private javax.swing.JLabel lbl_MauSac;
    private javax.swing.JLabel lbl_SoLuong;
    private javax.swing.JLabel lbl_SoLuong1;
    private javax.swing.JLabel lbl_TenSp;
    private javax.swing.JLabel lbl_size;
    // End of variables declaration//GEN-END:variables
}
