package lotto;

public enum Rank {
    ZERO_MATCH("0개 일치", 0, "0"),
    ONE_MATCH("1개 일치", 0, "0"),
    TWO_MATCH("2개 일치", 0, "0"),
    THREE_MATCH("3개 일치", 5_000L, "5,000"),
    FOUR_MATCH("4개 일치", 50_000L, "50,000"),
    FIVE_MATCH("5개 일치", 1_500_000L, "1,500,000"),
    SIX_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치", 30_000_000L, "30,000,000"),
    SIX_MATCH("6개 일치", 2_000_000_000L, "2,000,000,000");

    final private String content;
    final private long prize;
    final private String convertedPrize;

    Rank(String content, long prize, String convertPrize) {
        this.content = content;
        this.prize = prize;
        this.convertedPrize = convertPrize;
    }

    public String getContent() {
        return content;
    }

    public long getPrize() {
        return prize;
    }

    public String getConvertedPrize() {
        return convertedPrize;
    }
}
