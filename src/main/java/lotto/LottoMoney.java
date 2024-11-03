package lotto;

public record LottoMoney(int amount) {
    public LottoMoney {
        validate(amount);
    }

    private void validate(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.format());
        }
    }
}
