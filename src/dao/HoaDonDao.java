/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;

import entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;

import java.util.List;


import java.util.Map;


/**
 *
 * @author GMT
 */
public class HoaDonDao {

    ArrayList<HoaDonBanHang> listHD;
    HoaDonBanHang hoaDon;
    NhanVienDao nvDao = new NhanVienDao();
    KhachHangDao khDao = new KhachHangDao();
    SimpleDateFormat originalFormat = new SimpleDateFormat("dd");
    SimpleDateFormat originalFormatYear = new SimpleDateFormat("yyyy");

    public HoaDonDao() {
        listHD = new ArrayList<HoaDonBanHang>();
        hoaDon = new HoaDonBanHang();
    }

    //dua du lieu tu sql vao aArrayList
    public ArrayList<HoaDonBanHang> getDsHoaDon() {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from HDBanHang order by NgayLapHD desc";

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                Date ngayLap = rs.getTimestamp(2);
                //System.err.println(ngayLap);
                int soLuong = rs.getInt(3);
                Double tongTien = rs.getDouble(4);
                Double tienKhachDua = rs.getDouble(5);
                String ghiChu = rs.getString(6);
                String maNV = rs.getString(7);
                String maKH = rs.getString(8);
                String tinhTrang = rs.getString(10);

                HoaDonBanHang hd = new HoaDonBanHang(maHD, ngayLap, soLuong, tongTien, tienKhachDua, ghiChu, tinhTrang);

                //set nhan Vien 
                NhanVien nv = nvDao.getNVByMaNV(maNV);
                hd.setNhanVien(nv);

                //set KHachHang
                KhachHang kh = khDao.getKHByMaKH(maKH);
                hd.setKhachHang(kh);

                listHD.add(hd);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi day");
        }
        return listHD;
    }

    public boolean updateTrangThai(String maHD, String trangThai) {
        int n = 0;
        java.sql.Connection con = connect.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("update HDBanHang set [TrangThai] =? where MaHD=?");

            stmt.setString(1, trangThai);
            stmt.setString(2, maHD);

            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    //tim kiems hoa don theo ma hoadon
    /*
            @param maHoaDon String
            return hoaDon HoaDonBanHang
     */
    public HoaDonBanHang findHDByMaHD(String maHoaDon) {
        HoaDonBanHang hd = null;
        try {

            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from HDBanHang where MaHD = '" + maHoaDon + "' ";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                Date ngayLap = rs.getTimestamp(2);
                int soLuong = rs.getInt(3);
                Double tongTien = rs.getDouble(4);
                Double tienKhachDua = rs.getDouble(5);
                String ghiChu = rs.getString(6);
                String maNV = rs.getString(7);
                String maKH = rs.getString(8);
                Double giaGiam = rs.getDouble(9);
                String tinhTrang = rs.getString(10);
                hd = new HoaDonBanHang(maHD, ngayLap, soLuong, tongTien, tienKhachDua, ghiChu, giaGiam, tinhTrang);

                //set nhan Vien 
                NhanVien nv = nvDao.getNVByMaNV(maNV);
                hd.setNhanVien(nv);

                //set KHachHang
                KhachHang kh = khDao.getKHByMaKH(maKH);
                hd.setKhachHang(kh);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hd;

    }

    //tim kiems hoa don theo ma NV
    /*
            @param maNV String
            return hoaDon HoaDonBanHang
     */
    public ArrayList<HoaDonBanHang> getDsHoaDonByMaNV(String manv) {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from HDBanHang  where MaNV = '" + manv + "' order by NgayLapHD desc";

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                Date ngayLap = rs.getTimestamp(2);
                //System.err.println(ngayLap);
                int soLuong = rs.getInt(3);
                Double tongTien = rs.getDouble(4);
                Double tienKhachDua = rs.getDouble(5);
                String ghiChu = rs.getString(6);
                String maNV = rs.getString(7);
                String maKH = rs.getString(8);

                HoaDonBanHang hd = new HoaDonBanHang(maHD, ngayLap, soLuong, tongTien, tienKhachDua, ghiChu);

                //set nhan Vien 
                NhanVien nv = nvDao.getNVByMaNV(maNV);
                hd.setNhanVien(nv);

                //set KHachHang
                KhachHang kh = khDao.getKHByMaKH(maKH);
                hd.setKhachHang(kh);

                listHD.add(hd);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi day");
            // TODO: handle exception
        }
        return listHD;
    }

    //them 1 HoaDon vao database
    public boolean createHoaDonBH(HoaDonBanHang hd) {
        java.sql.Connection con = connect.getInstance().getConnection();

        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("Insert Into HDBanHang values(?,getdate(),?,?,?,?,?,?,?,?)");

            //  java.time.
            stmt.setString(1, hd.getMaHD());
            stmt.setInt(2, hd.getSoLuong());
            stmt.setDouble(3, hd.getTongTien());
            stmt.setDouble(4, hd.getTienKhachDua());
            stmt.setString(5, hd.getGhiChu());
            stmt.setString(6, hd.getNhanVien().getMaNV());
            stmt.setString(7, hd.getKhachHang().getMaKH());
            stmt.setDouble(8, hd.getTienKhuyenMai());
            stmt.setString(9, hd.getTinhTrang());
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }

    public ArrayList<HoaDonBanHang> thongkeKhachHangTheoNam(String year) {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "SELECT top 10 sokh.kh AS 'MaKh', sokh.ten AS 'TenNV', sokh.sc AS 'SoHD',sokh.sl as'SoLuongMua',sokh.tong as'TongTien' from\n"
                    + "				(SELECT hdb.MaKH kh ,SUM (hdb.SoLuong) sl,SUM (hdb.TongTien) tong , COUNT(hdb.MaHD) sc, kh.TenKH ten \n"
                    + "                					FROM [dbo].[HDBanHang] hdb, [dbo].[KhachHang] kh\n"
                    + "                					WHERE hdb.MaKH = kh.MaKH and hdb.[TrangThai]='Hoàn Thành'and year( hdb.NgayLapHD) ='" + year + "'\n"
                    + "               					 GROUP BY hdb.MaKH , kh.TenKH ) sokh\n"
                    + "								 order by sokh.tong desc";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int soLuong = rs.getInt(4);
                Double tongTien = rs.getDouble(5);
                String maKH = rs.getString(1);
                HoaDonBanHang hd = new HoaDonBanHang(soLuong, tongTien);
                KhachHang kh = khDao.getKHByMaKH(maKH);
                hd.setKhachHang(kh);
                listHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi day");
        }
        return listHD;
    }

    public ArrayList<HoaDonBanHang> thongkeKhachHangTheoThang(String month, String year) {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "SELECT top 10 sokh.kh AS 'MaKh', sokh.ten AS 'TenNV', sokh.sc AS 'SoHD',sokh.sl as'SoLuongMua',sokh.tong as'TongTien' from\n"
                    + "				(SELECT hdb.MaKH kh ,SUM (hdb.SoLuong) sl,SUM (hdb.TongTien) tong , COUNT(hdb.MaHD) sc, kh.TenKH ten \n"
                    + "                					FROM [dbo].[HDBanHang] hdb, [dbo].[KhachHang] kh\n"
                    + "                					WHERE hdb.MaKH = kh.MaKH and hdb.[TrangThai]='Hoàn Thành'and Month( hdb.NgayLapHD) ='" + month + "' and year( hdb.NgayLapHD) ='" + year + "' \n"
                    + "               					 GROUP BY hdb.MaKH , kh.TenKH ) sokh\n"
                    + "								 order by sokh.tong desc";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int soLuong = rs.getInt(4);
                Double tongTien = rs.getDouble(5);
                String maKH = rs.getString(1);
                HoaDonBanHang hd = new HoaDonBanHang(soLuong, tongTien);
                KhachHang kh = khDao.getKHByMaKH(maKH);
                hd.setKhachHang(kh);
                listHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public ArrayList<HoaDonBanHang> thongkeKhachHangTheoNgay(String day, String month, String year) {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "SELECT top 10 sokh.kh AS 'MaKh', sokh.ten AS 'TenNV', sokh.sc AS 'SoHD',sokh.sl as'SoLuongMua',sokh.tong as'TongTien' from\n"
                    + "				(SELECT hdb.MaKH kh ,SUM (hdb.SoLuong) sl,SUM (hdb.TongTien) tong , COUNT(hdb.MaHD) sc, kh.TenKH ten \n"
                    + "                					FROM [dbo].[HDBanHang] hdb, [dbo].[KhachHang] kh\n"
                    + "                					WHERE hdb.MaKH = kh.MaKH and hdb.[TrangThai]='Hoàn Thành'and day( hdb.NgayLapHD) ='" + day + "' and month( hdb.NgayLapHD) ='" + month + "' and year( hdb.NgayLapHD) ='" + year + "' \n"
                    + "               					 GROUP BY hdb.MaKH , kh.TenKH ) sokh\n"
                    + "								 order by sokh.tong desc";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int soLuong = rs.getInt(4);
                Double tongTien = rs.getDouble(5);
                String maKH = rs.getString(1);
                HoaDonBanHang hd = new HoaDonBanHang(soLuong, tongTien);
                KhachHang kh = khDao.getKHByMaKH(maKH);
                hd.setKhachHang(kh);
                listHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }


    /*
    *lấy ra số hóa đơn, số sản phẩm, tổng tiền trong 1 ngày
     
     */
    public ArrayList<Double> getThongkeInDay(String date) {
        ArrayList<Double> list = new ArrayList<Double>();
        try {

            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select count(*), sum(a.SoLuong), sum(TongTien) from HDBanHang a\n"
                    + "where CAST(a.NgayLapHD AS DATE) = '" + date + "' ";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int soHD = rs.getInt(1);
                int soLuong = rs.getInt(2);
                Double tongTien = rs.getDouble(3);

                list.add((double) soHD);
                list.add((double) soLuong);
                list.add(tongTien);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /*Lay tong loi nhuan(chua tinh tien khuyen mai) trong 1 ngay
     */
    public double getLoiNhuanInDay(String date) {
        double loiNhuan = 0.0;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select sum((b.DonGia-c.GiaNhap)*b.SoLuong )from HDBanHang a\n"
                    + "inner join CT_HoaDonBanHang b on a.MaHD = b.MaHD\n"
                    + "inner join SanPham c on b.MaSP = c.MaSP\n"
                    + "where CAST(a.NgayLapHD AS DATE) = '" + date + "' ";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                loiNhuan = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loiNhuan;
    }

    /*Lay tong tien giam gia trong 1 ngay
     */
    public double getKhuyenMaiInDay(String date) {
        double km = 0.0;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select SUM(PhanTramGiamGia) from HDBanHang a\n"
                    + "where CAST(a.NgayLapHD AS DATE) = '" + date + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                km = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return km;
    }

    /*Tính tổng tiền từng ngày trong 1 khóng thời gian
     */
    public Map<Date, Double> getTongTienAboutDates(java.sql.Date date1, java.sql.Date date2) {
        Map<Date, Double> map = new HashMap<>();
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select  CAST(a.NgayLapHD AS DATE), sum(a.TongTien) from HDBanHang a\n"
                    + "where CAST(a.NgayLapHD AS DATE) between '" + date1 + "' and '" + date2 + "'\n"
                    + "group by CAST(a.NgayLapHD AS DATE)\n"
                    + "order by CAST(a.NgayLapHD AS DATE) asc";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Date d = rs.getDate(1);
                double m = rs.getDouble(2);
                map.put(d, m);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public ArrayList<HoaDonBanHang> CT_thongkeDoanhThuTheoNgay(String dayFrom, String dayTo, String month, String year) {
        ArrayList<HoaDonBanHang> dstk = new ArrayList<HoaDonBanHang>();
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select MaHD,NgayLapHD,SoLuong,TongTien from [dbo].[HDBanHang]\n"
                    + "where [TrangThai]='Hoàn Thành' and day([NgayLapHD])<='" + dayTo + "' and day([NgayLapHD])>='" + dayFrom + "' and MONTH([NgayLapHD])='" + month + "' and YEAR([NgayLapHD])='" + year + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int soLuong = rs.getInt(3);
                Double tongTien = rs.getDouble(4);
                String maHd = rs.getString(1);
                Date date = rs.getTimestamp(2);
                HoaDonBanHang hd = new HoaDonBanHang(maHd, soLuong, tongTien, date);
                dstk.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dstk;
    }

    public ArrayList<HoaDonBanHang> CT_thongkeDoanhThuTheoThang(String monthFrom, String monthTo, String year) {
        ArrayList<HoaDonBanHang> dstk = new ArrayList<HoaDonBanHang>();
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select MaHD,NgayLapHD,SoLuong,TongTien from [dbo].[HDBanHang]\n"
                    + "where [TrangThai]='Hoàn Thành' and MONTH([NgayLapHD])<='" + monthTo + "' and MONTH([NgayLapHD])>='" + monthFrom + "' and YEAR([NgayLapHD])='" + year + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int soLuong = rs.getInt(3);
                Double tongTien = rs.getDouble(4);
                String maHd = rs.getString(1);
                Date date = rs.getTimestamp(2);
                HoaDonBanHang hd = new HoaDonBanHang(maHd, soLuong, tongTien, date);
                dstk.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dstk;
    }

    public ArrayList<HoaDonBanHang> CT_thongkeDoanhThuTheoNam(String yearFrom, String yearTo) {
        ArrayList<HoaDonBanHang> dstk = new ArrayList<HoaDonBanHang>();
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select MaHD,NgayLapHD,SoLuong,TongTien from [dbo].[HDBanHang]\n"
                    + "where [TrangThai]='Hoàn Thành' and year([NgayLapHD])<='" + yearTo + "' and year([NgayLapHD])>='" + yearFrom + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int soLuong = rs.getInt(3);
                Double tongTien = rs.getDouble(4);
                String maHd = rs.getString(1);
                Date date = rs.getTimestamp(2);
                HoaDonBanHang hd = new HoaDonBanHang(maHd, soLuong, tongTien, date);
                dstk.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dstk;
    }

    public ArrayList<HoaDonBanHang> thongkeDoanhThuTheoNgay(String dayFrom, String dayTo, String month, String year) {
        try {

            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select day(b.NgayLapHD), sum(b.TongTien) from [dbo].[HDBanHang] b\n"
                    + "where [TrangThai]='Hoàn Thành' and day([NgayLapHD])<='" + dayTo + "' and day([NgayLapHD])>='" + dayFrom + "' and MONTH([NgayLapHD])='" + month + "' and YEAR([NgayLapHD])='" + year + "'\n"
                    + "group by day(b.NgayLapHD)";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int ngayInt = rs.getInt(1);
                String ngay = String.valueOf(ngayInt);
                Date date = originalFormat.parse(ngay);

                Double tongTien = rs.getDouble(2);
                HoaDonBanHang hd = new HoaDonBanHang(tongTien, date);
                listHD.add(hd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public ArrayList<HoaDonBanHang> thongkeDoanhThuTheoThang(String monthFrom, String monthTo, String year) {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select sum(b.TongTien) as'doanh thu' ,MONTH(b.NgayLapHD) as 'thang' from [dbo].[HDBanHang] b\n"
                    + "where [TrangThai]='Hoàn Thành' and MONTH([NgayLapHD])<='" + monthTo + "' and MONTH([NgayLapHD])>='" + monthFrom + "' and YEAR([NgayLapHD])='" + year + "'\n"
                    + "group by MONTH(b.NgayLapHD)";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int ngayInt = rs.getInt(2);
                String ngay = String.valueOf(ngayInt);
                Date date = originalFormat.parse(ngay);

                Double tongTien = rs.getDouble(1);
                HoaDonBanHang hd = new HoaDonBanHang(tongTien, date);
                listHD.add(hd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public ArrayList<HoaDonBanHang> thongkeDoanhThuTheoNam(String yearFrom, String yearTo) {
        try {

            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select sum(b.TongTien) as'doanh thu' ,year(b.NgayLapHD) as 'nam' from [dbo].[HDBanHang] b\n"
                    + "where [TrangThai]='Hoàn Thành' and year([NgayLapHD])<='" + yearTo + "' and year([NgayLapHD])>='" + yearFrom + "'\n"
                    + "group by year(b.NgayLapHD)";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int ngayInt = rs.getInt(2);
                String ngay = String.valueOf(ngayInt);
                Date date = originalFormatYear.parse(ngay);

                Double tongTien = rs.getDouble(1);
                HoaDonBanHang hd = new HoaDonBanHang(tongTien, date);
                listHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;

    }
}
