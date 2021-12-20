/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;



import Connect.connect;
import dao.HoaDonDao;
import entity.HoaDonBanHang;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author HP
 */
public class FrmTkeDoanhThu extends javax.swing.JPanel {

    private DefaultTableModel dftkdt1_Model;
    private DefaultTableModel dftkdt2_Model;
    private HoaDonDao hdDao;
    private SimpleDateFormat formatterDay = new SimpleDateFormat("dd");
    private SimpleDateFormat formatterMonth = new SimpleDateFormat("MM");
    private SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
    private String ngayStart ;
    private String ngayEnd ;
    private String thang ;
    private String nam ;
    private String thangDef ;
    private String namDef ;
    private java.sql.Date date ;
    List<HoaDonBanHang>list;
    List<HoaDonBanHang>list2;
    List<HoaDonBanHang>list3;
    List<HoaDonBanHang>dsct1;
    List<HoaDonBanHang>dsct2;
    List<HoaDonBanHang>dsct3;
    public FrmTkeDoanhThu() {
        initComponents();
        list = new ArrayList<HoaDonBanHang>();
        list2 = new ArrayList<HoaDonBanHang>();
        list3 = new ArrayList<HoaDonBanHang>();
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        dftkdt1_Model = (DefaultTableModel) jTable1.getModel();
        dftkdt2_Model = (DefaultTableModel) jTable2.getModel();
        hdDao = new HoaDonDao();
        dsct1 = new ArrayList<HoaDonBanHang>();
        dsct2 = new ArrayList<HoaDonBanHang>();
        dsct3 = new ArrayList<HoaDonBanHang>();
        long millis=System.currentTimeMillis();
        date=new java.sql.Date(millis);
        thangDef = (String) formatterMonth.format(date);
        namDef = (String) formatterYear.format(date);
        tkNgay("01", "31", thangDef, namDef, jPanel3);
        upTblChiTietTheoNgay("01", "31", thangDef, namDef);
        upTblChiTietTheoNgay2();
        jDateChooser1.setDate(date);
        jDateChooser2.setDate(date);
    }
    public void loadAgain(){
        tkNgay("01", "31", thangDef, namDef, jPanel3);
        upTblChiTietTheoNgay("01", "31", thangDef, namDef);
        upTblChiTietTheoNgay2();
    }

    /**
     * xóa chi model chi tiết ngay 1
     */
    public void xoaModelChiTiet1(){
        DefaultTableModel del = (DefaultTableModel) jTable1.getModel();
        del.getDataVector().removeAllElements();
    }
    /**
     * xóa chi model chi tiết ngay 2
     */
    public void xoaModelChiTiet2(){
        DefaultTableModel del = (DefaultTableModel) jTable2.getModel();
        del.getDataVector().removeAllElements();
    }
    
    /**
     * đọc dữ liệu lên bảng chi tiet theo ngày 
     */
    public void upTblChiTietTheoNgay(String ngayStart, String ngayEnd, String thang, String nam) {

        dsct1 = hdDao.CT_thongkeDoanhThuTheoNgay(ngayStart, ngayEnd, thang, nam);
        for (HoaDonBanHang hd : dsct1) {
            dftkdt1_Model.addRow(new Object[]{
                hd.getMaHD(),hd.getNgayLapHD(),hd.getSoLuong(),hd.getTongTien()
            });
        }
    }
    /**
     * đọc dữ liệu lên bảng chi tiet tong quan theo ngày
     */
    public void upTblChiTietTheoNgay2() {
        for (HoaDonBanHang hd : list) {
            Date ngay = hd.getNgayLapHD();
            String day = (String) formatterDay.format(ngay);
            dftkdt2_Model.addRow(new Object[]{
               day,hd.getTongTien()
            });
        }
    }
    
    /**
     * đọc dữ liệu lên bảng chi tiet theo ngày 
     */
    public void upTblChiTietTheoThang(String thangStart, String thangEnd, String nam) {
        dsct2 = hdDao.CT_thongkeDoanhThuTheoThang(thangStart, thangEnd, nam);
        for (HoaDonBanHang hd : dsct2) {
            dftkdt1_Model.addRow(new Object[]{
                hd.getMaHD(),hd.getNgayLapHD(),hd.getSoLuong(),hd.getTongTien()
            });
        }
    }
    /**
     * đọc dữ liệu lên bảng chi tiet tong quan theo ngày
     */
    public void upTblChiTietTheoThang2() {
        for (HoaDonBanHang hd : list2) {
            Date thang = hd.getNgayLapHD();
            String month = (String) formatterDay.format(thang);
            dftkdt2_Model.addRow(new Object[]{
               month,hd.getTongTien()
            });
        }
    }
    
    /**
     * đọc dữ liệu lên bảng chi tiet theo năm
     */
    public void upTblChiTietTheoNam(String namStart, String namEnd) {

        dsct3 = hdDao.CT_thongkeDoanhThuTheoNam(namStart, namEnd);
        for (HoaDonBanHang hd : dsct3) {
            dftkdt1_Model.addRow(new Object[]{
                hd.getMaHD(),hd.getNgayLapHD(),hd.getSoLuong(),hd.getTongTien()
            });
        }
    }
    /**
     * đọc dữ liệu lên bảng chi tiet tong quan theo năm
     */
    public void upTblChiTietTheoNam2() {
        for (HoaDonBanHang hd : list3) {
            Date nam = hd.getNgayLapHD();
            String year = (String) formatterYear.format(nam);
            dftkdt2_Model.addRow(new Object[]{
               year,hd.getTongTien()
            });
        }
    }
    
    /**
     * Biểu đồ thống kê theo ngày
     */
    public void tkNgay(String ngayStart, String ngayEnd, String thang, String nam ,JPanel pnItem){
        list = hdDao.thongkeDoanhThuTheoNgay(ngayStart, ngayEnd, thang, nam);
        if(list != null){
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(HoaDonBanHang hd : list){
                Date ngay = hd.getNgayLapHD();
                String day = (String) formatterDay.format(ngay);
                
               
                dataset.addValue(hd.getTongTien(), "Tổng Tiền",
                        String.valueOf(day)
                        );
            }
            JFreeChart chart = ChartFactory.createBarChart("Biểu đồ doanh thu theo Ngày trong tháng "+thang+", năm "+nam+"", "Ngày", "Tổng Tiền(VND)", dataset,PlotOrientation.VERTICAL, true, true, false);
            
//            chart.setBackgroundPaint(Color.white);
            CategoryPlot plot = chart.getCategoryPlot();
            plot.getRenderer().setSeriesPaint(0, new Color(98,157,221));
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(pnItem.getWidth(),pnItem.getHeight()));
            pnItem.removeAll();
            pnItem.setLayout(new CardLayout());
            pnItem.add(chartPanel);
            pnItem.repaint();
            pnItem.revalidate();
            
        }
    }
    
    /**
     * Biểu đồ thống kê theo tháng
     */
    public void tkThang(String monthStart, String monthEnd,String nam ,JPanel pnItem){
        list2 = hdDao.thongkeDoanhThuTheoThang(monthStart, monthEnd, nam);
        if(list2 != null){
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(HoaDonBanHang hd : list2){
                Date thang = hd.getNgayLapHD();
               
                String month = (String) formatterDay.format(thang);
              
                dataset.addValue(hd.getTongTien(), "Tổng Tiền",
                        String.valueOf(month)
                        );
            }
            JFreeChart chart = ChartFactory.createBarChart("Biểu đồ doanh thu theo Tháng trong năm "+nam+" ", "Tháng", "Tổng Tiền(VND)", dataset,PlotOrientation.VERTICAL, true, true, false);
            
            chart.setBackgroundPaint(Color.white);
            CategoryPlot plot = chart.getCategoryPlot();
            plot.getRenderer().setSeriesPaint(0, new Color(98,157,221));
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(pnItem.getWidth(),pnItem.getHeight()));
            pnItem.removeAll();
            pnItem.setLayout(new CardLayout());
            pnItem.add(chartPanel);
            pnItem.repaint();
            pnItem.revalidate();
            
        }
    }
    
    /**
     * Biểu đồ thống kê theo năm
     */
    public void tkNam(String yearStart, String yearEnd,JPanel pnItem){
        list3 = hdDao.thongkeDoanhThuTheoNam(yearStart, yearEnd);
        if(list3 != null){
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(HoaDonBanHang hd : list3){
                Date nam = hd.getNgayLapHD();
                String year = (String) formatterYear.format(nam);
               
                dataset.addValue(hd.getTongTien(), "Tổng Tiền",
                        String.valueOf(year)
                        );
            }
            JFreeChart chart = ChartFactory.createBarChart("Biểu đồ doanh thu theo Năm", "Năm", "Tổng Tiền(VND)", dataset,PlotOrientation.VERTICAL, true, true, false);
            
            chart.setBackgroundPaint(Color.white);
            CategoryPlot plot = chart.getCategoryPlot();
            plot.getRenderer().setSeriesPaint(0, new Color(98,157,221));
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(pnItem.getWidth(),pnItem.getHeight()));
            pnItem.removeAll();
            pnItem.setLayout(new CardLayout());
            pnItem.add(chartPanel);
            pnItem.repaint();
            pnItem.revalidate();
            
        }
    }
    
    //xuất ra file ex
    public void exportDataToExcel(String title) {
        try{
           JFileChooser jFileChooser = new JFileChooser("C:\\\\Users\\\\HP\\\\OneDrive\\\\Máy tính\\\\QLBH");
           jFileChooser.showSaveDialog(this);
           File saveFile = jFileChooser.getSelectedFile();
           
           if(saveFile != null){
               saveFile = new File(saveFile.toString()+".xlsx");
               Workbook wb = new XSSFWorkbook();
               Sheet sheet = wb.createSheet(title);
               
               Row rowCol = sheet.createRow(3);
               
               
               for(int i=0;i<jTable2.getColumnCount();i++){
                   Cell cell = rowCol.createCell(i,CellType.NUMERIC);
                   cell.setCellValue(jTable2.getColumnName(i));
               }
               
               for(int j=0;j<jTable2.getRowCount();j++){
                   Row row = sheet.createRow(j);
                   for(int k=0;k<jTable2.getColumnCount();k++){
                       Cell cell = row.createCell(k,CellType.NUMERIC);
                       if(jTable2.getValueAt(j, k)!=null){
                           cell.setCellValue(jTable2.getValueAt(j, k).toString());
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
//               JOptionPane.showMessageDialog(null,"Error");
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        pnl_tab_Form_TKedt = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jPanel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jMonthChooser2 = new com.toedter.calendar.JMonthChooser();
        jLabel27 = new javax.swing.JLabel();
        jYearChooser2 = new com.toedter.calendar.JYearChooser();
        jLabel28 = new javax.swing.JLabel();
        jMonthChooser3 = new com.toedter.calendar.JMonthChooser();
        jPanel7 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jYearChooser3 = new com.toedter.calendar.JYearChooser();
        jYearChooser4 = new com.toedter.calendar.JYearChooser();

        setPreferredSize(new java.awt.Dimension(1090, 620));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Lọc Theo");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
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

        jPanel3.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 603, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tổng Quan", jPanel1);

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Ngày Lập ", "Tổng số lượng", "Tổng Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày", "Tổng Doanh Thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setRowHeight(30);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 602, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chi Tiết", jPanel2);

        jButton2.setBackground(new java.awt.Color(119, 103, 188));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Lọc");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ngày bắt đầu");

        jDateChooser1.setDateFormatString("dd");
        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
        });

        jDateChooser2.setDateFormatString("dd");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Ngày kết thúc");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Tháng");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Năm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel20)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Tháng bắt đầu");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Tháng kết thúc");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Năm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jMonthChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jMonthChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jYearChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 163, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jYearChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jMonthChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jMonthChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Năm bắt đầu");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Năm kết thúc");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jYearChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jYearChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 336, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jYearChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jYearChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout pnl_tab_Form_TKedtLayout = new javax.swing.GroupLayout(pnl_tab_Form_TKedt);
        pnl_tab_Form_TKedt.setLayout(pnl_tab_Form_TKedtLayout);
        pnl_tab_Form_TKedtLayout.setHorizontalGroup(
            pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_Form_TKedtLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_tab_Form_TKedtLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
            .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_Form_TKedtLayout.createSequentialGroup()
                    .addContainerGap(307, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(797, Short.MAX_VALUE)))
            .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_tab_Form_TKedtLayout.createSequentialGroup()
                    .addGap(310, 310, 310)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(787, Short.MAX_VALUE)))
        );
        pnl_tab_Form_TKedtLayout.setVerticalGroup(
            pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_Form_TKedtLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_tab_Form_TKedtLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
            .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_Form_TKedtLayout.createSequentialGroup()
                    .addContainerGap(18, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(552, Short.MAX_VALUE)))
            .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_tab_Form_TKedtLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(556, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1693, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_tab_Form_TKedt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_tab_Form_TKedt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
//        locBieuDo();
            if(jComboBox1.getSelectedIndex()==0){
                jTable2.getColumnModel().getColumn(0).setHeaderValue("Ngày");
                jPanel5.setVisible(true);
                jPanel6.setVisible(false);
                jPanel7.setVisible(false);
                dsct1.removeAll(dsct1);
                list.removeAll(list);
                list2.removeAll(list2);
                list3.removeAll(list3);
                xoaModelChiTiet1();
                xoaModelChiTiet2();
                tkNgay("01", "31", thangDef, namDef, jPanel3);
                upTblChiTietTheoNgay("01", "31", thangDef, namDef);
                upTblChiTietTheoNgay2();
            }else if(jComboBox1.getSelectedIndex()==1){
                jTable2.getColumnModel().getColumn(0).setHeaderValue("Tháng");
                jPanel6.setVisible(true);
                jPanel5.setVisible(false);
                jPanel7.setVisible(false);
                dsct1.removeAll(dsct1);
                list.removeAll(list);
                list2.removeAll(list2);
                list3.removeAll(list3);
                xoaModelChiTiet1();
                xoaModelChiTiet2();
                tkThang("01", "12", namDef, jPanel3);
                upTblChiTietTheoThang("01", "12", namDef);
                upTblChiTietTheoThang2();
            }else if(jComboBox1.getSelectedIndex()==2){
                jTable2.getColumnModel().getColumn(0).setHeaderValue("Năm");
                jPanel6.setVisible(false);
                jPanel5.setVisible(false);
                jPanel7.setVisible(true);
                dsct1.removeAll(dsct1);
                list.removeAll(list);
                list2.removeAll(list2);
                list3.removeAll(list3);
                xoaModelChiTiet1();
                xoaModelChiTiet2();
                tkNam("2010", "2021", jPanel3);
                upTblChiTietTheoNam("2010", "2021");
                upTblChiTietTheoNam2();
                
            }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
//        exportDataToExcel();
            if(jComboBox1.getSelectedIndex()==0){
                exportDataToExcel("Tổng Doanh Thu Theo Ngày");
            }else if(jComboBox1.getSelectedIndex()==1){
                exportDataToExcel("Tổng Doanh Thu Theo Tháng");
            }else if(jComboBox1.getSelectedIndex()==2){
                exportDataToExcel("Tổng Doanh Thu Theo Năm");
            }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        if(jComboBox1.getSelectedIndex()==0){
            Date date1 = jDateChooser1.getDate();
            Date date2 = jDateChooser2.getDate();
            try {
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("C:\\Users\\HP\\OneDrive\\Máy tính\\QLBH\\src\\BaoCao\\rptThongKeDoanhThuTheoNgay.jrxml");
            String ngayS =(String) formatterDay.format(date1);
            String ngayE =(String) formatterDay.format(date2);
            String thang =String.valueOf(jMonthChooser1.getMonth()+1);
            String nam =String.valueOf(jYearChooser1.getYear());
                
            map.put("dayStart", ngayS);
            map.put("dayEnd", ngayE);
            map.put("month", thang);
            map.put("year", nam);
            JasperPrint p = JasperFillManager.fillReport(report,  map, connect.getConnection() );
            JasperViewer.viewReport(p, false);
            } catch (Exception e) {
            }
        }else if(jComboBox1.getSelectedIndex()==1){
            try {
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("C:\\Users\\HP\\OneDrive\\Máy tính\\QLBH\\src\\BaoCao\\rptThongKeDoanhThuTheoThang.jrxml");
            String thangStart = String.valueOf(jMonthChooser3.getMonth()+1);
           String thangEnd = String.valueOf(jMonthChooser2.getMonth()+1);
           String nam = String.valueOf(jYearChooser2.getYear());
            map.put("thangStart", thangStart);
            map.put("thangEnd", thangEnd);
            map.put("year", nam);
            JasperPrint p = JasperFillManager.fillReport(report,  map, connect.getConnection() );
            JasperViewer.viewReport(p, false);
            } catch (Exception e) {
            }

        }else if(jComboBox1.getSelectedIndex()==2){
            try {
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("C:\\Users\\HP\\OneDrive\\Máy tính\\QLBH\\src\\BaoCao\\rptThongKeDoanhThuTheoNam.jrxml");
            String namStart = String.valueOf(jYearChooser4.getYear());
           String namEnd = String.valueOf(jYearChooser3.getYear());
            map.put("namStart", namStart);
            map.put("namEnd", namEnd);
            JasperPrint p = JasperFillManager.fillReport(report,  map, connect.getConnection() );
            JasperViewer.viewReport(p, false);
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if(jComboBox1.getSelectedIndex()==0){
            list.removeAll(list);
        dsct1.removeAll(dsct1);
        xoaModelChiTiet1();
        xoaModelChiTiet2();
        Date date1 = jDateChooser1.getDate();
        Date date2 = jDateChooser2.getDate();
        ngayStart =(String) formatterDay.format(date1);
        ngayEnd = (String) formatterDay.format(date2);
        thang = String.valueOf(jMonthChooser1.getMonth()+1);
        nam = String.valueOf(jYearChooser1.getYear());
        
        tkNgay(ngayStart, ngayEnd, thang, nam, jPanel3);
        upTblChiTietTheoNgay(ngayStart, ngayEnd, thang, nam);
        upTblChiTietTheoNgay2();
        }else if(jComboBox1.getSelectedIndex()==1){
           list2.removeAll(list2);
           dsct2.removeAll(dsct2);
           xoaModelChiTiet1();
           xoaModelChiTiet2();
           String thangStart = String.valueOf(jMonthChooser3.getMonth()+1);
           String thangEnd = String.valueOf(jMonthChooser2.getMonth()+1);
           String nam = String.valueOf(jYearChooser2.getYear());
          
            tkThang(thangStart, thangEnd, nam, jPanel3);
            upTblChiTietTheoThang(thangStart, thangEnd, nam);
            upTblChiTietTheoThang2();
        }else if(jComboBox1.getSelectedIndex()==2){
            list3.removeAll(list3);
           dsct3.removeAll(dsct3);
           xoaModelChiTiet1();
           xoaModelChiTiet2();
           String namStart = String.valueOf(jYearChooser4.getYear());
           String namEnd = String.valueOf(jYearChooser3.getYear());
           
            tkNam(namStart, namEnd, jPanel3);
            upTblChiTietTheoNam(namStart, namEnd);
            upTblChiTietTheoNam2();
        }
        
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        
    }//GEN-LAST:event_jDateChooser1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private com.toedter.calendar.JMonthChooser jMonthChooser2;
    private com.toedter.calendar.JMonthChooser jMonthChooser3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel5;
    public static javax.swing.JPanel jPanel6;
    public static javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private com.toedter.calendar.JYearChooser jYearChooser2;
    private com.toedter.calendar.JYearChooser jYearChooser3;
    private com.toedter.calendar.JYearChooser jYearChooser4;
    private javax.swing.JPanel pnl_tab_Form_TKedt;
    // End of variables declaration//GEN-END:variables
}
