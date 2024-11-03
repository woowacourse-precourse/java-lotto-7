package lotto.score;

public enum Prize {
    FIFTH_PRIZE(3, "3개 일치 (5,000원)", 5000),
    FOURTH_PRIZE(4, "4개 일치 (50,000원)", 50000),
    THIRD_PRIZE(5, "5개 일치 (1,500,000원)", 1500000),
    SECOND_PRIZE(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    FIRST_PRIZE(6, "6개 일치 (2,000,000,000원)", 2000000000),
    NO_PRIZE(0, "당첨 안됨 (0원)", 0);

    private final int numberOfMatches;
    private final String winningMessage;
    private final int prizeMoney;

    Prize(int numberOfMatches, String winningMessage, int prizeMoney) {
        this.numberOfMatches = numberOfMatches;
        this.winningMessage = winningMessage;
        this.prizeMoney = prizeMoney;
    }

    public boolean matches(int numberOfMatches, boolean bonusNumberMatch) {
        if (this == THIRD_PRIZE) {
            return numberOfMatches == 5 && !bonusNumberMatch;
        }
        if (this == NO_PRIZE) {
            return numberOfMatches < 3;
        }
        return this.numberOfMatches == numberOfMatches;
    }

    public static Prize calculateScore(int numberOfMatches, boolean bonusNumberMatch) {
        for (Prize prize : values()) {
            if (prize.matches(numberOfMatches, bonusNumberMatch)) {
                return prize;
            }
        }
        return NO_PRIZE;
    }

    private String getWinningMessage() {
        return winningMessage;
    }

    public int calculatePrizeMoney(int count) {
        return prizeMoney * count;
    }

    public String formatScoreDetails(int count) {
        return String.format("%s - %d개", getWinningMessage(), count);
    }
}
