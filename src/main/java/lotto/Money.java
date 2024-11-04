package lotto;

public class Money {
    private final int amount;

    public Money(String amount) {
        this.amount = parseAmount(amount);
    }

    public int getAmount() {
        return amount;
    }

    private int parseAmount(String amountRaw) {
        int amount;

        if (amountRaw == null || amountRaw.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 비거나 null이 될 수 없습니다.");
        }
        try {
            amount = Integer.parseInt(amountRaw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양의 정수여야 합니다.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양의 정수여야 합니다.");
        }

        return amount;
    }
}
