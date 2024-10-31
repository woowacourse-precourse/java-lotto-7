package lotto;

import static java.lang.Integer.parseInt;

public enum LottoPrize {
    FIRST("2,000,000,000"),
    SECOND("30,000,000"),
    THIRD("1,500,000"),
    FOURTH("50,000"),
    FIFTH("5,000");

    private final String price;

    LottoPrize(String price) {
        this.price = price;
    }

    public String getStringPrize() {
        return price;
    }

    public int getIntPrize() {
        return parseInt(price.replaceAll(",", ""));
    }
}
