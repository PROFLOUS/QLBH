package entity;

/**
 *
 * @author GMT
 */
public class CT_HoaDonNhap {

    private SanPham sanPham;
    private HoaDonNhap hoaDonNhap;
    private int soLuong;
    private double donGia;

    public CT_HoaDonNhap() {
    }

    public CT_HoaDonNhap(int soLuong, double donGia) {
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public HoaDonNhap getHoaDonNhap() {
        return hoaDonNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public void setHoaDonNhap(HoaDonNhap hoaDonNhap) {
        this.hoaDonNhap = hoaDonNhap;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "CT_HoaDonNhap{" + "sanPham=" + sanPham + ", hoaDonNhap=" + hoaDonNhap + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    
    

}
