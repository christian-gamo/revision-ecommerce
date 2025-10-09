package com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;

    @NotBlank
    @Size(min = 5, message = "Street name must be atleast 5 characters")
    private String street;

    @NotBlank
    @Size(min = 5, message = "Building name must be atleast 5 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 4, message = "City name must be atleast 4 characters")
    private String city;

    @NotBlank
    @Size(min = 2, message = "State name must be atleast 2 characters")
    private String state;

    @NotBlank
    @Size(min = 2, message = "Country name must be atleast 2 characters")
    private String country;

    @NotBlank
    @Size(min = 5, message = "Pincode must be atleast 5 characters")
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;


    public AddressEntity(Address address) {
        this.idAddress = address.getIdAddress();
        this.street = address.getStreet();
        this.buildingName = address.getBuildingName();
        this.city = address.getCity();
        this.state = address.getState();
        this.country = address.getCountry();
        this.pincode = address.getPincode();
        this.user = new UserEntity(address.getUser());
    }

    public Address toAddress() {
        return new Address(
                this.getIdAddress(),
                this.getBuildingName(),
                this.getStreet(),
                this.getCity(),
                this.getState(),
                this.getCountry(),
                this.getPincode(),
                this.user.toUser());
    }
}
