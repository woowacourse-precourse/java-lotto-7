package lotto.domain;

import lotto.exception.LottoException;
import lotto.utils.LottoUtils;

import static lotto.exception.ExceptionMessage.*;

public class LottoPurchase {

    private static final int LOTTO_PRICE = 1_000;
    private static final int MAXIMUM_PURCHASABLE_PRICE = 100_000;

    private int purchase;
    private int amount;

    public LottoPurchase(int purchase) {
        validate(purchase);

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

    private static void validate(int input) {
        LottoException.throwIllegalArgumentException(
            NOT_GREATER_THEN_MAX_PRICE, isGreaterThenMaxPrice(input)
        );

        LottoException.throwIllegalArgumentException(NOT_RIGHT_PRICE,
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
