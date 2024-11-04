package lotto.domain;

public class Prize {
    public final int PRIZE_3 = 5000;
    public final int PRIZE_4 = 50000;
    public final int PRIZE_5 = 1500000;
    public final int PRIZE_5_BONUS = 30000000;
    public final int PRIZE_6 = 2000000000;

    public int getPrize(Match match) {
        if (match == Match.MATCH_3) {
            return PRIZE_3;
        }
        if (match == Match.MATCH_4) {
            return PRIZE_4;
        }
        if (match == Match.MATCH_5) {
            return PRIZE_5;
        }
        if (match == Match.MATCH_5_WITH_BONUS) {
            return PRIZE_5_BONUS;
        }
        if (match == Match.MATCH_6) {
            return PRIZE_6;
        }
        return 0;
    }
}
