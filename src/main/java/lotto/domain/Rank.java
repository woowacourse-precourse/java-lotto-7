package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000, "%d개 일치 (%s원) - %d개"),
    SECOND(5, 30_000_000, "%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    THIRD(5, 1_500_000, "%d개 일치 (%s원) - %d개"),
    FOURTH(4, 50_000, "%d개 일치 (%s원) - %d개"),
    FIFTH(3, 5_000, "%d개 일치 (%s원) - %d개"),
    NONE(0, 0, "");

    private final int matchCount;
    private final int winningAmount;
    private final String messageFormat;

    Rank(int matchCount, int winningAmount, String messageFormat) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.messageFormat = messageFormat;
    }

    public static Rank getRank(int matchCount, boolean hasBonus) {
        if (matchCount == 5 && hasBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return NONE;
    }

    public int getWinnings() {
        return winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getFormattedMessage(long count, String formattedWinningAmount) {
        return String.format(messageFormat, matchCount, formattedWinningAmount, count);
    }
}