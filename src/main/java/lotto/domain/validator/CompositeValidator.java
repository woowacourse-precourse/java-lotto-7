package lotto.domain.validator;

import java.util.List;

public class CompositeValidator implements InputValidator {
    private final List<InputValidator> validators;

    public CompositeValidator(List<InputValidator> validators) {
        this.validators = validators;
    }

    @Override
    public void validate(String input) {
        validators.forEach(validator -> validator.validate(input));
    }
}
