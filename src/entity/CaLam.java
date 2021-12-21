
package entity;


import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author GMT
 */


public class CaLam {
    private String maCa;
    private NhanVien nhanVien;
    private String buoi;
    private Date ngayLam;

    public CaLam() {
    }

    public CaLam(String maCa, NhanVien nhanVien, String buoi) {
        this.maCa = maCa;
        this.nhanVien = nhanVien;
        this.buoi = buoi;
    }

    public CaLam(String maCa, NhanVien nhanVien, String buoi, Date ngayLam) {
        this.maCa = maCa;
        this.nhanVien = nhanVien;
        this.buoi = buoi;
        this.ngayLam = ngayLam;
    }

    public String getMaCa() {
        return maCa;
    }

    public NhanVien getNV() {
        return nhanVien;
    }

    public String getBuoi() {
        return buoi;
    }

    public Date getNgayLam() {
        return ngayLam;
    }

    public void setMaCa(String maCa) {
        this.maCa = maCa;
    }

    public void setNV(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setBuoi(String buoi) {
        this.buoi = buoi;
    }

    public void setNgayLam(Date ngayLam) {
        this.ngayLam = ngayLam;
    }

    @Override
    public String toString() {
        return "CaLam{" + "maCa=" + maCa + ", NV=" + nhanVien + ", buoi=" + buoi + ", ngayLam=" + ngayLam + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.maCa);
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
        final CaLam other = (CaLam) obj;
        if (!Objects.equals(this.maCa, other.maCa)) {
            return false;
        }
        return true;
    }

    

    

   
    
}
