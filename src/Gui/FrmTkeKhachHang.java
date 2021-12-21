/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Connect.connect;
import static Gui.FrmDangNhap.quyen;

import dao.HoaDonDao;
import entity.HoaDonBanHang;
import entity.SanPham;
import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hiển thị Giao diện Form Thống kê khách hàng mua nhiều
 *
 */
public class FrmTkeKhachHang extends javax.swing.JPanel {

    private DefaultTableModel dftkKH_Model;
    ArrayList<HoaDonBanHang> dstkKH;
    private Date date = new Date();
    private Date date2 = new Date(2021, 11, 15);
    private SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
    private SimpleDateFormat formatterMonth = new SimpleDateFormat("MM");
    private SimpleDateFormat formatterday = new SimpleDateFormat("dd");
    HoaDonDao hdDao;

    public FrmTkeKhachHang() {
        initComponents();
        dstkKH = new ArrayList<HoaDonBanHang>();
        hdDao = new HoaDonDao();
        try {
            connect.getInstance().connect();
            locBieuDo();
        } catch (Exception e) {
            System.out.println("loll");
            e.printStackTrace();
        }

        if (quyen.equals("Nhân viên")) {
            cb2.removeAllItems();
            cb2.addItem("Ngày");
            cb2.setEnabled(false);
        }

    }

    /**
     * Lọc biểu đồ theo ngày, tháng, năm
     *
     */
    public void locBieuDo() {
        if (cb2.getSelectedIndex() == 2) {
            System.out.println("okkk");
            String year = (String) formatterYear.format(date);
            dstkKH.removeAll(dstkKH);
            xoaModelChiTiet();
            upTblChiTietTheoNam(year);
            xoaBieuDo();
            bieuDo(1000000000);
            jLabel7.setText("50.000.000");
            jLabel11.setText("300.000.000");
            jLabel12.setText("500.000.000");
            jLabel13.setText("1.000.000.000");
            jLabel14.setText("800.000.000");
            jLabel17.setText("trong Năm");
        } else if (cb2.getSelectedIndex() == 1) {
            String month = (String) formatterMonth.format(date);
            String year = (String) formatterYear.format(date);
            dstkKH.removeAll(dstkKH);
            xoaModelChiTiet();
            upTblChiTietTheoThang(month, year);
            xoaBieuDo();
            bieuDo(100000000);
            jLabel7.setText("5.000.000");
            jLabel11.setText("30.000.000");
            jLabel12.setText("50.000.000");
            jLabel13.setText("100.000.000");
            jLabel14.setText("80.000.000");
            jLabel17.setText("trong Tháng");
        } else if (cb2.getSelectedIndex() == 0) {
            String day = (String) formatterday.format(date);
            String month = (String) formatterMonth.format(date);
            String year = (String) formatterYear.format(date);
            dstkKH.removeAll(dstkKH);
            xoaModelChiTiet();
            upTblChiTietTheoNgay(day, month, year);
            xoaBieuDo();
            bieuDo(10000000);
            jLabel7.setText("500.000");
            jLabel11.setText("3.000.000");
            jLabel12.setText("5.000.000");
            jLabel13.setText("10.000.000");
            jLabel14.setText("8.000.000");
            jLabel17.setText("trong Ngày");
        }

    }

    /**
     * Xuất dữ liệu ra file excel
     */
    public void exportDataToExcel() {

        try {
            JFileChooser jFileChooser = new JFileChooser("C:\\\\Users\\\\HP\\\\OneDrive\\\\Máy tính\\\\QLBH");
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Khách Hàng");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < jTable1.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(jTable1.getColumnName(i));
                }

                for (int j = 0; j < jTable1.getRowCount(); j++) {
                    Row row = sheet.createRow(j);
                    for (int k = 0; k < jTable1.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (jTable1.getValueAt(j, k) != null) {
                            cell.setCellValue(jTable1.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                JOptionPane.showMessageDialog(this, "Xuất Thành Công");
                openFile(saveFile.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_tab_FormTKkh = new javax.swing.JPanel();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cb2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        pnl_tab_FormTKkh.setPreferredSize(new java.awt.Dimension(1090, 628));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1090, 500));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Ngyen Văn A");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Ngyen Văn A");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(153, 153, 153)));

        jProgressBar2.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jProgressBar2.setForeground(new java.awt.Color(74, 136, 200));
        jProgressBar2.setToolTipText("");
        jProgressBar2.setValue(50);

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(74, 136, 200));
        jProgressBar1.setToolTipText("");
        jProgressBar1.setValue(50);
        jProgressBar1.setBorder(null);

        jProgressBar3.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar3.setForeground(new java.awt.Color(74, 136, 200));
        jProgressBar3.setToolTipText("");
        jProgressBar3.setValue(70);
        jProgressBar3.setBorder(null);

        jProgressBar4.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar4.setForeground(new java.awt.Color(74, 136, 200));
        jProgressBar4.setToolTipText("");
        jProgressBar4.setValue(30);
        jProgressBar4.setAutoscrolls(true);
        jProgressBar4.setBorder(null);

        jProgressBar5.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jProgressBar5.setForeground(new java.awt.Color(74, 136, 200));
        jProgressBar5.setToolTipText("");
        jProgressBar5.setValue(80);
        jProgressBar5.setAutoscrolls(true);
        jProgressBar5.setBorder(null);

        jProgressBar6.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar6.setForeground(new java.awt.Color(74, 136, 200));
        jProgressBar6.setToolTipText("");
        jProgressBar6.setValue(20);
        jProgressBar6.setBorder(null);

        jProgressBar7.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar7.setForeground(new java.awt.Color(74, 136, 200));
        jProgressBar7.setToolTipText("");
        jProgressBar7.setValue(5);
        jProgressBar7.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jProgressBar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jProgressBar6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jProgressBar7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jProgressBar2.getAccessibleContext().setAccessibleName("");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Ngyen Văn A");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ngyen Văn A");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Ngyen Văn A");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Ngyen Văn A");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Ngyen Văn A");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("5.000.000");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("10.000.000");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("30.000.000");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("100.000.000");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("30.000.000");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Lợi Nhuận");

        jPanel4.setBackground(new java.awt.Color(74, 136, 199));
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

        jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Biểu đồ top 7 Khách Hàng mua hàng nhiều nhất ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("VNĐ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("trong Năm.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel17)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7)
                        .addGap(131, 131, 131)
                        .addComponent(jLabel11)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel13)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17))
                    .addComponent(jLabel15)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tổng Quan", jPanel1);

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "SDT", "Địa Chỉ", "Số Lượng Sản Phẩm Mua", "Tổng Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Chi Tiết", jPanel2);

        cb2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm" }));
        cb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb2MouseClicked(evt);
            }
        });
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Lọc Theo");

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

        javax.swing.GroupLayout pnl_tab_FormTKkhLayout = new javax.swing.GroupLayout(pnl_tab_FormTKkh);
        pnl_tab_FormTKkh.setLayout(pnl_tab_FormTKkhLayout);
        pnl_tab_FormTKkhLayout.setHorizontalGroup(
            pnl_tab_FormTKkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(pnl_tab_FormTKkhLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnl_tab_FormTKkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_tab_FormTKkhLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_tab_FormTKkhLayout.setVerticalGroup(
            pnl_tab_FormTKkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_FormTKkhLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_tab_FormTKkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_tab_FormTKkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_tab_FormTKkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        locBieuDo();
    }//GEN-LAST:event_cb2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        exportDataToExcel();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        String year = (String) formatterYear.format(date);
        String month = (String) formatterMonth.format(date);
        String day = (String) formatterday.format(date);
        if (cb2.getSelectedIndex() == 2) {
            String source = "src\\BaoCao/rptThongKeKhachHangNam.jrxml";
            printBill(year, day, month, source);
        } else if (cb2.getSelectedIndex() == 1) {

            String source = "src\\BaoCao/rptThongKeKhachHangNamThang.jrxml";
            printBill(month, day, year, source);

        } else if (cb2.getSelectedIndex() == 0) {

            String source = "src\\BaoCao/rptThongKeKhachHangNamNgay.jrxml";
            printBill(day, month, year, source);

        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void cb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb2MouseClicked
//        locBieuDo();
    }//GEN-LAST:event_cb2MouseClicked
    /**
     * đọc dữ liệu lên bảng chi tiet theo năm
     */
    public void upTblChiTietTheoNam(String year) {
        dftkKH_Model = (DefaultTableModel) jTable1.getModel();
        dstkKH = hdDao.thongkeKhachHangTheoNam(year);
        for (HoaDonBanHang hd : dstkKH) {
            dftkKH_Model.addRow(new Object[]{
                hd.getKhachHang().getMaKH(), hd.getKhachHang().getTenKH(), hd.getKhachHang().getSdt(),
                hd.getKhachHang().getDiaChi(), hd.getSoLuong(), hd.getTongTien()
            });
        }
    }

    /**
     * đọc dữ liệu lên bảng chi tiet theo tháng
     */
    public void upTblChiTietTheoThang(String month, String year) {
        dftkKH_Model = (DefaultTableModel) jTable1.getModel();
        dstkKH = hdDao.thongkeKhachHangTheoThang(month, year);
        for (HoaDonBanHang hd : dstkKH) {
            dftkKH_Model.addRow(new Object[]{
                hd.getKhachHang().getMaKH(), hd.getKhachHang().getTenKH(), hd.getKhachHang().getSdt(),
                hd.getKhachHang().getDiaChi(), hd.getSoLuong(), hd.getTongTien()
            });
        }
    }

    /**
     * đọc dữ liệu lên bảng chi tiet theo ngày
     */
    public void upTblChiTietTheoNgay(String day, String month, String year) {
        dftkKH_Model = (DefaultTableModel) jTable1.getModel();
        dstkKH = hdDao.thongkeKhachHangTheoNgay(day, month, year);
        for (HoaDonBanHang hd : dstkKH) {
            dftkKH_Model.addRow(new Object[]{
                hd.getKhachHang().getMaKH(), hd.getKhachHang().getTenKH(), hd.getKhachHang().getSdt(),
                hd.getKhachHang().getDiaChi(), hd.getSoLuong(), hd.getTongTien()
            });
        }
    }

    /**
     * xóa model chi tiết
     */
    public void xoaModelChiTiet() {
        DefaultTableModel del = (DefaultTableModel) jTable1.getModel();
        del.getDataVector().removeAllElements();
    }

    /**
     * Xóa dữ liệu biểu đồ
     */
    public void xoaBieuDo() {
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

    /**
     * Tạo biểu đồ thóng kê
     *
     * @param max int
     *
     */
    public void bieuDo(int max) {
        try {
            jLabel3.setText(jTable1.getValueAt(0, 0).toString());
            jLabel3.setToolTipText(jTable1.getValueAt(0, 1).toString());
            jProgressBar2.setMaximum(max);
            jProgressBar2.setForeground(new Color(74, 136, 199));
            int tk1 = (int) Double.parseDouble(jTable1.getValueAt(0, 5).toString());
            jProgressBar2.setValue(tk1);
            jProgressBar2.setToolTipText(String.valueOf(tk1));

            jLabel4.setText(jTable1.getValueAt(1, 0).toString());
            jLabel4.setToolTipText(jTable1.getValueAt(1, 1).toString());
            jProgressBar1.setMaximum(max);
            int tk2 = (int) Double.parseDouble(jTable1.getValueAt(1, 5).toString());
            jProgressBar1.setValue(tk2);
            jProgressBar1.setToolTipText(String.valueOf(tk2));

            jLabel5.setText(jTable1.getValueAt(2, 0).toString());
            jLabel5.setToolTipText(jTable1.getValueAt(2, 1).toString());
            jProgressBar3.setMaximum(max);
            int tk3 = (int) Double.parseDouble(jTable1.getValueAt(2, 5).toString());
            jProgressBar3.setValue(tk3);
            jProgressBar3.setToolTipText(String.valueOf(tk3));

            jLabel6.setText(jTable1.getValueAt(3, 0).toString());
            jLabel6.setToolTipText(jTable1.getValueAt(3, 1).toString());
            jProgressBar4.setMaximum(max);
            int tk4 = (int) Double.parseDouble(jTable1.getValueAt(3, 5).toString());
            jProgressBar4.setValue(tk4);
            jProgressBar4.setToolTipText(String.valueOf(tk4));

            jLabel8.setText(jTable1.getValueAt(4, 0).toString());
            jLabel8.setToolTipText(jTable1.getValueAt(4, 1).toString());
            jProgressBar5.setMaximum(max);
            int tk5 = (int) Double.parseDouble(jTable1.getValueAt(4, 5).toString());
            jProgressBar5.setValue(tk5);
            jProgressBar5.setToolTipText(String.valueOf(tk5));

            jLabel9.setText(jTable1.getValueAt(5, 0).toString());
            jLabel9.setToolTipText(jTable1.getValueAt(5, 1).toString());
            jProgressBar6.setMaximum(max);
            int tk6 = (int) Double.parseDouble(jTable1.getValueAt(5, 5).toString());
            jProgressBar6.setValue(tk6);
            jProgressBar6.setToolTipText(String.valueOf(tk6));

            jLabel10.setText(jTable1.getValueAt(6, 0).toString());
            jLabel10.setToolTipText(jTable1.getValueAt(6, 1).toString());
            jProgressBar7.setMaximum(max);
            int tk7 = (int) Double.parseDouble(jTable1.getValueAt(6, 5).toString());
            jProgressBar7.setValue(tk7);
            jProgressBar7.setToolTipText(String.valueOf(tk7));
        } catch (Exception e) {
        }
    }

    /**
     * Xuất hóa đơn
     */
    public void printBill(String date, String month, String year, String source) {
        try {
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport(source);
            map.put("date", date);
            map.put("month", month);
            map.put("year", year);
            JasperPrint p = JasperFillManager.fillReport(report, map, connect.getConnection());
            JasperViewer.viewReport(p, false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel pnl_tab_FormTKkh;
    // End of variables declaration//GEN-END:variables
}
