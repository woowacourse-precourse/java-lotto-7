package lotto.wrapper;

public class Amount {

    private final int amount;

    private static final int MIN_LOTTO_PRICE = 1000;

    private Amount(String inputAmount) {
        int amount = validateType(inputAmount);
        validateRange(amount);
        validateDivisible(amount);
        this.amount = amount;
    }

    public static Amount of(String inputAmount) {
        return new Amount(inputAmount);
    }

    private static int validateType(String inputAmount) {
        int amount;

        try {
            amount = Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 자연수여야 합니다.");
        }

        return amount;
    }

    private void validateRange(int amount) {
        if (amount < MIN_LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    private void validateDivisible(int amount) {
        if ((amount / MIN_LOTTO_PRICE) * MIN_LOTTO_PRICE != amount) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }

}
