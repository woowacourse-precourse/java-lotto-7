package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.SortComparator;
import lotto.domain.prizelotto.PrizeLotto;

public class PrizeNumber {

    private final List<PrizeLotto> prizeLottos;

    public PrizeNumber(List<PrizeLotto> prizeLottos) {
        this.prizeLottos = prizeLottos;
    }

    public void countMatchNumber(List<Integer> lottoNumbers, WinNumbers winNumbers) {
        List<Integer> compareNumbers = winNumbers.primaryWinNumbers();
        int count = 0;
        for (Integer number : lottoNumbers) {
            if (compareNumbers.contains(number)) {
                count++;
            }
        }
        decideRankNumber(count, lottoNumbers, winNumbers);
    }

    private void decideRankNumber(int count, List<Integer> lottoNumbers, WinNumbers winNumbers) {
        for (PrizeLotto prizeLotto : prizeLottos) {
            if (prizeLotto.isSatisfyPrizeRule(count, lottoNumbers, winNumbers)) {
                prizeLotto.upCount();
            }
        }
    }

    public int calculateTotalPrize() {
        int total = 0;
        for (PrizeLotto prizeLotto : prizeLottos) {
            total += prizeLotto.calculatePrize();
        }
        return total;
    }

    public List<PrizeLotto> sortByRank() {
        List<PrizeLotto> sortedPrizeLottos = new ArrayList<>(prizeLottos);
        sortedPrizeLottos.sort(new SortComparator());
        return sortedPrizeLottos;
    }

    public void countWinningLottos(WinNumbers winNumbers, Lottos lottos) {
        List<Lotto> allLotto = lottos.value();
        for (Lotto lotto : allLotto) {
            countMatchNumber(lotto.getNumbers(), winNumbers);
        }
    }
}
