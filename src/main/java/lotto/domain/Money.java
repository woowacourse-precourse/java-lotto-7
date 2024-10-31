package lotto.domain;

import static lotto.utils.ErrorMessage.INVALID_MONEY_INPUT;

import java.util.Objects;

public class Money {
    private final Long amount;
    private long lottoCount;

    protected Money(String input) {
        Long parsedMoney = parseMoney(input);
        this.amount = validateMoney(parsedMoney);
        this.lottoCount = calculateLottoCount(parsedMoney);
    }

    public static Money create(String input) {
        return new Money(input);
    }

    private Long parseMoney(String money) {
        if (money == null || money.isBlank()) {
            throw new IllegalArgumentException(INVALID_MONEY_INPUT.getMessage());
        }

        try {
            return Long.valueOf(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY_INPUT.getMessage());
        }
    }

    private Long validateMoney(Long amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_INPUT.getMessage());
        }

        return amount;
    }

    private Long calculateLottoCount(Long money) {
        return money / 1000;
    }

    public boolean lottoTry() {
        if (lottoCount <= 0) {
            return false;
        }
        lottoCount--;
        return true;
    }

    @Override
    public String toString() {
        return amount.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return lottoCount == money.lottoCount && Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, lottoCount);
    }
}
