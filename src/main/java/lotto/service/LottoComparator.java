package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class LottoComparator {

    private LottoComparator() {
    }

    public static List<LottoResult> getLottoResults(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);

        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto, winningLotto);
            boolean isBonusMatch = isBonusNumberMatched(lotto, bonusNumber);
            lottoResults.add(new LottoResult(matchCount, isBonusMatch));
        }
        return lottoResults;
    }

    private static int getMatchCount(Lotto userLotto, Lotto winningLotto) {
        int matchCount = 0;
        for (Integer number : userLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static boolean isBonusNumberMatched(Lotto userLotto, int bonusNumber) {
        return userLotto.getNumbers().contains(bonusNumber);
    }

    public static void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
