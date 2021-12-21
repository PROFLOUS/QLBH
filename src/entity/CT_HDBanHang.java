package entity;

/**
 *
 * @author GMT
 */
public class CT_HDBanHang {

    private int soLuong;
    private Double donGia;
    private HoaDonBanHang hoaDon;
    private SanPham sanPham;

    public CT_HDBanHang() {
    }

    public CT_HDBanHang(int soLuong, Double donGia) {
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public CT_HDBanHang(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public HoaDonBanHang getHoaDon() {
        return hoaDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public void setHoaDon(HoaDonBanHang hoaDon) {
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
