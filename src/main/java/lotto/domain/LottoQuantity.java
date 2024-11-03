package lotto.domain;

public record LottoQuantity(
        int value
) {

    public static LottoQuantity findQuantity(int purchasePrice) {
        int quantity = purchasePrice / PurchasePrice.DIVIDE_UNIT;
        return new LottoQuantity(quantity);
    }
}
