package lotto.validator;

public class AmountValidator implements Validator {

    @Override
    public void validate(String input) {
        int number = isNumber(input);
        if (isNotPositiveNumber(number)) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력 가능합니다.");
        }
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위로 입력 가능합니다.");
        }
    }

    private int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
        }
    }

    private boolean isNotPositiveNumber(int number) {
        return number <= 0;
    }
}
