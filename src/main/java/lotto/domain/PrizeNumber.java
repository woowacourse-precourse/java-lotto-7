package lotto.domain;

import java.util.List;
import lotto.prizelotto.PrizeLotto;

public class PrizeNumber {

    private List<PrizeLotto> prizeLottos;

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
            if (prizeLotto.isSatisfyRule(count, lottoNumbers, winNumbers)) {
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
}
