package lotto.domain;

public record LottoQuantity(
        int value
) {

    public static LottoQuantity findQuantity(int purchasePrice) {
        int quantity = purchasePrice / 1000;
        return new LottoQuantity(quantity);
    }
}
