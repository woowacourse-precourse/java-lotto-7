package lotto.domain;

public record LottoQuantity(
        int value
) {

    public static LottoQuantity findQuantity(Price price) {
        int quantity = price.value() / 1000;
        return new LottoQuantity(quantity);
    }
}
