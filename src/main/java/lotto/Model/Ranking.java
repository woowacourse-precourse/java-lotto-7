package lotto.Model;

public enum Ranking {

    MISS(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", true),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int matchingCount;
    private final int winningPrize;
    private final String message;
    private final boolean requiresBonus;

    private static final int WINNING_MIN_COUNT = 3;

    Ranking(int matchingCount, int winningPrize, String message) {
        this(matchingCount, winningPrize, message, false);
    }

    Ranking(int matchingCount, int winningPrize, String message, boolean requiresBonus) {
        this.matchingCount = matchingCount;
        this.winningPrize = winningPrize;
        this.message = message;
        this.requiresBonus = requiresBonus;
    }
    //로또에서 당첨숫자 일치개수와 보너스 일치를 받아서 Rank를 정하는 로직
    public static Ranking valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return MISS;
        }
        for (Ranking rank : values()) {
            if (rank.isMatchingRank(countOfMatch, matchBonus)) {
                return rank;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 매칭 수 또는 보너스 조건입니다.");
    }

    private boolean isMatchingRank(int countOfMatch, boolean matchBonus) {
        return this.matchingCount == countOfMatch && (!this.requiresBonus || matchBonus == this.requiresBonus);
    }

    public String getMessage() {
        return message;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}
