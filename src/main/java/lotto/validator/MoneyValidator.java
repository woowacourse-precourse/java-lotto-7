package lotto.validator;

public class MoneyValidator {
    public void validateNumeric(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자여야 합니다");
        }
    }
}
