package lotto.service;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.dto.LottoResult;

public class LottoDrawService {

    public LottoResult drawLotto(Lotto lotto, WinningLotto winningLotto){
        int matchingNumberCount = countMatchingNumbers(lotto,winningLotto);
        boolean bonusMatch = isBonusMatched(lotto,winningLotto);
        return new LottoResult(matchingNumberCount,bonusMatch);
    }

    private int countMatchingNumbers(Lotto lotto, WinningLotto winningLotto) {
        Set<Integer> matchCount = new HashSet<>(lotto.getNumbers());
        matchCount.retainAll(winningLotto.getWinningNumbers());
        return matchCount.size();
    }

    private boolean isBonusMatched(Lotto lotto,WinningLotto winningLotto) {
        for (int number: lotto.getNumbers()){
            if(winningLotto.isBonusNumber(number)){
                return true;
            }
        }
        return false;
    }
}
