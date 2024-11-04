package lotto.service;

import static lotto.constants.Constants.ONE;
import static lotto.constants.Constants.ZERO;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.Winning;

public class LottoGroupService {
    public void calculateResults(LottoGroup lottoGroup, Lotto winningLotto, int bonusNumber) {
        List<Lotto> lottos = lottoGroup.getLottos();

        for (Lotto lotto : lottos) {
            int matchingCount = countMatchingNumbers(lotto.getNumbers(), winningLotto.getNumbers());
            int bonusCount = ZERO;

            if (hasBonusNumber(lotto.getNumbers(), bonusNumber)) {
                bonusCount = ONE;
            }

            Winning winning = Winning.findPrize(matchingCount, bonusCount);
            lottoGroup.updateWinningStatistics(winning);
            lottoGroup.addToTotalPrize(winning.getPrice());
        }

    }

    private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean hasBonusNumber(List<Integer> userNumbers, int bonusNumber) {
        return userNumbers.contains(bonusNumber);
    }
}
