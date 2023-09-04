package Model;

public class NguyenVong {
    private String cccd;

    private String thuTuNguyenVong;
    private String truongDaiHoc;
    private String maTruongDaiHoc;
    private String nganh;
    private String maNganh;
    private String phuongThucXetTuyen;
    private String toHopMon;

    public NguyenVong() {
    }

    public NguyenVong(String cccd, String thuTuNguyenVong, String truongDaiHoc, String maTruongDaiHoc,
                      String nganh, String maNganh, String phuongThucXetTuyen, String toHopMon) {
        this.cccd = cccd;
        this.thuTuNguyenVong = thuTuNguyenVong;
        this.truongDaiHoc = truongDaiHoc;
        this.maTruongDaiHoc = maTruongDaiHoc;
        this.nganh = nganh;
        this.maNganh = maNganh;
        this.phuongThucXetTuyen = phuongThucXetTuyen;
        this.toHopMon = toHopMon;
    }

    public String getThuTuNguyenVong() {
        return thuTuNguyenVong;
    }

    public String getTruongDaiHoc() {
        return truongDaiHoc;
    }

    public String getMaTruongDaiHoc() {
        return maTruongDaiHoc;
    }

    public String getNganh() {
        return nganh;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public String getPhuongThucXetTuyen() {
        return phuongThucXetTuyen;
    }

    public String getToHopMon() {
        return toHopMon;
    }

    public void setThuTuNguyenVong(String thuTuNguyenVong) {
        this.thuTuNguyenVong = thuTuNguyenVong;
    }

    public void setTruongDaiHoc(String truongDaiHoc) {
        this.truongDaiHoc = truongDaiHoc;
    }

    public void setMaTruongDaiHoc(String maTruongDaiHoc) {
        this.maTruongDaiHoc = maTruongDaiHoc;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public void setPhuongThucXetTuyen(String phuongThucXetTuyen) {
        this.phuongThucXetTuyen = phuongThucXetTuyen;
    }

    public void setToHopMon(String toHopMon) {
        this.toHopMon = toHopMon;
    }
    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }
}
