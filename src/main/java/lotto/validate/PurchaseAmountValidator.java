package lotto.validate;

public class PurchaseAmountValidator {

    private static final int PURCHASE_UNIT_WON = 1000;

    public static int getValidatedPurchaseAmount(String purchaseAmount) throws IllegalArgumentException {
        validateInputType(purchaseAmount);
        int purchaseAmountToInt = Integer.parseInt(purchaseAmount);
        validateInputUnit(purchaseAmountToInt);
        return purchaseAmountToInt;
    }

    private static void validateInputUnit(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount % PURCHASE_UNIT_WON != 0 || purchaseAmount < PURCHASE_UNIT_WON) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_UNIT.getMessage());
        }
    }

    private static void validateInputType(String purchaseAmount) throws IllegalArgumentException {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_TYPE.getMessage());
        }
    }
}
