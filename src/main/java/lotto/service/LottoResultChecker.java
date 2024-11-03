package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Score;

public class LottoResultChecker {
    public Score calculateScore(Lotto comparedLotto, Lotto winningLotto, int bonusNum) {
        int correctCount = checkCorrectCount(comparedLotto, winningLotto);
        boolean isBonusCorrect = isBonusNumMatched(comparedLotto, bonusNum);
        return determineScore(correctCount, isBonusCorrect);
    }

    private int checkCorrectCount(Lotto comparedLotto, Lotto winningLotto) {
        List<Integer> winningNums = winningLotto.getNumbers();
        return (int) comparedLotto.getNumbers().stream()
                .filter(winningNums::contains)
                .count();
    }

    private boolean isBonusNumMatched(Lotto comparedLotto, int bonusNum) {
        return comparedLotto.getNumbers().contains(bonusNum);
    }

    private Score determineScore(int correctCount, boolean isBonusCorrect) {
        if (correctCount == 3) return Score.THREE_CORRECT;
        if (correctCount == 4) return Score.FOUR_CORRECT;
        if (correctCount == 5 && isBonusCorrect) return Score.FIVE_CORRECT_BONUS_CORRECT;
        if (correctCount == 5) return Score.FIVE_CORRECT;
        if (correctCount == 6) return Score.SIX_CORRECT;
        return Score.NONE;
    }
}
