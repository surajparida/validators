package com.code.validators;

import java.time.LocalDate;

public class Customer {

    private LocalDate dob;

    public Customer(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDob() {
        return dob;
    }
}