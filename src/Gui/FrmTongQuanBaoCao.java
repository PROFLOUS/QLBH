/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.toedter.calendar.JTextFieldDateEditor;
import java.util.Map;
import dao.HoaDonDao;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartColor;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Hiển thị Giao diện Form Tổng qua thống kê
 *
 */
public class FrmTongQuanBaoCao extends javax.swing.JPanel {

    private HoaDonDao hdDao = new HoaDonDao();

    /**
     * Creates new form FrmTkeDoanhThu
     */
    public FrmTongQuanBaoCao() {
        initComponents();
        renderData();

    }

    public String dinhDangString(String str) {
        String newString = str.substring(0, str.length() - 2);
        return newString;
    }

    /**
     * đọc dữ liệu lên biểu đồ
     */
    public void renderData() {
        Date date = new Date();
        DateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String nowString = dateFormat.format(date);
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        //String str1 = currencyVN.format(vnd);
        ArrayList<Double> list = hdDao.getThongkeInDay(nowString);
        //System.out.println("Gui.FrmTongQuanBaoCao.renderData()"+list);

        lblSoHD.setText(dinhDangString(list.get(0).toString()));
        lblSumDoanhThu.setText(currencyVN.format(list.get(2)));
        lblSLKH.setText(dinhDangString(list.get(0).toString()));
        lblSoSP.setText(dinhDangString(list.get(1).toString()));
        int donTraHang = hdDao.getHoaDonTraInDay(nowString);
        lblSoDonTra.setText(String.valueOf(donTraHang));

        //lay ra tong nhoi nhuan
        double loiNhuan = hdDao.getLoiNhuanInDay(nowString) - hdDao.getKhuyenMaiInDay(nowString);
        lblTongLoiNhuan.setText(currencyVN.format(loiNhuan));

        DecimalFormat df = new DecimalFormat("0.000");// làm tròn với 3 chữ số thập phân, muốn bao nhiêu chữ số sau dấu phẩy //thì thêm bấy nhiêu số 0.
        //    Double tySuat= df.Format((loiNhuan/list.get(2)*100 ));

        lblTySuat.setText(df.format((loiNhuan / list.get(2) * 100)) + "%");

        //render bar chart
        //lay ngay hien tai la sql date
        java.sql.Date date2 = new java.sql.Date(System.currentTimeMillis());
        bar_chart(date2, 7);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        pnl_tab_Form_TKedt = new javax.swing.JPanel();
        pnChart = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSLKH = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblSoHD = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblSoSP = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblSoDonTra = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblSumDoanhThu = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblTongLoiNhuan = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblTySuat = new javax.swing.JLabel();
        jdcfrom = new com.toedter.calendar.JDateChooser();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jdcTo = new com.toedter.calendar.JDateChooser();
        btnLoc = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(1090, 620));

        pnl_tab_Form_TKedt.setBackground(new java.awt.Color(220, 214, 247));

        pnChart.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout pnChartLayout = new javax.swing.GroupLayout(pnChart);
        pnChart.setLayout(pnChartLayout);
        pnChartLayout.setHorizontalGroup(
            pnChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 799, Short.MAX_VALUE)
        );
        pnChartLayout.setVerticalGroup(
            pnChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        jPanel2.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Thông tin hôm nay");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/add-user.png"))); // NOI18N

        lblSLKH.setText("100");

        jLabel4.setText("khách mua hàng");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/bill 1.png"))); // NOI18N

        lblSoHD.setText("100");

        jLabel9.setText("hóa đơn bán");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/package.png"))); // NOI18N

        lblSoSP.setText("100000");

        jLabel12.setText("sản phẩm đã bán");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/return01.png"))); // NOI18N

        lblSoDonTra.setText("0");

        jLabel14.setText("đơn hàng trả");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSoSP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(lblSLKH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(lblSoDonTra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSoHD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblSLKH))
                    .addComponent(jLabel2))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSoHD)
                                    .addComponent(jLabel9)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSoSP)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSoDonTra)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setToolTipText("Tổng doang thu trong hôm nay");
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/money-bag32.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(java.awt.Color.black);
        jLabel16.setText("Tổng doanh thu");

        lblSumDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSumDoanhThu.setForeground(java.awt.Color.green);
        lblSumDoanhThu.setText("100.000.000 đ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(lblSumDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSumDoanhThu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel15)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setToolTipText("Tổng doang thu trong hôm nay");
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/bill.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(java.awt.Color.black);
        jLabel18.setText("Tổng lợi nhuận");

        lblTongLoiNhuan.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTongLoiNhuan.setForeground(java.awt.Color.blue);
        lblTongLoiNhuan.setText("20.000.000 đ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(lblTongLoiNhuan, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblTongLoiNhuan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)))
                .addGap(16, 16, 16))
        );

        jPanel6.setBackground(java.awt.Color.white);
        jPanel6.setToolTipText("Tổng doang thu trong hôm nay");
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/profit.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(java.awt.Color.black);
        jLabel20.setText("Tỷ suất lợi nhuận ");

        lblTySuat.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTySuat.setForeground(java.awt.Color.blue);
        lblTySuat.setText("40%");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTySuat, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblTySuat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addComponent(jLabel19))
                .addGap(21, 21, 21))
        );

        jLabel3.setText("Từ:");

        jLabel5.setText("Đến:");

        btnLoc.setBackground(new java.awt.Color(21, 151, 229));
        btnLoc.setForeground(java.awt.Color.white);
        btnLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search_1.png"))); // NOI18N
        btnLoc.setText("Lọc");
        btnLoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_tab_Form_TKedtLayout = new javax.swing.GroupLayout(pnl_tab_Form_TKedt);
        pnl_tab_Form_TKedt.setLayout(pnl_tab_Form_TKedtLayout);
        pnl_tab_Form_TKedtLayout.setHorizontalGroup(
            pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_Form_TKedtLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_tab_Form_TKedtLayout.createSequentialGroup()
                        .addComponent(pnChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(pnl_tab_Form_TKedtLayout.createSequentialGroup()
                        .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(78, 78, 78)
                        .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator11))
                        .addGap(26, 26, 26))
                    .addGroup(pnl_tab_Form_TKedtLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdcTo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnl_tab_Form_TKedtLayout.setVerticalGroup(
            pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_Form_TKedtLayout.createSequentialGroup()
                .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_tab_Form_TKedtLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_Form_TKedtLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jdcfrom, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcTo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(btnLoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)))
                .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_tab_Form_TKedtLayout.createSequentialGroup()
                        .addComponent(pnChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_Form_TKedtLayout.createSequentialGroup()
                                .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(1, 1, 1)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_tab_Form_TKedt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_tab_Form_TKedt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        try {
            Date DateFrom = jdcfrom.getDate();
            Date DateTo = jdcTo.getDate();

            long difference_In_Time = DateTo.getTime() - DateFrom.getTime();
            long difference_In_Days
                    = (difference_In_Time
                    / (1000 * 60 * 60 * 24));
            if (difference_In_Days < 1) {
                JOptionPane.showMessageDialog(pnChart, "Thời gian không hợp lệ!");
            } else {
                //  JOptionPane.showMessageDialog(pnChart, difference_In_Days);
                pnChart.removeAll();
                java.sql.Date date2 = new java.sql.Date(DateTo.getTime());
                System.out.println("Gui.FrmTongQuanBaoCao.btnLocActionPerformed()" + date2);
                bar_chart(date2, (int) difference_In_Days + 1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(pnChart, "Chưa chọn thời gian muốn thống kê!");
        }


    }//GEN-LAST:event_btnLocActionPerformed

    /**
     * Láy dữ liệu từ ngày
     *
     * @param date Date
     * @param int soNgay
     * @param map Map
     */
    private CategoryDataset createDataset(java.sql.Date date, int soNgay, Map<Date, Double> map) {

        ArrayList<String> arrDate = new ArrayList<String>();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        DateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i < soNgay; i++) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Date today = calendar.getTime();
            calendar.add(Calendar.DAY_OF_YEAR, -i);
            Date date2 = calendar.getTime();
            String date2_str = dateFormat.format(date2);

            if (i == 0) {
                String strNow = dateFormat.format(date);
                arrDate.add(strNow);
            } else {
                arrDate.add(date2_str);
            }

        }
        for (int i = arrDate.size() - 1; i >= 0; i--) {

            dataset.addValue(0, "đồng", arrDate.get(i));

            for (Date d : map.keySet()) {
                String d_str = dateFormat.format(d);

                if (arrDate.get(i).equals(d_str)) {
                    dataset.setValue(map.get(d), "đồng", arrDate.get(i));
                    break;
                }

            }
        }

//          dataset.addValue(8, "triệu đồng", "11/26/2021");  
        return dataset;
    }

    /**
     * Tạo Biểu đồ
     */
    public void bar_chart(java.sql.Date date2, int soNgay) {

        //lay ngay sau n ngay ngay
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date2);
        calendar.add(Calendar.DAY_OF_YEAR, -soNgay);
        Date date1 = calendar.getTime();
        //chuyen sang sql Date
        java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());

        Map<Date, Double> map = new HashMap<>();
        map = hdDao.getTongTienAboutDates(sqlDate1, date2);
        CategoryDataset dataset = createDataset(date2, soNgay, map);

        //Create chart 
        JFreeChart chart = ChartFactory.createBarChart(
                "Biểu đồ thống kê doanh thu", //Chart Title  
                "Ngày tháng", // Category axis  
                "Đồng", // Value axis  
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );
        TextTitle my_Chart_title = new TextTitle("Biểu đồ thống kê doanh thu", new Font("Dialog", Font.PLAIN, 18));
        chart.setTitle(my_Chart_title);
        /* Get instance of CategoryPlot */
        CategoryPlot plot = chart.getCategoryPlot();
        ChartPanel panel = new ChartPanel(chart);
        panel.setSize(800, 440);
        pnChart.add(panel);
        /* Change Bar colors */
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        renderer.setSeriesPaint(0, new java.awt.Color(29, 185, 195));
        Plot plott = chart.getPlot();

        plott.setBackgroundPaint(new java.awt.Color(253, 250, 246));

        Font font3 = new Font("Dialog", Font.PLAIN, 16);
        plot.getDomainAxis().setLabelFont(font3);
        plot.getRangeAxis().setLabelFont(font3);
        plot.setWeight(1);

        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.black);

        plot.setRangeGridlinePaint(Color.blue);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoc;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator9;
    private com.toedter.calendar.JDateChooser jdcTo;
    private com.toedter.calendar.JDateChooser jdcfrom;
    private javax.swing.JLabel lblSLKH;
    private javax.swing.JLabel lblSoDonTra;
    private javax.swing.JLabel lblSoHD;
    private javax.swing.JLabel lblSoSP;
    private javax.swing.JLabel lblSumDoanhThu;
    private javax.swing.JLabel lblTongLoiNhuan;
    private javax.swing.JLabel lblTySuat;
    private javax.swing.JPanel pnChart;
    private javax.swing.JPanel pnl_tab_Form_TKedt;
    // End of variables declaration//GEN-END:variables
}
