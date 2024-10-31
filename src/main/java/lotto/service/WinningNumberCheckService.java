package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.LottoResult;

public class WinningNumberCheckService {
    public LottoResult checkWinningNumber(List<Integer> randomLotto, List<Integer> winningNumber, int bonusNumber) {
        Set<Integer> winningNumberSet = new HashSet<>(winningNumber);
        long matchCount = randomLotto.stream().filter(winningNumberSet::contains).count();
        boolean hasBonus = randomLotto.contains(bonusNumber);
        return new LottoResult(matchCount, hasBonus);
    }
}
