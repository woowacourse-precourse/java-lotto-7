package lotto.domain;

public enum LottoRank {

    NO_RANK_0(0, false,0L, "0"),
    NO_RANK_1(1, false,0L, "0"),
    NO_RANK_2(2, false,0L, "0"),
    FAVE_RANK(3, false,5000L, "5,000"),
    FOURTH_RANK(4, false, 50000L, "50,000"),
    THIRD_RANK(5, false, 1500000L, "1,500,000"),
    SECOND_RANK(5, true, 30000000L, "30,000,000"),
    FIRST_RANK(6, false, 20000000000L, "2,000,000,000");

    private int count;
    private boolean bonus;
    private long price;
    private String stringPrice;

    LottoRank(int count, boolean bonus, long price, String stringPrice) {
        this.count = count;
        this.bonus = bonus;
        this.price = price;
        this.stringPrice = stringPrice;
    }

    public int getCount() {
        return count;
    }

    public boolean getBonus() {
        return bonus;
    }

    public long getPrice() {
        return price;
    }

    public String getStringPrice() {
        return stringPrice;
    }
}
