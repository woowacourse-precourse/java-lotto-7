package lotto.constant;

public enum LottoResult {
    ALL(2000000000),
    FIVE_AND_BONUS(30000000),
    FIVE(1500000),
    FOUR(50000),
    THREE(5000),
    NONE(0);

    private Integer price;

    LottoResult(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
