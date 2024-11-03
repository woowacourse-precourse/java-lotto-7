package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Winning;
import lotto.model.WinningNumbers;

public class LottoResultService {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoResultService(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Winning, Integer> checkWinningResults(List<Lotto> lottoTickets) {
        Map<Winning, Integer> winningResults = new HashMap<>();

        lottoTickets.forEach(lotto -> {
            int matchCount = winningNumbers.getMatchCount(lotto);
            boolean isBonusNumberMatched = bonusNumber.isMatched(lotto);

            Winning rank = Winning.getRank(matchCount, isBonusNumberMatched);

            winningResults.merge(rank, 1, Integer::sum);
        });

        return winningResults;
    }
}
