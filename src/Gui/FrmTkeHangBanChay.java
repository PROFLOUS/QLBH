/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Connect.connect;
import static Gui.FrmDangNhap.quyen;
import static Gui.GD_Chinh.lbl_title_TaiKhoan1;

import dao.CT_HoaDonDao;
import dao.DanhMucSPDao;
import entity.CT_HDBanHang;
import entity.DanhMucSP;
import entity.HoaDonBanHang;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HP
 */
public class FrmTkeHangBanChay extends javax.swing.JPanel {
private DefaultTableModel dftkSp_Model;
ArrayList<CT_HDBanHang> dstkSp;
    CT_HoaDonDao cthdDao;
DanhMucSPDao dmDao ;
private Date date = new Date();
private Date date2 = new Date(2021,11,15);
private SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
private SimpleDateFormat formatterMonth = new SimpleDateFormat("MM");
private SimpleDateFormat formatterday = new SimpleDateFormat("dd");
    public FrmTkeHangBanChay() {
        initComponents();
        dstkSp = new ArrayList<CT_HDBanHang>();
        cthdDao = new CT_HoaDonDao();
        locBieuDo();


        if(quyen.equals("Nhân viên")){
            jComboBox1_2.removeAllItems();
            jComboBox1_2.addItem("Ngày");
            jComboBox1_2.setEnabled(false);
        }
        
    }
    
        //lọc thôngn kê theo ngày, thang , năm
    public void locBieuDo(){
        if(jComboBox1_2.getSelectedIndex()==2){
           String year = (String) formatterYear.format(date);
            dstkSp.removeAll(dstkSp);
            xoaModelChiTiet();
            upTblChiTietTheoNam(year);
            xoaBieuDo();
            bieuDo(10000);
            jLabel7.setText("500");
        jLabel11.setText("3.000");
        jLabel12.setText("5.000");
        jLabel13.setText("10.000");
        jLabel14.setText("8.000");
        jLabel17.setText("trong Năm");
        }else if(jComboBox1_2.getSelectedIndex()==1){
            String month = (String) formatterMonth.format(date);
            String year = (String) formatterYear.format(date);
            dstkSp.removeAll(dstkSp);
            xoaModelChiTiet();
            upTblChiTietTheoThang(month,year);
            xoaBieuDo();
            bieuDo(1000);
            jLabel7.setText("50");
        jLabel11.setText("300");
        jLabel12.setText("500");
        jLabel13.setText("1.000");
        jLabel14.setText("800");
        jLabel17.setText("trong Tháng");
        }else if(jComboBox1_2.getSelectedIndex()==0){
             String day = (String) formatterday.format(date);
             String month = (String) formatterMonth.format(date);
            String year = (String) formatterYear.format(date);
            dstkSp.removeAll(dstkSp);
            xoaModelChiTiet();
            upTblChiTietTheoNgay(day,month,year);
            xoaBieuDo();
            bieuDo(100);
            jLabel7.setText("5");
        jLabel11.setText("30");
        jLabel12.setText("50");
        jLabel13.setText("100");
        jLabel14.setText("80");
        jLabel17.setText("trong Ngày");
        }
    
    }
    
    //đọc dữ liệu lene chi tiet
    public void upTblChiTietTheoNam(String year) {
        dmDao = new DanhMucSPDao();
        dftkSp_Model = (DefaultTableModel) jTable1.getModel();
        dstkSp = cthdDao.thongkeSpTheoNam(year);
        for (CT_HDBanHang ct : dstkSp) {
            DanhMucSP dm =dmDao.getDMmaSp(ct.getSanPham().getMaSP());
            dftkSp_Model.addRow(new Object[]{
                ct.getSanPham().getMaSP(),ct.getSanPham().getTenSP(),dm.getTenLoai(),
                ct.getDonGia(),ct.getSoLuong()
            });
        }
    }
    public void upTblChiTietTheoThang(String month,String year) {
        dmDao = new DanhMucSPDao();
        dftkSp_Model = (DefaultTableModel) jTable1.getModel();
        dstkSp = cthdDao.thongkeSpTheoThang(month,year);
        for (CT_HDBanHang ct : dstkSp) {
            DanhMucSP dm =dmDao.getDMmaSp(ct.getSanPham().getMaSP());
            dftkSp_Model.addRow(new Object[]{
                ct.getSanPham().getMaSP(),ct.getSanPham().getTenSP(),dm.getTenLoai(),
                ct.getDonGia(),ct.getSoLuong()
            });
        }
    }
    public void upTblChiTietTheoNgay(String day,String month, String year) {
        dmDao = new DanhMucSPDao();
        dftkSp_Model = (DefaultTableModel) jTable1.getModel();
        dstkSp = cthdDao.thongkeSpTheoNgay(day,month,year);
        for (CT_HDBanHang ct : dstkSp) {
            DanhMucSP dm =dmDao.getDMmaSp(ct.getSanPham().getMaSP());
            dftkSp_Model.addRow(new Object[]{
                ct.getSanPham().getMaSP(),ct.getSanPham().getTenSP(),dm.getTenLoai(),
                ct.getDonGia(),ct.getSoLuong()
            });
        }
    }
    //xóa model bảng chi tiết
    public void xoaModelChiTiet(){
        DefaultTableModel del = (DefaultTableModel) jTable1.getModel();
        del.getDataVector().removeAllElements();
    }
    //xoa bieu do 
    public void xoaBieuDo(){
        jLabel3.setText("");
            jProgressBar2.setValue(0);
            jProgressBar2.setString("");
            jLabel4.setText("");
            jProgressBar1.setValue(0);
            jProgressBar1.setString("");
            jLabel5.setText("");
            jProgressBar3.setValue(0);
            jProgressBar3.setString("");
            jLabel6.setText("");
            jProgressBar4.setValue(0);
            jProgressBar4.setString("");
            jLabel8.setText("");
            jProgressBar5.setValue(0);
            jProgressBar5.setString("");
            jLabel9.setText("");
            jProgressBar6.setValue(0);
            jProgressBar6.setString("");
            jLabel10.setText("");
            jProgressBar7.setValue(0);
            jProgressBar7.setString("");
    }
    //thống kê khach hang có tong tien cao nhat
    public void bieuDo(int max){
        try {
        jLabel3.setText(jTable1.getValueAt(0, 0).toString());
        jLabel3.setToolTipText(jTable1.getValueAt(0, 1).toString());
        jProgressBar2.setMaximum(max);
        int tk1= (int) Double.parseDouble(jTable1.getValueAt(0, 4).toString());
        jProgressBar2.setValue(tk1);
        jProgressBar2.setToolTipText(String.valueOf(tk1));
        
        jLabel4.setText(jTable1.getValueAt(1, 0).toString());
        jLabel4.setToolTipText(jTable1.getValueAt(1, 1).toString());
        jProgressBar1.setMaximum(max);
        int tk2= (int) Double.parseDouble(jTable1.getValueAt(1, 4).toString());
        jProgressBar1.setValue(tk2);
        jProgressBar1.setToolTipText(String.valueOf(tk2));
        
        jLabel5.setText(jTable1.getValueAt(2, 0).toString());
        jLabel5.setToolTipText(jTable1.getValueAt(2, 1).toString());
        jProgressBar3.setMaximum(max);
        int tk3= (int) Double.parseDouble(jTable1.getValueAt(2, 4).toString());
        jProgressBar3.setValue(tk3);
        jProgressBar3.setToolTipText(String.valueOf(tk3));
        
        jLabel6.setText(jTable1.getValueAt(3, 0).toString());
        jLabel6.setToolTipText(jTable1.getValueAt(3, 1).toString());
        jProgressBar4.setMaximum(max);
        int tk4= (int) Double.parseDouble(jTable1.getValueAt(3, 4).toString());
        jProgressBar4.setValue(tk4);
        jProgressBar4.setToolTipText(String.valueOf(tk4));
        
        jLabel8.setText(jTable1.getValueAt(4, 0).toString());
        jLabel8.setToolTipText(jTable1.getValueAt(4, 1).toString());
        jProgressBar5.setMaximum(max);
        int tk5= (int) Double.parseDouble(jTable1.getValueAt(4, 4).toString());
        jProgressBar5.setValue(tk5);
        jProgressBar5.setToolTipText(String.valueOf(tk5));
        
        jLabel9.setText(jTable1.getValueAt(5, 0).toString());
        jLabel9.setToolTipText(jTable1.getValueAt(5, 1).toString());
        jProgressBar6.setMaximum(max);
        int tk6= (int) Double.parseDouble(jTable1.getValueAt(5, 4).toString());
        jProgressBar6.setValue(tk6);
        jProgressBar6.setToolTipText(String.valueOf(tk6));
        
        jLabel10.setText(jTable1.getValueAt(6, 0).toString());
        jLabel10.setToolTipText(jTable1.getValueAt(6, 1).toString());
        jProgressBar7.setMaximum(max);
        int tk7= (int) Double.parseDouble(jTable1.getValueAt(6, 4).toString());
        jProgressBar7.setValue(tk7);
        jProgressBar7.setToolTipText(String.valueOf(tk7));
        } catch (Exception e) {
        }
        
    }
    //xuất ra file ex
    public void exportDataToExcel() {
        try{
           JFileChooser jFileChooser = new JFileChooser("C:\\\\Users\\\\HP\\\\OneDrive\\\\Máy tính\\\\QLBH");
           jFileChooser.showSaveDialog(this);
           File saveFile = jFileChooser.getSelectedFile();
           
           if(saveFile != null){
               saveFile = new File(saveFile.toString()+".xlsx");
               Workbook wb = new XSSFWorkbook();
               Sheet sheet = wb.createSheet("Sảm Phẩm");
               
               Row rowCol = sheet.createRow(0);
               for(int i=0;i<jTable1.getColumnCount();i++){
                   Cell cell = rowCol.createCell(i);
                   cell.setCellValue(jTable1.getColumnName(i));
               }
               
               for(int j=0;j<jTable1.getRowCount();j++){
                   Row row = sheet.createRow(j);
                   for(int k=0;k<jTable1.getColumnCount();k++){
                       Cell cell = row.createCell(k);
                       if(jTable1.getValueAt(j, k)!=null){
                           cell.setCellValue(jTable1.getValueAt(j, k).toString());
                       }
                   }
               }
               FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
               wb.write(out);
               wb.close();
               out.close();
               JOptionPane.showMessageDialog(null,"Xuất Thành Công");
               openFile(saveFile.toString());
           }else{
               JOptionPane.showMessageDialog(null,"Error");
           }
       }catch(FileNotFoundException e){
           System.out.println(e);
       }catch(IOException io){
           System.out.println(io);
       }
    } 
     public void openFile(String file){
        try{
            File path = new File(file);
            Desktop.getDesktop().open(path);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
      //Tạo hàm xuất hóa đơn
    public void printBill(String date,String month,String year,String source){
        try {
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport(source);
            map.put("date", date);
            map.put("month", month);
            map.put("year", year);
            JasperPrint p = JasperFillManager.fillReport(report,  map, connect.getConnection() );
            JasperViewer.viewReport(p, false);
           // JasperExportManager.exportReportToPdfFile(p, "test.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_tab_FormTKhbc = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1_2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        jProgressBar5 = new javax.swing.JProgressBar();
        jProgressBar6 = new javax.swing.JProgressBar();
        jProgressBar7 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Lọc Theo");

        jComboBox1_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm" }));
        jComboBox1_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1_2MouseClicked(evt);
            }
        });
        jComboBox1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(40, 196, 80));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Xuất File");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(37, 186, 229));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("In Báo Cáo");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1090, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("SP001");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 25));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("SP001");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 50, 24));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jProgressBar2.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jProgressBar2.setForeground(new java.awt.Color(0, 204, 204));
        jProgressBar2.setToolTipText("");
        jProgressBar2.setValue(100);
        jProgressBar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jProgressBar2MouseExited(evt);
            }
        });
        jPanel3.add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 14, 922, 25));

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(0, 204, 204));
        jProgressBar1.setToolTipText("");
        jProgressBar1.setValue(100);
        jProgressBar1.setBorder(null);
        jPanel3.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 60, 922, 25));

        jProgressBar3.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar3.setForeground(new java.awt.Color(0, 204, 204));
        jProgressBar3.setToolTipText("");
        jProgressBar3.setValue(100);
        jProgressBar3.setBorder(null);
        jPanel3.add(jProgressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 110, 922, 25));

        jProgressBar4.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar4.setForeground(new java.awt.Color(0, 204, 204));
        jProgressBar4.setToolTipText("");
        jProgressBar4.setValue(30);
        jProgressBar4.setAutoscrolls(true);
        jProgressBar4.setBorder(null);
        jPanel3.add(jProgressBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 160, 922, 25));

        jProgressBar5.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jProgressBar5.setForeground(new java.awt.Color(0, 204, 204));
        jProgressBar5.setToolTipText("");
        jProgressBar5.setValue(80);
        jProgressBar5.setAutoscrolls(true);
        jProgressBar5.setBorder(null);
        jPanel3.add(jProgressBar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 210, 922, 25));

        jProgressBar6.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar6.setForeground(new java.awt.Color(0, 204, 204));
        jProgressBar6.setToolTipText("");
        jProgressBar6.setValue(20);
        jProgressBar6.setBorder(null);
        jPanel3.add(jProgressBar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 260, 922, 25));

        jProgressBar7.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar7.setForeground(new java.awt.Color(0, 204, 204));
        jProgressBar7.setToolTipText("");
        jProgressBar7.setValue(5);
        jProgressBar7.setBorder(null);
        jPanel3.add(jProgressBar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 310, 922, 25));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 922, 358));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("SP001");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 50, 24));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("SP001");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 50, 24));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("SP001");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 50, 24));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("SP001");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 50, 24));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("SP001");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 50, 24));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("500");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 400, 50, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("3.000");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 60, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("5.000");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, 60, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("10.000");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 400, 60, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("8.000");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, 60, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Số lượng đã bán");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 434, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setForeground(new java.awt.Color(74, 136, 199));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 434, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Biểu đồ top 7 Sản Phẩm bán chạy ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 434, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("trong Năm");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 434, -1, -1));

        jLabel18.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 9, 25));

        jLabel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 9, 15));

        jLabel21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 380, 9, 15));

        jLabel22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 380, 9, 15));

        jLabel23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 9, 15));

        jTabbedPane1.addTab("Tổng Quan", jPanel1);

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Danh Mục", "Giá Bán", "Số Lượng Đã Bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 96, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Chi Tiết", jPanel2);

        javax.swing.GroupLayout pnl_tab_FormTKhbcLayout = new javax.swing.GroupLayout(pnl_tab_FormTKhbc);
        pnl_tab_FormTKhbc.setLayout(pnl_tab_FormTKhbcLayout);
        pnl_tab_FormTKhbcLayout.setHorizontalGroup(
            pnl_tab_FormTKhbcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(pnl_tab_FormTKhbcLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnl_tab_FormTKhbcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(pnl_tab_FormTKhbcLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_tab_FormTKhbcLayout.setVerticalGroup(
            pnl_tab_FormTKhbcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormTKhbcLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(pnl_tab_FormTKhbcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_tab_FormTKhbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_tab_FormTKhbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       exportDataToExcel();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        
        String year = (String) formatterYear.format(date);
        String month = (String) formatterMonth.format(date);
        String day = (String) formatterday.format(date);
        if(jComboBox1_2.getSelectedIndex()==2){
           
           String source = "src\\BaoCao/rptThongKeSamPhamNam.jrxml";
           printBill(year,month,day, source);
        }else if(jComboBox1_2.getSelectedIndex()==1){
            String source = "src\\BaoCao/rptThongKeSamPhamThang.jrxml";
           printBill(month,day,year, source);
            
        }else if(jComboBox1_2.getSelectedIndex()==0){
            String source = "src\\BaoCao/rptThongKeSamPhamNgay.jrxml";
           printBill(day,month,year, source);
            
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jProgressBar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBar2MouseEntered
        jProgressBar2.setForeground(new  Color(4,220,220));
    }//GEN-LAST:event_jProgressBar2MouseEntered

    private void jProgressBar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBar2MouseExited
        jProgressBar2.setForeground(new  Color(0,204,204));
    }//GEN-LAST:event_jProgressBar2MouseExited

    private void jComboBox1_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1_2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1_2MouseClicked

    private void jComboBox1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_2ActionPerformed
       locBieuDo();
       
    }//GEN-LAST:event_jComboBox1_2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1_2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JProgressBar jProgressBar6;
    private javax.swing.JProgressBar jProgressBar7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnl_tab_FormTKhbc;
    // End of variables declaration//GEN-END:variables
}
