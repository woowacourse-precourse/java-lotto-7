package lotto;

import static java.lang.Integer.parseInt;

public enum LottoPrize {
    FIFTH("5,000", "3개 일치"),
    FOURTH("50,000", "4개 일치"),
    THIRD("1,500,000", "5개 일치"),
    SECOND("30,000,000", "5개 일치, 보너스 볼 일치"),
    FIRST("2,000,000,000", "6개 일치");

    private final String price;
    private final String condition;

    LottoPrize(String price, String condition) {
        this.price = price;
        this.condition = condition;
    }

    public String getStringPrize() {
        return price;
    }

    public int getIntPrize() {
        return parseInt(price.replaceAll(",", ""));
    }

    public String getCondition() {
        return condition;
    }
}
