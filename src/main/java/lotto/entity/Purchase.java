package lotto.entity;

import lotto.configuration.LottoConfiguration;

public class Purchase {
    private final int amount;

    public Purchase(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int calculateTicketCount() {
        return amount / LottoConfiguration.LOTTO_PRICE.getValue();
    }


    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        if (amount < LottoConfiguration.LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException("로또 가격보다 적은 금액입니다.");
        }
        if (amount % LottoConfiguration.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("로또 가격은 1000원 단위로만 가능합니다.");
        }
        if (amount > LottoConfiguration.PURCHASE_LIMIT.getValue()) {
            throw new IllegalArgumentException("로또는 한번에 10만원 까지 구입 가능합니다.");
        }
    }

}
