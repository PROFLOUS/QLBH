/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Connect.connect;
import dao.HoaDonDao;
import dao.HoaDonNhapDao;
import entity.HoaDonBanHang;
import entity.HoaDonNhap;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class FrmHoaDonNhapHang extends javax.swing.JPanel {
private javax.swing.table.DefaultTableModel modelTBHoaDon;
private ArrayList<HoaDonNhap> listHoaDon ;
  
    public FrmHoaDonNhapHang()throws SQLException {
        
        initComponents();
        listHoaDon = new ArrayList<HoaDonNhap>();
        try {
            connect.getInstance().connect();
        
            renderListHoaDon();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//dua du lieu HoaDon len Table
	public void renderListHoaDon() {
		          HoaDonNhapDao hoaDonNhapDao = new HoaDonNhapDao();
                 String[] title = { "MaHD", "Ngày Tạo", "Nhà Cung Cấp", "Số lượng", "Tổng Tiền", "Nhân Viên", "Ghi Chú"};
		 listHoaDon  = hoaDonNhapDao.getDsHoaDonNhap();
                System.out.print(listHoaDon.size());
                 modelTBHoaDon = new DefaultTableModel(title,0);
                int i = 0;
		for(HoaDonNhap s : listHoaDon) {
                   //  System.out.print(i++);
			String[] rowData = {
				s.getMaHDNhap(),changeDateToString(s.getNgayLapHD()),s.getNCC().getTenNCC(),String.valueOf(s.getSoLuong()),String.valueOf(s.getTongTien()),
                            s.getNhanVien().getTenNV(),s.getGhiChu()
			};
                       
			modelTBHoaDon.addRow(rowData);
                        
		}
               
		tbHoaDon.setModel(modelTBHoaDon);
                lblNumHD.setText(String.valueOf(listHoaDon.size()));
                
	}
        
        public String changeDateToString(Date date){
            
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String dateString  = df.format(date);
                return dateString;
          }
        public void xoaModel() {
        DefaultTableModel del = (DefaultTableModel) tbHoaDon.getModel();
        del.getDataVector().removeAllElements();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtSearchHD = new javax.swing.JTextField();
        btnShowHD = new javax.swing.JButton();
        btnSearchHD = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNumHD = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();

        jPanel1.setBackground(java.awt.Color.white);

        txtSearchHD.setBackground(java.awt.Color.white);
        txtSearchHD.setText("Nhập mã hóa đơn...");
        txtSearchHD.setToolTipText("");
        txtSearchHD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchHDFocusGained(evt);
            }
        });
        txtSearchHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchHDActionPerformed(evt);
            }
        });

        btnShowHD.setBackground(new java.awt.Color(21, 151, 229));
        btnShowHD.setForeground(java.awt.Color.white);
        btnShowHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/clipboard.png"))); // NOI18N
        btnShowHD.setText("Hiển thị Hóa Đơn");
        btnShowHD.setToolTipText("");
        btnShowHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowHD.setEnabled(false);
        btnShowHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowHDMouseClicked(evt);
            }
        });

        btnSearchHD.setBackground(new java.awt.Color(21, 151, 229));
        btnSearchHD.setForeground(java.awt.Color.white);
        btnSearchHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search_1.png"))); // NOI18N
        btnSearchHD.setText("Tìm Kiếm");
        btnSearchHD.setToolTipText("");
        btnSearchHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchHD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnSearchHDMouseDragged(evt);
            }
        });
        btnSearchHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchHDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchHDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchHDMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSearchHDMousePressed(evt);
            }
        });
        btnSearchHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHDActionPerformed(evt);
            }
        });

        jLabel1.setText("Số Hóa Đơn: ");

        lblNumHD.setText("2");

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/reloading.png"))); // NOI18N
        jButton1.setToolTipText("Tải lại danh sách");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 375, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnShowHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblNumHD)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowHD, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(lblNumHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearchHD)
                    .addComponent(btnSearchHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tbHoaDon.setBackground(java.awt.Color.white);
        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbHoaDon.setRowHeight(28);
        tbHoaDon.setShowGrid(true);
        tbHoaDon.setUpdateSelectionOnSort(false);
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void txtSearchHDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchHDFocusGained
        txtSearchHD.setText("");
    }//GEN-LAST:event_txtSearchHDFocusGained

    private void btnShowHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowHDMouseClicked
        btnShowHD.setEnabled(false);
//        renderListHoaDon();
    }//GEN-LAST:event_btnShowHDMouseClicked

    private void btnSearchHDMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchHDMouseDragged
        // TODO add your handling code here:
        btnShowHD.setBackground(new java.awt.Color(17, 60, 252));
    }//GEN-LAST:event_btnSearchHDMouseDragged

    private void btnSearchHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchHDMouseClicked
        String text = txtSearchHD.getText();
        AtomicBoolean check = new AtomicBoolean();
        HoaDonNhapDao hoaDonNhapDao = new HoaDonNhapDao();

        ArrayList<HoaDonNhap> listHoaDon  = hoaDonNhapDao.getDsHoaDonNhap();

        listHoaDon.forEach(s ->{
            if(s.getMaHDNhap().toUpperCase().equals(text.toUpperCase())){
                check.set(true);
                String[] title = { "MaHD", "Ngày Tạo", "Nhà Cung Cấp", "Số lượng", "Tổng Tiền", "Nhân Viên", "Ghi Chú"};
                modelTBHoaDon = new DefaultTableModel(title,0);
                String[] rowData = {
                    s.getMaHDNhap(),changeDateToString(s.getNgayLapHD()),s.getNCC().getTenNCC(),String.valueOf(s.getSoLuong()),String.valueOf(s.getTongTien()),
                   s.getNhanVien().getTenNV(),s.getGhiChu()
                };
                modelTBHoaDon.addRow(rowData);
                tbHoaDon.setModel(modelTBHoaDon);
                btnShowHD.setEnabled(true);
            }
        });
        if(!check.get()){
            JOptionPane.showMessageDialog(btnSearchHD, "Không có Hóa Đơn có mã:" + text + " " );
        }
    }//GEN-LAST:event_btnSearchHDMouseClicked

    private void btnSearchHDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchHDMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchHDMouseEntered

    private void btnSearchHDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchHDMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_btnSearchHDMouseExited

    private void btnSearchHDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchHDMousePressed
        // TODO add your handling code here:

        btnShowHD.setBackground(new java.awt.Color(17, 60, 252));
    }//GEN-LAST:event_btnSearchHDMousePressed

    private void btnSearchHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchHDActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        listHoaDon.removeAll(listHoaDon);
        xoaModel();
        renderListHoaDon();
    }//GEN-LAST:event_jButton1MouseClicked

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        // lay ra row vua click
        int row = tbHoaDon.getSelectedRow();
        //lay ra MaHD
        String maHD = tbHoaDon.getValueAt(row, 0).toString();
        //JOptionPane.showMessageDialog(jPanel1, maHD);
        new FrmCT_HoaDonNhap(maHD).setVisible(true);
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void txtSearchHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchHDActionPerformed
//         String text = txtSearchHD.getText();
//        AtomicBoolean check = new AtomicBoolean();
//        HoaDonNhapDao hoaDonDao = new HoaDonNhapDao();
//
//        ArrayList<HoaDonNhap> listHoaDon  = hoaDonDao.getDsHoaDonNhap();
//
//        listHoaDon.forEach(s ->{
//            if(s.getMaHDNhap().toUpperCase().equals(text.toUpperCase())){
//                check.set(true);
//                String[] title = { "MaHD", "Ngày Tạo", "Khách Hàng", "Số lượng", "Tổng Tiền", "Tiền Khách Đưa", "Nhân Viên", "Ghi Chú"};
//                modelTBHoaDon = new DefaultTableModel(title,0);
//                String[] rowData = {
//                    s.getMaHDNhap(),changeDateToString(s.getNgayLapHD()),s.getKhachHang().getTenKH(),String.valueOf(s.getSoLuong()),String.valueOf(s.getTongTien()),
//                    String.valueOf(s.ge),s.getNhanVien().getTenNV(),s.getGhiChu()
//                };
//                modelTBHoaDon.addRow(rowData);
//                tbHoaDon.setModel(modelTBHoaDon);
//                btnShowHD.setEnabled(true);
//            }
//        });
//        if(!check.get()){
//            JOptionPane.showMessageDialog(btnSearchHD, "Không có Hóa Đơn có mã:" + text + " " );
//        }
    }//GEN-LAST:event_txtSearchHDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchHD;
    private javax.swing.JButton btnShowHD;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNumHD;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTextField txtSearchHD;
    // End of variables declaration//GEN-END:variables
}
