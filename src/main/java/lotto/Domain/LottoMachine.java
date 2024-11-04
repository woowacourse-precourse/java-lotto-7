package lotto.Domain;

import lotto.Messages.ErrorMessage;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_STOCK = 100000;

    private LottoMachine() {
    }

    public static LottoMachine create() {
        return new LottoMachine();
    }

    private static void validateAmount(PurchaseAmount purchaseAmount) {
        int amount = purchaseAmount.getValue();
        checkMinimum(amount);
        checkDivisible(amount);
        checkLimit(amount);
    }

    private static void checkMinimum(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void checkDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void checkLimit(int amount) {
        if (amount / LOTTO_PRICE > MAX_STOCK) {
            throw new IllegalArgumentException(ErrorMessage.MAX_OUT_PURCHASE_AMOUNT.getMessage());
        }
    }

    private int calculateMaxLottos(PurchaseAmount amount) {
        return amount.getValue() / LOTTO_PRICE;
    }

    private Lottos generateLottos(int quantity) {
        return Lottos.from(quantity);
    }

    public Lottos buyLottos(PurchaseAmount amount) {
        validateAmount(amount);

        int quantity = calculateMaxLottos(amount);

        return generateLottos(quantity);
    }

}
