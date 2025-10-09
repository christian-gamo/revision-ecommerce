package com.cpg.pprojects.ecommerce.usecase.address.dto;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;

public class AddressDTO {
    private Long idAddress;
    private String street;
    private String buildingName;
    private String city;
    private String state;
    private String country;
    private String pincode;

    public AddressDTO() {
    }

    public AddressDTO(Long idAddress, String street, String buildingName,
                      String city, String state, String country, String pincode) {
        this.idAddress = idAddress;
        this.street = street;
        this.buildingName = buildingName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public AddressDTO(Address address) {
        this.idAddress = address.getIdAddress();
        this.street = address.getStreet();
        this.buildingName = address.getBuildingName();
        this.city = address.getCity();
        this.state = address.getState();
        this.country = address.getCountry();
        this.pincode = address.getPincode();
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
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

    @Override
    public String toString() {
        return "AddressDTO{" +
                "idAddress=" + idAddress +
                ", street='" + street + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
