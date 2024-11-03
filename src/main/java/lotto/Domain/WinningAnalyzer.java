package lotto.Domain;

import java.util.List;

public class WinningAnalyzer {

    public WinningResult analyze(Lottos issuedLottos, WinningNumbers winningNumbers) {
        WinningResult winningResult = WinningResult.create();

        for (Lotto lotto : issuedLottos.getLottoList()) {
            WinningRules rule = calculateRank(winningNumbers, lotto);
            winningResult.addResult(rule);
        }

        return winningResult;
    }

    private WinningRules calculateRank(WinningNumbers winningNumbers, Lotto issuedLotto) {
        int matchCount = getMatchCount(winningNumbers.getMainNumbers(), issuedLotto);
        boolean bonusMatch = issuedLotto.getNumbers().contains(winningNumbers.getBonusNumber());

        return WinningRules.valueOf(matchCount, bonusMatch);
    }

    private int getMatchCount(Lotto winningLotto, Lotto issuedLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        List<Integer> issuedNumbers = issuedLotto.getNumbers();
        int count = 0;
        for (Integer number : issuedNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

}
