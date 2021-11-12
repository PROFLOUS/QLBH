/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;
import java.awt.List;
import  entity.*;
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
import java.util.Locale;
import java.util.TimeZone;
/**
 *
 * @author GMT
 */
public class HoaDonDao {
   	ArrayList<HoaDonBanHang> listHD;
	HoaDonBanHang hoaDon;
        NhanVienDao nvDao = new NhanVienDao();
        KhachHangDao khDao = new KhachHangDao();

    public HoaDonDao() {
        listHD = new ArrayList<HoaDonBanHang>();
        hoaDon = new HoaDonBanHang();
    }
	
      //dua du lieu tu sql vao aArrayList
	public ArrayList<HoaDonBanHang> getDsHoaDon(){
		try {
			java.sql.Connection con = connect.getInstance().getConnection();
                        String sql = "select * from HDBanHang order by NgayLapHD desc";
				
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
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
			
		}
		catch (Exception e) {
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
        public HoaDonBanHang findHDByMaHD(String maHoaDon){
            HoaDonBanHang hd = null;
            try {
                 
                java.sql.Connection con = connect.getInstance().getConnection();
                String sql = "select * from HDBanHang where MaHD = '"+maHoaDon+"' ";
                Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString(1);
				Date ngayLap = rs.getTimestamp(2);
                                int soLuong = rs.getInt(3);
                                Double tongTien = rs.getDouble(4);
                                Double tienKhachDua = rs.getDouble(5);
                                String ghiChu = rs.getString(6);
                                String maNV = rs.getString(7);
                                String maKH = rs.getString(8);
                                Double giaGiam = rs.getDouble(9);
                                hd = new HoaDonBanHang(maHD, ngayLap, soLuong, tongTien, tienKhachDua, ghiChu,giaGiam );
                              
                                
                                
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

          //them 1 HoaDon vao database
	public boolean createHoaDonBH(HoaDonBanHang hd) {
            java.sql.Connection con = connect.getInstance().getConnection();
			
            PreparedStatement stmt = null;
            int n = 0;
            try {
		stmt = con.prepareStatement("Insert Into HDBanHang values(?,getdate(),?,?,?,?,?,?,?)");
                
             

              //  java.time.
                
		stmt.setString(1, hd.getMaHD());
//		stmt.setDate(2, (java.sql.Date) new Date());
                stmt.setInt(2, hd.getSoLuong());
                stmt.setDouble(3, hd.getTongTien());
                stmt.setDouble(4, hd.getTienKhachDua());
                stmt.setString(5, hd.getGhiChu());
                stmt.setString(6, hd.getNhanVien().getMaNV());
                stmt.setString(7, hd.getKhachHang().getMaKH());
                 stmt.setDouble(8, hd.getTienKhuyenMai());
                                        
                 n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
                    return n > 0;
		}
}
