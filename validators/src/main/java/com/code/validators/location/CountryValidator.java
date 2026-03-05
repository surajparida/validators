package com.code.validators.location;

import com.code.validators.CommonValidator;
import com.code.validators.Country;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CountryValidator extends CommonValidator<Country> {

    @Autowired
    private List<Country> countries = List.of(new Country("US"));

    private CountryValidator(Country target) {
        super(target);
    }

    public static CountryValidator of(Country country) {
        return new CountryValidator(country);
    }

    public CountryValidator hasCountryCode() {
        rules.add(p -> p.getCountryCode() != null);
        return this;
    }

    public CountryValidator existsInList() {
        rules.add(c -> countries.stream()
                .anyMatch(x -> x.getCountryCode().equals(c.getCountryCode())));
        return this;
    }
}
