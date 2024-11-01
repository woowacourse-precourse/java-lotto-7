package lotto.util;

public enum PrizeType {
    MATCHING_3("3개 일치 ", "(5,000원)", 5000),
    MATCHING_4("4개 일치 ", "(50,000원)", 50000),
    MATCHING_5("5개 일치 ", "(1,500,000원)", 1500000),
    HAS_BONUS_WIN_MATCHING_5("5개 일치, 보너스 볼 일치 ", "(30,000,000원)", 30000000),
    MATCHING_6("6개 일치 ", "(2,000,000,000원)", 2000000000);

    private final String match;
    private final String prize;
    private final int prizeMoney;

    PrizeType(String match, String prize, int prizeMoney) {
        this.match = match;
        this.prize = prize;
        this.prizeMoney = prizeMoney;
    }

    public String getMatching() {
        return match;
    }

    public String getPrize() {
        return prize;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}