package lotto.domain;

public record LottoQuantity(
        int value
) {

    public static LottoQuantity findQuantity(PurchasePrice purchasePrice) {
        int quantity = purchasePrice.value() / 1000;
        return new LottoQuantity(quantity);
    }
}
