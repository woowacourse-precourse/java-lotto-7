package lotto.dto;

public class PurchaseAmountDTO {
    private final int purchaseAmount;

    public PurchaseAmountDTO(String purchaseAmount) {
        this.purchaseAmount = validate(purchaseAmount);
    }

    private int validate(String purchaseAmount) {
        int rawPurchaseAmount = validateIntegerInput(purchaseAmount);
        validateNonNegativeValue(rawPurchaseAmount);
        return validateDivisibleByThousand(rawPurchaseAmount);
    }

    private int validateIntegerInput(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 정수여야 합니다");
        }
    }

    private void validateNonNegativeValue(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 양수여야 합니다");
        }
    }

    private int validateDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다");
        }
        return purchaseAmount / 1000;
    }
}
