package lotto.domain;

public class Money {
    private static final int ONE_THOUSAND = 1000;
    private final int money;

    public Money(final int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int value) {
        validateAboveMinimum(value);
        validateAmountInThousands(value);
    }

    private void validateAboveMinimum(int value) {
        if (value < ONE_THOUSAND) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력해야합니다.");
        }
    }

    private void validateAmountInThousands(int value) {
        if (value % ONE_THOUSAND != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원으로 나누어 떨어져야합니다.");
        }
    }

    public int calculateLottoTickets() {
        return money / ONE_THOUSAND;
    }
    public int getMoney() {
        return money;
    }
}
