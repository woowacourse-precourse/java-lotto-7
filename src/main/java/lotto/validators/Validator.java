package lotto.validators;

public interface Validator {
    String POSITIVE_WHOLE_INT_REGEX = "^[1-9][0-9]*$";

    void validate(String input);
}
