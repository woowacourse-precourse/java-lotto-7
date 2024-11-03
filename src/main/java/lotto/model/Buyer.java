package lotto.model;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Buyer {

    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private final int numberOfLottos;

    private Buyer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.numberOfLottos = calculateNumberOfLottos(purchaseAmount);
    }

    public static Buyer from(String rawAmount) {
        NumberStringConverter numberStringConverter = new NumberStringConverter();

        int purchaseAmount = numberStringConverter.convert(rawAmount);

        validatePurchaseAmount(purchaseAmount);

        return new Buyer(purchaseAmount);
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw LottoException.from(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_AT_LEAST_1000);
        }

        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw LottoException.from(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000);
        }
    }

    private int calculateNumberOfLottos(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public int getNumberOfLottos() {
        return numberOfLottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
