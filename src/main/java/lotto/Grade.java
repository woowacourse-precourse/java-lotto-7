package lotto;

import java.text.DecimalFormat;

public enum Grade {
    THREECOINSIDE(3, 5000L, false),
    FOURCOINSIDE(4, 50000L, false),
    FIVECOINSIDE(5, 1500000L, false),
    FIVECOINSIDE_BONUS(5, 30000000L, true),
    SIXCOINSIDE(6, 2000000000L, false);

    private int coinside;
    private Long price;
    private boolean bonus;

    private static final DecimalFormat df = new DecimalFormat("###,###");

    Grade(int coinside, Long price){
        this.coinside = coinside;
        this.price = price;
        this.bonus = false;
    }

    Grade(int coinside, Long price, boolean bonus){
        this.coinside = coinside;
        this.price = price;
        this.bonus = bonus;
    }

    public int getCoinside() {
        return coinside;
    }

    public Long getPrice() {
        return price;
    }

    public boolean isBonus() {
        return bonus;
    }

    public String bonusToString(){
        if(isBonus()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    @Override
    public String toString() {
        return getCoinside() + "개 일치" + bonusToString() + " (" + df.format(getPrice()) + "원) - ";
    }
}
