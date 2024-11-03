package lotto.util.validator;

public interface Validator<T> {
    T validate(String userInput) throws IllegalArgumentException;

    static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
}