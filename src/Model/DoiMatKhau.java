package Model;

public class DoiMatKhau {
    private String matKhauCu;
    private String matKhauMoi;
    private String nhapLaiMatKhauMoi;
    private String checkMatKhauCu;

    public DoiMatKhau() {
    }

    public DoiMatKhau(String matKhauCu, String matKhauMoi, String nhapLaiMatKhauMoi, String checkMatKhauCu) {
        this.matKhauCu = matKhauCu;
        this.matKhauMoi = matKhauMoi;
        this.nhapLaiMatKhauMoi = nhapLaiMatKhauMoi;
        this.checkMatKhauCu = checkMatKhauCu;
    }

    public String getCheckMatKhauCu() {
        return checkMatKhauCu;
    }

    public void setCheckMatKhauCu(String checkMatKhauCu) {
        this.checkMatKhauCu = checkMatKhauCu;
    }

    public String getMatKhauCu() {
        return matKhauCu;
    }

    public String getMatKhauMoi() {
        return matKhauMoi;
    }

    public String getNhapLaiMatKhauMoi() {
        return nhapLaiMatKhauMoi;
    }

    public void setMatKhauCu(String matKhauCu) {
        this.matKhauCu = matKhauCu;
    }

    public void setMatKhauMoi(String matKhauMoi) {
        this.matKhauMoi = matKhauMoi;
    }

    public void setNhapLaiMatKhauMoi(String nhapLaiMatKhauMoi) {
        this.nhapLaiMatKhauMoi = nhapLaiMatKhauMoi;
    }
}
