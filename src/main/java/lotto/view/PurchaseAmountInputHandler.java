package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseAmountInputHandler {

    public static String promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

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
}
