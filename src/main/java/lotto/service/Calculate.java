package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningPrize;

public class Calculate {

    public int matchCount(Lotto issuedLotto, Lotto winningLotto) {
        List<Integer> issuedNumbers = issuedLotto.getNumbers();
        Set<Integer> winningNumbers = new HashSet<>(winningLotto.getNumbers());

        int matchCount = 0;

        for (Integer issuedNumber : issuedNumbers) {
            if (winningNumbers.contains(issuedNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public WinningPrize rank(int matchCount, BonusNumber bonusNumber, Lotto winningLotto) {
        Set<Integer> winningNumbers = new HashSet<>(winningLotto.getNumbers());

        if (matchCount == 3) {
            return WinningPrize.FIFTH;
        }
        if (matchCount == 4) {
            return WinningPrize.FOURTH;
        }
        if (matchCount == 5) {
            if (winningNumbers.contains(bonusNumber.getNumber())) {
                return WinningPrize.SECOND;
            }
            return WinningPrize.THIRD;
        }
        if (matchCount == 6) {
            return WinningPrize.FIRST;
        }
        return WinningPrize.FAILURE;
    }
}
