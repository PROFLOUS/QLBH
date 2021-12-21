/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import Connect.connect;

import static Gui.GD_Chinh.jTabbedPane1;
import dao.CT_HoaDonDao;

import dao.HoaDonDao;

import dao.SanPhamDao;
import entity.CT_HDBanHang;

import entity.HoaDonBanHang;
import entity.SanPham;
import java.awt.Color;
import java.awt.List;
import java.text.DateFormat;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Hiển thị Giao diện Form Đặt hàng
 *
 */
public class FrmCT_HoaDonDatHang extends javax.swing.JFrame {

    DefaultTableModel modelTBHoaDon;
    ArrayList<CT_HDBanHang> listCtHoaDon = new ArrayList<CT_HDBanHang>();
    private String maHD;
    private String tongTien;

    /**
     * Creates new form FrmCT_HoaDon
     */
    public FrmCT_HoaDonDatHang() {
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
    public FrmCT_HoaDonDatHang(String maHD) {
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
     * Đọc dữ liệu lên bản chi tiết hóa đơn
     *
     */
    public void renderCTHD() {
        CT_HoaDonDao ctHoaDonDao = new CT_HoaDonDao();
        String[] title = {"Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền"};
        modelTBHoaDon = new DefaultTableModel(title, 0);

        listCtHoaDon = ctHoaDonDao.getCTHoadDonByMaHD(this.maHD);

        for (CT_HDBanHang s : listCtHoaDon) {
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
     * Đọc thông tin của hóa đơn lên phần chi tiết
     *
     */
    public void renderInfoHD() {
        HoaDonDao hoaDonDao = new HoaDonDao();
        HoaDonBanHang hd = hoaDonDao.findHDByMaHD(maHD);
        //System.out.print(hd.toString());
        lbHoaDon.setText(hd.getMaHD());
        lbGhiChu.setText(hd.getGhiChu());
        lbNV.setText(hd.getNhanVien().getTenNV());
        lbDate.setText(changeDateToString(hd.getNgayLap()));

        String name = sliderString(hd.getKhachHang().getTenKH()) + " - " + hd.getKhachHang().getSdt();
        lbKhachHang.setText(name);
        lbTienKhachDua.setText(String.valueOf(hd.getTongTien()));
        lbTongTien.setText(String.valueOf(hd.getTongTien()));
        lbSoLuong.setText(String.valueOf(hd.getSoLuong()));

        jLabel7.setText(hd.getTinhTrang());
        tongTien = lbTongTien.getText().toString();
        String tt = jLabel7.getText();
        if (tt.equals("Đang Giao")) {
            jLabel7.setForeground(new Color(255, 204, 0));
        } else if (tt.equals("Hoàn Thành")) {
            jToggleButton2.setVisible(false);
            jToggleButton3.setVisible(false);
            jLabel7.setForeground(new Color(0, 204, 102));
        } else if (tt.equals("Trả Hàng")) {
            jToggleButton2.setVisible(false);
            jToggleButton3.setVisible(false);
            jLabel7.setForeground(new Color(255, 102, 102));
        }

    }

    //lấy ra tên đệm và tên
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
     *
     *
     */
    public void printBill(String maHD) {
        try {

            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src\\Gui/rptHoaDon.jrxml");

            map.put("MaHD", maHD);

            JasperPrint p = JasperFillManager.fillReport(report, map, connect.getConnection());
            JasperViewer.viewReport(p, false);
            // JasperExportManager.exportReportToPdfFile(p, "test.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    /**
     * Láy các sản phẩm trên bản chi tiết hóa đơn
     *
     * @return list
     *
     *
     */
    public java.util.List<SanPham> getSpFromTB() {
        java.util.List<SanPham> list = new ArrayList<SanPham>();
        for (int i = 0; i < tbCTHD.getRowCount(); i++) {
            String maSp = tbCTHD.getValueAt(i, 0).toString();
            String tenSp = tbCTHD.getValueAt(i, 1).toString();
            String SL = tbCTHD.getValueAt(i, 2).toString();
            String donGia = tbCTHD.getValueAt(i, 3).toString();

            SanPham sp = new SanPham(maSp, tenSp, Double.parseDouble(donGia), Integer.parseInt(SL));
            list.add(sp);
        }
        return list;
    }

    /**
     * Cập nhật lại số lượng khi khách trả hàng
     *
     *
     *
     */
    public void capNhatSLTraHang() {
        java.util.List<SanPham> listSP = getSpFromTB();
        int sl = 0;
        for (int i = 0; i < listSP.size(); i++) {
            sl = listSP.get(i).getSoLuong();
            SanPhamDao spDao = new SanPhamDao();
            spDao.updateSLNhapKho(listSP.get(i).getMaSP(), sl);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jpParent = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnInHD = new javax.swing.JButton();
        btnExit = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbTienKhachDua = new javax.swing.JLabel();
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
        jSeparator9 = new javax.swing.JSeparator();
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
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        btnInHD1 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jpParent.setBackground(java.awt.Color.black);
        jpParent.setPreferredSize(new java.awt.Dimension(1300, 700));

        jPanel5.setBackground(new java.awt.Color(243, 244, 237));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel5.add(btnInHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 503, -1, 35));

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
        jPanel5.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 503, 94, 35));

        jPanel4.setBackground(new java.awt.Color(243, 244, 237));

        jLabel12.setText("Tổng số lượng : ");

        lbSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSoLuong.setText("2");

        jLabel14.setText("Tổng tiền hàng : ");

        lbTongTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTongTien.setText("2.00.000");

        jLabel15.setText("Khách đã trả");

        lbTienKhachDua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTienKhachDua.setText("2.000.000");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lbSoLuong)
                        .addContainerGap())
                    .addComponent(lbTongTien, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTienKhachDua, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbSoLuong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbTongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbTienKhachDua))
                .addContainerGap())
        );

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 417, -1, -1));

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

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 166, 793, 233));

        jPanel6.setBackground(java.awt.Color.white);

        jPanel2.setBackground(java.awt.Color.white);

        jLabel6.setText("Trạng thái: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("Đang Giao");

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
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 167, Short.MAX_VALUE))
                    .addComponent(lbGhiChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setText("Mã hóa đơn:");

        lbHoaDon.setText("HD001");

        jLabel2.setText("Ngày lập: ");

        lbDate.setText("20/10/2021");

        jLabel5.setText("Khách hàng:");

        lbKhachHang.setForeground(java.awt.Color.blue);
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
                        .addComponent(lbKhachHang))
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
            .addComponent(jSeparator3)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 26, 793, -1));

        jToggleButton2.setBackground(new java.awt.Color(13, 180, 115));
        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton2.setForeground(java.awt.Color.white);
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/debit-card.png"))); // NOI18N
        jToggleButton2.setText("Đã Thanh Toán");
        jToggleButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton2MouseClicked(evt);
            }
        });
        jPanel5.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 501, -1, 37));

        jToggleButton3.setBackground(new java.awt.Color(255, 102, 102));
        jToggleButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton3.setForeground(java.awt.Color.white);
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/exchange.png"))); // NOI18N
        jToggleButton3.setText("Trả Hàng");
        jToggleButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton3MouseClicked(evt);
            }
        });
        jPanel5.add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, -1, 37));

        btnInHD1.setBackground(new java.awt.Color(21, 151, 229));
        btnInHD1.setForeground(java.awt.Color.white);
        btnInHD1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/bill.png"))); // NOI18N
        btnInHD1.setText("In hóa đơn");
        btnInHD1.setToolTipText("");
        btnInHD1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInHD1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInHD1MouseClicked(evt);
            }
        });
        btnInHD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHD1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnInHD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 503, -1, 35));

        javax.swing.GroupLayout jpParentLayout = new javax.swing.GroupLayout(jpParent);
        jpParent.setLayout(jpParentLayout);
        jpParentLayout.setHorizontalGroup(
            jpParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpParentLayout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jpParentLayout.setVerticalGroup(
            jpParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpParentLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
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

    private void jToggleButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MouseClicked
        int tb = JOptionPane.showConfirmDialog(null, "Khách Hàng đã thánh toán số tiền " + tongTien + " ?", "Xác nhận thanh toán", JOptionPane.YES_NO_OPTION);
        if (tb == JOptionPane.YES_OPTION) {

            HoaDonDao hoaDonDao = new HoaDonDao();
            hoaDonDao.updateTrangThai(maHD, "Hoàn Thành");
            jLabel7.setText("Hoàn Thành");
            jLabel7.setForeground(new Color(0, 204, 102));
            jToggleButton2.setVisible(false);
            jToggleButton3.setVisible(false);

        }
    }//GEN-LAST:event_jToggleButton2MouseClicked

    private void jToggleButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton3MouseClicked
        int tb = JOptionPane.showConfirmDialog(null, "Đã hoàn lại số tiền " + tongTien + " cho Khách Hàng ?", "Xác nhận Trả Hàng", JOptionPane.YES_NO_OPTION);
        if (tb == JOptionPane.YES_OPTION) {
            HoaDonDao hoaDonDao = new HoaDonDao();
            hoaDonDao.updateTrangThai(maHD, "Trả Hàng");
            capNhatSLTraHang();
            jLabel7.setText("Trả Hàng");
            jLabel7.setForeground(new Color(255, 102, 102));
            jToggleButton2.setVisible(false);
            jToggleButton3.setVisible(false);
        }
    }//GEN-LAST:event_jToggleButton3MouseClicked

    private void btnInHD1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInHD1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInHD1MouseClicked

    private void btnInHD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInHD1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCT_HoaDonDatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCT_HoaDonDatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCT_HoaDonDatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCT_HoaDonDatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCT_HoaDonDatHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnExit;
    private javax.swing.JButton btnInHD;
    private javax.swing.JButton btnInHD1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JPanel jpParent;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbGhiChu;
    private javax.swing.JLabel lbHoaDon;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbNV;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTienKhachDua;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tbCTHD;
    private javax.swing.JLabel txt1;
    // End of variables declaration//GEN-END:variables
}
