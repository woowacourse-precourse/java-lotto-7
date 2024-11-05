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
            throw new IllegalArgumentException(MessageManager.getError("error.money.invalid_money"));
        }
        try {
            amount = Integer.parseInt(amountRaw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageManager.getError("error.money.not_integer"));
        }
        if (amount <= 0) {
            throw new IllegalArgumentException(MessageManager.getError("error.money.not_positive"));
        }

        return amount;
    }
}
