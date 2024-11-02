package lotto.validator;

public class AmountValidator implements Validator<String> {

    @Override
    public void validate(String value) {
        int number = isNumber(value);
        if (isNotPositiveNumber(number)) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력 가능합니다.");
        }
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위로 입력 가능합니다.");
        }
    }

    private int isNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
        }
    }

    private boolean isNotPositiveNumber(int number) {
        return number <= 0;
    }
}
