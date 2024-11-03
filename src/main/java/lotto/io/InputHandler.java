package lotto.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {

    public int getLottoPurchaseAmount() {
        String userInput = readLine();
        int purchaseAmount = parseIntPurchaseAmount(userInput);

        validatePurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    private int parseIntPurchaseAmount(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자를 입력해야 합니다.");
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위이어야 합니다.");
        }
    }
}
