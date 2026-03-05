package com.code.validators;

import java.util.ArrayList;
import java.util.List;

public class CommonValidator<T> {

    protected final T target;
    protected final List<Rule<T>> rules = new ArrayList<>();

    protected CommonValidator(T target) {
        this.target = target;
    }

    public boolean isValid() {
        return rules.stream().allMatch(r -> r.apply(target));
    }

}