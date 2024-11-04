package lotto.dto.request;

public record PurchaseAmountDTO(
        Integer purchaseAmount
) {
    public static PurchaseAmountDTO of(Integer purchaseAmount) {
        return new PurchaseAmountDTO(purchaseAmount);
    }
}
