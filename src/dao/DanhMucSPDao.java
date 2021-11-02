/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;
import entity.DanhMucSP;
import entity.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author GMT
 */
public class DanhMucSPDao {

    ArrayList<DanhMucSP> dsDMSP;

    public DanhMucSPDao() {
        dsDMSP = new ArrayList<DanhMucSP>();
    }

    //tim danh muc khi biet ma
    public DanhMucSP getDMSP(String maDM) {
        DanhMucSP dm = null;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "Select * from DanhMucSP where MaLoai = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dm = new DanhMucSP(rs.getString("MaLoai"), rs.getString("TenLoai"));
            }
        } catch (Exception e) {
        }
        return dm;
    }

    //Lấy danh sách danh mục sản pham
    public ArrayList<DanhMucSP> getAllDM() {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            Statement stmt = con.createStatement();
            String Sql = "select * from DanhMucSP";
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {;
                DanhMucSP dm = new DanhMucSP(rs.getString("MaLoai"), rs.getString("TenLoai"));
                dsDMSP.add(dm);
            }
        } catch (Exception e) {

        }
        return dsDMSP;
    }

    //tìm danh muc khi biết tên
    public DanhMucSP getDMByTen(String tenDM) {
        DanhMucSP dm = null;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "Select * from DanhMucSP where TenLoai = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenDM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dm = new DanhMucSP(rs.getString("MaLoai"), rs.getString("TenLoai"));
            }
        } catch (Exception e) {
        }
        return dm;
    }
    
    //cập nhật danh mục
    public  boolean  updateDM(String maDm, DanhMucSP dm){
        java.sql.Connection con = connect.getInstance().getConnection();
        String sql = "update DanhMucSP set TenLoai = ? Where MaLoai = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dm.getTenLoai());
            ps.setString(2, dm.getMaloai());
            int n = ps.executeUpdate();
            if(n>0){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    //thêm danh mục
    public  boolean  themDM(DanhMucSP dm){
        
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement dmAdd = con.prepareStatement("INSERT INTO DanhMucSP([TenLoai])\n" +
"VALUES (?)");
            dmAdd.setString(1, dm.getTenLoai());

            int n = dmAdd.executeUpdate();
            if(n>0){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    //xóa danh mục khi biét mã
    public boolean xoaDM(String maDM) {
        int n = 0;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "delete from DanhMucSP where MaLoai = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDM);
            n = ps.executeUpdate();
        } catch (Exception e) {
        }
        return n > 0;
    }

}
