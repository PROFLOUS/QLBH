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
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Date;
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
                        String sql = "select * from HDBanHang";
				
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString(1);
				Date ngayLap = rs.getDate(2);
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
				Date ngayLap = rs.getDate(2);
                                int soLuong = rs.getInt(3);
                                Double tongTien = rs.getDouble(4);
                                Double tienKhachDua = rs.getDouble(5);
                                String ghiChu = rs.getString(6);
                                String maNV = rs.getString(7);
                                String maKH = rs.getString(8);
                                hd = new HoaDonBanHang(maHD, ngayLap, soLuong, tongTien, tienKhachDua, ghiChu);
                              
                                
                                
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
}
