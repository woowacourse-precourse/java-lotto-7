package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static int PURCHASE_AMOUNT_UNIT = 1000;

    public static int inputLottoPurchaseAmount() {
        String input = Console.readLine();
        validateInputIsNumber(input);

        int purchaseAmount = Integer.parseInt(input);
        validatePurchaseAmountIsDivisible(purchaseAmount, PURCHASE_AMOUNT_UNIT);
        validatePurchaseAmountIsNotZero(purchaseAmount);

        return purchaseAmount;
    }

    private static void validateInputIsNumber(String input) {
        if (!input.matches("-?[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    private static void validatePurchaseAmountIsDivisible(int purchaseAmount, int divisor) {
        if (purchaseAmount % divisor != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원으로 나누어 떨어져야 합니다.");
        };
    }

    private static void validatePurchaseAmountIsNotZero(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양수여야 합니다.");
        };
    }
}
