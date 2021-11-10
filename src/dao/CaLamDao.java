/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;
import entity.CaLam;
import entity.DanhMucSP;
import entity.NhanVien;
import entity.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author GMT
 */
public class CaLamDao {
    private ArrayList<CaLam> listCa;
    private CaLam caLam;
    
    public CaLamDao(){
        listCa = new ArrayList<CaLam>();
        caLam = new CaLam();
    }
    
    public ArrayList<CaLam> getAllCaLam(){
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            Statement stmt = con.createStatement();
            String Sql = "select * from CaLam";
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                NhanVienDao nv_dao = new NhanVienDao();
                NhanVien nv = nv_dao.getNVByMaNV(rs.getString("MaNV"));
                CaLam ca = new CaLam(rs.getString("MaCa"), nv, rs.getString("Buoi"));
                listCa.add(ca);
            }
        } catch (Exception e) {
        }
        return listCa;
    }
    
    //thêm ca làm vào database
    public boolean themCa(CaLam ca){
        boolean checkTrung = true;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement caAdd = con.prepareStatement("INSERT INTO CaLam([Buoi],[MaNV])\n" +
"VALUES (?, ? )");
            caAdd.setString(1, ca.getBuoi());
            caAdd.setString(2, ca.getNV().getMaNV());
            int n = caAdd.executeUpdate();
            if(n>0)
                return true;
        } catch (Exception e) {
        }
        return false;
    }
    //xóa ca làm 
    public boolean xoaCa(String maCa) {
        int n = 0;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "delete from CaLam where maCa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maCa);
            n = ps.executeUpdate();
        } catch (Exception e) {
        }
        return n > 0;
    }
    //đọc bảng lương từ database
    public ArrayList<CaLam> getBangLuong(){
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            Statement stmt = con.createStatement();
            String Sql = "select * from CaLam";
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                NhanVienDao nv_dao = new NhanVienDao();
                NhanVien nv = nv_dao.getNVByMaNV(rs.getString("MaNV"));
                CaLam ca = new CaLam(rs.getString("MaCa"), nv, rs.getString("Buoi"));
                listCa.add(ca);
            }
        } catch (Exception e) {
        }
        return listCa;
    }
}
