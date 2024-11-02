package lotto.lotto;

public class LottoAmount {

    private final int amount;

    public LottoAmount(int amount) {
        validatePositiveAmount(amount);
        this.amount = amount;
    }

    private void validatePositiveAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 음수가 될 수 없습니다.");
        }
    }
}
