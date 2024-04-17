package it.epicode.ex3;

import java.util.Date;

public class Customer {

    private String customerCode;
    private String name;
    private String email;
    private Date registrationDate;

    public Customer(String customerCode, String name, String email) {
        this.customerCode = customerCode;
        this.name = name;
        this.email = email;
        this.registrationDate = new Date(); // Current date
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String toString() {
        return name + " (" + email + ")";
    }

}
