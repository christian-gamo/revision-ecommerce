package com.cpg.pprojects.ecommerce.entity.address.model;

import com.cpg.pprojects.ecommerce.entity.user.model.User;

public class Address {
    private long idAddress;
    private String buildingName;
    private String street;
    private String city;
    private String state;
    private String country;
    private String pincode;

    private User user;

    public Address() {}

    public Address(
            long idAddress,
            String buildingName,
            String street,
            String city,
            String state,
            String country,
            String pincode,
            User user
    ) {
        this.idAddress = idAddress;
        this.buildingName = buildingName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.user = user;
    }

    public Address(String buildingName,
                   String street,
                   String city,
                   String state,
                   String country,
                   String pincode,
                   User user
    ) {
        this.buildingName = buildingName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.user = user;
    }

    public long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(long idAddress) {
        this.idAddress = idAddress;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
