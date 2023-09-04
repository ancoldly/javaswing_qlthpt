package Model;

public class ThiSinh {
    private String cccd;
    private String hoVaTen;
    private String sinhNhat;
    private String gioiTinh;
    private String dienUuTien;
    private String khuVuc;
    private String diaChi;
    private String thpt;
    private String checkCccd;

    public ThiSinh(String cccd, String hoVaTen, String sinhNhat, String gioiTinh,
                   String dienUuTien, String khuVuc, String diaChi, String thpt, String checkCccd) {
        this.cccd = cccd;
        this.hoVaTen = hoVaTen;
        this.sinhNhat = sinhNhat;
        this.gioiTinh = gioiTinh;
        this.dienUuTien = dienUuTien;
        this.khuVuc = khuVuc;
        this.diaChi = diaChi;
        this.thpt = thpt;
        this.checkCccd = checkCccd;
    }

    public void setCheckCccd(String checkCccd) {
        this.checkCccd = checkCccd;
    }

    public String getCheckCccd() {
        return checkCccd;
    }

    public ThiSinh() {

    }


    public String getCccd() {
        return cccd;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public String getSinhNhat() {
        return sinhNhat;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getDienUuTien() {
        return dienUuTien;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getThpt() {
        return thpt;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public void setSinhNhat(String sinhNhat) {
        this.sinhNhat = sinhNhat;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDienUuTien(String dienUuTien) {
        this.dienUuTien = dienUuTien;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setThpt(String thpt) {
        this.thpt = thpt;
    }
}
