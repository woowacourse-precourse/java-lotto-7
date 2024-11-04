package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResultCalculator {

    private final List<Lotto> userLottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResultCalculator(List<Lotto> userLottos, List<Integer> winningNumbers, int bonusNumber) {
        this.userLottos = userLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoResult> calculateResults() {
        List<LottoResult> results = new ArrayList<>();
        for (Lotto lotto : userLottos) {
            int matchCount = calculateMatchCount(lotto);
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.getRank(matchCount, hasBonus);
            results.add(new LottoResult(rank, matchCount, hasBonus));
        }
        return results;
    }

    private int calculateMatchCount(Lotto lotto) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
