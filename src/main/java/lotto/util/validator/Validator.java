package lotto.util.validator;

public interface Validator {

    void validate(String userInput) throws IllegalArgumentException;

    static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
}
