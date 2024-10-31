package lotto.model;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Money(String input) {
        validateInput(input);
        this.amount = Integer.parseInt(input);
        validateAmount();
    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("구입 금액을 입력해 주세요.");
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 숫자여야 합니다.");
        }
    }

    private void validateAmount() {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 " + LOTTO_PRICE + "원 이상이어야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 " + LOTTO_PRICE + "원 단위여야 합니다.");
        }
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
