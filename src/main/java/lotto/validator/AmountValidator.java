package lotto.validator;

public class AmountValidator implements Validator {

    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR = "[ERROR] ";

    @Override
    public void validate(String input) {
        int number = isNumber(input);
        if (isNotPositiveNumber(number)) {
            throw new IllegalArgumentException(ERROR + "양수만 입력 가능합니다.");
        }
        if (number % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR + "1000 단위로 입력 가능합니다.");
        }
    }

    private int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + "정수만 입력 가능합니다.");
        }
    }

    private boolean isNotPositiveNumber(int number) {
        return number <= 0;
    }
}
