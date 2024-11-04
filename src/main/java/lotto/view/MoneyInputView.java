package lotto.view;

import lotto.util.Validator;

public class MoneyInputView extends InputView {

    private static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";

    public static int inputMoney() {
        while (true) {
            try {
                System.out.println(REQUEST_INPUT_MONEY);
                String input = inputValue();

                validateBefore(input);
                int money = Integer.parseInt(input);
                validateAfter(money);

                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateBefore(String input) {
        Validator.validateIsNumeric(input);
    }

    private static void validateAfter(int input) {
        Validator.validateIsDivisible(input);
        Validator.validateBelowMinimum(input);
    }
}
