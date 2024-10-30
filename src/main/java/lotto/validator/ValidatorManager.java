package lotto.validator;

import java.util.HashMap;
import java.util.Map;
import lotto.validator.strategies.ValidationStrategy;

public class ValidatorManager<T> {

    private final Map<String, ValidationStrategy<T>> validators = new HashMap<>();

    public void registerValidator(String type, ValidationStrategy<T> validator) {
        validators.put(type, validator);
    }

    public void validate(String type, T input) {
        ValidationStrategy<T> validator = validators.get(type);
        validator.validate(input);
    }

}
