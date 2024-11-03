package lotto.domain;

public class LottoRank {
    private final String rankName;
    private final int prize;
    private final int requiredMatchCount;
    private final boolean requiresBonus;
    private int winningCount;

    public LottoRank(String rankName, int prize, int requiredMatchCount, boolean requiresBonus) {
        this.rankName = rankName;
        this.prize = prize;
        this.requiredMatchCount = requiredMatchCount    ;
        this.requiresBonus = requiresBonus;
        this.winningCount = 0;
    }

    public LottoRank(String rankName, int prize, int requiredMatchCount, boolean requiresBonus, int winningCount) {
        this.rankName = rankName;
        this.prize = prize;
        this.requiredMatchCount = requiredMatchCount    ;
        this.requiresBonus = requiresBonus;
        this.winningCount = winningCount;
    }

    public void increaseWinningCount() {
        winningCount++;
    }

    public String getRankName() {
        return rankName;
    }

    public int getPrize() {
        return prize;
    }

    public int getRequiredMatchCount() {
        return requiredMatchCount;
    }

    public boolean getRequiresBonus() {
        return requiresBonus;
    }

    public int getWinningCount() {
        return winningCount;
    }
}
