package Model;

public class MonThi {
    private String van;
    private String toan;
    private String ly;
    private String hoa;
    private String sinh;
    private String su;
    private String dia;
    private String gdcd;
    private String anh;
    private String cccd;
    private String ngayThi;
    private String gioThi;

    public MonThi() {
    }

    public MonThi(String van, String toan, String ly, String hoa, String sinh, String su,
                  String dia, String gdcd, String anh, String cccd, String ngayThi, String gioThi) {
        this.van = van;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.sinh = sinh;
        this.su = su;
        this.dia = dia;
        this.gdcd = gdcd;
        this.anh = anh;
        this.cccd = cccd;
        this.ngayThi = ngayThi;
        this.gioThi = gioThi;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    public void setGioThi(String gioThi) {
        this.gioThi = gioThi;
    }

    public String getCccd() {
        return cccd;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public String getGioThi() {
        return gioThi;
    }

    public String getVan() {
        return van;
    }

    public String getToan() {
        return toan;
    }

    public String getLy() {
        return ly;
    }

    public String getHoa() {
        return hoa;
    }

    public String getSinh() {
        return sinh;
    }

    public String getSu() {
        return su;
    }

    public String getDia() {
        return dia;
    }

    public String getGdcd() {
        return gdcd;
    }

    public String getAnh() {
        return anh;
    }

    public void setVan(String van) {
        this.van = van;
    }

    public void setToan(String toan) {
        this.toan = toan;
    }

    public void setLy(String ly) {
        this.ly = ly;
    }

    public void setHoa(String hoa) {
        this.hoa = hoa;
    }

    public void setSinh(String sinh) {
        this.sinh = sinh;
    }

    public void setSu(String su) {
        this.su = su;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setGdcd(String gdcd) {
        this.gdcd = gdcd;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
