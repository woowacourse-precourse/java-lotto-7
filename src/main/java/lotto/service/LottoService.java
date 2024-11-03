package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.PrizeTable;

public class LottoService {

    public int getTotalPrizeMoney(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int totalPrizeMoney = 0;

        countWinningLottos(lottos, winningNumbers, bonusNumber);

        for (PrizeTable prizeTable : PrizeTable.values()) {
            totalPrizeMoney += prizeTable.getTotalPrizeMoney();
        }

        return totalPrizeMoney;
    }

    public List<Lotto> getLottos(int purchaseMoney) {
        int purchaseLottoQuantity = purchaseMoney / Lotto.PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseLottoQuantity; i++) {
            lottos.add(new Lotto(pickSixNumbers()));
        }
        return lottos;
    }

    private void countWinningLottos(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            countWinningLotto(lotto, winningNumbers, bonusNumber);
        }
    }

    private void countWinningLotto(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchNumbers = countMatchNumbers(lotto, winningNumbers);
        boolean isBonusNumber = existBonusNumber(lotto, bonusNumber);

        validateMatchNumbers(matchNumbers, isBonusNumber);
    }

    private void validateMatchNumbers(int matchNumbers, boolean isBonusNumber) {
        if (matchNumbers == 5 && isBonusNumber) {
            PrizeTable.FIVE_BONUS_MATCHES.addWinningCount();
            return;
        }

        for (PrizeTable prizeTable : PrizeTable.values()) {
            if (matchNumbers == prizeTable.getMatchNumbers()) {
                prizeTable.addWinningCount();
                break;
            }
        }
    }

    private List<Integer> pickSixNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private boolean existBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private int countMatchNumbers(Lotto lotto, List<Integer> winningNumbers) {
        Set<Integer> countNumbers = new HashSet<>();
        int existNumbers = lotto.getNumbers().size() + winningNumbers.size();

        countNumbers.addAll(lotto.getNumbers());
        countNumbers.addAll(winningNumbers);

        return existNumbers - countNumbers.size();
    }
}
