package lotto;

import static lotto.Exception.DONT_NOT_ZERO;
import static lotto.Exception.IS_NOT_1000_UNIT;

import camp.nextstep.edu.missionutils.Console;

public class Consumer {
    public static String input() {
        return Console.readLine();
    }

    public static int enterPurchaseAmount() {
        int purchaseAmount = Integer.parseInt(Console.readLine());
        isNotZero(purchaseAmount);
        validRange(purchaseAmount);
        return purchaseAmount;
    }

    public static void validRange(int purchaseAmount) {
        if (purchaseAmount / 1000 < 1 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(IS_NOT_1000_UNIT);
        }
    }

    public static void isNotZero(int purchaseAmount) {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(DONT_NOT_ZERO);
        }
    }
}
