package lotto.custom.model;

public enum LottoPrize {
    THREE_MATCH("3개 일치", 5000),
    FOUR_MATCH("4개 일치", 50000),
    FIVE_MATCH("5개 일치", 1500000),
    FIVE_MATCH_BONUS("5개 일치, 보너스 볼 일치", 30000000),
    SIX_MATCH("6개 일치", 2000000000);

    private final String description;
    private final int prizeMoney;

    LottoPrize(String description, int prizeMoney) {
        this.description = description;
        this.prizeMoney = prizeMoney;
    }

    public String getPrizeDescription() {
        return description;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
