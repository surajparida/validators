package com.code.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ValidationAggregator {

    private final List<Supplier<Boolean>> validations = new ArrayList<>();

    public ValidationAggregator add(Supplier<Boolean> validation) {
        validations.add(validation);
        return this;
    }

    public boolean validate() {
        return validations.stream().allMatch(Supplier::get);
    }
}