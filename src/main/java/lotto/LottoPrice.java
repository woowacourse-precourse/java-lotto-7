package lotto;

public enum LottoPrice {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000)
    ;

    private final int match;
    private final int price;


    LottoPrice(int match, int price) {
        this.match = match;
        this.price = price;
    }

    public int getMatch() {
        return match;
    }

    public int getPrice() {
        return price;
    }
}
