package com.example.demo.Controllers.Customer;

public class Customer {
    private String cusId;
    private String Name;
    private String address;
    private String contact_Number;

    public Customer(String cusId, String name, String address, String contact_Number) {
        this.cusId = cusId;
        Name = name;
        this.address = address;
        this.contact_Number = contact_Number;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_Number() {
        return contact_Number;
    }

    public void setContact_Number(String contact_Number) {
        this.contact_Number = contact_Number;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId='" + cusId + '\'' +
                ", Name='" + Name + '\'' +
                ", address='" + address + '\'' +
                ", contact_Number='" + contact_Number + '\'' +
                '}';
    }
}
