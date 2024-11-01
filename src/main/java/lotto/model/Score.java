package lotto.model;

public enum Score {

    ZERO(0),
    THREE(5_000),
    FOURTH(50_000),
    FIFTH(1_500_000),
    FIFTH_WITH_BONUS(30000_000),
    SIX(2_000_000_000);

    private final int prize;

    Score(int prize) {
        this.prize = prize;
    }

    public static Score calculateScore(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = winningLotto.getMatchCount(lotto);
        boolean isBonusNumberMatches = winningLotto.isBonusNumberMatches(lotto);

        return switch (matchCount) {
            case 6 -> SIX;
            case 5 -> isBonusNumberMatches ? FIFTH_WITH_BONUS : FIFTH;
            case 4 -> FOURTH;
            case 3 -> THREE;
            default -> ZERO;
        };
    }

    public int getPrize() {
        return prize;
    }
}
