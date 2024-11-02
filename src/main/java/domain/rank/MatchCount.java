package domain.rank;

import domain.error.ErrorMessage;

public enum MatchCount {
    THREE_MATCH(3, "3개 일치 (5,000원)", 5000L),
    FOUR_MATCH(4, "4개 일치 (50,000원)", 50000L),
    FIVE_MATCH(5, "5개 일치 (1,500,000원)", 1500000L),
    BONUS_FIVE_MATCH(7, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000L),
    SIX_MATCH(6, "6개 일치 (2,000,000,000원)", 2000000000L);

    private final int matchCount;
    private final String outputMessage;
    private final Long priceMoney;

    private MatchCount(int matchCount, String outputMessage, Long priceMoney) {
        this.matchCount = matchCount;
        this.outputMessage = outputMessage;
        this.priceMoney = priceMoney;
    }

    private int getMatchCount() {
        return matchCount;
    }

    public static MatchCount from(int count) {
        for (MatchCount matchCount : MatchCount.values()) {
            if (matchCount.getMatchCount() == count) {
                return matchCount;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.UNKNOWN_ERROR.getErrorMessage());
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
