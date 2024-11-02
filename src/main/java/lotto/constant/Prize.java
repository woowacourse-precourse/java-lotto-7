package lotto.constant;

public enum Prize {
    THREE(3, "5,000원"),
    FOUR(4, "50,000원"),
    FIVE(5, "1,500,000원"),
    FIVE_AND_BONUS(5, "30,000,000원"),
    SIX(6, "2,000,000,000원");

    private final Integer count;
    private final String prize;

    Prize(Integer count, String prize) {
        this.count = count;
        this.prize = prize;
    }

    public Integer getCount() {
        return count;
    }

    public String getPrize() {
        return prize;
    }
}
