package com.example.productdata.Entity;

public class LicensePlate {
    private int id;
    private String code;
    private int length;

    public LicensePlate(){}
    public LicensePlate(int id, String code, int length){
        this.id = id;
        this.code = code;
        this.length = length;
    }

    @Override
    public String toString() {
        return "LicensePlate{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", length=" + length +
                '}';
    }
}