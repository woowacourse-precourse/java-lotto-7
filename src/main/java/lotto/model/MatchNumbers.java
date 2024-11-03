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
            updateCounts(getCount(number, userNumbers), number.contains(bonusNumber));
        }
    }

    private int getCount(final List<Integer> number, final List<Integer> userNumbers) {
        return (int) userNumbers.stream()
                .filter(number::contains)
                .count();
    }

    private void updateCounts(final int matchCount, final boolean bonusMatch) {
        if (matchCount == Match.THREE.getCount()) threeMatch++;
        if (matchCount == Match.FOUR.getCount()) fourMatch++;
        if (matchCount == Match.FIVE.getCount() && !(bonusMatch)) fiveMatch++;
        if (matchCount == Match.BONUS.getCount() && bonusMatch) fiveAndBonusMatch++;
        if (matchCount == Match.SIX.getCount()) sixMatch++;
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