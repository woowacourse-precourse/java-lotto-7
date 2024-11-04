package lotto;

public class PurchaseAmount {
    private int amount;

    public PurchaseAmount(String input) {
        this.amount = parseAmount(input);
        validatePositiveAmount(this.amount);
        validateThousandUnitAmount(this.amount);
    }

    private int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_AMOUNT_REQUIRED.getMessage());
        }
    }

    private void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.POSITIVE_AMOUNT_REQUIRED.getMessage());
        }
    }

    private void validateThousandUnitAmount(int amount) {
        if (!isThousandUnit(amount)) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_AMOUNT.getMessage(), LottoRules.LOTTO_TICKET_PRICE));
        }
    }

    public boolean isThousandUnit(int purchaseAmount) {
        return purchaseAmount % 1000 == 0;
    }

    public int getAmount() {
        return amount;
    }
}
