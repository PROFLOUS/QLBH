/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;
import entity.CT_HDDatHang;
import entity.HoaDonDatHang;
import entity.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author GMT
 */
public class CT_HoaDonDatHangDao {
       	ArrayList<CT_HDDatHang> listCTHD;
	CT_HDDatHang cthd;
        HoaDonDatHangDao hoaDonDao = new HoaDonDatHangDao();
        SanPhamDao sanPhamDao = new SanPhamDao();
        
        
        
    public CT_HoaDonDatHangDao() {
        listCTHD = new ArrayList<CT_HDDatHang>();
        cthd = new CT_HDDatHang();
    }
  
    //query theo ma HoaDon
    /*
        @param maHD String
        return ArrayList CT_HoaDon
    */
    public ArrayList<CT_HDDatHang> getCTHoadDonByMaHD(String maHD){
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from [CT_HoaDonDatHang] where [MaHDDH] = '"+maHD+"' ";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
		int soLuong = rs.getInt(1);
                double donGia = rs.getDouble(2);
                String maHoaDon = rs.getString(3);
                String maSP = rs.getString(4);

                CT_HDDatHang ctHD = new CT_HDDatHang(soLuong, donGia);
                
                HoaDonDatHang hoaDon = hoaDonDao.findHDByMaHD(maHoaDon);
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
	public boolean createCTHoaDonBH(CT_HDDatHang ct) {
            java.sql.Connection con = connect.getInstance().getConnection();
			
            PreparedStatement stmt = null;
            int n = 0;
            try {
		stmt = con.prepareStatement("INSERT [dbo].[CT_HoaDonDatHang] ([SoLuong], [DonGia], [MaHDDH], [MaSP]) VALUES (?, ?, ?, ?)");
		stmt.setInt(1, ct.getSoLuong());
                stmt.setDouble(2, ct.getDonGia());
                stmt.setString(3, ct.getHoaDon().getMaHDDH());
                stmt.setString(4,ct.getSanPham().getMaSP());
                 n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
                    return n > 0;
		}
     //Thống kê số lượng sản phẩm theo năm
//         public ArrayList<CT_HDBanHang>thongkeSpTheoNam(String year){
//        try {
//            java.sql.Connection con = connect.getInstance().getConnection();
//            String sql = "SELECT  sosp.sp AS 'Masp', sosp.ten AS 'Tensp',sosp.sl as'SoLuongBang' , sosp.dongia as'Gia Ban'  from\n" +
//"				(SELECT cthd.MaSP sp ,SUM (cthd.SoLuong)  sl, sp.TenSP ten ,sp.DonGia dongia\n" +
//"                					FROM [dbo].[CT_HoaDonBanHang] cthd, [dbo].[SanPham] sp ,[dbo].[HDBanHang] hdb\n" +
//"                					WHERE cthd.MaSP = sp.MaSP and cthd.MaHD =hdb.MaHD and year( hdb.NgayLapHD) ='"+year+"'\n" +
//"               					 GROUP BY cthd.MaSP , sp.TenSP,sp.DonGia ) sosp\n" +
//"								 order by sosp.sl desc";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                int soLuong = rs.getInt(3);
//                String maSP = rs.getString(1);
//                SanPham sp = sanPhamDao.findSPByMaSP(maSP);
//                Double donGia =rs.getDouble(4);
//                CT_HDBanHang ct = new CT_HDBanHang(soLuong,donGia);
//                ct.setSanPham(sp);
//                listCTHD.add(ct);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi day");
//        }
//        return listCTHD;
//    }
//          public ArrayList<CT_HDBanHang>thongkeSpTheoThang(String month){
//        try {
//            java.sql.Connection con = connect.getInstance().getConnection();
//            String sql = "SELECT  sosp.sp AS 'Masp', sosp.ten AS 'Tensp',sosp.sl as'SoLuongBang' , sosp.dongia as'Gia Ban'  from\n" +
//"				(SELECT cthd.MaSP sp ,SUM (cthd.SoLuong)  sl, sp.TenSP ten ,sp.DonGia dongia\n" +
//"                					FROM [dbo].[CT_HoaDonBanHang] cthd, [dbo].[SanPham] sp ,[dbo].[HDBanHang] hdb\n" +
//"                					WHERE cthd.MaSP = sp.MaSP and cthd.MaHD =hdb.MaHD and Month( hdb.NgayLapHD) ='"+month+"'\n" +
//"               					 GROUP BY cthd.MaSP , sp.TenSP,sp.DonGia ) sosp\n" +
//"								 order by sosp.sl desc";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                int soLuong = rs.getInt(3);
//                String maSP = rs.getString(1);
//                SanPham sp = sanPhamDao.findSPByMaSP(maSP);
//                Double donGia =rs.getDouble(4);
//                CT_HDBanHang ct = new CT_HDBanHang(soLuong,donGia);
//                ct.setSanPham(sp);
//                listCTHD.add(ct);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi day");
//        }
//        return listCTHD;
//    }
//           public ArrayList<CT_HDBanHang>thongkeSpTheoNgay(String day){
//        try {
//            java.sql.Connection con = connect.getInstance().getConnection();
//            String sql = "SELECT  sosp.sp AS 'Masp', sosp.ten AS 'Tensp',sosp.sl as'SoLuongBang' , sosp.dongia as'Gia Ban'  from\n" +
//"				(SELECT cthd.MaSP sp ,SUM (cthd.SoLuong)  sl, sp.TenSP ten ,sp.DonGia dongia\n" +
//"                					FROM [dbo].[CT_HoaDonBanHang] cthd, [dbo].[SanPham] sp ,[dbo].[HDBanHang] hdb\n" +
//"                					WHERE cthd.MaSP = sp.MaSP and cthd.MaHD =hdb.MaHD and day( hdb.NgayLapHD) ='"+day+"'\n" +
//"               					 GROUP BY cthd.MaSP , sp.TenSP,sp.DonGia ) sosp\n" +
//"								 order by sosp.sl desc";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                int soLuong = rs.getInt(3);
//                String maSP = rs.getString(1);
//                
//                SanPham sp = sanPhamDao.findSPByMaSP(maSP);
//                Double donGia =rs.getDouble(4);
//                CT_HDBanHang ct = new CT_HDBanHang(soLuong,donGia);
//                ct.setSanPham(sp);
//                listCTHD.add(ct);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi day");
//        }
//        return listCTHD;
//    }

}
