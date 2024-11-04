package lotto.domain;

import lotto.message.ExceptionMessage;

public class Money {
    private final int amount;

    public Money(int amount){
        validateMoneyUnit(amount);
        this.amount = amount;
    }

    public int getPurchasableLottoCount(){
        return amount / LottoOption.PUCHASE_MONEY_UNIT;
    }

    private void validateMoneyUnit(int amount) {
        if (amount % LottoOption.PUCHASE_MONEY_UNIT != 0){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MONEY_UNIT);
        }
    }

}
