/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;


/**
 *
 * @author GMT
 */
//●       MaHD – varchar(30) – PrimaryKey
//●       MaKH – varchar(30) - Foreign Key
//●       MaNV – varchar(30) - Foreign Key
//●       NgayLapHD – date - not null
//●       SoLuongSP – interger – not null - Không âm ( >= 0)
//●       TongTien –  – not null - Không âm ( >= 0)
//●       TienKhachDua –  – not null
//●       GhiChu – varchar(255)

public class HoaDonBanHang {
    private String maHD;
   
    private int soLuong;
    private double tongTien;
    private double tienKhachDua;
    private String ghiChu;
    private double tienKhuyenMai;
    private Date ngayLap;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private String trangThai;
   

    public HoaDonBanHang() {
    }

    public HoaDonBanHang(String maHD) {
        this.maHD = maHD;
    }

    public HoaDonBanHang(String maHD, int soLuong, double tongTien, Date ngayLap) {
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ngayLap = ngayLap;
    }

    public HoaDonBanHang(int soLuong, double tongTien, String ghiChu, String trangThai) {
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public HoaDonBanHang(String maHD, int soLuong, double tongTien, String ghiChu, Date ngayLap, String trangThai) {
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.ngayLap = ngayLap;
        this.trangThai = trangThai;
    }

    public HoaDonBanHang(String maHD, int soLuong, double tongTien, double tienKhachDua, String ghiChu, double tienKhuyenMai, String trangThai) {
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.ghiChu = ghiChu;
        this.tienKhuyenMai = tienKhuyenMai;
        this.trangThai = trangThai;
    }
    

    
    

    
    public HoaDonBanHang(String maHD, int soLuong, double tongTien, double tienKhachDua, String ghiChu, double tienKhuyenMai ) {
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.ghiChu = ghiChu;
        this.ngayLap = new Date();
        this.tienKhuyenMai = tienKhuyenMai;
    }
    

    public HoaDonBanHang(String maHD,Date ngayLap,  int soLuong, double tongTien, double tienKhachDua, String ghiChu, double KhuyenMai) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.ghiChu = ghiChu;
        this.tienKhuyenMai = KhuyenMai;
    }
    
      public HoaDonBanHang(String maHD,Date ngayLap,  int soLuong, double tongTien, double tienKhachDua, String ghiChu) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.ghiChu = ghiChu;
        
    }

    public HoaDonBanHang(String maHD,Date ngayLap, int soLuong, double tongTien, double tienKhachDua, String ghiChu,  String trangThai) {
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.ghiChu = ghiChu;
        this.ngayLap = ngayLap;
        this.trangThai = trangThai;
    }
    public HoaDonBanHang(String maHD,Date ngayLap,  int soLuong, double tongTien, double tienKhachDua, String ghiChu, double KhuyenMai,String trangThai) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.ghiChu = ghiChu;
        this.tienKhuyenMai = KhuyenMai;
        this.trangThai = trangThai;
    }
    
      

    public HoaDonBanHang(int soLuong, double tongTien) {
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    

    public HoaDonBanHang(double tongTien, Date ngayLap) {
        this.tongTien = tongTien;
        this.ngayLap = ngayLap;
    }
    
    

    public Date getNgayLap() {
        return ngayLap;
    }

    

    public void setTienKhuyenMai(double tienKhuyenMai) {
        this.tienKhuyenMai = tienKhuyenMai;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getTinhTrang() {
        return trangThai;
    }

    public void setTinhTrang(String trangThai) {
        this.trangThai = trangThai;
    }

    

    
      
    
  

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

   

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void setTienKhachDua(double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getMaHD() {
        return maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    @Override
    public String toString() {
        return "HoaDonBanHang{" + "maHD=" + maHD + ", soLuong=" + soLuong + ", tongTien=" + tongTien + ", tienKhachDua=" + tienKhachDua + ", ghiChu=" + ghiChu + ", tienKhuyenMai=" + tienKhuyenMai + ", ngayLap=" + ngayLap + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", tinhTrang=" + trangThai + '}';
    }

    

    public  double getTienKhuyenMai() {
        return tienKhuyenMai;
    }

    public Date getNgayLapHD() {
        return ngayLap;
    }
    
    
}
