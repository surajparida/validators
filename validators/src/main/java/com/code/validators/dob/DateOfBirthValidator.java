package com.code.validators.dob;

import com.code.validators.CommonValidator;
import com.code.validators.Customer;

import java.time.LocalDate;

public class DateOfBirthValidator extends CommonValidator<Customer> {

    private DateOfBirthValidator(Customer target) {
        super(target);
    }

    public static DateOfBirthValidator of(Customer customer) {
        return new DateOfBirthValidator(customer);
    }

    public DateOfBirthValidator hasDob() {
        rules.add(p -> p.getDob() != null);
        return this;
    }

    public DateOfBirthValidator dobNotFuture() {
        rules.add(p -> p.getDob() != null &&
                !p.getDob().isAfter(LocalDate.now()));
        return this;
    }
}