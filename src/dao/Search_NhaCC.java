/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KhachHang;
import entity.NhaCC;

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
public class Search_NhaCC extends javax.swing.JPanel {
    
  
    public Search_NhaCC(NhaCC data) {
        initComponents();
        setData(data);
    }

    private void setData(NhaCC data) {
        addEventMouse(this);
        addEventMouse(lbl_NCC);
//        addEventMouse(lbRemove);
        lbl_NCC.setText(data.getTenNCC());
        lbl_SDT.setText(data.getSdt());
        lbl_MaNcc.setText(data.getMaNCC());
        lbl_DiaChi.setText(data.getDiaChi());
        
        
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_NCC = new javax.swing.JLabel();
        lbl_SDT = new javax.swing.JLabel();
        lbl_MaNcc = new javax.swing.JLabel();
        lbl_DiaChi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 153, 255)));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lbl_NCC.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_NCC.setForeground(new java.awt.Color(0, 0, 0));
        lbl_NCC.setText("Text ...");
        lbl_NCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_NCCMouseClicked(evt);
            }
        });

        lbl_SDT.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        lbl_SDT.setForeground(new java.awt.Color(102, 153, 255));
        lbl_SDT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_SDT.setText("0125478598");

        lbl_MaNcc.setForeground(new java.awt.Color(255, 255, 255));

        lbl_DiaChi.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_DiaChi.setForeground(new java.awt.Color(0, 0, 0));
        lbl_DiaChi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_DiaChi.setText("Láng Hạ Chùa Láng HN");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/smartphone.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/address.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbl_NCC, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_MaNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_NCC)
                    .addComponent(lbl_MaNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(lbl_DiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_SDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_NCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_NCCMouseClicked
//         System.out.println("ok");
    }//GEN-LAST:event_lbl_NCCMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
//        System.out.println("click");
        eventClick.actionPerformed(null);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_DiaChi;
    private javax.swing.JLabel lbl_MaNcc;
    private javax.swing.JLabel lbl_NCC;
    private javax.swing.JLabel lbl_SDT;
    // End of variables declaration//GEN-END:variables
}
