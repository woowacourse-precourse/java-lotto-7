package lotto.validator;

public class IntegerValidator {
    private static final String INVALID_MONEY = "[ERROR] 정수로만 입력할 수 있습니다.";
    private static final String INVALID_LOTTO = "[ERROR] 로또 번호는 정수여야 합니다.";

    public static int moneyValidator(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
    }

    public static int lottoValidator(String lotto) {
        try {
            return Integer.parseInt(lotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO);
        }
    }
}