package org.mmmorritti.customer.models;

import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    private Long customerId;
    private String name;
    private String surname;
    private String street;
    private Integer number;
    private String city;
    private Long telephoneNumber;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString(){
        String data = this.name + " "
                + this.surname + " "
                + this.street + " "
                + this.number + " "
                + this.city + " "
                + this.telephoneNumber;
        return data;
    }
}
