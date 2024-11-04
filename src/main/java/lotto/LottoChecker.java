package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoChecker {
    private final List<Integer> winningNumbers;
    private final List<Lotto> lottos;
    private final int bonusNumber;

    LottoChecker(WinningNumber winningNumber, List<Lotto> lottos) {
        this.winningNumbers = winningNumber.getWinningNumber();
        this.lottos = lottos;
        this.bonusNumber = winningNumber.getBonusNumber();
    }

    public HashMap<RANK, Integer> checkAll() {
        HashMap<RANK, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            result.put(check(lotto), result.getOrDefault(check(lotto), 0) + 1);
        }
        return result;
    }

    public RANK check(Lotto lotto) {
        Set<Integer> unionNumbers = new HashSet<>(winningNumbers);
        unionNumbers.retainAll(lotto.getNumbers());
        if (unionNumbers.size() == 6) {
            return RANK.FIRST;
        }
        if (unionNumbers.size() == 5) {
            return checkBonus(lotto);
        }
        if (unionNumbers.size() == 4) {
            return RANK.FOURTH;
        }
        if (unionNumbers.size() == 3) {
            return RANK.FIFTH;
        }
        return RANK.FAILURE;
    }

    private RANK checkBonus(Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return RANK.SECOND;
        }
        return RANK.THIRD;
    }
}
