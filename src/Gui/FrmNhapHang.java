/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Connect.connect;
import dao.PanelSearch;
import dao.EventClick;
import dao.BanHangDao;
import dao.CT_HoaDonNhapDao;
import dao.DanhMucSPDao;
import dao.HoaDonNhapDao;
import dao.KhachHangDao;
import dao.NhaCCDao;
import dao.NhanVienDao;
import dao.SanPhamDao;
import entity.CT_HoaDonNhap;
import entity.DanhMucSP;
import entity.HoaDonNhap;
import entity.KhachHang;
import entity.NhaCC;
import entity.NhanVien;
import entity.SanPham;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HP
 */
public class FrmNhapHang extends javax.swing.JPanel {

    ArrayList<DanhMucSP> dsDmSP;
    DanhMucSPDao dm_dao;
    private JPopupMenu menu;
    private PanelSearch search;
    private JPopupMenu menu2;
    private PanelSearch search2;

    BanHangDao bhDao;
    KhachHangDao khDao;
    NhaCCDao nccDao;
    SanPhamDao sp_dao;
    private DefaultTableModel dfbh_model;
    private ArrayList<SanPham> dstt = null;
    private ArrayList<SanPham> dssp;
    private int soLuongTon = 0;

    SanPham sp = new SanPham();
    private double tong;
    private int r;
    final JFileChooser fileDialog = new JFileChooser();
    JFrame cha = new JFrame();
    private double thanhTien;
    private int soLuong;
    private int slNhap;
    private double tongtien;

    public FrmNhapHang() {
        initComponents();
        sp_dao = new SanPhamDao();
        dm_dao = new DanhMucSPDao();
        jPanel6.setVisible(false);
        bhDao = new BanHangDao();
        khDao = new KhachHangDao();
        nccDao = new NhaCCDao();
        dstt = new ArrayList<SanPham>();
        dssp = new ArrayList<SanPham>();
        SanPham sp = new SanPham();
        menu = new JPopupMenu();
        search = new PanelSearch();
        menu2 = new JPopupMenu();
        search2 = new PanelSearch();
        lbl_TienPhaiTra.setEnabled(false);
        menu2.add(search2);
        menu2.setFocusable(false);
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick(new EventClick() {

            @Override
            public void itemClick(SanPham data) {

                dfbh_model = (DefaultTableModel) tbl_BanHang.getModel();
                System.out.println("Click" + data.getTenSP());
                menu.setVisible(false);
                String maSp = (data.getMaSP());
                String tenSp = (data.getTenSP());
                String mau = (data.getMauSac());
                double donGia = (data.getDonGia());
                String size = (data.getSize());
                double giaNhap =(data.getGiaNhap());
                soLuong = 1;
                thanhTien = soLuong * giaNhap;

                SanPham sp = new SanPham(maSp, tenSp, donGia, soLuong, size, mau,giaNhap);

                //tao vi tri sp
                int vitri = vitriSP(sp);
                System.out.println(vitri);

                if (vitri > -1) {
                    Integer sl = dstt.get(vitri).getSoLuong() + 1;
                    dstt.get(vitri).setSoLuong(sl);
                    tongtien = sl * sp.getGiaNhap();
                    dfbh_model.setValueAt(sl, vitri, 3);
                    dfbh_model.setValueAt(tongtien, vitri, 6);
                } else {
                    try {
                        dstt.add(sp);
                    } catch (Exception e) {
                        System.out.println("loi add");
                        e.printStackTrace();
                    }
                    dfbh_model.addRow(new Object[]{
                        sp.getMaSP(), sp.getTenSP(), sp.getMauSac(), soLuong,sp.getGiaNhap(),sp.getDonGia(), thanhTien
                    });
                }
                TinhTong3();
            }

            @Override
            public void itemClick(KhachHang data) {
            }

            @Override
            public void itemClick(NhaCC data) {
            }

        });
        //enven click chon Nha cung cap
        search2.addEventClick(new EventClick() {
            @Override
            public void itemClick(SanPham data) {
            }

            @Override
            public void itemClick(KhachHang data) {
//               String maKh = data.getMaKH();
//               String tenKh = data.getTenKH();
//               String sDT = data.getSdt();
//               lbl_TenKh.setText(tenKh);
//               lbl_maKh.setText(maKh);
//               lbl_SDT.setText(sDT);
//               menu2.setVisible(false);
//               lbl_XoaKh.setEnabled(true);
//               btn_AddKh.setVisible(false);
//               txt_Search_KH.setVisible(false);
//                System.out.println(lbl_TenKh.getText());
            }

            @Override
            public void itemClick(NhaCC data) {
                String maNcc = data.getMaNCC();
                String tenNcc = data.getTenNCC();
                String sdt = data.getSdt();
                String diaChi = data.getDiaChi();

                txtMaNCC1.setText(maNcc);
                txtTenNCC.setText(tenNcc);
                txtSDTNCC2.setText(sdt);
                txtDiaChiNCC.setText(diaChi);
                jLabel3.setText(sdt);
                jLabel4.setText(diaChi);
                menu2.setVisible(false);
                jPanel7.setVisible(false);
                jPanel6.setVisible(true);

            }
        });

        upCbo_DM();
        Hide();
        lbl_HinhAnh.setIcon(new ImageIcon("D:\\code\\DeTai_NB\\PTUD_QLBH-main - Copy\\PTUD_QLBH-main\\src\\imgVSicon\\image.png"));
    }

    //tao vi tri san pham
    private int vitriSP(SanPham sp) {
        int i = -1;
        try {
            if (dstt.contains(sp)) {
                return dstt.indexOf(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi");
        }
        return i;
    }

    //kiem tra du lieu them nha cc moi
    public boolean kiemTraData() {
        String tenNcc = txt_tenNcc.getText().trim();
        String sdt = txt_sdt.getText().trim();
        String diachi = txt_DiaChi.getText().trim();
        String email = txt_email.getText().trim();

        String regexMail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";//check mail
        String regexPhone = "^[0-9]{10}";
        //ten ncc 
        if (tenNcc.length() <= 0) {
            JOptionPane.showMessageDialog(btn_Luu1, "Tên NCC không được để trống");
            return false;
        }
        if (diachi.length() <= 0) {
            JOptionPane.showMessageDialog(btn_Luu1, "Địa chỉ NCC không được để trống");
            return false;
        }
//            if(!email.matches(regexMail)){
//		JOptionPane.showMessageDialog(btnLuu, "Email không đúng định dạng");			
//		return false;             
//           }
        if (!sdt.matches(regexPhone)) {
            JOptionPane.showMessageDialog(btn_Luu1, "Số điện thoại có 10 số");
            return false;
        }
        return true;
    }

    //kiem tra du lieu them san pham
    public boolean kiemTraDataSp() {
        String giaNhap = txt_GiaNhap.getText().trim();
        String tenSP = txt_TenSp.getText().trim();
        String mau = txt_MauSac.getText().trim();
        String size = txt_Size.getText().trim();
        String slKho = txt_SlKho.getText().trim();
        String donGia = txt_GiaBan.getText().trim();

        // Tên sản phẩm phải là chữ
        if (!(tenSP.length() > 0)) {
            JOptionPane.showMessageDialog(this, "Tên Sản Phẩm phải là chữ");
            return false;
        }
        //Mau phải là chữ
        if (!(mau.length() > 0 )) {
            JOptionPane.showMessageDialog(this, "Mầu sắc phải là chữ");
            return false;
        }
        //size ko am
        if (!(size.length() > 0 )) {
            JOptionPane.showMessageDialog(this, "Size sản phẩm không được là số âm");
            return false;
        }
        //sl kho số ko âm
        if (slKho.length() > 0) {
            try {
                int x = Integer.parseInt(slKho);
                if (x <= 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải nhập số nguyên dương");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Số lượng phải nhập số nguyên dương");
                return false;
            }
        }
        //sl số ko âm
        //Đơn giá số ko âm
        if (donGia.length() > 0) {
            try {
                int x = Integer.parseInt(donGia);
                if (x <= 0) {
                    JOptionPane.showMessageDialog(this, "Đơn Giá phải nhập số nguyên dương");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Đơn Giá phải nhập số nguyên dương");
                return false;
            }
        }
        if (giaNhap.length() > 0) {
            try {
                int x = Integer.parseInt(giaNhap);
                if (x <= 0) {
                    JOptionPane.showMessageDialog(this, "Giá Nhập phải nhập số nguyên dương");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Giá Nhập phải nhập số nguyên dương");
                return false;
            }
        }
        
        return true;
    }

    //láy thông tin trên textfield sản phẩm
    public SanPham restTextSp() {
        
        Double giaNhap = Double.parseDouble(txt_GiaNhap.getText().toString());
        String tenSp = txt_TenSp.getText().toString();
        String tenDm = cbo_Dm.getSelectedItem().toString();
        DanhMucSP dm = dm_dao.getDMByTen(tenDm);
        String mau = txt_MauSac.getText().toString();
        String size = txt_Size.getText().toString();
        slNhap = Integer.parseInt(txt_SlKho.getText().toString());
        int slKho =0;
        double donGia = Double.parseDouble(txt_GiaBan.getText());
        String hinh = lbl_HinhAnh.getIcon().toString();
        return new SanPham(dm, tenSp, donGia, slKho, hinh, size, mau, giaNhap);
    }

    //lay du lieu tu tef
    public NhaCC restText() {
        String tenNcc = txt_tenNcc.getText().toString();
        String sdt = txt_sdt.getText().toString();
        String diachi = txt_DiaChi.getText().toString();
        String email = txt_email.getText().toString();
        return new NhaCC(tenNcc, sdt, email, diachi);
    }

    //xoa rong text them nha cc
    public void xoaRongText() {
        txt_SlKho.setText("");
        txt_TenSp.setText("");
        txt_GiaBan.setText("");
        txt_Size.setText("");
        txt_MauSac.setText("");
        txt_GiaNhap.setText("");
        lbl_HinhAnh.setIcon(new ImageIcon("D:\\code\\DeTai_NB\\PTUD_QLBH-main - Copy\\PTUD_QLBH-main\\src\\imgVSicon\\image.png"));
        txt_GiaNhap.requestFocus();
    }

    //xóa sảm phảm từ dơn hàng
    public void huy(int r) {

        String masp = dstt.get(r).getMaSP();
        int index = -1;
        for (SanPham sp : dssp) {
            if (sp.getMaSP() == masp) {
                index = dssp.indexOf(sp);
                break;
            }
        }

        dfbh_model.removeRow(r);
        dstt.remove(r);
    }

    //tính tổng tiền
//    public void TinhTong() {
//        DecimalFormat x = new DecimalFormat("###,###,###");
//        tong = 0;
//        for (int i = 0; i < tbl_BanHang.getRowCount(); i++) {
//            tong += Double.parseDouble(tbl_BanHang.getValueAt(i, 5).toString());
//        }
//        System.out.println("tong" + tong);
//        lbl_TongTien.setText(x.format(tong));
//        lbl_TienPhaiTra.setText(x.format(tong));
////        lbl_TongTien.setText(String.valueOf(tong));
////        lbl_TienPhaiTra.setText(String.valueOf(tong));
//    }

    //tính tổng tiền
    public void TinhTong2() {
        DecimalFormat x = new DecimalFormat("###,###,###");
        tong = 0;
        for (int i = 0; i < tbl_BanHang.getRowCount(); i++) {
            tong += Double.parseDouble(tbl_BanHang.getValueAt(i, 6).toString());
        }
        System.out.println("tong" + tong);
//        lbl_TongTien.setText(x.format(tong));
        lbl_TienPhaiTra.setText(x.format(tong));
//        lbl_TongTien.setText(String.valueOf(tong));
//        lbl_TienPhaiTra.setText(String.valueOf(tong));

    }
    //tính tổng tiền
    public void TinhTong3(){        
        // tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của Việt Nam
        // đơn vị tiền tệ của Việt Nam là đồng
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        tong =0.0;
        for( int i = 0;i<tbl_BanHang.getRowCount();i++){
            tong += Double.parseDouble( tbl_BanHang.getValueAt(i, 6).toString());
        }
//        lbl_TongTien.setText(currencyVN.format(tong));
        lbl_TienPhaiTra.setText(currencyVN.format(tong));
        
    }

    //tính tiền thừ
//    public void TinhTienThua(){
//        DecimalFormat x = new DecimalFormat("###,###,###");
//        double d = 3.76628729;
//        double tienThua = 0;
//        double tienTra = tong;
//        double tienDua = Double.valueOf(txt_TienDua.getText().toString());
//        
//        tienThua = tienDua-tienTra;
//        System.out.println("tienthua"+tienThua);
//        lbl_TienThua.setText(x.format(tienThua));
//    }
    //ẩn các nút chức năng
    public void Hide() {
        btn_XoaMatHang.setVisible(false);
        lbl_TextSL.setVisible(false);
        lbl_GiamSL.setVisible(false);
        lbl_TangSL.setVisible(false);
        txt_SuaSL.setVisible(false);
        txtMaNCC1.setEditable(false);
        txtTenNCC.setEditable(false);
        txtSDTNCC2.setEditable(false);
        txtDiaChiNCC.setEditable(false);
    }

    //chuyen doi kieu tien te sang double
    //@param: 128.000 d
    //@return 128000
    public Double changeMoney(String money) {
        if (money.length() > 1) {
            String newMoney = money.substring(0, money.length() - 2).replace(".", "");
            return Double.parseDouble(newMoney);
        }
        return 0.0;
    }

    //tính tiền thừ va cap nhat tien thua len giao dien
    //tienthua = tienkhachdua - tienphaitra
    public void TinhTienThua() {
//           // tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của Việt Nam
//        // đơn vị tiền tệ của Việt Nam là đồng
//        Locale localeVN = new Locale("vi", "VN");
//        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
//        
//      String tienPhaiTra = lbl_TienPhaiTra.getText();
//      String tienKhachDua = txt_TienDua1.getText();
//      Double tienThua = changeMoney(tienKhachDua) - changeMoney(tienPhaiTra);
//       lbl_TienPhaiTra.setText(currencyVN.format(tienThua));

//        Double tienNhap = Double.valueOf(lbl_TongTien.getText().toString());
//        Double tienThue = Double.valueOf(txt_TienDua1.getText().toString());

//        Double togTien = tienNhap + tienThue;
//        lbl_TienPhaiTra.setText(togTien.toString());

    }

    //đọc dữ liệu lên combobox danh mục
    public void upCbo_DM() {
        dsDmSP = dm_dao.getAllDM();
        for (DanhMucSP dm : dsDmSP) {
            cbo_Dm.addItem(dm.getTenLoai());
//           
        }
    }

    //Kiem tra nhap hang
    private boolean kiemTraTruocNhapHang() {

        //kiem tra table co san pham can ban nao chua
        if (tbl_BanHang.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(tbl_BanHang, "Bạn chưa có sản phẩm nào để nhập");
            return false;
        }
        //neu chua chon khach hang
        if (txtMaNCC1.getText().length() == 0 && txtSDTNCC2.getText().length() == 0) {
            JOptionPane.showMessageDialog(tbl_BanHang, "Chưa nhập thông tin Nhà Cung Cấp!");
            return false;
        }

        return true;
    }

    //xoa rong nhap hang
    public void xoaRong() {
        txtMaNCC1.setText("");
        txtTenNCC.setText("");
        txtSDTNCC2.setText("");
        txtDiaChiNCC.setText("");
        jPanel6.setVisible(false);
        jPanel7.setVisible(true);
        dfbh_model.setRowCount(0);
//        lbl_TongTien.setText("");
//        txt_TienDua1.setText("");
        lbl_TienPhaiTra.setText("");
        
        btn_XoaMatHang.setVisible(false);
        lbl_TextSL.setVisible(false);
        lbl_GiamSL.setVisible(false);
        lbl_TangSL.setVisible(false);
        txt_SuaSL.setVisible(false);
        txt_Search_KH2.requestFocus();

    }

    //xuat hoa don
    public void printBill(String maHDN) {
        try {

            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src\\Gui/rptHoaDon.jrxml");

            map.put("MaHD", maHDN);

            JasperPrint p = JasperFillManager.fillReport(report, map, connect.getConnection());
            JasperViewer.viewReport(p, false);
            // JasperExportManager.exportReportToPdfFile(p, "test.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    //lay san pham tren table
    public List<SanPham> getSpFromTB() {
        List<SanPham> list = new ArrayList<SanPham>();
        for (int i = 0; i < tbl_BanHang.getRowCount(); i++) {
            String maSp = tbl_BanHang.getValueAt(i, 0).toString();
            String tenSp = tbl_BanHang.getValueAt(i, 1).toString();
            String mau = tbl_BanHang.getValueAt(i, 2).toString();
            String SL = tbl_BanHang.getValueAt(i, 3).toString();
            String donGia = tbl_BanHang.getValueAt(i, 4).toString();
            String giaNhap = tbl_BanHang.getValueAt(i, 5).toString();
            SanPham sp = new SanPham(maSp, tenSp, Double.parseDouble(donGia), Integer.parseInt(SL), mau,Double.parseDouble(giaNhap));
            list.add(sp);
        }
        return list;
    }
    
    
//    public String TaoMaHD(){
//        Random rand = new Random();
//         int ranNum = rand.nextInt(100000000)+ 1;
//         String maHD = "HDNH"+String.valueOf(ranNum);
//         
//         return maHD;
//    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbl_MauSac = new javax.swing.JLabel();
        txt_TenSp = new javax.swing.JTextField();
        lbl_Size = new javax.swing.JLabel();
        txt_Size = new javax.swing.JTextField();
        lbl_DonGia = new javax.swing.JLabel();
        txt_GiaBan = new javax.swing.JTextField();
        lbl_TenSp = new javax.swing.JLabel();
        txt_MauSac = new javax.swing.JTextField();
        lbl_DanhMuc = new javax.swing.JLabel();
        cbo_Dm = new javax.swing.JComboBox<>();
        lbl_SlKho = new javax.swing.JLabel();
        txt_SlKho = new javax.swing.JTextField();
        btn_Luu = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        lbl_HinhAnh = new javax.swing.JLabel();
        lbl_TenSp2 = new javax.swing.JLabel();
        txt_GiaNhap = new javax.swing.JTextField();
        jFrame2 = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbl_MauSac1 = new javax.swing.JLabel();
        txt_tenNcc = new javax.swing.JTextField();
        lbl_Size1 = new javax.swing.JLabel();
        txt_DiaChi = new javax.swing.JTextField();
        lbl_TenSp1 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        lbl_SlKho1 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        btn_Luu1 = new javax.swing.JButton();
        btn_Xoa1 = new javax.swing.JButton();
        pnl_FormBanHang = new javax.swing.JPanel();
        lbl_text_BanHang = new javax.swing.JLabel();
        pnl_tab_Form_BangHang = new javax.swing.JPanel();
        pnl_ThanhToan = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbl_TienPhaiTra = new javax.swing.JLabel();
        lbl_maKh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txt_Ghichu = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        pnl_textSearch = new javax.swing.JPanel();
        txt_Search_SP = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        btn_XoaMatHang = new javax.swing.JButton();
        txt_SuaSL = new javax.swing.JTextField();
        lbl_TextSL = new javax.swing.JLabel();
        lbl_GiamSL = new javax.swing.JLabel();
        lbl_TangSL = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel6 = new javax.swing.JPanel();
        txtMaNCC1 = new javax.swing.JTextField();
        lblMaNCC = new javax.swing.JLabel();
        lblTenNCC = new javax.swing.JLabel();
        txtTenNCC = new javax.swing.JTextField();
        lblSDT = new javax.swing.JLabel();
        txtSDTNCC2 = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChiNCC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        txt_Search_KH2 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_BanHang = new javax.swing.JTable();

        jFrame1.setUndecorated(true);
        jFrame1.setSize(new java.awt.Dimension(898, 483));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(90, 103, 121)));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nhập Sản Phẩm Mới ");
        jLabel6.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        lbl_MauSac.setBackground(new java.awt.Color(203, 214, 225));
        lbl_MauSac.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MauSac.setForeground(new java.awt.Color(90, 103, 121));
        lbl_MauSac.setText("Màu Sắc ");

        txt_TenSp.setBackground(new java.awt.Color(255, 255, 255));
        txt_TenSp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_TenSp.setForeground(new java.awt.Color(0, 0, 0));
        txt_TenSp.setToolTipText("");

        lbl_Size.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_Size.setForeground(new java.awt.Color(90, 103, 121));
        lbl_Size.setText("Size");

        txt_Size.setBackground(new java.awt.Color(255, 255, 255));
        txt_Size.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_Size.setForeground(new java.awt.Color(0, 0, 0));
        txt_Size.setToolTipText("");

        lbl_DonGia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_DonGia.setForeground(new java.awt.Color(90, 103, 121));
        lbl_DonGia.setText("Giá Bán");

        txt_GiaBan.setBackground(new java.awt.Color(255, 255, 255));
        txt_GiaBan.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_GiaBan.setForeground(new java.awt.Color(0, 0, 0));
        txt_GiaBan.setToolTipText("");

        lbl_TenSp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_TenSp.setForeground(new java.awt.Color(90, 103, 121));
        lbl_TenSp.setText("Tên Sản Phẩm ");

        txt_MauSac.setBackground(new java.awt.Color(255, 255, 255));
        txt_MauSac.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_MauSac.setForeground(new java.awt.Color(0, 0, 0));
        txt_MauSac.setToolTipText("");

        lbl_DanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_DanhMuc.setForeground(new java.awt.Color(90, 103, 121));
        lbl_DanhMuc.setText("Danh Mục");

        cbo_Dm.setBackground(new java.awt.Color(255, 255, 255));
        cbo_Dm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_Dm.setForeground(new java.awt.Color(0, 0, 0));

        lbl_SlKho.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_SlKho.setForeground(new java.awt.Color(90, 103, 121));
        lbl_SlKho.setText("Số Lượng Nhập");

        txt_SlKho.setBackground(new java.awt.Color(255, 255, 255));
        txt_SlKho.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_SlKho.setForeground(new java.awt.Color(0, 0, 0));
        txt_SlKho.setToolTipText("");

        btn_Luu.setBackground(new java.awt.Color(21, 151, 229));
        btn_Luu.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_Luu.setForeground(new java.awt.Color(255, 255, 255));
        btn_Luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/clipboard.png"))); // NOI18N
        btn_Luu.setText("Nhập Sản Phẩm");
        btn_Luu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Luu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LuuMouseClicked(evt);
            }
        });
        btn_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuActionPerformed(evt);
            }
        });

        btn_Xoa.setBackground(new java.awt.Color(255, 102, 102));
        btn_Xoa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/close (1).png"))); // NOI18N
        btn_Xoa.setText("Thoát");
        btn_Xoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaMouseClicked(evt);
            }
        });

        lbl_HinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        lbl_HinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_HinhAnh.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 153, 255)));
        lbl_HinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_HinhAnhMouseClicked(evt);
            }
        });

        lbl_TenSp2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_TenSp2.setForeground(new java.awt.Color(90, 103, 121));
        lbl_TenSp2.setText("Giá Nhập");

        txt_GiaNhap.setBackground(new java.awt.Color(255, 255, 255));
        txt_GiaNhap.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_GiaNhap.setForeground(new java.awt.Color(0, 0, 0));
        txt_GiaNhap.setToolTipText("");
        txt_GiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GiaNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Xoa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_HinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_TenSp)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbl_Size, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_DonGia, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_Size, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(txt_GiaBan, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_TenSp2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_GiaNhap, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_SlKho)
                                    .addComponent(lbl_MauSac)
                                    .addComponent(lbl_DanhMuc)
                                    .addComponent(txt_MauSac)
                                    .addComponent(cbo_Dm, 0, 300, Short.MAX_VALUE)
                                    .addComponent(txt_SlKho)))
                            .addComponent(txt_TenSp))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_TenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_MauSac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_HinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_Size)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_DanhMuc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbo_Dm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_TenSp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_GiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_DonGia)
                            .addComponent(lbl_SlKho))))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_GiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_SlKho, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jFrame2.setUndecorated(true);
        jFrame2.setSize(new java.awt.Dimension(747, 318));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(90, 103, 121)));

        jPanel5.setBackground(new java.awt.Color(102, 153, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thêm Nhà Cung Cấp Mới ");
        jLabel7.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        lbl_MauSac1.setBackground(new java.awt.Color(203, 214, 225));
        lbl_MauSac1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MauSac1.setForeground(new java.awt.Color(90, 103, 121));
        lbl_MauSac1.setText("Số Điện Thoại");

        txt_tenNcc.setBackground(new java.awt.Color(255, 255, 255));
        txt_tenNcc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_tenNcc.setForeground(new java.awt.Color(0, 0, 0));
        txt_tenNcc.setToolTipText("");

        lbl_Size1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_Size1.setForeground(new java.awt.Color(90, 103, 121));
        lbl_Size1.setText("Địa Chỉ ");

        txt_DiaChi.setBackground(new java.awt.Color(255, 255, 255));
        txt_DiaChi.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_DiaChi.setForeground(new java.awt.Color(0, 0, 0));
        txt_DiaChi.setToolTipText("");

        lbl_TenSp1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_TenSp1.setForeground(new java.awt.Color(90, 103, 121));
        lbl_TenSp1.setText("Tên Nhà Cung Cấp ");

        txt_sdt.setBackground(new java.awt.Color(255, 255, 255));
        txt_sdt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_sdt.setForeground(new java.awt.Color(0, 0, 0));
        txt_sdt.setToolTipText("");

        lbl_SlKho1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_SlKho1.setForeground(new java.awt.Color(90, 103, 121));
        lbl_SlKho1.setText("Email");

        txt_email.setBackground(new java.awt.Color(255, 255, 255));
        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_email.setForeground(new java.awt.Color(0, 0, 0));
        txt_email.setToolTipText("");

        btn_Luu1.setBackground(new java.awt.Color(21, 151, 229));
        btn_Luu1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_Luu1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Luu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/clipboard.png"))); // NOI18N
        btn_Luu1.setText("Lưu");
        btn_Luu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Luu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Luu1MouseClicked(evt);
            }
        });
        btn_Luu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Luu1ActionPerformed(evt);
            }
        });

        btn_Xoa1.setBackground(new java.awt.Color(255, 102, 102));
        btn_Xoa1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_Xoa1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/close (1).png"))); // NOI18N
        btn_Xoa1.setText("Thoát");
        btn_Xoa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Xoa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Xoa1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_TenSp1)
                            .addComponent(lbl_Size1)
                            .addComponent(txt_tenNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txt_DiaChi))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_SlKho1)
                            .addComponent(lbl_MauSac1)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txt_email))
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_Luu1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btn_Xoa1)
                        .addGap(42, 42, 42))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_MauSac1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_TenSp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tenNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(lbl_Size1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_SlKho1)
                        .addGap(5, 5, 5)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Xoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Luu1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setPreferredSize(new java.awt.Dimension(1090, 700));

        pnl_FormBanHang.setBackground(new java.awt.Color(243, 244, 237));
        pnl_FormBanHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_BanHang.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_BanHang.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_BanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_BanHang.setText("Bán Hàng");
        pnl_FormBanHang.add(lbl_text_BanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_tab_Form_BangHang.setBackground(new java.awt.Color(243, 244, 237));
        pnl_tab_Form_BangHang.setPreferredSize(new java.awt.Dimension(1090, 720));
        pnl_tab_Form_BangHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_ThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        pnl_ThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(102, 153, 255)));
        pnl_ThanhToan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Tổng Tiền Hóa Đơn:");
        pnl_ThanhToan.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 30));

        lbl_TienPhaiTra.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TienPhaiTra.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_TienPhaiTra.setForeground(new java.awt.Color(0, 102, 204));
        lbl_TienPhaiTra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_TienPhaiTra.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
        pnl_ThanhToan.add(lbl_TienPhaiTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 298, 30));

        lbl_maKh.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_maKh.setForeground(new java.awt.Color(255, 255, 255));
        lbl_maKh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnl_ThanhToan.add(lbl_maKh, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 66, 18, 46));
        pnl_ThanhToan.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1043, 6, -1, 40));

        jButton4.setBackground(new java.awt.Color(102, 153, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Nhập Hàng");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        pnl_ThanhToan.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 84, 190, 46));

        txt_Ghichu.setBackground(new java.awt.Color(255, 255, 255));
        txt_Ghichu.setFont(new java.awt.Font("Consolas", 0, 15)); // NOI18N
        txt_Ghichu.setForeground(new java.awt.Color(153, 153, 153));
        txt_Ghichu.setText("Nhập ghi chú đơn hàng");
        txt_Ghichu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
        txt_Ghichu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_GhichuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_GhichuFocusLost(evt);
            }
        });
        txt_Ghichu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GhichuActionPerformed(evt);
            }
        });
        pnl_ThanhToan.add(txt_Ghichu, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 10, 324, 30));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/pencil1.png"))); // NOI18N
        jButton9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        pnl_ThanhToan.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 10, 32, 30));

        pnl_tab_Form_BangHang.add(pnl_ThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 1070, 140));

        pnl_textSearch.setBackground(new java.awt.Color(102, 153, 255));
        pnl_textSearch.setPreferredSize(new java.awt.Dimension(1090, 100));

        txt_Search_SP.setBackground(new java.awt.Color(102, 153, 255));
        txt_Search_SP.setFont(new java.awt.Font("Consolas", 0, 15)); // NOI18N
        txt_Search_SP.setForeground(new java.awt.Color(153, 204, 255));
        txt_Search_SP.setText("Thêm Sản Phẩm Nhập");
        txt_Search_SP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_Search_SP.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_Search_SP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_Search_SPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_Search_SPFocusLost(evt);
            }
        });
        txt_Search_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_Search_SPMouseClicked(evt);
            }
        });
        txt_Search_SP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Search_SPActionPerformed(evt);
            }
        });
        txt_Search_SP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Search_SPKeyReleased(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search3.png"))); // NOI18N
        jButton8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btn_XoaMatHang.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btn_XoaMatHang.setForeground(new java.awt.Color(255, 255, 255));
        btn_XoaMatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/delete.png"))); // NOI18N
        btn_XoaMatHang.setToolTipText("Xóa sản phẩm khỏi đơn");
        btn_XoaMatHang.setBorder(null);
        btn_XoaMatHang.setContentAreaFilled(false);
        btn_XoaMatHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_XoaMatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaMatHangMouseClicked(evt);
            }
        });
        btn_XoaMatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaMatHangActionPerformed(evt);
            }
        });

        txt_SuaSL.setBackground(new java.awt.Color(102, 153, 255));
        txt_SuaSL.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txt_SuaSL.setForeground(new java.awt.Color(255, 255, 255));
        txt_SuaSL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_SuaSL.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_SuaSL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_SuaSLFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_SuaSLFocusLost(evt);
            }
        });
        txt_SuaSL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_SuaSLMouseClicked(evt);
            }
        });
        txt_SuaSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SuaSLActionPerformed(evt);
            }
        });
        txt_SuaSL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SuaSLKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SuaSLKeyTyped(evt);
            }
        });

        lbl_TextSL.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_TextSL.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TextSL.setText("Số lượng:");

        lbl_GiamSL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/minus.png"))); // NOI18N
        lbl_GiamSL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_GiamSL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_GiamSLMouseClicked(evt);
            }
        });

        lbl_TangSL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/add1.png"))); // NOI18N
        lbl_TangSL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_TangSL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_TangSLMouseClicked(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/new-product.png"))); // NOI18N
        jButton1.setToolTipText("Nhập Sản Phẩm Mới");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_textSearchLayout = new javax.swing.GroupLayout(pnl_textSearch);
        pnl_textSearch.setLayout(pnl_textSearchLayout);
        pnl_textSearchLayout.setHorizontalGroup(
            pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_textSearchLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton8)
                .addGap(0, 0, 0)
                .addComponent(txt_Search_SP, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addComponent(lbl_TextSL)
                .addGap(18, 18, 18)
                .addComponent(lbl_GiamSL, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_SuaSL, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_TangSL)
                .addGap(29, 29, 29)
                .addComponent(btn_XoaMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        pnl_textSearchLayout.setVerticalGroup(
            pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_textSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_XoaMatHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_textSearchLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(pnl_textSearchLayout.createSequentialGroup()
                                .addGroup(pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_SuaSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_TextSL)
                                    .addComponent(lbl_GiamSL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_TangSL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_textSearchLayout.createSequentialGroup()
                .addGroup(pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_textSearchLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_Search_SP)))
                .addGap(12, 12, 12))
        );

        pnl_tab_Form_BangHang.add(pnl_textSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 1070, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 153, 255), new java.awt.Color(0, 204, 255)), "Thông Tin Nhà Cung Cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        txtMaNCC1.setForeground(new java.awt.Color(0, 0, 0));
        txtMaNCC1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaNCC1FocusGained(evt);
            }
        });
        txtMaNCC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNCC1ActionPerformed(evt);
            }
        });

        lblMaNCC.setText("Mã NCC: ");

        lblTenNCC.setText("Tên NCC: ");

        txtTenNCC.setForeground(new java.awt.Color(0, 0, 0));
        txtTenNCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenNCCFocusGained(evt);
            }
        });
        txtTenNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNCCActionPerformed(evt);
            }
        });

        lblSDT.setText("SĐT:");

        txtSDTNCC2.setForeground(new java.awt.Color(0, 0, 0));
        txtSDTNCC2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSDTNCC2FocusGained(evt);
            }
        });
        txtSDTNCC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTNCC2ActionPerformed(evt);
            }
        });

        lblDiaChi.setText("Địa chỉ:");

        txtDiaChiNCC.setForeground(new java.awt.Color(0, 0, 0));
        txtDiaChiNCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiaChiNCCFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Địa Chỉ Xuất Hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("016558741548");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nguyễn Văn Bảo-Gò Vấp");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/reload.png"))); // NOI18N
        jButton3.setToolTipText("Đổi Nhà Cung Cấp");
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblTenNCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblMaNCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblSDT)
                        .addGap(18, 18, 18)
                        .addComponent(txtSDTNCC2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(lblDiaChi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDiaChiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDTNCC2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSDT)
                            .addComponent(txtMaNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaNCC))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaChiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiaChi)
                            .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenNCC)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(102, 102, 102));

        txt_Search_KH2.setBackground(new java.awt.Color(255, 255, 255));
        txt_Search_KH2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_Search_KH2.setForeground(new java.awt.Color(153, 153, 153));
        txt_Search_KH2.setText("Tìm Nhà Cung Cấp");
        txt_Search_KH2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(102, 153, 255)));
        txt_Search_KH2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_Search_KH2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_Search_KH2FocusLost(evt);
            }
        });
        txt_Search_KH2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_Search_KH2MouseClicked(evt);
            }
        });
        txt_Search_KH2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Search_KH2ActionPerformed(evt);
            }
        });
        txt_Search_KH2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Search_KH2KeyReleased(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search3.png"))); // NOI18N
        jButton11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(102, 153, 255)));
        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/supplier.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt_Search_KH2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(272, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_Search_KH2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pnl_tab_Form_BangHang.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1070, 150));

        jScrollPane2.setBackground(new java.awt.Color(102, 153, 255));
        jScrollPane2.setForeground(new java.awt.Color(51, 153, 255));

        tbl_BanHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_BanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Màu", "Số Lượng Nhập", "Giá Nhập", "Giá Bán", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_BanHang.setFocusable(false);
        tbl_BanHang.setRowHeight(30);
        tbl_BanHang.setShowGrid(true);
        tbl_BanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_BanHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_BanHang);

        pnl_tab_Form_BangHang.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 1070, 250));

        pnl_FormBanHang.add(pnl_tab_Form_BangHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1090, 760));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Search_SPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Search_SPFocusGained
        if (txt_Search_SP.getText().equals("Thêm Sản Phẩm Nhập")) {
            txt_Search_SP.setText("");
            txt_Search_SP.setForeground(Color.white);
        }
    }//GEN-LAST:event_txt_Search_SPFocusGained

    private void txt_Search_SPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Search_SPFocusLost
        if (txt_Search_SP.getText().equals("")) {
            txt_Search_SP.setText("Thêm Sản Phẩm Nhập");
            txt_Search_SP.setForeground(Color.white);
        }
    }//GEN-LAST:event_txt_Search_SPFocusLost

    private void txt_Search_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Search_SPMouseClicked
        if (search.getItemSize() > 0) {
            menu.show(txt_Search_SP, 0, txt_Search_SP.getHeight());

        }
    }//GEN-LAST:event_txt_Search_SPMouseClicked

    private void txt_Search_SPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Search_SPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Search_SPActionPerformed

    private void txt_Search_SPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Search_SPKeyReleased
        String text = txt_Search_SP.getText().trim().toLowerCase();
        search.setDataSP(bhDao.SearchMaSpOrTenSp(text));

        if (search.getItemSize() > 0) {
            //  * 2 top and bot border
            menu.show(txt_Search_SP, 0, txt_Search_SP.getHeight());
            //            
        } else {
            menu.setVisible(false);
        }
    }//GEN-LAST:event_txt_Search_SPKeyReleased


    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btn_XoaMatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaMatHangMouseClicked
        System.out.println("ok ");
        r = tbl_BanHang.getSelectedRow();
        if (r != -1) {
            huy(r);
            txt_SuaSL.setText("");

        } //        else if(tb){
        //            btn_XoaMatHang.setVisible(false);
        //        lbl_TextSL.setVisible(false);
        //        lbl_GiamSL.setVisible(false);
        //        lbl_TangSL.setVisible(false);
        //        txt_SuaSL.setVisible(false);
        //        }
        else {

            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
        }

    }//GEN-LAST:event_btn_XoaMatHangMouseClicked

    private void btn_XoaMatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaMatHangActionPerformed

    }//GEN-LAST:event_btn_XoaMatHangActionPerformed

    private void tbl_BanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_BanHangMouseClicked
        r = tbl_BanHang.getSelectedRow();
        dfbh_model = (DefaultTableModel) tbl_BanHang.getModel();

        if (r != -1) {
            String ssl = tbl_BanHang.getValueAt(r, 3).toString();
            txt_SuaSL.setText(ssl);
            btn_XoaMatHang.setVisible(true);
            lbl_TextSL.setVisible(true);
            lbl_GiamSL.setVisible(true);
            lbl_TangSL.setVisible(true);

            txt_SuaSL.setVisible(true);

        }

    }//GEN-LAST:event_tbl_BanHangMouseClicked

    private void txt_SuaSLFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SuaSLFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SuaSLFocusGained

    private void txt_SuaSLFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SuaSLFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SuaSLFocusLost

    private void txt_SuaSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_SuaSLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SuaSLMouseClicked

    private void txt_SuaSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SuaSLActionPerformed

        int sl = Integer.parseInt(txt_SuaSL.getText().toString());
//        txt_SuaSL.setText(String.valueOf(plus));
        tbl_BanHang.setValueAt(sl, r, 3);
        lbl_GiamSL.setEnabled(true);
        double giaNhap = Double.parseDouble(tbl_BanHang.getValueAt(r, 4).toString());
        tbl_BanHang.setValueAt(sl * giaNhap, r, 6);
        TinhTong3();
    }//GEN-LAST:event_txt_SuaSLActionPerformed

    private void txt_SuaSLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SuaSLKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SuaSLKeyReleased

    private void txt_SuaSLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SuaSLKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SuaSLKeyTyped

    private void lbl_GiamSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_GiamSLMouseClicked
        // TODO add your handling code here:
        if (txt_SuaSL.getText().equals("0")) {
            lbl_GiamSL.setEnabled(false);
        } else {
            int minus = 0;
            int sl = Integer.parseInt(txt_SuaSL.getText().toString());
            minus = sl - 1;
            txt_SuaSL.setText(String.valueOf(minus));
            tbl_BanHang.setValueAt(minus, r, 3);
            double donGia = Double.parseDouble(tbl_BanHang.getValueAt(r, 4).toString());
            tbl_BanHang.setValueAt(minus * donGia, r, 6);
            lbl_GiamSL.setEnabled(true);
            TinhTong3();
        }
    }//GEN-LAST:event_lbl_GiamSLMouseClicked

    private void lbl_TangSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TangSLMouseClicked
        int plus = 0;
        int sl = Integer.parseInt(txt_SuaSL.getText().toString());
        plus = sl + 1;
        txt_SuaSL.setText(String.valueOf(plus));
        tbl_BanHang.setValueAt(plus, r, 3);
        lbl_GiamSL.setEnabled(true);
        double donGia = Double.parseDouble(tbl_BanHang.getValueAt(r, 4).toString());
        tbl_BanHang.setValueAt(plus * donGia, r, 6);
        TinhTong3();
    }//GEN-LAST:event_lbl_TangSLMouseClicked

    private void txtMaNCC1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNCC1FocusGained
        // TODO add your handling code here:
        ///txtMaNCC1.setTe txtMaNCC1.setForeground(new java.awt.Color(26, 25, 25));xt("");
        txtMaNCC1.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtMaNCC1FocusGained

    private void txtMaNCC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNCC1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNCC1ActionPerformed

    private void txtTenNCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenNCCFocusGained
        // TODO add your handling code here:
        //   txtTenNCC.setText("");
        txtTenNCC.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtTenNCCFocusGained

    private void txtTenNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNCCActionPerformed

    private void txtSDTNCC2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTNCC2FocusGained
        //txtSDTNCC2.setText("");
        txtSDTNCC2.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtSDTNCC2FocusGained

    private void txtSDTNCC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTNCC2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTNCC2ActionPerformed

    private void txtDiaChiNCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiNCCFocusGained
        // txtDiaChiNCC.setText("");
        txtDiaChiNCC.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtDiaChiNCCFocusGained

    private void txt_Search_KH2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Search_KH2FocusGained
        if (txt_Search_KH2.getText().equals("Tìm Nhà Cung Cấp")) {
            txt_Search_KH2.setText("");
            txt_Search_KH2.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_Search_KH2FocusGained

    private void txt_Search_KH2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Search_KH2FocusLost
        if (txt_Search_KH2.getText().equals("")) {
            txt_Search_KH2.setText("Tìm Nhà Cung Cấp");
            txt_Search_KH2.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_Search_KH2FocusLost

    private void txt_Search_KH2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Search_KH2MouseClicked
        if (search2.getItemSize() > 0) {
            menu2.show(txt_Search_KH2, 0, txt_Search_KH2.getHeight());

        }
    }//GEN-LAST:event_txt_Search_KH2MouseClicked

    private void txt_Search_KH2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Search_KH2KeyReleased
        String text = txt_Search_KH2.getText().trim().toLowerCase();

        search2.setDataNcc(nccDao.SearchMaSpOrTenNcc(text));

        if (search2.getItemSize() > 0) {
            //  * 2 top and bot border
            menu2.show(txt_Search_KH2, 0, txt_Search_KH2.getHeight());

            //            
        } else {
            menu2.setVisible(false);
        }
    }//GEN-LAST:event_txt_Search_KH2KeyReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        jFrame2.setVisible(true);
        jFrame2.setResizable(false);
        jFrame2.setLocationRelativeTo(null);
        txt_tenNcc.requestFocus();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        jPanel7.setVisible(true);
        jPanel6.setVisible(false);
    }//GEN-LAST:event_jButton3MouseClicked

    private void btn_LuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LuuMouseClicked
        if (kiemTraDataSp()) {
            SanPhamDao spDao = new SanPhamDao();
            SanPham sp = restTextSp();
            if (sp_dao.themSP2(sp)) {
                SanPham sps = spDao.SearchWithSl(sp.getSoLuong());
                dfbh_model = (DefaultTableModel) tbl_BanHang.getModel();
                double tong = slNhap * sps.getGiaNhap();
                //tao vi tri sp
                int vitri = vitriSP(sps);
                System.out.println(vitri);

                if (vitri > -1) {
                    Integer sl = slNhap + 1;
                    dstt.get(vitri).setSoLuong(sl);
                    tongtien = sl * sps.getGiaNhap();
                    dfbh_model.setValueAt(sl, vitri, 3);
                    dfbh_model.setValueAt(tongtien, vitri, 5);
                } else {
                    try {
                        dstt.add(sps);
                    } catch (Exception e) {
                        System.out.println("loi add");
                        e.printStackTrace();
                    }
                    dfbh_model.addRow(new Object[]{
                        sps.getMaSP(), sps.getTenSP(), sps.getMauSac(), slNhap,sps.getGiaNhap(), sps.getDonGia(), tong
                    });
                }

//                dsSP.removeAll(dsSP);
//                xoaRongTextSp();
//                xoaModelSP();
//                upTblSP();
                TinhTong3();
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                jFrame1.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Mã Sản Phẩm đã tồn tại vui lòng nhập lại ");
            }
        }
    }//GEN-LAST:event_btn_LuuMouseClicked

    private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LuuActionPerformed

    private void btn_XoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaMouseClicked
        jFrame1.setVisible(false);
    }//GEN-LAST:event_btn_XoaMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        jFrame1.setVisible(true);
        jFrame1.setResizable(false);
        jFrame1.setLocationRelativeTo(null);
        txt_TenSp.requestFocus();
//        jFrame1.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
    }//GEN-LAST:event_jButton1MouseClicked

    private void btn_Luu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Luu1MouseClicked
        if (kiemTraData()) {
            NhaCC ncc = restText();
            if (nccDao.createNCC2(ncc)) {
                NhaCC nccs = nccDao.getNccBySdt(ncc.getSdt().toString());
                txtMaNCC1.setText(nccs.getMaNCC());

                txtTenNCC.setText(ncc.getTenNCC());
                jLabel3.setText(ncc.getSdt());
                txtSDTNCC2.setText(ncc.getSdt());
                txtDiaChiNCC.setText(ncc.getDiaChi());
                jLabel4.setText(ncc.getDiaChi());
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                jFrame2.setVisible(false);
                jPanel7.setVisible(false);
                jPanel6.setVisible(true);
            }
        }
    }//GEN-LAST:event_btn_Luu1MouseClicked

    private void btn_Luu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Luu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Luu1ActionPerformed

    private void btn_Xoa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Xoa1MouseClicked
        jFrame2.setVisible(false);
    }//GEN-LAST:event_btn_Xoa1MouseClicked

    private void txt_Search_KH2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Search_KH2ActionPerformed
//        jPanel7.setVisible(false);
//        jPanel6.setVisible(true);
    }//GEN-LAST:event_txt_Search_KH2ActionPerformed

    private void lbl_HinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_HinhAnhMouseClicked
        int returnVal = fileDialog.showOpenDialog(cha);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            java.io.File file = fileDialog.getSelectedFile();
            lbl_HinhAnh.setIcon(new ImageIcon(file.getPath()));
            //System.out.println("file"+file.getPath());
        }
    }//GEN-LAST:event_lbl_HinhAnhMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if (kiemTraTruocNhapHang()) {
            
            taoDonNhap();
            
            
        }


    }//GEN-LAST:event_jButton4MouseClicked

    private void txt_GhichuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_GhichuFocusGained
        if (txt_Ghichu.getText().equals("Nhập ghi chú đơn hàng")) {
            txt_Ghichu.setText("");
            txt_Ghichu.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_GhichuFocusGained

    private void txt_GhichuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_GhichuFocusLost
        if (txt_Ghichu.getText().equals("")) {
            txt_Ghichu.setText("Nhập ghi chú đơn hàng");
            txt_Ghichu.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_GhichuFocusLost

    private void txt_GhichuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GhichuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GhichuActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txt_GiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GiaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GiaNhapActionPerformed
    
    public void printBillNhap(String maHD){
        try {
            
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src\\Gui/rptHoaDonNhap.jrxml");
            
            map.put("MaHDNhap", maHD);
                  
            JasperPrint p = JasperFillManager.fillReport(report,  map, connect.getConnection() );
            JasperViewer.viewReport(p, false);
           // JasperExportManager.exportReportToPdfFile(p, "test.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
           
        }
    }
    
    
    //tao hoa don nhap hang
    public void taoDonNhap() {
        //lay sp tu table
        List<SanPham> listSp = getSpFromTB();
        //lay so luong sp
        int sl = 0;
        for (int i = 0; i < listSp.size(); i++) {
            sl += listSp.get(i).getSoLuong();
        }
        //lay tt nha cung cap
        String maNcc = txtMaNCC1.getText();
        NhaCC ncc = nccDao.getNccByMa(maNcc);
        //lay nhan vien
        NhanVienDao nvDao = new NhanVienDao();
        NhanVien nv = nvDao.getNVByMaTrangThai("online");
        System.out.println("nv" + nv);
        //lay tong tien
        Double tongTien = changeMoney(lbl_TienPhaiTra.getText());
        System.out.println("Tong tien"+tongTien);
        String ghiChu = txt_Ghichu.getText();
        if (ghiChu.equals("Nhập ghi chú đơn hàng")) {
            ghiChu = " ";
        }
        HoaDonNhap hdn = new HoaDonNhap(new java.util.Date(), sl, tongTien, ghiChu, nv, ncc);
        //them vao database
        HoaDonNhapDao hdnDao = new HoaDonNhapDao();
        hdnDao.createHoaDonBH(hdn);
        HoaDonNhap hn = new HoaDonNhap();
        hn = hdnDao.findHDBySl(hdn.getSoLuong());
        //them vao ct_HoaDonNhap
        List<CT_HoaDonNhap> list_CTHDN = new ArrayList<CT_HoaDonNhap>();
        for (int i = 0; i < listSp.size(); i++) {
            int sll = listSp.get(i).getSoLuong();
            Double donGia = listSp.get(i).getGiaNhap();
            CT_HoaDonNhap ctn = new CT_HoaDonNhap(sll, donGia);
            SanPhamDao spDao = new SanPhamDao();
            SanPham sp = spDao.findSPByMaSP(listSp.get(i).getMaSP());
            ctn.setSanPham(sp);
            ctn.setHoaDonNhap(hn);
            list_CTHDN.add(ctn);
            //cap nhat sl
            spDao.updateSLNhapKho(listSp.get(i).getMaSP(), sll);
        }
        //them cthd
        CT_HoaDonNhapDao ctnDao = new CT_HoaDonNhapDao();
        for (int i = 0; i < list_CTHDN.size(); i++) {
            ctnDao.createCTHoaDonNH(list_CTHDN.get(i));
        }
         xoaRong();
        //in hoa don
        printBillNhap(hn.getMaHDNhap());
       

    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_Luu1;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_Xoa1;
    private javax.swing.JButton btn_XoaMatHang;
    private javax.swing.JComboBox<String> cbo_Dm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblMaNCC;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenNCC;
    private javax.swing.JLabel lbl_DanhMuc;
    private javax.swing.JLabel lbl_DonGia;
    private javax.swing.JLabel lbl_GiamSL;
    private javax.swing.JLabel lbl_HinhAnh;
    private javax.swing.JLabel lbl_MauSac;
    private javax.swing.JLabel lbl_MauSac1;
    private javax.swing.JLabel lbl_Size;
    private javax.swing.JLabel lbl_Size1;
    private javax.swing.JLabel lbl_SlKho;
    private javax.swing.JLabel lbl_SlKho1;
    private javax.swing.JLabel lbl_TangSL;
    private javax.swing.JLabel lbl_TenSp;
    private javax.swing.JLabel lbl_TenSp1;
    private javax.swing.JLabel lbl_TenSp2;
    private javax.swing.JLabel lbl_TextSL;
    private javax.swing.JLabel lbl_TienPhaiTra;
    private javax.swing.JLabel lbl_maKh;
    private javax.swing.JLabel lbl_text_BanHang;
    private javax.swing.JPanel pnl_FormBanHang;
    private javax.swing.JPanel pnl_ThanhToan;
    private javax.swing.JPanel pnl_tab_Form_BangHang;
    private javax.swing.JPanel pnl_textSearch;
    public javax.swing.JTable tbl_BanHang;
    private javax.swing.JTextField txtDiaChiNCC;
    private javax.swing.JTextField txtMaNCC1;
    private javax.swing.JTextField txtSDTNCC2;
    private javax.swing.JTextField txtTenNCC;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_Ghichu;
    private javax.swing.JTextField txt_GiaBan;
    private javax.swing.JTextField txt_GiaNhap;
    private javax.swing.JTextField txt_MauSac;
    public javax.swing.JTextField txt_Search_KH2;
    private javax.swing.JTextField txt_Search_SP;
    private javax.swing.JTextField txt_Size;
    private javax.swing.JTextField txt_SlKho;
    private javax.swing.JTextField txt_SuaSL;
    private javax.swing.JTextField txt_TenSp;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_tenNcc;
    // End of variables declaration//GEN-END:variables
}
