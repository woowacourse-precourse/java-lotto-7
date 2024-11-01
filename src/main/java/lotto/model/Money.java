package lotto.model;

public class Money {
    private static final int UNIT_AMOUNT = 1000;
    private final int amount;

    public Money(final String money) {
        int amount = convertToInt(money);
        validateAmount(amount);
        this.amount = amount;
    }

    private int convertToInt(final String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private void validateAmount(final int amount) {
        if (amount < UNIT_AMOUNT || amount % UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원 단위로 투입되어야 합니다.");
        }
    }

    public int calculateLottoCount() {
        return amount / UNIT_AMOUNT;
    }

    public int getAmount() {
        return amount;
    }
}
