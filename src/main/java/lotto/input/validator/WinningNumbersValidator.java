package lotto.input.validator;

public class WinningNumbersValidator {
    private final static String WINNING_NUMBERS_REGEX = "^(?:([1-9]|[1-3][0-9]|4[0-5]),?){5}([1-9]|[1-3][0-9]|4[0-5])$";

    public void validate(String input) {
        if(!input.matches(WINNING_NUMBERS_REGEX))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
