package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseAmountInputHandler {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static int promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return validatePurchaseAmount(input);
    }

    public static int validatePurchaseAmount(String input) {
        int purchaseAmount = validatePurchaseAmountIsInteger(input);
        validatePurchaseAmountIsThousandUnit(purchaseAmount);
        return purchaseAmount;
    }

    public static int validatePurchaseAmountIsInteger(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입 금액은 정수여야 합니다.");
        }
    }

    public static void validatePurchaseAmountIsThousandUnit(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
