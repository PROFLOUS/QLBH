/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.toedter.calendar.JTextFieldDateEditor;
import dao.CaLamDao;
import dao.ChucVuDao;
import dao.LuongDao;
import dao.NhanVienDao;
import entity.CaLam;
import entity.ChucVu;
import entity.Luong;
import entity.NhanVien;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class FrmLuong extends javax.swing.JPanel {
private DefaultTableModel dfLuong_Model;
private DefaultTableModel dfLsLuong_Model;
private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
   ArrayList<CaLam> dsCa;
   ArrayList<NhanVien> dsNv;
    ArrayList<Luong> dsLuong;
    ArrayList<ChucVu> dsCv;
    CaLamDao ca_dao;
    NhanVienDao nv_dao;
    LuongDao l_dao;
    ChucVuDao cv_dao;
  
    public FrmLuong() {
        initComponents();
        dsCa = new ArrayList<CaLam>();
        ca_dao = new CaLamDao();
        nv_dao = new NhanVienDao();
        dsNv = new ArrayList<NhanVien>();
        dsLuong = new ArrayList<Luong>();
        dsCv = new ArrayList<ChucVu>();
        cv_dao = new ChucVuDao();
        l_dao = new LuongDao();
        upTblLuong();
        upCbo_CV();
         Date date = new  Date();
         dt_From.setDate(date);
         dt_To.setDate(date);
         jDateChooser3.setDate(date);
         JTextFieldDateEditor editor = (JTextFieldDateEditor) dt_From.getDateEditor();
        editor.setEditable(false);
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) dt_To.getDateEditor();
        editor2.setEditable(false);
        
    }
    
    //doc du lieu len cbo chuc vu
    public  void upCbo_CV(){
        dsCv = cv_dao.getAllCV();
        for (ChucVu cv : dsCv) {
            cbo_TkCv_Luong.addItem(cv.getTenCV());
        }
    }

    public void upTblLuong() {
        dfLuong_Model = (DefaultTableModel) tbl_Luong.getModel();
        dsLuong = l_dao.getAllLuong();
        for (Luong luong : dsLuong) {
            dfLuong_Model.addRow(new Object[]{
                luong.getMaNV().getMaNV(),luong.getMaNV().getTenNV(),luong.getMaCV().getTenCV(),
                luong.getMaCV().getHsLuong(),luong.getSoCa(),luong.getLuong()
            });
        }

    }
    
    public void xoaModelLuong(){
        DefaultTableModel del = (DefaultTableModel) tbl_Luong.getModel();
        del.getDataVector().removeAllElements();
    }
    //tìm thoe ngày
    public  void TkNgayLam(){
        l_dao = new LuongDao();
        
        String from = (String) formatter.format(dt_From.getDate());
        String to = (String) formatter.format(dt_To.getDate());
        ArrayList<Luong> list = l_dao.searchNgayLam(from,to);
        System.out.println("Gui.FrmLuong.TkNgayLam()"+list);
        for (Luong luong : list) {
                dfLuong_Model.addRow(new Object[]{
                    luong.getMaNV().getMaNV(),luong.getMaNV().getTenNV(),luong.getMaCV().getTenCV(),
                    luong.getMaCV().getHsLuong(),luong.getSoCa(),luong.getLuong()
                });
            }
        
    }
    
    //tìm tên chúc vụ trong bảng lương
    public  void TKCV(){
        l_dao = new LuongDao();
        String ten = cbo_TkCv_Luong.getSelectedItem().toString();
        if(ten.equals("Tất Cả")){
            dsLuong.removeAll(dsLuong);
            xoaModelLuong();
            upTblLuong();
        }else{
            ArrayList<Luong> list = l_dao.searchTenCV(ten);
        
        if(!list.isEmpty()){
            for (Luong luong : list) {
                dfLuong_Model.addRow(new Object[]{
                    luong.getMaNV().getMaNV(),luong.getMaNV().getTenNV(),luong.getMaCV().getTenCV(),
                    luong.getMaCV().getHsLuong(),luong.getSoCa(),luong.getLuong()
                });
            }
//            JOptionPane.showMessageDialog(this, "Đã tìm thấy ");
        }else{
            JOptionPane.showMessageDialog(this, " Khống có chức vụ nào ");
        }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jToggleButton3 = new javax.swing.JToggleButton();
        btnExit2 = new javax.swing.JToggleButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        pnl_tab_FormLuong = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Luong = new javax.swing.JTable();
        btn_TinhLuong = new javax.swing.JButton();
        btn_CapNhat_Luong = new javax.swing.JToggleButton();
        jPanel7 = new javax.swing.JPanel();
        cbo_TkCv_Luong = new javax.swing.JComboBox<>();
        dt_From = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dt_To = new com.toedter.calendar.JDateChooser();
        btnTkLuong = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        jFrame1.setUndecorated(true);
        jFrame1.setSize(new java.awt.Dimension(808, 467));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ", "Ngày Nhận", "Số Ca", "Lương"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable3);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lịch Sử Nhận Lương");

        jToggleButton3.setBackground(new java.awt.Color(21, 151, 229));
        jToggleButton3.setForeground(java.awt.Color.white);
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/system-update.png"))); // NOI18N
        jToggleButton3.setText("Cập nhật");
        jToggleButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnExit2.setBackground(new java.awt.Color(21, 151, 229));
        btnExit2.setForeground(java.awt.Color.white);
        btnExit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/close.png"))); // NOI18N
        btnExit2.setText("Thoát");
        btnExit2.setToolTipText("");
        btnExit2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExit2btnExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExit2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnl_tab_FormLuong.setBackground(new java.awt.Color(243, 244, 237));

        tbl_Luong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ", "Hệ Số Lương", "Số Ca", "Lương"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_Luong.setRowHeight(30);
        tbl_Luong.setShowGrid(true);
        tbl_Luong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_LuongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_Luong);

        btn_TinhLuong.setBackground(new java.awt.Color(21, 151, 229));
        btn_TinhLuong.setForeground(java.awt.Color.white);
        btn_TinhLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/salary.png"))); // NOI18N
        btn_TinhLuong.setText("Tính Lương");
        btn_TinhLuong.setToolTipText("");
        btn_TinhLuong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_TinhLuong.setEnabled(false);
        btn_TinhLuong.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_TinhLuongMouseDragged(evt);
            }
        });
        btn_TinhLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TinhLuongMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_TinhLuongMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_TinhLuongMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_TinhLuongMousePressed(evt);
            }
        });
        btn_TinhLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TinhLuongActionPerformed(evt);
            }
        });

        btn_CapNhat_Luong.setBackground(new java.awt.Color(21, 151, 229));
        btn_CapNhat_Luong.setForeground(java.awt.Color.white);
        btn_CapNhat_Luong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/system-update.png"))); // NOI18N
        btn_CapNhat_Luong.setText("Cập nhật");
        btn_CapNhat_Luong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CapNhat_Luong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CapNhat_LuongMouseClicked(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jPanel7.setForeground(new java.awt.Color(204, 204, 204));

        cbo_TkCv_Luong.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_TkCv_Luong.setForeground(new java.awt.Color(0, 0, 0));
        cbo_TkCv_Luong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả" }));
        cbo_TkCv_Luong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_TkCv_LuongItemStateChanged(evt);
            }
        });
        cbo_TkCv_Luong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_TkCv_LuongMouseClicked(evt);
            }
        });
        cbo_TkCv_Luong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_TkCv_LuongActionPerformed(evt);
            }
        });

        dt_From.setDateFormatString("dd-MM-yyyy");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Từ Ngày:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Đến Ngày:");

        dt_To.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cbo_TkCv_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(dt_From, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dt_To, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbo_TkCv_Luong, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt_From, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt_To, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        btnTkLuong.setBackground(new java.awt.Color(21, 151, 229));
        btnTkLuong.setForeground(java.awt.Color.white);
        btnTkLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search_1.png"))); // NOI18N
        btnTkLuong.setText("Tìm kiếm");
        btnTkLuong.setToolTipText("Nhập mã. tên NCC để tìm kiếm");
        btnTkLuong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTkLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTkLuongMouseClicked(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(21, 151, 229));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/history.png"))); // NOI18N
        jToggleButton1.setToolTipText("Chọn Để Xem Lịch Sử Nhân Viên Nhận Lương");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_tab_FormLuongLayout = new javax.swing.GroupLayout(pnl_tab_FormLuong);
        pnl_tab_FormLuong.setLayout(pnl_tab_FormLuongLayout);
        pnl_tab_FormLuongLayout.setHorizontalGroup(
            pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_FormLuongLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_tab_FormLuongLayout.createSequentialGroup()
                        .addComponent(btnTkLuong)
                        .addGap(32, 32, 32)
                        .addComponent(btn_CapNhat_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_TinhLuong)
                        .addGap(26, 26, 26)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        pnl_tab_FormLuongLayout.setVerticalGroup(
            pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_FormLuongLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_tab_FormLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_TinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_CapNhat_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTkLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1099, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_tab_FormLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_tab_FormLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_LuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_LuongMouseClicked
        btn_TinhLuong.setEnabled(true);
    }//GEN-LAST:event_tbl_LuongMouseClicked

    private void btn_TinhLuongMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TinhLuongMouseDragged
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_TinhLuongMouseDragged

    private void btn_TinhLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TinhLuongMouseClicked
        int r = tbl_Luong.getSelectedRow();
        String id = dfLuong_Model.getValueAt(r, 0).toString();
        if (r != -1) {
            System.out.println(id);
             ArrayList<Luong> list = l_dao.searchByMaNV(id);
             System.out.println("Gui.FrmLuong.btn_TinhLuongMouseClicked()"+list);
             for (Luong luong : list) {
                 dfLsLuong_Model = (DefaultTableModel) jTable3.getModel();
                dfLsLuong_Model.addRow(new Object[]{
                    luong.getMaNV().getMaNV(),luong.getMaNV().getTenNV(),luong.getMaCV().getTenCV(), new Date(),
                    luong.getSoCa(),luong.getLuong()
                });
            }
            dfLuong_Model.removeRow(r);
            l_dao.tinhLuong(id);
            dsCa.removeAll(dsCa);
            
            
            JOptionPane.showMessageDialog(null, "Nhân viên "+id+" đã nhận lương");
        } else {
            //JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
        }
    }//GEN-LAST:event_btn_TinhLuongMouseClicked

    private void btn_TinhLuongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TinhLuongMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TinhLuongMouseEntered

    private void btn_TinhLuongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TinhLuongMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TinhLuongMouseExited

    private void btn_TinhLuongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TinhLuongMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_TinhLuongMousePressed

    private void btn_TinhLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TinhLuongActionPerformed

    }//GEN-LAST:event_btn_TinhLuongActionPerformed

    private void btn_CapNhat_LuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CapNhat_LuongMouseClicked
        dsLuong.removeAll(dsLuong);
        xoaModelLuong();
        upTblLuong();
    }//GEN-LAST:event_btn_CapNhat_LuongMouseClicked

    private void cbo_TkCv_LuongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_TkCv_LuongItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            dfLuong_Model.setRowCount(0);
            TKCV();
        }
    }//GEN-LAST:event_cbo_TkCv_LuongItemStateChanged

    private void cbo_TkCv_LuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_TkCv_LuongMouseClicked

    }//GEN-LAST:event_cbo_TkCv_LuongMouseClicked

    private void cbo_TkCv_LuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_TkCv_LuongActionPerformed

    }//GEN-LAST:event_cbo_TkCv_LuongActionPerformed

    private void btnTkLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTkLuongMouseClicked
        dfLuong_Model.setRowCount(0);
        TkNgayLam();
        
        
    }//GEN-LAST:event_btnTkLuongMouseClicked

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        
        jFrame1.setVisible(true);
        jFrame1.setResizable(false);
        jFrame1.setLocationRelativeTo(null);
               
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void btnExit2btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExit2btnExitMouseClicked
        
        jFrame1.setVisible(false);
    }//GEN-LAST:event_btnExit2btnExitMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnExit2;
    private javax.swing.JButton btnTkLuong;
    private javax.swing.JToggleButton btn_CapNhat_Luong;
    private javax.swing.JButton btn_TinhLuong;
    private javax.swing.JComboBox<String> cbo_TkCv_Luong;
    private com.toedter.calendar.JDateChooser dt_From;
    private com.toedter.calendar.JDateChooser dt_To;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JTable jTable3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JPanel pnl_tab_FormLuong;
    private javax.swing.JTable tbl_Luong;
    // End of variables declaration//GEN-END:variables
}
