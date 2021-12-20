
package entity;

import java.util.Date;


/**
 *
 * @author GMT
 */

public class HoaDonDatHang {
    private String maHDDH;
    private int soLuong;
    private double tongTien;
    private String ghiChu;
    private Date ngayLap;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private String tinhTrang;
    private String PTTT;
    
   

    public HoaDonDatHang() {
    }

    public HoaDonDatHang(String maHDDH) {
        this.maHDDH = maHDDH;
    }




    public HoaDonDatHang(int soLuong, double tongTien, String ghiChu, String tinhTrang, String PTTT) {
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
        this.PTTT = PTTT;
        
    }

    public HoaDonDatHang(String maHDDH, int soLuong, double tongTien, String ghiChu, Date ngayLap, String tinhTrang, String PTTT) {
        this.maHDDH = maHDDH;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.ngayLap = ngayLap;
        this.tinhTrang = tinhTrang;
        this.PTTT = PTTT;
    }
    
    
    
    
  

  
    
    

    public String getMaHDDH() {
        return maHDDH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public String getPTTT() {
        return PTTT;
    }

    public void setMaHDDH(String maHDDH) {
        this.maHDDH = maHDDH;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public void setPTTT(String PTTT) {
        this.PTTT = PTTT;
    }

    

    @Override
    public String toString() {
        return "HoaDonDatHang{" + "maHDDH=" + maHDDH + ", soLuong=" + soLuong + ", tongTien=" + tongTien + ", ghiChu=" + ghiChu + ", ngayLap=" + ngayLap + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", tinhTrang=" + tinhTrang + ", PTTT=" + PTTT + '}';
    }

    
    
    

    
    
}
