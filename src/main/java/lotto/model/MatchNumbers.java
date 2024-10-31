package lotto.model;

import java.util.List;

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

    public void count(List<List<Integer>> lottoNumbers, List<Integer> userNumbers, int bonusNumber) {
        for (List<Integer> number : lottoNumbers) {
            int matchCount = getMatchCount(number, userNumbers);
            boolean bonusMatch = number.contains(bonusNumber);
            updateMatchCounts(matchCount, bonusMatch);
        }
    }

    private int getMatchCount(List<Integer> number, List<Integer> userNumbers) {
        return (int) userNumbers.stream()
                .filter(number::contains)
                .count();
    }

    private void updateMatchCounts(int matchCount, boolean bonusMatch) {
        if (matchCount == 3) threeMatch++;
        if (matchCount == 4) fourMatch++;
        if (matchCount == 5 && !(bonusMatch)) fiveMatch++;
        if (matchCount == 5 && bonusMatch) fiveAndBonusMatch++;
        if (matchCount == 6) sixMatch++;
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
