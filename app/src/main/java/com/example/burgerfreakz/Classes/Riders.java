package com.example.burgerfreakz.Classes;

public class Riders  {

    private int ID;
    private String name,riderNo,phone,bikeNo;

    public Riders() {
    }

    public Riders(int ID, String name, String riderNo, String phone, String bikeNo) {
        this.ID = ID;
        this.name = name;
        this.riderNo = riderNo;
        this.phone = phone;
        this.bikeNo = bikeNo;
    }

    public Riders(String name, String riderNo, String phone, String bikeNo) {
        this.name = name;
        this.riderNo = riderNo;
        this.phone = phone;
        this.bikeNo = bikeNo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRiderNo() {
        return riderNo;
    }

    public void setRiderNo(String riderNo) {
        this.riderNo = riderNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBikeNo() {
        return bikeNo;
    }

    public void setBikeNo(String bikeNo) {
        this.bikeNo = bikeNo;
    }
}
