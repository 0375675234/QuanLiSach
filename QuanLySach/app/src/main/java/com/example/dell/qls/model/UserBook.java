package com.example.dell.qls.model;

public class UserBook {
    private String Avatar;
    private  String Name;
    private  String Address;
    protected boolean isDelete;

    public UserBook(String studentAvatar, String name, String address) {
        this.Avatar = studentAvatar;
        Name = name;
        Address = address;
    }

    public String getStudentAvatar() {
        return Avatar;
    }

    public void setStudentAvatar(String studentAvatar) {
        this.Avatar = studentAvatar;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
