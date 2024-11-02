package lotto.domain;

import lotto.exception.ExceptionMessage;
import lotto.exception.LottoException;
import lotto.utils.LottoUtils;

public class LottoPurchase {

    private static final int LOTTO_PRICE = 1_000;
    private static final int MAXIMUM_PURCHASABLE_PRICE = 100_000;

    private int purchase;
    private int amount;

    public LottoPurchase(int purchase) {
        this.purchase = purchase;
        this.amount = purchase / LOTTO_PRICE;
    }

    public int getPurchase() {
        return purchase;
    }

    public int getAmount() {
        return amount;
    }

    public void setPurchase(int purchase) {
        this.purchase = purchase;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static LottoPurchase to(String request) {
        int purchase = LottoUtils.parseInt(request);
        validation(purchase);

        return new LottoPurchase(purchase);
    }

    private static void validation(int input) {
        LottoException.throwIllegalArgumentException(
            ExceptionMessage.NOT_GREATER_THEN_MAX_PRICE, isGreaterThenMaxPrice(input)
        );

        LottoException.throwIllegalArgumentException(ExceptionMessage.NOT_RIGHT_PRICE,
            !isDivisibleByLottoPrice(input) || isLessThenMinPrice(input)
        );
    }

    private static boolean isDivisibleByLottoPrice(int num) {
        return num % LOTTO_PRICE == 0;
    }

    private static boolean isGreaterThenMaxPrice(int num) {
        return num > MAXIMUM_PURCHASABLE_PRICE;
    }

    private static boolean isLessThenMinPrice(int num) {
        return num < LOTTO_PRICE;
    }
}
