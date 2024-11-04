package lotto.model;

import java.util.List;

public class LottoNumberMatcher {
    private final List<Lotto> purchasedLottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoNumberMatcher(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult calculateWinningResult() {
        WinningResult result = new WinningResult();

        for (Lotto lotto : purchasedLottos) {
            int matchCount = countMatchingNumbers(lotto.getNumbers());
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            result.addResult(rank);
        }

        return result;
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
