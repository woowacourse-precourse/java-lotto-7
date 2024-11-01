package service;

import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.List;

public class LottoCalculator {

    public static LottoRank calculateRank(Lotto userLotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = 0;
        boolean bonusMatch = false;

        for (int number : userLotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
            if (number == bonusNumber) {
                bonusMatch = true;
            }
        }
        return LottoRank.findRank(matchCount, bonusMatch);


    }
}
