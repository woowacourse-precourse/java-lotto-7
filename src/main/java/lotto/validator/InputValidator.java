package lotto.validator;

public interface InputValidator {

    boolean isBlank(String input);

    boolean isPlusNumber(String input);

    boolean isDigit(String input);

    boolean isZero(String input);
}
