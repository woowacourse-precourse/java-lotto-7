package lotto;

public class PurchaseAmount {
    private int amount;

    public PurchaseAmount(String input) {
        this.amount = parseAmount(input);
        validateAmount(this.amount);
    }

    private int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(lotto.ErrorMessage.INTEGER_REQUIRED.getMessage());
        }
    }

    private void validateAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(lotto.ErrorMessage.POSITIVE_AMOUNT_REQUIRED.getMessage());
        }
        if (!isThousandUnit(purchaseAmount)) {
            throw new IllegalArgumentException(
                    String.format(lotto.ErrorMessage.INVALID_AMOUNT.getMessage(), lotto.LottoRules.LOTTO_TICKET_PRICE));
        }
    }

    public boolean isThousandUnit(int purchaseAmount) {
        return amount % 1000 == 0;
    }

    public int getAmount() {
        return amount;
    }

    public int getPurchaseCount() {
        return amount / lotto.LottoRules.LOTTO_TICKET_PRICE;
    }
}
