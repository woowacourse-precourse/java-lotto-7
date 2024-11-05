package lotto.constants;

public enum PrizeType {
    PLACE_OF_5ST("3개 일치 ", "(5,000원)", 5000),
    PLACE_OF_4ST("4개 일치 ", "(50,000원)", 50000),
    PLACE_OF_3ST("5개 일치 ", "(1,500,000원)", 1500000),
    PLACE_OF_2ST("5개 일치, 보너스 볼 일치 ", "(30,000,000원)", 30000000),
    PLACE_OF_1ST("6개 일치 ", "(2,000,000,000원)", 2000000000);

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