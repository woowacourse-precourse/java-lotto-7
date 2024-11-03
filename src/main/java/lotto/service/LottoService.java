package lotto.service;

import lotto.enums.WinningStatistics;
import lotto.model.Lotto;
import lotto.model.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {

    private Money money;

    public Lotto[] issueLotto(Money money) {
        this.money = money;
        int lottoCount = money.getPurchaseAmount() / 1000;
        Lotto[] issuedLottos = new Lotto[lottoCount];

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            issuedLottos[i] = new Lotto(numbers);
        }
        return issuedLottos;
    }

    public void countMatchingNumbers(Lotto[] issuedLottos, Lotto winningLotto) {
        for (Lotto lotto : issuedLottos) {
            List<Integer> matchingNumbers = new ArrayList<>(lotto.getNumbers());
            matchingNumbers.retainAll(winningLotto.getNumbers());
            int matchCount = matchingNumbers.size();

            if (matchCount == 5) {
                checkBonusNumber(lotto, winningLotto);
                return;
            }
            updateWinningStatistics(matchCount);
        }
    }

    private void checkBonusNumber(Lotto lotto, Lotto winningLotto) {
        if (lotto.getNumbers().contains(winningLotto.getNumbers().get(6))) {
            WinningStatistics.SECOND.setCount(WinningStatistics.SECOND.getCount() + 1);
            return;
        }

        WinningStatistics.THIRD.setCount(WinningStatistics.THIRD.getCount() + 1);
    }

    private void updateWinningStatistics(int matchCount) {
        for (WinningStatistics stat : WinningStatistics.values()) {
            if (stat.getMatchCount() == matchCount) {
                stat.setCount(stat.getCount() + 1);
            }
        }
    }

    public double calculateProfitRate() {
        int totalPrize = 0;
        for (WinningStatistics stat : WinningStatistics.values()) {
            totalPrize += stat.getPrize() * stat.getCount();
        }
        return (double) totalPrize / this.money.getPurchaseAmount() * 100;
    }
}
