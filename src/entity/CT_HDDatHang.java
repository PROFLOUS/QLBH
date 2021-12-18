
package entity;

/**
 *
 * @author GMT
 */
public class CT_HDDatHang {
   
 
    private int soLuong;
    private double donGia;
    private HoaDonDatHang hoaDon;
    private SanPham sanPham;
    
    public CT_HDDatHang() {
    }

    public CT_HDDatHang(int soLuong, double donGia) {
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public CT_HDDatHang(int soLuong) {
        this.soLuong = soLuong;
    }
    

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public HoaDonDatHang getHoaDon() {
        return hoaDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setHoaDon(HoaDonDatHang hoaDon) {
        this.hoaDon = hoaDon;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    @Override
    public String toString() {
        return "CT_HDBanHang{" + "soLuong=" + soLuong + ", donGia=" + donGia + ", hoaDon=" + hoaDon + ", sanPham=" + sanPham + '}';
    }

    

    
 
    
}
