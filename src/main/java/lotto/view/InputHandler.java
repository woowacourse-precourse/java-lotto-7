package lotto.view;

import java.util.List;

public class InputHandler {

    public static void validatePurchaseAmount(String input) {
        int purchaseAmount = validatePurchaseAmountIsInteger(input);
        validatePurchaseAmountIsThousandUnit(purchaseAmount);
    }

    public static int validatePurchaseAmountIsInteger(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수여야 합니다.");
        }
    }

    public static void validatePurchaseAmountIsThousandUnit(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        for (Integer num : winningNumbers) {
            if (num < 1 || 45 < num) {
                throw new IllegalArgumentException("[ERROR] 당청 번호는 1에서 45 사이의 정수 값이어야 합니다.");
            }
        }
    }
}
