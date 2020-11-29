package com.customer.types;

public class Adderess {
    private String mobNo;
    private String street;
    private String email;
    private String dNo;

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getdNo() {
        return dNo;
    }

    public void setdNo(String dNo) {
        this.dNo = dNo;
    }

    @Override
    public String toString() {
        return "Adderess{" +
                "mobNo='" + mobNo + '\'' +
                ", street='" + street + '\'' +
                ", email='" + email + '\'' +
                ", dNo='" + dNo + '\'' +
                '}';
    }
}
