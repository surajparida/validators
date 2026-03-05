package com.code.validators;

import com.code.validators.dob.DateOfBirthValidator;
import com.code.validators.location.CountryValidator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ValidatorsApplication {

	//SpringApplication.run(ValidatorsApplication.class, args);

	 static void main(String[] args) {
		Customer customer = new Customer(LocalDate.of(2000, 5, 10));
		Country country = new Country("US");

		 boolean valid =
				 new ValidationAggregator()
						 .add(() -> DateOfBirthValidator.of(customer)
								 .hasDob()
								 .isValid())
						 .add(() -> CountryValidator.of(country)
								 .hasCountryCode()
								 .existsInList()
								 .isValid())
						 .validate();

		 	System.out.println(valid);


	}

}
