package lotto.model;

public enum Ranking {

    FIFTH_PLACE(3, false, 5000),
    FOURTH_PLACE(4, false, 50000),
    THIRD_PLACE(5, false, 1500000),
    SECOND_PLACE(5, true, 30000000),
    FIRST_PLACE(6, false, 2000000000), 
    LOSE(0, false, 0);

    public final int numberOfHits;
    public final boolean requiresBonus;
    public final int award;

    private Ranking(int numberOfHits, boolean requiresBonus, int award) {
        this.numberOfHits = numberOfHits;
        this.requiresBonus = requiresBonus;
        this.award = award;
    }

    public static Ranking calculate(DrawnLotto drawnLotto, Lotto lotto) {
        int numberOfHits = drawnLotto.countHits(lotto);
        boolean bonusNumberHit = drawnLotto.isBonusNumberHit(lotto);

        Ranking[] rankings = Ranking.values();
        for (int i = rankings.length - 1; i >= 0; i--) {
            Ranking ranking = rankings[i];
            if (isMatchingRanking(ranking, numberOfHits, bonusNumberHit)) {
                return ranking;
            }
        }
        return LOSE;
    }

    private static boolean isMatchingRanking(Ranking ranking, int numberOfHits, boolean bonusNumberHit) {
        if (ranking.numberOfHits != numberOfHits) {
            return false;
        }
        if (ranking.requiresBonus) {
            return bonusNumberHit;
        }
        return true;
    }
}
