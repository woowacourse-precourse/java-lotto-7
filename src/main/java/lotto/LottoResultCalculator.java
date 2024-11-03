package lotto;

import java.util.List;

public class LottoResultCalculator {
    public static LottoResult calculate(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();

        for (Lotto lotto : purchasedLottos) {
            int matchCount = getMatchCount(lotto, winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            result.addResult(matchCount, bonusMatch);
        }

        return result;
    }

    private static int getMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
