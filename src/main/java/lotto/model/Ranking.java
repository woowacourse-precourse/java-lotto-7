package lotto.model;

public enum Ranking {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchNumber;
    private final boolean isBonusMatched;
    private final int prize;
    private int count = 0; // 당첨 횟수 저장 필드

    Ranking(int matchNumber, boolean isBonusMatched, int prize) {
        this.matchNumber = matchNumber;
        this.isBonusMatched = isBonusMatched;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }

    public static Ranking findByMatchCountAndBonus(int matchCount, boolean isBonusMatched) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.matchNumber == matchCount && ranking.isBonusMatched == isBonusMatched) {
                return ranking;
            }
        }
        return NONE;
    }

    public static double calculateTotalPrizeMoney() {
        int totalPrizeMoney = 0;
        for (Ranking ranking : Ranking.values()) {
            totalPrizeMoney += ranking.getPrize() * ranking.getCount();
        }
        return totalPrizeMoney;
    }

    public static double calculateYield(int amount) {
        return calculateTotalPrizeMoney() / (double) amount * 100;
    }
}
