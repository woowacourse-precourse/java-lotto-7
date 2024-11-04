package lotto.domain;

public class WinningResult {
    private static final int PRIZE_MATCH_THREE = 5000;
    private static final int PRIZE_MATCH_FOUR = 50000;
    private static final int PRIZE_MATCH_FIVE = 1500000;
    private static final int PRIZE_MATCH_FIVE_AND_BONUS = 30000000;
    private static final int PRIZE_MATCH_SIX = 2000000000;

    private int matchThreeCount = 0;
    private int matchFourCount = 0;
    private int matchFiveCount = 0;
    private int matchFiveAndBonusCount = 0;
    private int matchSixCount = 0;

    public void increaseMatchThree() {
        matchThreeCount++;
    }

    public void increaseMatchFour() {
        matchFourCount++;
    }

    public void increaseMatchFive() {
        matchFiveCount++;
    }

    public void increaseMatchFiveAndBonus() {
        matchFiveAndBonusCount++;
    }

    public void increaseMatchSix() {
        matchSixCount++;
    }

    public int getMatchThreeCount() {
        return matchThreeCount;
    }

    public int getMatchFourCount() {
        return matchFourCount;
    }

    public int getMatchFiveCount() {
        return matchFiveCount;
    }

    public int getMatchFiveAndBonusCount() {
        return matchFiveAndBonusCount;
    }

    public int getMatchSixCount() {
        return matchSixCount;
    }

    public int calculateTotalPrize() {
        return (matchThreeCount * PRIZE_MATCH_THREE) +
                (matchFourCount * PRIZE_MATCH_FOUR) +
                (matchFiveCount * PRIZE_MATCH_FIVE) +
                (matchFiveAndBonusCount * PRIZE_MATCH_FIVE_AND_BONUS) +
                (matchSixCount * PRIZE_MATCH_SIX);
    }
}
