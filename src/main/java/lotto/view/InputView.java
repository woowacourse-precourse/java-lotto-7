package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public int readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String amount = Console.readLine();

        validateNotNullOrBlank(amount);
        validateIsNumeric(amount);

        return Integer.parseInt(amount);
    }

    private void validateNotNullOrBlank(String amount) {
        if (amount == null || amount.isBlank())
            throw new IllegalArgumentException();
    }

    private void validateIsNumeric(String amount) {
        if (!amount.chars().allMatch(Character::isDigit))
            throw new IllegalArgumentException();
    }
}
