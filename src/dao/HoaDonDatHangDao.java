/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;
import entity.HoaDonDatHang;
import entity.KhachHang;
import entity.NhanVien;


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
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


/**
 *
 * @author GMT
 */
public class HoaDonDatHangDao {

    ArrayList<HoaDonDatHang> listHD;
    HoaDonDatHang hoaDon;
    NhanVienDao nvDao = new NhanVienDao();
    KhachHangDao khDao = new KhachHangDao();
    SimpleDateFormat originalFormat = new SimpleDateFormat("dd");
    SimpleDateFormat originalFormatYear = new SimpleDateFormat("yyyy");
    private final Connection con;

    public HoaDonDatHangDao() {
        listHD = new ArrayList<HoaDonDatHang>();
        hoaDon = new HoaDonDatHang();
        con = connect.getInstance().getConnection();
    }

    //dua du lieu tu sql vao aArrayList
    public ArrayList<HoaDonDatHang> getDsHoaDon() {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from [HDDatHang] order by NgayLapHD desc";

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                Date ngayLap = rs.getTimestamp(2);
                //System.err.println(ngayLap);
                int soLuong = rs.getInt(3);
                double tongTien = rs.getDouble(4);
                String ghiChu = rs.getString(5);
                String trangThai = rs.getString(6);
                String PTTT = rs.getString(7);
                String DVVC = rs.getString(8);
                String maNV = rs.getString(9);
                String maKH = rs.getString(10);

                //HoaDonBanHang hd = new HoaDonBanHang(maHD, ngayLap, soLuong, tongTien, tienKhachDua, ghiChu);
                HoaDonDatHang hdd = new HoaDonDatHang(maHD, soLuong, tongTien, ghiChu, ngayLap, trangThai, PTTT);
                //set nhan Vien 
                NhanVien nv = nvDao.getNVByMaNV(maNV);
                hdd.setNhanVien(nv);

                //set KHachHang
                KhachHang kh = khDao.getKHByMaKH(maKH);
                hdd.setKhachHang(kh);

                listHD.add(hdd);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi day");
            // TODO: handle exception
        }
        return listHD;
    }

    //tim kiems hoa don theo ma hoadon
    /*
            @param maHoaDon String
            return hoaDon HoaDonBanHang
     */
    public HoaDonDatHang findHDByMaHD(String maHoaDon) {
        HoaDonDatHang hdd = null;
        try {

            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from HDDatHang where [MaHDDH] = '" + maHoaDon + "' ";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
               String maHD = rs.getString(1);
                Date ngayLap = rs.getTimestamp(2);
                //System.err.println(ngayLap);
                int soLuong = rs.getInt(3);
                double tongTien = rs.getDouble(4);
                String ghiChu = rs.getString(5);
                String trangThai = rs.getString(6);
                String PTTT = rs.getString(7);
                String DVVC = rs.getString(8);
                String maNV = rs.getString(9);
                String maKH = rs.getString(10);
               hdd = new HoaDonDatHang(maHD, soLuong, tongTien, ghiChu, ngayLap, trangThai, PTTT);
                //set nhan Vien 
                NhanVien nv = nvDao.getNVByMaNV(maNV);
                hdd.setNhanVien(nv);

                //set KHachHang
                KhachHang kh = khDao.getKHByMaKH(maKH);
                hdd.setKhachHang(kh);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hdd;

    }

    //them 1 HoaDon vao database
    public boolean createHoaDonBH(HoaDonDatHang hd) {
        java.sql.Connection con = connect.getInstance().getConnection();

        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("INSERT [dbo].[HDDatHang]( [NgayLapHD], [SoLuong], [TongTien], \n" +
"[GhiChu],[TrangThai],[PTTT],[MaNV], [MaKH])\n" +
"VALUES ( CAST(GETDATE() AS SmallDateTime), \n" +
"?, ?, ?,?,?,?, ?)");

            //  java.time.
//            stmt.setString(1, hd.getMaHD());
//		stmt.setDate(2, (java.sql.Date) new Date());
            stmt.setInt(1, hd.getSoLuong());
            stmt.setDouble(2, hd.getTongTien());
            stmt.setString(3, hd.getGhiChu());
            stmt.setString(4, hd.getTinhTrang());
            stmt.setString(5, hd.getPTTT());
            stmt.setString(6, hd.getNhanVien().getMaNV());
            stmt.setString(7, hd.getKhachHang().getMaKH());

            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    
    public boolean updateTrangThai(String maHD, String trangThai){
        int n =0;
            java.sql.Connection con = connect.getInstance().getConnection();	
            PreparedStatement stmt = null;
            try {
                stmt = con.prepareStatement("update [dbo].[HDDatHang] set [TrangThai] =? where [MaHDDH]=?");
		
		stmt.setString(1,trangThai);
		stmt.setString(2,maHD);
					
		n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
            return n > 0;
        }
    
    /*
      *Tìm hóa đơn mới thêm
      */
      public HoaDonDatHang getHdNew(){
             HoaDonDatHang hd = null;
            try {
                PreparedStatement stmt = con.prepareStatement("select  top 1 * from [dbo].[HDDatHang]\n" +
"order by [MaHDDH] desc");
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                String maHD = rs.getString(1);
                Date ngayLap = rs.getTimestamp(2);
                //System.err.println(ngayLap);
                int soLuong = rs.getInt(3);
                double tongTien = rs.getDouble(4);
                String ghiChu = rs.getString(5);
                String trangThai = rs.getString(6);
                String PTTT = rs.getString(7);
                String DVVC = rs.getString(8);
                String maNV = rs.getString(9);
                String maKH = rs.getString(10);

                //HoaDonBanHang hd = new HoaDonBanHang(maHD, ngayLap, soLuong, tongTien, tienKhachDua, ghiChu);
                 hd = new HoaDonDatHang(maHD, soLuong, tongTien, ghiChu, ngayLap, trangThai, PTTT);
                //set nhan Vien 
                NhanVien nv = nvDao.getNVByMaNV(maNV);
                hd.setNhanVien(nv);

                //set KHachHang
                KhachHang kh = khDao.getKHByMaKH(maKH);
                hd.setKhachHang(kh);
            }
            } catch (Exception e) {
            }
            
            return hd;
        }
//    public ArrayList<HoaDonBanHang>thongkeKhachHangTheoNam(String year){
//        try {
//            java.sql.Connection con = connect.getInstance().getConnection();
//            String sql = "SELECT top 10 sokh.kh AS 'MaKh', sokh.ten AS 'TenNV', sokh.sc AS 'SoHD',sokh.sl as'SoLuongMua',sokh.tong as'TongTien' from\n" +
//"				(SELECT hdb.MaKH kh ,SUM (hdb.SoLuong) sl,SUM (hdb.TongTien) tong , COUNT(hdb.MaHD) sc, kh.TenKH ten \n" +
//"                					FROM [dbo].[HDBanHang] hdb, [dbo].[KhachHang] kh\n" +
//"                					WHERE hdb.MaKH = kh.MaKH and year( hdb.NgayLapHD) ='"+year+"'\n" +
//"               					 GROUP BY hdb.MaKH , kh.TenKH ) sokh\n" +
//"								 order by sokh.tong desc";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                int soLuong = rs.getInt(4);
//                Double tongTien = rs.getDouble(5);
//                String maKH = rs.getString(1);
//                HoaDonBanHang hd = new HoaDonBanHang(soLuong, tongTien);
////                HoaDonBanHang hd = new HoaDonBanHang(maHD, ngayLap, soLuong, tongTien, tienKhachDua, ghiChu);
//                //set KHachHang
//                KhachHang kh = khDao.getKHByMaKH(maKH);
//                hd.setKhachHang(kh);
//                listHD.add(hd);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi day");
//        }
//        return listHD;
//    }
//    
//    public ArrayList<HoaDonBanHang>thongkeKhachHangTheoThang(String month){
//        try {
//            java.sql.Connection con = connect.getInstance().getConnection();
//            String sql = "SELECT top 10 sokh.kh AS 'MaKh', sokh.ten AS 'TenNV', sokh.sc AS 'SoHD',sokh.sl as'SoLuongMua',sokh.tong as'TongTien' from\n" +
//"				(SELECT hdb.MaKH kh ,SUM (hdb.SoLuong) sl,SUM (hdb.TongTien) tong , COUNT(hdb.MaHD) sc, kh.TenKH ten \n" +
//"                					FROM [dbo].[HDBanHang] hdb, [dbo].[KhachHang] kh\n" +
//"                					WHERE hdb.MaKH = kh.MaKH and Month( hdb.NgayLapHD) ='"+month+"'\n" +
//"               					 GROUP BY hdb.MaKH , kh.TenKH ) sokh\n" +
//"								 order by sokh.tong desc";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                int soLuong = rs.getInt(4);
//                Double tongTien = rs.getDouble(5);
//                String maKH = rs.getString(1);
//                HoaDonBanHang hd = new HoaDonBanHang(soLuong, tongTien);
////                HoaDonBanHang hd = new HoaDonBanHang(maHD, ngayLap, soLuong, tongTien, tienKhachDua, ghiChu);
//                //set KHachHang
//                KhachHang kh = khDao.getKHByMaKH(maKH);
//                hd.setKhachHang(kh);
//                listHD.add(hd);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi day");
//        }
//        return listHD;
//    }
//    
//    public ArrayList<HoaDonBanHang>thongkeKhachHangTheoNgay(String day){
//        try {
//            java.sql.Connection con = connect.getInstance().getConnection();
//            String sql = "SELECT top 10 sokh.kh AS 'MaKh', sokh.ten AS 'TenNV', sokh.sc AS 'SoHD',sokh.sl as'SoLuongMua',sokh.tong as'TongTien' from\n" +
//"				(SELECT hdb.MaKH kh ,SUM (hdb.SoLuong) sl,SUM (hdb.TongTien) tong , COUNT(hdb.MaHD) sc, kh.TenKH ten \n" +
//"                					FROM [dbo].[HDBanHang] hdb, [dbo].[KhachHang] kh\n" +
//"                					WHERE hdb.MaKH = kh.MaKH and day( hdb.NgayLapHD) ='"+day+"'\n" +
//"               					 GROUP BY hdb.MaKH , kh.TenKH ) sokh\n" +
//"								 order by sokh.tong desc";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                int soLuong = rs.getInt(4);
//                Double tongTien = rs.getDouble(5);
//                String maKH = rs.getString(1);
//                HoaDonBanHang hd = new HoaDonBanHang(soLuong, tongTien);
////                HoaDonBanHang hd = new HoaDonBanHang(maHD, ngayLap, soLuong, tongTien, tienKhachDua, ghiChu);
//                //set KHachHang
//                KhachHang kh = khDao.getKHByMaKH(maKH);
//                hd.setKhachHang(kh);
//                listHD.add(hd);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi day");
//        }
//        return listHD;
//    }
//    
//    public ArrayList<HoaDonBanHang>CT_thongkeDoanhThuTheoNgay(String dayFrom, String dayTo,String month, String year){
//        ArrayList<HoaDonBanHang> dstk = new ArrayList<HoaDonBanHang>();
//        try {
//            java.sql.Connection con = connect.getInstance().getConnection();
//            String sql = "select MaHD,NgayLapHD,SoLuong,TongTien from [dbo].[HDBanHang]\n" +
//"where day([NgayLapHD])<='"+dayTo+"' and day([NgayLapHD])>='"+dayFrom+"' and MONTH([NgayLapHD])='"+month+"' and YEAR([NgayLapHD])='"+year+"'";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                int soLuong = rs.getInt(3);
//                Double tongTien = rs.getDouble(4);
//                String maHd = rs.getString(1);
//                Date date = rs.getDate(2);
//                HoaDonBanHang hd = new HoaDonBanHang(maHd, soLuong, tongTien, date);
//                dstk.add(hd);
//                System.out.println("ct nagy"+listHD);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi day");
//        }
//        return dstk;
//    }
//    
//    public ArrayList<HoaDonBanHang>CT_thongkeDoanhThuTheoThang(String monthFrom, String monthTo, String year){
//         ArrayList<HoaDonBanHang> dstk = new ArrayList<HoaDonBanHang>();
//        try {
//            java.sql.Connection con = connect.getInstance().getConnection();
//            String sql = "select MaHD,NgayLapHD,SoLuong,TongTien from [dbo].[HDBanHang]\n" +
//"where MONTH([NgayLapHD])<='"+monthTo+"' and MONTH([NgayLapHD])>='"+monthFrom+"' and YEAR([NgayLapHD])='"+year+"'";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                int soLuong = rs.getInt(3);
//                Double tongTien = rs.getDouble(4);
//                String maHd = rs.getString(1);
//                Date date = rs.getDate(2);
//                HoaDonBanHang hd = new HoaDonBanHang(maHd, soLuong, tongTien, date);
//
//                dstk.add(hd);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi day");
//        }
//        return dstk;
//    }
//    
//    public ArrayList<HoaDonBanHang>CT_thongkeDoanhThuTheoNam(String yearFrom, String yearTo){
//        ArrayList<HoaDonBanHang> dstk = new ArrayList<HoaDonBanHang>();
//        try {
//            java.sql.Connection con = connect.getInstance().getConnection();
//            String sql = "select MaHD,NgayLapHD,SoLuong,TongTien from [dbo].[HDBanHang]\n" +
//"where year([NgayLapHD])<='"+yearTo+"' and year([NgayLapHD])>='"+yearFrom+"'";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                int soLuong = rs.getInt(3);
//                Double tongTien = rs.getDouble(4);
//                String maHd = rs.getString(1);
//                Date date = rs.getDate(2);
//                HoaDonBanHang hd = new HoaDonBanHang(maHd, soLuong, tongTien, date);
//                dstk.add(hd);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi day");
//        }
//        return dstk;
//    }
//    
//    public ArrayList<HoaDonBanHang> thongkeDoanhThuTheoNgay(String dayFrom, String dayTo,String month, String year){
//        try {
//            
//            java.sql.Connection con = connect.getInstance().getConnection();
//            String sql = "select day(b.NgayLapHD), sum(b.TongTien) from [dbo].[HDBanHang] b\n" +
//"where day([NgayLapHD])<='"+dayTo+"' and day([NgayLapHD])>='"+dayFrom+"' and MONTH([NgayLapHD])='"+month+"' and YEAR([NgayLapHD])='"+year+"'\n" +
//"group by day(b.NgayLapHD)";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                  int ngayInt= rs.getInt(1);
//                  String ngay = String.valueOf(ngayInt);
//                  Date date = originalFormat.parse(ngay);
//                  System.out.println("ngay la"+date);
//                  Double tongTien = rs.getDouble(2);
//                  HoaDonBanHang hd = new HoaDonBanHang( tongTien,date);
//                listHD.add(hd);
//            }
//            System.out.println("dataset la"+listHD);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi day aa");
//        }
//        return listHD;
//    }
//    
//    public ArrayList<HoaDonBanHang> thongkeDoanhThuTheoThang(String monthFrom, String monthTo, String year){
//        try {
//            java.sql.Connection con = connect.getInstance().getConnection();
//            String sql = "select sum(b.TongTien) as'doanh thu' ,MONTH(b.NgayLapHD) as 'thang' from [dbo].[HDBanHang] b\n" +
//"where MONTH([NgayLapHD])<='"+monthTo+"' and MONTH([NgayLapHD])>='"+monthFrom+"' and YEAR([NgayLapHD])='"+year+"'\n" +
//"group by MONTH(b.NgayLapHD)";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                  int ngayInt= rs.getInt(2);
//                  String ngay = String.valueOf(ngayInt);
//                  Date date = originalFormat.parse(ngay);
//                  System.out.println("ngay la"+date);
//                  Double tongTien = rs.getDouble(1);
//                  HoaDonBanHang hd = new HoaDonBanHang( tongTien,date);
//                listHD.add(hd);
//            }
//            System.out.println("dataset la"+listHD);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi day aa");
//        }
//        return listHD;
//    }
//    public ArrayList<HoaDonBanHang> thongkeDoanhThuTheoNam(String yearFrom, String yearTo){
//        try {
//            
//            java.sql.Connection con = connect.getInstance().getConnection();
//            String sql = "select sum(b.TongTien) as'doanh thu' ,year(b.NgayLapHD) as 'nam' from [dbo].[HDBanHang] b\n" +
//"where year([NgayLapHD])<='"+yearTo+"' and year([NgayLapHD])>='"+yearFrom+"'\n" +
//"group by year(b.NgayLapHD)";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                  int ngayInt= rs.getInt(2);
//                  String ngay = String.valueOf(ngayInt);
//                  Date date = originalFormatYear.parse(ngay);
//                  System.out.println("ngay sql la"+date);
//                  Double tongTien = rs.getDouble(1);
//                  HoaDonBanHang hd = new HoaDonBanHang( tongTien,date);
//                listHD.add(hd);
//            }
//            System.out.println("dataset la"+listHD);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi day aa");
//        }
//        return listHD;
//    }
}
