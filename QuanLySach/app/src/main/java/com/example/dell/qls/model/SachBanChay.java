package com.example.dell.qls.model;

public class SachBanChay {
    private String AvatarSachbc;
    private  String MaSachbc;
    private  String Soluong;
    protected boolean isDelete;

    public SachBanChay(String avatarSachbc, String maSachbc, String soluong) {
        AvatarSachbc = avatarSachbc;
        MaSachbc = maSachbc;
        Soluong = soluong;
    }

    public String getAvatarSachbc() {
        return AvatarSachbc;
    }

    public void setAvatarSachbc(String avatarSachbc) {
        AvatarSachbc = avatarSachbc;
    }

    public String getMaSachbc() {
        return MaSachbc;
    }

    public void setMaSachbc(String maSachbc) {
        MaSachbc = maSachbc;
    }

    public String getSoluong() {
        return Soluong;
    }

    public void setSoluong(String soluong) {
        Soluong = soluong;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
