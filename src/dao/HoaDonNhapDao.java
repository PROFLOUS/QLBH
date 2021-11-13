/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;
import java.awt.List;
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
import java.util.Locale;
import java.util.TimeZone;

public class HoaDonNhapDao {

    ArrayList<HoaDonNhap> listHD;
    HoaDonNhap hoaDonNhap;
    NhanVienDao nvDao = new NhanVienDao();
    NhaCCDao nccDao = new NhaCCDao();

    public HoaDonNhapDao() {
        listHD = new ArrayList<HoaDonNhap>();
        hoaDonNhap = new HoaDonNhap();
    }

    //dua du lieu tu sql 
    public ArrayList<HoaDonNhap> getDsHoaDonNhap() {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from HDNhapHang ";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                Date ngayLap = rs.getTimestamp(2);
                //System.err.println(ngayLap);
                int soLuong = rs.getInt(3);
                Double tongTien = rs.getDouble(4);
                String ghiChu = rs.getString(5);
                String maNV = rs.getString(6);
                String maNCC = rs.getString(7);
                NhanVien nv = nvDao.getNVByMaNV(maNV);
                //set KHachHang
                NhaCC ncc = nccDao.getNccByMa(maNCC);
                HoaDonNhap hdn = new HoaDonNhap(maHD,ngayLap, soLuong, tongTien, ghiChu, nv, ncc);
                //set nhan Vien 
                listHD.add(hdn);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi day");
            // TODO: handle exception
        }
        return listHD;
    }

    public HoaDonNhap findHDByMaHD(String maHoaDon) {
        HoaDonNhap hdn = null;
        try {

            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from HDNhapHang where MaHDNhap like '%" + maHoaDon + "%'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                Date ngayLap = rs.getTimestamp(2);
                //System.err.println(ngayLap);
                int soLuong = rs.getInt(3);
                Double tongTien = rs.getDouble(4);
                String ghiChu = rs.getString(5);
                String maNV = rs.getString(6);
                String maNCC = rs.getString(7);
                NhanVien nv = nvDao.getNVByMaNV(maNV);
                //set KHachHang
                NhaCC ncc = nccDao.getNccByMa(maNCC);
                hdn = new HoaDonNhap(maHD,ngayLap, soLuong, tongTien, ghiChu, nv, ncc);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hdn;

    }

    //them 1 HoaDon vao database
    public boolean createHoaDonBH(HoaDonNhap hd) {
        java.sql.Connection con = connect.getInstance().getConnection();

        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("INSERT INTO HDNhapHang([NgayLapHD],[SoLuong],[TongTien],[GhiChu],[MaNV],[MaNCC])\n"
                    + "VALUES (GETDATE(), ?, ?, ?, ?, ?);");

//		stmt.setString(1, hd.getMaHDNhap());
//		stmt.setDate(2, (java.sql.Date) new Date());
            stmt.setInt(1, hd.getSoLuong());
            stmt.setDouble(2, hd.getTongTien());
            stmt.setString(3, hd.getGhiChu());
            stmt.setString(4, hd.getNhanVien().getMaNV());
            stmt.setString(5, hd.getNCC().getMaNCC());

            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }
    
    public HoaDonNhap findHDBySl(int sl) {
        HoaDonNhap hdn = null;
        try {

            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from HDNhapHang where [SoLuong] ='"+sl+"'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                Date ngayLap = rs.getTimestamp(2);
                //System.err.println(ngayLap);
                int soLuong = rs.getInt(3);
                Double tongTien = rs.getDouble(4);
                String ghiChu = rs.getString(5);
                String maNV = rs.getString(6);
                String maNCC = rs.getString(7);
                NhanVien nv = nvDao.getNVByMaNV(maNV);
                //set KHachHang
                NhaCC ncc = nccDao.getNccByMa(maNCC);
                hdn = new HoaDonNhap(maHD,ngayLap, soLuong, tongTien, ghiChu, nv, ncc);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hdn;

    }

}
