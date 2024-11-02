package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView
{
    public static int LottoPurchaseAmount() {
        try {
            System.out.println("구입 금액을 입력해 주세요.");
            int amount = Integer.parseInt(Console.readLine());
            validatePurchaseLotto(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            // 다시 입력 받는다.
            return LottoPurchaseAmount();
        }
    }

    private static void validatePurchaseLotto(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해주세요.");
        }
    }
}
