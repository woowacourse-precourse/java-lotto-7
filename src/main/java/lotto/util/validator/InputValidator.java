package lotto.util.validator;

public class InputValidator {

    private final static String MONEY_REGEX = "[1-9][0-9]*000";

    public static void validateMoney(String money) {
        checkNull(money);
        checkMoneyForm(money);
    }

    private static void checkNull(String money) {
        if (money == null || money.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요");
        }
    }

    private static void checkMoneyForm(String money) {
        if (!money.matches(MONEY_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000의 배수인 양수를 입력해야 합니다");
        }
    }
}
