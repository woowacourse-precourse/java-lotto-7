package lotto.domain.validator;

import java.util.List;

public class CompositeValidator implements InputValidator {
    protected final List<InputValidator> validators;

    public CompositeValidator(List<InputValidator> validators) {
        this.validators = validators;
    }

    @Override
    public void validate(String input) {
        validators.forEach(validator -> validator.validate(input));
    }

    @Override
    public void validate(List<Integer> numbers) {
    }
}
