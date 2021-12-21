/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import Connect.connect;
import dao.CT_HoaDonDao;
import dao.CT_HoaDonNhapDao;
import dao.HoaDonDao;
import dao.HoaDonNhapDao;
import entity.CT_HDBanHang;
import entity.CT_HoaDonNhap;
import entity.HoaDonBanHang;
import entity.HoaDonNhap;
import java.awt.Color;
import java.awt.List;
import java.text.DateFormat;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Hiển thị Giao diện Form Chi Tiết Hóa Đơn Nhập Hàng
 *
 */
public class FrmCT_HoaDonNhap extends javax.swing.JFrame {

    DefaultTableModel modelTBHoaDon;
    ArrayList<CT_HoaDonNhap> listCtHoaDon = new ArrayList<CT_HoaDonNhap>();
    private String maHD;

    /**
     * Creates new form FrmCT_HoaDonNhap
     */
    public FrmCT_HoaDonNhap() {
        initComponents();
        // this.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f));
        jpParent.setBackground(new Color(0, 0, 0, 120));
        this.setLocationRelativeTo(null);
    }

    /**
     * Creates new form FrmCT_HoaDon for maHD
     *
     * @param maHD String
     *
     */
    public FrmCT_HoaDonNhap(String maHD) {
        this.maHD = maHD;
        initComponents();
        this.setLocationRelativeTo(null);
        jpParent.setBackground(new Color(0, 0, 0, 64));
        this.setBackground(new Color(0, 0, 0, 64));
        try {
            connect.getInstance().connect();
            renderInfoHD();
            renderCTHD();

        } catch (Exception e) {
        }
    }

    /**
     * Đọc dữ liệu lên bản chi tiết hóa đơn nhập hàng
     *
     */
    public void renderCTHD() {
        CT_HoaDonNhapDao ctHoaDonNhapDao = new CT_HoaDonNhapDao();
        String[] title = {"Mã SP", "Tên SP", "Số Lượng", "Giá Nhập", "Thành Tiền"};
        modelTBHoaDon = new DefaultTableModel(title, 0);

        listCtHoaDon = ctHoaDonNhapDao.getCTHoadDonByMaHD(this.maHD);

        for (CT_HoaDonNhap s : listCtHoaDon) {
            String[] rowData = {
                s.getSanPham().getMaSP(),
                String.valueOf(s.getSanPham().getTenSP()),
                String.valueOf(s.getSoLuong()),
                String.valueOf(s.getDonGia()),
                String.valueOf(handleMoney(s.getSoLuong(), s.getDonGia()))
            };

            modelTBHoaDon.addRow(rowData);
        }

        tbCTHD.setModel(modelTBHoaDon);
    }

    /**
     * Đọc thông tin của hóa đơn nhập hàng lên phần chi tiết
     *
     */
    public void renderInfoHD() {
        HoaDonNhapDao hoaDonNhapDao = new HoaDonNhapDao();
        HoaDonNhap hdn = hoaDonNhapDao.findHDByMaHD(maHD);
        //System.out.print(hd.toString());
        lbHoaDon.setText(hdn.getMaHDNhap());
        lbGhiChu.setText(hdn.getMaHDNhap());
        lbNV.setText(hdn.getNhanVien().getTenNV());
        lbDate.setText(changeDateToString(hdn.getNgayLapHD()));

        String name = sliderString(hdn.getNCC().getTenNCC()) + " - " + hdn.getNCC().getSdt();
        lbKhachHang.setText(name);

        lbTongTien.setText(String.valueOf(hdn.getTongTien()));
        lbSoLuong.setText(String.valueOf(hdn.getSoLuong()));

    }

    /**
     * Lấy ra tên đệm và tên
     *
     */
    public String sliderString(String str) {
        int countSpace = 0;
        for (int i = 0; i < str.trim().length(); i++) {
            if (str.charAt(i) == 32) {
                countSpace++;
            }
        }
        if (countSpace >= 2) {
            int pos = str.indexOf(" ");
            String s = str.substring(pos + 1);
            return s;
        }

        return str;
    }

    /**
     * Chuyển kiểu dữ liệu Date dang String
     *
     * @param date Date
     * @return dateString String
     */
    public String changeDateToString(Date date) {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String dateString = df.format(date);
        return dateString;
    }

    /**
     * Tính tổng tiền của một sản phẩm
     *
     */
    public Double handleMoney(int sl, Double DonGia) {
        return sl * DonGia;
    }

    /**
     * Xuất ra hóa đơn
     *
     * @param maHD String
     */
    public void printBill(String maHD) {
        try {

            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src\\Gui/rptHoaDonNhap.jrxml");

            map.put("MaHDNhap", maHD);

            JasperPrint p = JasperFillManager.fillReport(report, map, connect.getConnection());
            JasperViewer.viewReport(p, false);
            // JasperExportManager.exportReportToPdfFile(p, "test.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jpParent = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        btnInHD = new javax.swing.JButton();
        btnExit = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCTHD = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt1 = new javax.swing.JLabel();
        lbNV = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbGhiChu = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbHoaDon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbKhachHang = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jpParent.setBackground(java.awt.Color.black);
        jpParent.setPreferredSize(new java.awt.Dimension(1300, 700));

        jPanel5.setBackground(new java.awt.Color(243, 244, 237));

        jToggleButton1.setBackground(new java.awt.Color(21, 151, 229));
        jToggleButton1.setForeground(java.awt.Color.white);
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/system-update.png"))); // NOI18N
        jToggleButton1.setText("Cập nhật");
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnInHD.setBackground(new java.awt.Color(21, 151, 229));
        btnInHD.setForeground(java.awt.Color.white);
        btnInHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/bill.png"))); // NOI18N
        btnInHD.setText("In hóa đơn");
        btnInHD.setToolTipText("");
        btnInHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInHDMouseClicked(evt);
            }
        });
        btnInHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHDActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(21, 151, 229));
        btnExit.setForeground(java.awt.Color.white);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/close.png"))); // NOI18N
        btnExit.setText("Thoát");
        btnExit.setToolTipText("");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(243, 244, 237));

        jLabel12.setText("Tổng số lượng : ");

        lbSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSoLuong.setText("2");

        jLabel14.setText("Tổng tiền hàng : ");

        lbTongTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTongTien.setText("2.00.000");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSoLuong, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTongTien, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbSoLuong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbTongTien))
                .addGap(28, 28, 28))
        );

        tbCTHD.setBackground(java.awt.Color.white);
        tbCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCTHD.setRowHeight(26);
        tbCTHD.setShowGrid(true);
        tbCTHD.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tbCTHD);

        jPanel6.setBackground(java.awt.Color.white);

        jPanel2.setBackground(java.awt.Color.white);

        jLabel6.setText("Trạng thái: ");

        jLabel7.setForeground(java.awt.Color.green);
        jLabel7.setText("Hoàn thành");

        txt1.setText("Nhân viên:");

        lbNV.setText("Hoàng Anh");

        jLabel8.setText("Cứa hàng: ");

        jLabel9.setText("01 Văn Bảo, Gò Vấp");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt1)
                                .addGap(18, 18, 18)
                                .addComponent(lbNV))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1)
                    .addComponent(lbNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(java.awt.Color.white);

        jLabel11.setText("Ghi Chú:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(lbGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setText("Mã hóa đơn:");

        lbHoaDon.setText("HD001");

        jLabel2.setText("Ngày lập: ");

        lbDate.setText("20/10/2021");

        jLabel5.setText("Nhà Cung Cấp");

        lbKhachHang.setForeground(java.awt.Color.blue);
        lbKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbKhachHang.setText(" anh châu - 0397530256");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbHoaDon))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDate))))
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbDate))
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbKhachHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInHD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpParentLayout = new javax.swing.GroupLayout(jpParent);
        jpParent.setLayout(jpParentLayout);
        jpParentLayout.setHorizontalGroup(
            jpParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpParentLayout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jpParentLayout.setVerticalGroup(
            jpParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpParentLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnInHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInHDActionPerformed

    private void btnInHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInHDMouseClicked
        // TODO add your handling code here:

        printBill(maHD);
    }//GEN-LAST:event_btnInHDMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCT_HoaDonNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCT_HoaDonNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCT_HoaDonNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCT_HoaDonNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCT_HoaDonNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnExit;
    private javax.swing.JButton btnInHD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPanel jpParent;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbGhiChu;
    private javax.swing.JLabel lbHoaDon;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbNV;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tbCTHD;
    private javax.swing.JLabel txt1;
    // End of variables declaration//GEN-END:variables
}
