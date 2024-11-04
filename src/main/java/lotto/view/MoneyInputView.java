package lotto.view;

import lotto.util.Validator;

public class MoneyInputView extends InputView {

    private static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";

    public static int inputMoney() {
        while (true) {
            try {
                System.out.println(REQUEST_INPUT_MONEY);
                String input = inputValue();

                Validator.validateIsNumeric(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
