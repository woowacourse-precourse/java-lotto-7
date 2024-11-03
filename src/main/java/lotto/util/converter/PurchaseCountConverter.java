package lotto.util.converter;

import lotto.exception.custom.NotDivisibleByThousandException;

import static lotto.common.Lotto.LOTTO_PRICE;
import static lotto.common.Number.ZERO;

public class PurchaseCountConverter {

    public static int convert(String inputPurchaseAmount) {
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        if (!isDivisibleByThousand(purchaseAmount)) {
            throw new NotDivisibleByThousandException();
        }
        return purchaseAmount / LOTTO_PRICE;
    }

    private static boolean isDivisibleByThousand(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE == ZERO;
    }
}
