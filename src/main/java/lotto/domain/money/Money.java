package lotto.domain.money;

import lotto.exception.LottoApplicationException;

public record Money(int amount) {

    public Money {
        validate(amount);
    }

    private void validate(int amount) {
        if (amount < 0) {
            throw new LottoApplicationException("금액은 0보다 작을 수 없습니다.");
        }
    }

    public boolean isEnoughToBuy(int price) {
        return amount >= price;
    }

    public Money deduct(int price) {
        if (isEnoughToBuy(price)) {
            return new Money(amount - price);
        }
        throw new IllegalArgumentException("잔액이 충분하지 않습니다.");
    }

    public boolean isEmpty() {
        return this.amount == 0;
    }

}
