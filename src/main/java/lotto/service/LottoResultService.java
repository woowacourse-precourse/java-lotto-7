package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.Winning;
import lotto.model.WinningNumbers;

public class LottoResultService {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoResultService(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Winning, Integer> getWinningResults(List<Lotto> lottoTickets) {
        Map<Winning, Integer> winningResults = new EnumMap<>(Winning.class);

        lottoTickets.forEach(lotto -> {
            int matchCount = winningNumbers.getMatchCount(lotto);
            boolean isBonusNumberMatched = bonusNumber.isMatched(lotto);

            Winning rank = Winning.getRank(matchCount, isBonusNumberMatched);

            winningResults.merge(rank, 1, Integer::sum);
        });

        return winningResults;
    }

    public double calculateRateOfReturn(PurchaseAmount purchaseAmount, Map<Winning, Integer> winningResults) {
        long prizeMoney = winningResults.keySet().stream()
                .mapToLong(winning -> winning.prizeMoney() * winningResults.get(winning)).sum();
        return Math.round((double) prizeMoney / purchaseAmount.amount() * 1000) / 10.0;
    }
}
