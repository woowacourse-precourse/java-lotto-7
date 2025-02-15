package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.List;
import java.util.Set;

public class LottoChecker {
    public Prize checkPrize(Lotto lotto, List<Integer> winningNumbers, int bonusNumber){

        Set<Integer> userLotto = Set.copyOf(lotto.getLottoNums());
        long matchCount = winningNumbers.stream().filter(
                userLotto::contains
        ).count();
        boolean bonusMatch = userLotto.contains(bonusNumber);
        return Prize.getPrize((int)matchCount, bonusMatch);
    }
}
