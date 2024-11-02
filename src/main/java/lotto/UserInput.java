package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

public class UserInput {

    private int numberOfLotto;

    public int purchaseAmountInput() {

        System.out.println("구입 금액을 입력해주세요.");

        String amount = readLine();

        validPurchaseAmountInput(amount);

        return Integer.parseInt(amount);
    }

    private void validPurchaseAmountInput(String input) {

        int amount;

        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 0 이상이어야 합니다.");
        }

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }
}
