package lotto.model;

public enum Score {

    ZERO("꽝", 0),
    THREE("3개 일치", 5_000),
    FOURTH("4개 일치", 50_000),
    FIFTH("5개 일치", 1_500_000),
    FIFTH_WITH_BONUS("5개 일치, 보너스 볼 일치", 30000_000),
    SIX("6개 일치", 2_000_000_000);

    private final String message;
    private final int prize;

    Score(String name, int prize) {
        this.message = name;
        this.prize = prize;
    }

    public static Score calculateScore(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = winningLotto.getMatchCount(lotto);
        boolean isBonusNumberMatches = winningLotto.isBonusNumberMatches(lotto);

        if (matchCount < 3) {
            return ZERO;
        }
        if (matchCount == 3) {
            return THREE;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 5 && isBonusNumberMatches) {
            return FIFTH_WITH_BONUS;
        }
        if (matchCount == 5) {
            return FIFTH;
        }
        if (matchCount == 6) {
            return SIX;
        }
        return ZERO;
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }
}
