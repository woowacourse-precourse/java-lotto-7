package lotto;

public enum LottoData {
    START_NUM(1),
    END_NUM(45),
    BALLS(6),
    FIRST_PRICE(2000000000),
    SECOND_PRICE(30000000),
    THIRD_PRICE(1500000),
    FOURTH_PRICE(50000),
    FIFTH_PRICE(5000),
    LOTTO_PRICE(1000)
    ;

    private final int num;
    LottoData(int range) {
        this.num = range;
    }

    public int getNum() {
        return num;
    }
}
