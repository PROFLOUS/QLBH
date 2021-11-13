/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhaCC;
import java.util.ArrayList;
import Connect.connect;
import java.util.List;
import entity.*;
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
public class NhaCCDao {

    private ArrayList<NhaCC> listNCC;
    private NhaCC ncc;
    private final Connection con;

    public NhaCCDao() {
        listNCC = new ArrayList<NhaCC>();
        ncc = new NhaCC();
        con = connect.getInstance().getConnection();
    }

    /**
     *
     * @param no
     * @return arrList dsNCC
     */
    public ArrayList<NhaCC> getDsNcc() {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from NhaCC";

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maNCC = rs.getString(1);

                String tenNCC = rs.getString(2);
                String sdt = rs.getString(3);
                String mail = rs.getString(4);
                String diaChi = rs.getString(5);

                NhaCC nhaCungCap = new NhaCC(maNCC, tenNCC, sdt, mail, diaChi);

                listNCC.add(nhaCungCap);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi day");
            // TODO: handle exception
        }
        return listNCC;
    }
    //update 1 NCC

    public boolean updateNCC(NhaCC ncc) {
        int n = 0;
        java.sql.Connection con = connect.getInstance().getConnection();

        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE NhaCC SET TenNCC = ?, SDT = ?,Mail = ?, DiaChi = ?  WHERE MaNCC = ?");

            stmt.setString(1, ncc.getTenNCC());
            stmt.setString(2, ncc.getSdt());
            stmt.setString(3, ncc.getMail());
            stmt.setString(4, ncc.getDiaChi());
            stmt.setString(5, ncc.getMaNCC());

            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    //them 1 NCC vao database
    public boolean createNCC(NhaCC ncc) {
        java.sql.Connection con = connect.getInstance().getConnection();

        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("Insert Into NhaCC values(?,?,?,?,?)");
            stmt.setString(1, ncc.getMaNCC());
            stmt.setString(2, ncc.getTenNCC());
            stmt.setString(3, ncc.getSdt());
            stmt.setString(4, ncc.getMail());
            stmt.setString(5, ncc.getDiaChi());

            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }

    //them nha cc ko co ma
    public boolean createNCC2(NhaCC ncc) {

        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO NhaCC([TenNCC],[SDT],[Mail],[DiaChi])\n"
                    + "VALUES (?, ?, ?, ? )");

            stmt.setString(1, ncc.getTenNCC());
            stmt.setString(2, ncc.getSdt());
            stmt.setString(3, ncc.getMail());
            stmt.setString(4, ncc.getDiaChi());
            int n = stmt.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //tim ma ncc qua sdt
    public NhaCC getNccBySdt(String sdt) {
        NhaCC ncc = null;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from NhaCC where [SDT] like '" + sdt + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ncc = new NhaCC(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(5));
            }
        } catch (Exception e) {
        }
        return ncc;
    }
    //tim ncc qua ma
    public NhaCC getNccByMa(String ma) {
        NhaCC ncc = null;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from NhaCC where [MaNCC] like '" + ma + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ncc = new NhaCC(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(5));
            }
        } catch (Exception e) {
        }
        return ncc;
    }

    // select top 5 * from NhaCC where [MaNCC]='0397578976'or [TenNCC] like N'%0397578976%' or [SDT] ='0397578976'
    //tim nhcc theo ma or ten or sdt 
    public List<NhaCC> SearchMaSpOrTenNcc(String text) {
        List<NhaCC> list = new ArrayList<>();
        try {

            PreparedStatement stmt = con.prepareStatement("select top 5 * from NhaCC where [TenNCC] like N'%" + text + "%' or [MaNCC] like N'%" + text + "%' or [SDT] like N'%" + text + "%' or  [DiaChi] like N'%" + text + "%'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                NhaCC nhaCungCap = new NhaCC(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

                list.add(nhaCungCap);

            }
        } catch (Exception e) {
            System.out.println("dao.NhaCCDao.SearchMaSpOrTenNcc()");
            e.printStackTrace();
        }

        return list;
    }

}
