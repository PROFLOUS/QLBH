/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;
import static Connect.connect.con;
import entity.DanhMucSP;
import entity.HoaDonBanHang;
import entity.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author GMT
 */
public class SanPhamDao {

    private ArrayList<SanPham> listSP;
    private SanPham sanPham;

    public SanPhamDao() {
        listSP = new ArrayList<SanPham>();
        sanPham = new SanPham();
    }

    //tim san pham theo ma SP
    //còn danh muc san pham chua lay ra
    /*
        @param maSP String
        return sanPham SanPham
     */
    public SanPham findSPByMaSP(String maSP) {
        SanPham sp = null;
        try {

            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from SanPham where MaSP = '" + maSP + "' ";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maSanPham = rs.getString(1);
                String tenSP = rs.getString(2);
                int soLuong = rs.getInt(3);
                Double donGia = rs.getDouble(4);
                String hinhAnh = rs.getString(5);
                String size = rs.getString(6);
                String mauSac = rs.getString(7);
                String maLoai = rs.getString(8);

                sp = new SanPham(maSP, tenSP, donGia, soLuong, hinhAnh, size, mauSac);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sp;

    }

    /*
        lấy danh sách sản phẩm
        return sanPham SanPham
     */
    public ArrayList<SanPham> getAllSP() {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            Statement stmt = con.createStatement();
            String Sql = "select * from SanPham";
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                DanhMucSPDao dm_dao = new DanhMucSPDao();
                DanhMucSP dm = dm_dao.getDMSP(rs.getString("MaLoai"));
                SanPham sp = new SanPham(dm, rs.getString("MaSP"), rs.getString("TenSP"), rs.getDouble("DonGia"), rs.getInt("SoLuong"), rs.getString("HinhAnh"), rs.getString("Size"), rs.getString("MauSac"),rs.getDouble("GiaNhap"));
                listSP.add(sp);
            }
        } catch (Exception e) {
        }
        return listSP;
    }

    /*
        @param maSP String
        Xóa một sản phẩm khi biét mã
     */
    public boolean xoaSP(String maSP) {
        int n = 0;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "delete from SanPham where maSP = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            n = ps.executeUpdate();
        } catch (Exception e) {
        }
        return n > 0;
    }

    //cập nhật sản phẩm
    public boolean updateSP(String maSP, SanPham sp) {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "update SanPham set TenSP = ?, SoLuong = ?, DonGia = ?, HinhAnh = ?, Size = ?, MauSac = ?, MaLoai = ? where MaSP = ?";
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setInt(2, sp.getSoLuong());
            ps.setDouble(3, sp.getDonGia());
            ps.setString(4, sp.getHinhAnh());
            ps.setString(5, sp.getSize());
            ps.setString(6, sp.getMauSac());
            ps.setString(7, sp.getDmsp().getMaloai());
            ps.setString(8, sp.getMaSP());
             int n = ps.executeUpdate();
            if(n>0){
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //Thêm sản phẩm mới
    public  boolean  themSP(SanPham sp){ 
        
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement spAdd = con.prepareStatement("INSERT [dbo].[SanPham] ( [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap])\n" +
"VALUES (?,?,?,?,?,?,?,?)");
            spAdd.setString(1, sp.getTenSP());
            spAdd.setInt(2, sp.getSoLuong());
            spAdd.setDouble(3, sp.getDonGia());
            spAdd.setString(4, sp.getHinhAnh());
            spAdd.setString(5, sp.getSize());
            spAdd.setString(6, sp.getMauSac());
            spAdd.setString(7, sp.getDmsp().getMaloai());
            spAdd.setDouble(8, sp.getGiaNhap());
            int n = spAdd.executeUpdate();
            if(n>0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //Thêm sản phẩm mới có mã
    public  boolean  themSP2(SanPham sp){
        
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement spAdd = con.prepareStatement("INSERT INTO SanPham([TenSP],[SoLuong],[DonGia],[HinhAnh],[Size],[MauSac],[MaLoai],[GiaNhap])\n" +
"VALUES (?, ?, ?, ?, ?, ?, ?, ? )");
            spAdd.setString(1, sp.getTenSP());
            spAdd.setInt(2, sp.getSoLuong());
            spAdd.setDouble(3, sp.getDonGia());
            spAdd.setString(4, sp.getHinhAnh());
            spAdd.setString(5, sp.getSize());
            spAdd.setString(6, sp.getMauSac());
            spAdd.setString(7, sp.getDmsp().getMaloai());
            spAdd.setDouble(8, sp.getGiaNhap());
            int n = spAdd.executeUpdate();
            if(n>0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //tìm sản phẩm theo tên
    public List<SanPham> SearchSp(String text){
            List<SanPham> list = new ArrayList<>();
            try {
                java.sql.Connection con = connect.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement("select * from SanPham where [TenSP] like ? ");
                stmt.setString(1,"%"+text+"%");
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                DanhMucSPDao dm_dao = new DanhMucSPDao();
                DanhMucSP dm = null;
                dm = dm_dao.getDMSP(rs.getString(8));
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(4), rs.getInt(3), rs.getString(5), rs.getString(6), rs.getString(7),rs.getDouble(9));
                sp.setDmsp(dm);
                list.add(sp);
            }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("loi");
            }
            
            return list;
        }
    
    public ArrayList<SanPham> SearchDm(String dm){
        ArrayList<SanPham> dsDm = new ArrayList<>();
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT *\n" +
"FROM     SanPham INNER JOIN\n" +
"                  DanhMucSP ON SanPham.MaLoai = DanhMucSP.MaLoai\n" +
"				  where TenLoai= ?");
            stmt.setString(1,dm);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                String ma = rs.getString(1);
                DanhMucSPDao dm_dao = new DanhMucSPDao();
                DanhMucSP dms = null;
                dms = dm_dao.getDMSP(rs.getString(8));
                String tenSp=rs.getString(2);
                int soluong = rs.getInt(3);
                double dongia =rs.getDouble(4);
                String hinh = rs.getString(5);
                String size = rs.getString(6);
                String mau= rs.getString(7);
                SanPham sp = new SanPham(dms, ma, tenSp, dongia, soluong, hinh, size, mau);
                dsDm.add(sp);
   
                
            }
        } catch (Exception e) {
        }
        return dsDm;
    }
    //tìm sản phẩm qua giá nhở hơn hoặc bằng
    public List<SanPham>SearchGialte(double giaLte){
        List<SanPham> list = new ArrayList<>();
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from SanPham where DonGia <= ?");
            stmt.setDouble(1,giaLte);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                DanhMucSPDao dm_dao = new DanhMucSPDao();
                DanhMucSP dm = null;
                dm = dm_dao.getDMSP(rs.getString(8));
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(4), rs.getInt(3), rs.getString(5), rs.getString(6), rs.getString(7));
                sp.setDmsp(dm);
                list.add(sp);
            }
        } catch (Exception e) {
        }
        return  list;
    }
    //tìm sản phẩm qua giá nằm trong khoản nào đó
    public List<SanPham>SearchGiaAnd(double gia1,double gia2){
        List<SanPham> list = new ArrayList<>();
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from SanPham where DonGia >? AND DonGia <= ?");
            stmt.setDouble(1,gia1);
            stmt.setDouble(2,gia2);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                DanhMucSPDao dm_dao = new DanhMucSPDao();
                DanhMucSP dm = null;
                dm = dm_dao.getDMSP(rs.getString(8));
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(4), rs.getInt(3), rs.getString(5), rs.getString(6), rs.getString(7));
                sp.setDmsp(dm);
                list.add(sp);
            }
        } catch (Exception e) {
        }
        return  list;
    }
    //tìm sản phẩm qua giá lớn hơn hoặc bằng số nào đó
    public List<SanPham>SearchGiaGt(double giaGt){
        List<SanPham> list = new ArrayList<>();
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from SanPham where DonGia >= ? ");
            stmt.setDouble(1,giaGt);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                DanhMucSPDao dm_dao = new DanhMucSPDao();
                DanhMucSP dm = null;
                dm = dm_dao.getDMSP(rs.getString(8));
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(4), rs.getInt(3), rs.getString(5), rs.getString(6), rs.getString(7));
                sp.setDmsp(dm);
                list.add(sp);
            }
        } catch (Exception e) {
        }
        return  list;
    }
    
     //tim sam pham theo ma vs ten
        public List<SanPham> SearchMaSpOrTenSp(String text){
            List<SanPham> list = new ArrayList<>();
            try {
                java.sql.Connection con = connect.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement("select * from SanPham inner join DanhMucSP on SanPham.MaLoai=DanhMucSP.MaLoai\n" +
"where TenLoai like N'%"+text+"%' or [TenSP] like N'%"+text+"%' or [MaSP]='"+text+"'" );
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                DanhMucSPDao dm_dao = new DanhMucSPDao();
                DanhMucSP dm = null;
                dm = dm_dao.getDMSP(rs.getString(8));
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(4), rs.getInt(3), rs.getString(5), rs.getString(6), rs.getString(7),rs.getDouble(9));
                sp.setDmsp(dm);
                list.add(sp);
            }
            } catch (Exception e) {
            }
            
            return list;
        }
        
        
        //cap nhat lai soluong san pham
        //so luong moi - sl hien tai - slDa ban
        /**
         * @param String maSP, int slSP - so luong san pham da ban
         * @return 
         */
        public boolean updateSLSP(String maSP, int slSpDaBan){
            SanPham sp = findSPByMaSP(maSP);
            int newSL = sp.getSoLuong() - slSpDaBan;
            int n = 0;
            java.sql.Connection con = connect.getInstance().getConnection();
			
            PreparedStatement stmt = null;
            try {
		
                stmt = con.prepareStatement("UPDATE SanPham SET  SoLuong = ?  WHERE MaSP = ?");
		
		stmt.setInt(1,newSL);
		stmt.setString(2,maSP);
		
					
		n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
            return n > 0;
        }
        
        //cap nhat so luong nhap
        
        public boolean updateSLNhapKho(String maSP, int slNhap){
            SanPham sp = findSPByMaSP(maSP);
            int newSL = sp.getSoLuong() + slNhap;
            int n = 0;
            java.sql.Connection con = connect.getInstance().getConnection();
			
            PreparedStatement stmt = null;
            try {
		
                stmt = con.prepareStatement("UPDATE SanPham SET  SoLuong = ?  WHERE MaSP = ?");
		
		stmt.setInt(1,newSL);
		stmt.setString(2,maSP);
		
					
		n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
            return n > 0;
        }
        //tim sp qua so luong
         public SanPham SearchWithSl(int sl){
            SanPham sp = null;
            try {
                java.sql.Connection con = connect.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement("select top 1  * from SanPham where SoLuong="+sl+"\n" +
"order by MaSP desc" );
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                 DanhMucSPDao dm_dao = new DanhMucSPDao();
                DanhMucSP dm = null;
                dm = dm_dao.getDMSP(rs.getString(8));
                sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(4), rs.getInt(3), rs.getString(5), rs.getString(6), rs.getString(7),rs.getDouble(9));
                sp.setDmsp(dm);
                
            }
            } catch (Exception e) {
            }
            return sp;
        }
        
}
