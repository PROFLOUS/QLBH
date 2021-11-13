/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;
import entity.CT_HoaDonNhap;
import entity.HoaDonNhap;
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
public class CT_HoaDonNhapDao {

    ArrayList<CT_HoaDonNhap> listCTHD;
    CT_HoaDonNhap cthdn;
    HoaDonNhapDao hoaDonNhapDao = new HoaDonNhapDao();
    SanPhamDao sanPhamDao = new SanPhamDao();

    public CT_HoaDonNhapDao() {
        listCTHD = new ArrayList<CT_HoaDonNhap>();
        cthdn = new CT_HoaDonNhap();
    }
    //timf hoa dơn theo 

    public ArrayList<CT_HoaDonNhap> getCTHoadDonByMaHD(String maHD) {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from CT_HoaDonNhap where MaHDNhap like '%" + maHD + "%'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int soLuong = rs.getInt(1);
                Double donGia = rs.getDouble(2);
                String maHoaDonNhap = rs.getString(3);
                String maSP = rs.getString(4);

                CT_HoaDonNhap ctHDN = new CT_HoaDonNhap(soLuong, donGia);

                HoaDonNhap hoaDonNhap = hoaDonNhapDao.findHDByMaHD(maHoaDonNhap);
                ctHDN.setHoaDonNhap(hoaDonNhap);

                SanPham sp = sanPhamDao.findSPByMaSP(maSP);
                ctHDN.setSanPham(sp);

                listCTHD.add(ctHDN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTHD;
    }
    //them ct hoa don nhap

    public boolean createCTHoaDonNH(CT_HoaDonNhap ct) {
        java.sql.Connection con = connect.getInstance().getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("Insert Into CT_HoaDonNhap values(?,?,?,?)");
            stmt.setInt(1, ct.getSoLuong());
            stmt.setDouble(2, ct.getDonGia());
            stmt.setString(3, ct.getHoaDonNhap().getMaHDNhap());
            stmt.setString(4, ct.getSanPham().getMaSP());
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }
}
