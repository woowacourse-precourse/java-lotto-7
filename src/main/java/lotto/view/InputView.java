package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public long readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String userPurchaseAmount = Console.readLine();
        checkUserInputIsNull(userPurchaseAmount);

        return checkPurchaseAmountIsNum(userPurchaseAmount);
    }

    private void checkUserInputIsNull(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백입니다.");
        }
    }

    private long checkPurchaseAmountIsNum(String purchaseAmount) {
        try {
            return Long.parseLong(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
