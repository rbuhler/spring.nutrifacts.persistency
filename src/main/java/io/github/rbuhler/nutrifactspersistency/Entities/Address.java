package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.*;

@Entity
public class Address extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long index;

    @Column
    private String address1;
    @Column
    private String address2;
    @Column
    private String address3;

    @Column
    private String complement;
    @Column
    private Integer postalCode;
    @Column
    private String city;
    @Column
    private String region;
    @Column
    private String country;

    protected Address(){}

    public Address( String address1, String address2, String address3, String complement,
                    Integer postalCode, String city, String region, String country){
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.complement = complement;

        this.postalCode = postalCode;
        this.city = city;
        this.region = region;
        this.country = country;
    }

    public Long getIndex() {
        return index;
    }
    public void setIndex(Long index) {
        this.index = index;
    }

    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }
    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getComplement() {
        return complement;
    }
    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Integer getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
