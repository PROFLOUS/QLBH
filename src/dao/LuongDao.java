/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connect.connect;
import entity.CaLam;
import entity.ChucVu;
import entity.Luong;
import entity.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author HP
 */
public class LuongDao {

    private ArrayList<Luong> listLuong;
    private Luong luong;

    public LuongDao() {
        listLuong = new ArrayList<Luong>();
        luong = new Luong();

    }

    //đọc dữ liệu từ 
    public ArrayList<Luong> getAllLuong() {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            Statement stmt = con.createStatement();
            String Sql = "SELECT soca.nv AS 'MaNV', soca.ten AS 'TenNV', cv.TenCV AS 'CV', cv.HSLuong AS 'DonGia', soca.sc AS 'SoCa', soca.sc*cv.HSLuong AS 'Luong'\n"
                    + "				FROM chucvu cv, (SELECT cl.MaNV nv , nv.MaCV cv, COUNT(cl.MaCa) sc, nv.TenNV ten \n"
                    + "                					FROM calam cl, nhanvien nv\n"
                    + "                					WHERE cl.MaNV = nv.MaNV\n"
                    + "               					 GROUP BY cl.MaNV,nv.MaCV,nv.TenNV) soca\n"
                    + "				WHERE cv.MaCV = soca.cv ";
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                NhanVienDao nv_dao = new NhanVienDao();
                NhanVien nv = nv_dao.getNVByMaNV(rs.getString("MaNV"));

                ChucVuDao cv_dao = new ChucVuDao();
                ChucVu cv = cv_dao.getCVByTen(rs.getString("CV"));

                Luong l = new Luong(nv, cv, rs.getInt("SoCa"), rs.getDouble("Luong"));
                listLuong.add(l);
            }
        } catch (Exception e) {
            System.out.println("loi luong");
            e.printStackTrace();
        }
        return listLuong;
    }

    //tìm tên chúc vụ trong bảng lương
    public ArrayList<Luong> searchTenCV(String tenCV) {
        ArrayList<Luong> dsLuong = new ArrayList<>();
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT soca.nv AS 'MaNV', soca.ten AS 'TenNV', cv.TenCV AS 'CV', cv.HSLuong AS 'DonGia', soca.sc AS 'SoCa', soca.sc*cv.HSLuong AS 'Luong'\n" +
"				FROM chucvu cv, (SELECT cl.MaNV nv , nv.MaCV cv, COUNT(cl.MaCa) sc, nv.TenNV ten \n" +
"                					FROM calam cl, nhanvien nv\n" +
"                					WHERE cl.MaNV = nv.MaNV\n" +
"               					 GROUP BY cl.MaNV,nv.MaCV,nv.TenNV) soca\n" +
"				WHERE cv.MaCV = soca.cv and cv.TenCV = ? ");
            stmt.setString(1, tenCV);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                NhanVienDao nv_dao = new NhanVienDao();
            NhanVien nv = nv_dao.getNVByMaNV(rs.getString(1));
            
            ChucVuDao cv_dao = new ChucVuDao();
            ChucVu cv = cv_dao.getCVByTen(rs.getString(3));
            
            Luong luong =new Luong(nv,cv, rs.getInt(5), rs.getDouble(6));
            dsLuong.add(luong);
            }
            
        } catch (Exception e) {
            System.out.println("dao.LuongDao.searchTenCV()");
            e.printStackTrace();
        }
        return dsLuong;
    }
    //tính lương
    public boolean tinhLuong(String maNV){
        int n = 0;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "delete from [dbo].[CaLam] where [MaNV] = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maNV);
            n = ps.executeUpdate();
        } catch (Exception e) {
        }
        return  n>0;
    }
    
    //tinhs luong theo ngày 
    public ArrayList<Luong> searchNgayLam(String from , String to) {
        ArrayList<Luong> dsLuong = new ArrayList<>();
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT soca.nv AS 'MaNV', soca.ten AS 'TenNV', cv.TenCV AS 'CV', cv.HSLuong AS 'DonGia', soca.sc AS 'SoCa', soca.sc*cv.HSLuong AS 'Luong'\n" +
"				FROM chucvu cv, (SELECT cl.MaNV nv , nv.MaCV cv, COUNT(cl.MaCa) sc, nv.TenNV ten \n" +
"                					FROM calam cl, nhanvien nv\n" +
"                					WHERE cl.MaNV = nv.MaNV and (cl.ngaylam BETWEEN '"+from+"' AND '"+to+"') \n" +
"               					 GROUP BY cl.MaNV,nv.MaCV,nv.TenNV) soca\n" +
"				WHERE cv.MaCV = soca.cv");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                NhanVienDao nv_dao = new NhanVienDao();
            NhanVien nv = nv_dao.getNVByMaNV(rs.getString(1));
            
            ChucVuDao cv_dao = new ChucVuDao();
            ChucVu cv = cv_dao.getCVByTen(rs.getString(3));
            
            Luong luong =new Luong(nv,cv, rs.getInt(5), rs.getDouble(6));
            dsLuong.add(luong);
            }
            
        } catch (Exception e) {
            System.out.println("dao.LuongDao.searchTenCV()");
            e.printStackTrace();
        }
        return dsLuong;
    }
    
    //tim ma nhan vien
    public ArrayList<Luong> searchByMaNV(String ma) {
        ArrayList<Luong> dsLuong = new ArrayList<>();
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT soca.nv AS 'MaNV', soca.ten AS 'TenNV', cv.TenCV AS 'CV', cv.HSLuong AS 'DonGia', soca.sc AS 'SoCa', soca.sc*cv.HSLuong AS 'Luong'\n" +
"				FROM chucvu cv, (SELECT cl.MaNV nv , nv.MaCV cv, COUNT(cl.MaCa) sc, nv.TenNV ten \n" +
"                					FROM calam cl, nhanvien nv\n" +
"                					WHERE cl.MaNV = nv.MaNV and nv.MaNV = '"+ma+"'\n" +
"               					 GROUP BY cl.MaNV,nv.MaCV,nv.TenNV) soca\n" +
"				WHERE cv.MaCV = soca.cv ");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                NhanVienDao nv_dao = new NhanVienDao();
            NhanVien nv = nv_dao.getNVByMaNV(rs.getString(1));
            
            ChucVuDao cv_dao = new ChucVuDao();
            ChucVu cv = cv_dao.getCVByTen(rs.getString(3));
            
            Luong luong =new Luong(nv,cv, rs.getInt(5), rs.getDouble(6));
            dsLuong.add(luong);
            }
            
        } catch (Exception e) {
            System.out.println("dao.LuongDao.searchTenCV()");
            e.printStackTrace();
        }
        return dsLuong;
    }
    

}
