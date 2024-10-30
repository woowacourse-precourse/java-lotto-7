package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

public class Money {

    private static final int INT_ZERO = 0;

    private final Integer amount;

    public Money(final Integer amount) {
        validateAmount(amount);

        this.amount = amount;
    }

    private void validateAmount(final Integer amount) {
        if (amount < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 1,000원보다 작을 수 없습니다.");
        }
        if (amount % LOTTO_PRICE.getValue() != INT_ZERO) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 1,000원 단위로 입력해주시길 바랍니다.");
        }
    }

    public Integer getLottoCount() {
        return amount / LOTTO_PRICE.getValue();
    }

    public Integer getAmount() {
        return amount;
    }
}
