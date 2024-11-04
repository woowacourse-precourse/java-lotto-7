package lotto.domain;

import lotto.constant.NumberType;
import lotto.utils.Parser;

import static lotto.constant.ErrorMessage.PURCHASE_PRICE_ERROR;

public class Money {
    private Integer amount;

    public Money(String inputAmount) {
        Integer amount = parseNumber(inputAmount);
        validMoney(amount);
        this.amount = amount;
    }

    public void minus(Money money) {
        this.amount -= money.amount;
    }

    public Integer getAmount() {
        return amount;
    }

    private Integer parseNumber(String number) {
        return Parser.parse(number);
    }

    private void validMoney(Integer amount) {
        if (!isFitPurchasePrice(amount)) {
            throw new IllegalArgumentException(PURCHASE_PRICE_ERROR.getMessage());
        }
    }

    private boolean isFitPurchasePrice(Integer amount) {
        return amount % NumberType.LOTTO_PRICE.getPrice() == 0;
    }
}
