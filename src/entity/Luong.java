
package entity;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class Luong {
    private NhanVien maNV;
    private ChucVu maCV;
    private int soCa;
    private double luong;

    public Luong() {
    }
    
    

    public Luong(NhanVien maNV, ChucVu maCV, int soCa, double luong) {
        this.maNV = maNV;
        this.maCV = maCV;
        this.soCa = soCa;
        this.luong = luong;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public ChucVu getMaCV() {
        return maCV;
    }

    public int getSoCa() {
        return soCa;
    }

    public double getLuong() {
        return luong;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    public void setMaCV(ChucVu maCV) {
        this.maCV = maCV;
    }

    public void setSoCa(int soCa) {
        this.soCa = soCa;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "Luong{" + "maNV=" + maNV + ", maCV=" + maCV + ", soCa=" + soCa + ", luong=" + luong + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.maNV);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Luong other = (Luong) obj;
        if (!Objects.equals(this.maNV, other.maNV)) {
            return false;
        }
        return true;
    }
    
    
}
