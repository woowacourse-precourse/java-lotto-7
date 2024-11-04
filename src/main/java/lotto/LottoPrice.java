package lotto;

public enum LottoData {
    START_NUM(1),
    END_NUM(45),
    BALLS(6),
    FIRST_PRICE(6, 2000000000),
    SECOND_PRICE(7, 30000000),
    THIRD_PRICE(5, 1500000),
    FOURTH_PRICE(4, 50000),
    FIFTH_PRICE(3, 5000),
    LOTTO_PRICE(1000)
    ;

    private final int num;
    private final int match;
    private final int price;

    LottoData(int range) {
        this.num = range;
    }

    LottoData(int match, int price) {
        this.match = match;
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public int getMatch() {
        return match;
    }

    public int getPrice() {
        return price;
    }
}
