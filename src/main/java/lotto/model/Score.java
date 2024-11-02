package lotto.model;

public enum Score {
    FIFTHPLACE(3, 5000),
    FOURTHPLACE(4, 50000),
    THIRDPLACE(5, 1500000),
    SECONDPLACE(5, 30000000),
    FIRSTPLACE(6, 2000000000),
    ZERO(0, 0);
    private final int matchCount;
    private final int money;

    Score(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getMatchCount() {
        return matchCount;
    }
    public static Score getScore(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) {
            return FIRSTPLACE;
        }
        if (matchCount == 5 && bonusMatched) {
            return SECONDPLACE;
        }
        if (matchCount == 5) {
            return THIRDPLACE;
        }
        if (matchCount == 4) {
            return FOURTHPLACE;
        }
        if (matchCount == 3) {
            return FIFTHPLACE;
        }
        return ZERO;
    }
}
