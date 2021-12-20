package dao;

import Connect.connect;
import entity.CT_HDBanHang;
import entity.HoaDonBanHang;
import entity.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author GMT
 */
public class CT_HoaDonDao {

    ArrayList<CT_HDBanHang> listCTHD;
    CT_HDBanHang cthd;
    HoaDonDao hoaDonDao = new HoaDonDao();
    SanPhamDao sanPhamDao = new SanPhamDao();

    public CT_HoaDonDao() {
        listCTHD = new ArrayList<CT_HDBanHang>();
        cthd = new CT_HDBanHang();
    }

    //query theo ma HoaDon
    /*
        @param maHD String
        return ArrayList CT_HoaDon
     */
    public ArrayList<CT_HDBanHang> getCTHoadDonByMaHD(String maHD) {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from CT_HoaDonBanHang where MaHD = '" + maHD + "' ";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int soLuong = rs.getInt(1);
                Double donGia = rs.getDouble(2);
                String maHoaDon = rs.getString(3);
                String maSP = rs.getString(4);

                CT_HDBanHang ctHD = new CT_HDBanHang(soLuong, donGia);

                HoaDonBanHang hoaDon = hoaDonDao.findHDByMaHD(maHoaDon);
                ctHD.setHoaDon(hoaDon);

                SanPham sp = sanPhamDao.findSPByMaSP(maSP);
                ctHD.setSanPham(sp);

                listCTHD.add(ctHD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCTHD;
    }

    //them 1 CT_HoaDon vao database
    public boolean createCTHoaDonBH(CT_HDBanHang ct) {
        java.sql.Connection con = connect.getInstance().getConnection();

        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("Insert Into CT_HoaDonBanHang values(?,?,?,?)");
            stmt.setInt(1, ct.getSoLuong());

            stmt.setDouble(2, ct.getDonGia());

            stmt.setString(3, ct.getHoaDon().getMaHD());
            stmt.setString(4, ct.getSanPham().getMaSP());
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }

    //Thống kê số lượng sản phẩm theo năm
    public ArrayList<CT_HDBanHang> thongkeSpTheoNam(String year) {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "SELECT  sosp.sp AS 'Masp', sosp.ten AS 'Tensp',sosp.sl as'SoLuongBang' , sosp.dongia as'Gia Ban'  from\n"
                    + "				(SELECT cthd.MaSP sp ,SUM (cthd.SoLuong)  sl, sp.TenSP ten ,sp.DonGia dongia\n"
                    + "                					FROM [dbo].[CT_HoaDonBanHang] cthd, [dbo].[SanPham] sp ,[dbo].[HDBanHang] hdb\n"
                    + "                					WHERE cthd.MaSP = sp.MaSP and cthd.MaHD =hdb.MaHD and hdb.[TrangThai]='Hoàn Thành'and year( hdb.NgayLapHD) ='" + year + "'\n"
                    + "               					 GROUP BY cthd.MaSP , sp.TenSP,sp.DonGia ) sosp\n"
                    + "								 order by sosp.sl desc";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int soLuong = rs.getInt(3);
                String maSP = rs.getString(1);
                SanPham sp = sanPhamDao.findSPByMaSP(maSP);
                Double donGia = rs.getDouble(4);
                CT_HDBanHang ct = new CT_HDBanHang(soLuong, donGia);
                ct.setSanPham(sp);
                listCTHD.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listCTHD;
    }

    public ArrayList<CT_HDBanHang> thongkeSpTheoThang(String month, String year) {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "SELECT  sosp.sp AS 'Masp', sosp.ten AS 'Tensp',sosp.sl as'SoLuongBang' , sosp.dongia as'Gia Ban'  from\n"
                    + "				(SELECT cthd.MaSP sp ,SUM (cthd.SoLuong)  sl, sp.TenSP ten ,sp.DonGia dongia\n"
                    + "                					FROM [dbo].[CT_HoaDonBanHang] cthd, [dbo].[SanPham] sp ,[dbo].[HDBanHang] hdb\n"
                    + "                					WHERE cthd.MaSP = sp.MaSP and cthd.MaHD =hdb.MaHD and hdb.[TrangThai]='Hoàn Thành'and Month( hdb.NgayLapHD) ='" + month + "' and year( hdb.NgayLapHD) ='" + year + "' \n"
                    + "               					 GROUP BY cthd.MaSP , sp.TenSP,sp.DonGia ) sosp\n"
                    + "								 order by sosp.sl desc";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int soLuong = rs.getInt(3);
                String maSP = rs.getString(1);
                SanPham sp = sanPhamDao.findSPByMaSP(maSP);
                Double donGia = rs.getDouble(4);
                CT_HDBanHang ct = new CT_HDBanHang(soLuong, donGia);
                ct.setSanPham(sp);
                listCTHD.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listCTHD;
    }

    public ArrayList<CT_HDBanHang> thongkeSpTheoNgay(String day, String month, String year) {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "SELECT  sosp.sp AS 'Masp', sosp.ten AS 'Tensp',sosp.sl as'SoLuongBang' , sosp.dongia as'Gia Ban'  from\n"
                    + "				(SELECT cthd.MaSP sp ,SUM (cthd.SoLuong)  sl, sp.TenSP ten ,sp.DonGia dongia\n"
                    + "                					FROM [dbo].[CT_HoaDonBanHang] cthd, [dbo].[SanPham] sp ,[dbo].[HDBanHang] hdb\n"
                    + "                					WHERE cthd.MaSP = sp.MaSP and cthd.MaHD =hdb.MaHD and hdb.[TrangThai]='Hoàn Thành'and day( hdb.NgayLapHD) ='" + day + "' and month( hdb.NgayLapHD) ='" + month + "' and year( hdb.NgayLapHD) ='" + year + "' \n"
                    + "               					 GROUP BY cthd.MaSP , sp.TenSP,sp.DonGia ) sosp\n"
                    + "								 order by sosp.sl desc";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int soLuong = rs.getInt(3);
                String maSP = rs.getString(1);

                SanPham sp = sanPhamDao.findSPByMaSP(maSP);
                Double donGia = rs.getDouble(4);
                CT_HDBanHang ct = new CT_HDBanHang(soLuong, donGia);
                ct.setSanPham(sp);
                listCTHD.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listCTHD;
    }

}
