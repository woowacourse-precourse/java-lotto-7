package lotto.model;

public enum Ranking {
    
    FIFTH_PLACE(3, false, 5000),
    FOURTH_PLACE(4, false, 50000),
    THIRD_PLACE(5, false, 1500000),
    SECOND_PLACE(5, true, 30000000),
    FIRST_PLACE(6, false, 2000000000),
    LOSE(0,false,0);
    
    public final int numberOfHits;
    public final boolean bonusNumberHit;
    public final int award;
    
    private Ranking(int numberOfHits, boolean bonusNumberHit, int award) {
        this.numberOfHits = numberOfHits;
        this.bonusNumberHit = bonusNumberHit;
        this.award = award;
    }
    
    public static Ranking calculate(DrawnLotto drawnLotto, Lotto lotto) {
        int numberOfHits = drawnLotto.countHits(lotto);
        boolean bonusNumberHit = drawnLotto.isBonusNumberHit(lotto);
        
        for (Ranking ranking : Ranking.values()) {
            if (ranking.numberOfHits == numberOfHits && ranking.bonusNumberHit == bonusNumberHit) {
                return ranking;
            }
        }
        return LOSE;
    }
}
