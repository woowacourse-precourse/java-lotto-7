package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoAnswer;
import lotto.model.WinningResult;

public class LottoMatcher {
    private LottoMatcher() {
    }

    public static WinningResult match(Lotto userLotto, LottoAnswer lottoAnswer) {
        return match(userLotto.getNumbers(), lottoAnswer.getNumbers(), lottoAnswer.getBonusNumber());
    }

    public static WinningResult match(List<Integer> userLotto, List<Integer> winningLotto, int bonusNumber) {
        Set<Integer> userLottoSet = new HashSet<>(userLotto);
        Set<Integer> winningLottoSet = new HashSet<>(winningLotto);

        int matchCount = calcMatchCount(userLottoSet, winningLottoSet);
        boolean isBonusMatch = isBonusMatch(userLottoSet, bonusNumber);

        return WinningResult.of(matchCount, isBonusMatch);
    }

    private static int calcMatchCount(Set<Integer> userLotto, Set<Integer> winningLotto) {
        int matchCount = 0;
        for (Integer number : userLotto) {
            if (winningLotto.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public static boolean isBonusMatch(Set<Integer> userLotto, int bonusNumber) {
        return userLotto.contains(bonusNumber);
    }
}
