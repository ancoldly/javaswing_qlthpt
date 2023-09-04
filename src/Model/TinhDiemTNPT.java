package Model;

public class TinhDiemTNPT {
    private String cccd;
    private String checkCccd;
    private float diemToan;
    private float diemVan;
    private float diemAnh;
    private float diemLy_Su;
    private float diemHoa_Dia;
    private float diemSinh_Gdcd;
    private float diemTb12;
    private float diemKhuyenKhich;
    private float diemUuTien;
    private String doiTuongHs;
    private float diemxettotnghiep;

    public TinhDiemTNPT(String cccd, String checkCccd, float diemToan, float diemVan, float diemAnh, float diemLy_Su, float diemHoa_Dia,
                        float diemSinh_Gdcd, float diemTb12, float diemKhuyenKhich, float diemUuTien, String doiTuongHs, float diemxettotnghiep) {
        this.cccd = cccd;
        this.checkCccd = checkCccd;
        this.diemToan = diemToan;
        this.diemVan = diemVan;
        this.diemAnh = diemAnh;
        this.diemLy_Su = diemLy_Su;
        this.diemHoa_Dia = diemHoa_Dia;
        this.diemSinh_Gdcd = diemSinh_Gdcd;
        this.diemTb12 = diemTb12;
        this.diemKhuyenKhich = diemKhuyenKhich;
        this.diemUuTien = diemUuTien;
        this.doiTuongHs = doiTuongHs;
        this.diemxettotnghiep = diemxettotnghiep;
    }

    public String getCheckCccd() {
        return checkCccd;
    }

    public void setCheckCccd(String checkCccd) {
        this.checkCccd = checkCccd;
    }

    public void setDiemxettotnghiep(float diemxettotnghiep) {
        this.diemxettotnghiep = diemxettotnghiep;
    }

    public float getDiemxettotnghiep() {
        return diemxettotnghiep;
    }

    public TinhDiemTNPT() {
    }


    public String getCccd() {
        return cccd;
    }

    public float getDiemToan() {
        return diemToan;
    }

    public float getDiemVan() {
        return diemVan;
    }

    public float getDiemAnh() {
        return diemAnh;
    }

    public float getDiemLy_Su() {
        return diemLy_Su;
    }

    public float getDiemHoa_Dia() {
        return diemHoa_Dia;
    }

    public float getDiemSinh_Gdcd() {
        return diemSinh_Gdcd;
    }

    public float getDiemTb12() {
        return diemTb12;
    }

    public float getDiemKhuyenKhich() {
        return diemKhuyenKhich;
    }

    public float getDiemUuTien() {
        return diemUuTien;
    }

    public String getDoiTuongHs() {
        return doiTuongHs;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setDiemToan(float diemToan) {
        this.diemToan = diemToan;
    }

    public void setDiemVan(float diemVan) {
        this.diemVan = diemVan;
    }

    public void setDiemAnh(float diemAnh) {
        this.diemAnh = diemAnh;
    }

    public void setDiemLy_Su(float diemLy_Su) {
        this.diemLy_Su = diemLy_Su;
    }

    public void setDiemHoa_Dia(float diemHoa_Dia) {
        this.diemHoa_Dia = diemHoa_Dia;
    }

    public void setDiemSinh_Gdcd(float diemSinh_Gdcd) {
        this.diemSinh_Gdcd = diemSinh_Gdcd;
    }

    public void setDiemTb12(float diemTb12) {
        this.diemTb12 = diemTb12;
    }

    public void setDiemKhuyenKhich(float diemKhuyenKhich) {
        this.diemKhuyenKhich = diemKhuyenKhich;
    }

    public void setDiemUuTien(float diemUuTien) {
        this.diemUuTien = diemUuTien;
    }

    public void setDoiTuongHs(String doiTuongHs) {
        this.doiTuongHs = doiTuongHs;
    }
}
