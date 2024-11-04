package lotto.enums;

public enum LottoPrice {
    LOTTO_PRICE_UNIT(1000),
    THREE_WINNING_PRICE(5000),
    FOUR_WINNING_PRICE(50000),
    FIVE_WINNING_PRICE(1500000),
    FIVE_WINNING_WITH_BONUS_PRICE(30000000),
    SIX_WINNING_PRICE(2000000000);

    private final int price;
    LottoPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
