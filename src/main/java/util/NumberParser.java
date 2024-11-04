package util;

public final class NumberParser {
    private NumberParser() {
    }

    public static int parsePurchaseAmountToInt(final String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }
}
