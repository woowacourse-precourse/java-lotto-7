package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Rank;

public class LottoDrawMachine {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;
    private Map<Rank, Integer> winningResult;

    public LottoDrawMachine(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void compareLottoToWinning() {
        winningResult = new HashMap<>();
        for (Lotto lotto : lottos) {
            List<Integer> result = lotto.compareNumbersToWinningNumbers(winningNumbers);
            boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);
            Rank rank = Rank.findRank(result.size(), hasBonusNumber);
            winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<Rank, Integer> prizeWinningResult() {
        return winningResult;
    }

    public Double calculateEarningsRate() {
        long totalWinningPrice = sumTotalEarnings();
        long purchaseAmount = lottos.size() * 1000L;
        return (double) totalWinningPrice / purchaseAmount * 100;
    }

    private long sumTotalEarnings() {
        long total = 0L;
        for (Map.Entry<Rank, Integer> entry : winningResult.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            if (count == 0 || rank.equals(Rank.NONE)) continue;
            total += rank.price() * count;
        }
        return total;
    }
}
