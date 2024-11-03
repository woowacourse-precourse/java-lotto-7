package exception;

public class BonusNumber {
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

    public BonusNumber(String input) {
        emptyValidate(input);
        numberValidate(input);
        rangeValidate(input);
    }

    private void emptyValidate(String amount) {
        if (amount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 비어있습니다.");
        }
    }

    private void numberValidate(String amount) {
        if (!amount.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void rangeValidate(String amount) {
        if (Integer.parseInt(amount) < MIN_BONUS_NUMBER || Integer.parseInt(amount) > MAX_BONUS_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력 가능합니다.");
        }
    }
}
