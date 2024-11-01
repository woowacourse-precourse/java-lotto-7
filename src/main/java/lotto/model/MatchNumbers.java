package lotto.model;

import java.util.List;
import lotto.model.constant.Match;

public class MatchNumbers {
    private int threeMatch;
    private int fourMatch;
    private int fiveMatch;
    private int fiveAndBonusMatch;
    private int sixMatch;

    public MatchNumbers() {
        threeMatch = 0;
        fourMatch = 0;
        fiveMatch = 0;
        fiveAndBonusMatch = 0;
        sixMatch = 0;
    }

    public void calculate(final List<List<Integer>> lottoNumbers, final List<Integer> userNumbers, final int bonusNumber) {
        for (List<Integer> number : lottoNumbers) {
            updateMatchCounts(getMatchCount(number, userNumbers), number.contains(bonusNumber));
        }
    }

    private int getMatchCount(final List<Integer> number, final List<Integer> userNumbers) {
        return (int) userNumbers.stream()
                .filter(number::contains)
                .count();
    }

    private void updateMatchCounts(final int matchCount, final boolean bonusMatch) {
        if (matchCount == Match.THREE.getMatchCount()) threeMatch++;
        if (matchCount == Match.FOUR.getMatchCount()) fourMatch++;
        if (matchCount == Match.FIVE.getMatchCount() && !(bonusMatch)) fiveMatch++;
        if (matchCount == Match.BONUS.getMatchCount() && bonusMatch) fiveAndBonusMatch++;
        if (matchCount == Match.SIX.getMatchCount()) sixMatch++;
    }

    public int getThreeMatch() {
        return threeMatch;
    }

    public int getFourMatch() {
        return fourMatch;
    }

    public int getFiveMatch() {
        return fiveMatch;
    }

    public int getFiveAndBonusMatch() {
        return fiveAndBonusMatch;
    }

    public int getSixMatch() {
        return sixMatch;
    }
}
