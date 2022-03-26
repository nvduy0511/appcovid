package com.example.covidapp.model;

public class TinhThanh {
    private String tenTinhThanh;
    private String tongCaNhiem;
    private String soCaNhiem;
    private String soCaTuVong;

    public TinhThanh() {
    }

    public TinhThanh(String tenTinhThanh, String tongCaNhiem, String soCaNhiem, String soCaTuVong) {
        this.tenTinhThanh = tenTinhThanh;
        this.tongCaNhiem = tongCaNhiem;
        this.soCaNhiem = soCaNhiem;
        this.soCaTuVong = soCaTuVong;
    }

    public String getTenTinhThanh() {
        return tenTinhThanh;
    }

    public void setTenTinhThanh(String tenTinhThanh) {
        this.tenTinhThanh = tenTinhThanh;
    }

    public String getTongCaNhiem() {
        return tongCaNhiem;
    }

    public void setTongCaNhiem(String tongCaNhiem) {
        this.tongCaNhiem = tongCaNhiem;
    }

    public String getSoCaNhiem() {
        return soCaNhiem;
    }

    public void setSoCaNhiem(String soCaNhiem) {
        this.soCaNhiem = soCaNhiem;
    }

    public String getSoCaTuVong() {
        return soCaTuVong;
    }

    public void setSoCaTuVong(String soCaTuVong) {
        this.soCaTuVong = soCaTuVong;
    }
}
