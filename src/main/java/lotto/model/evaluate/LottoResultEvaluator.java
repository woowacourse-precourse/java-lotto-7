package lotto.model.evaluate;

import java.util.List;
import lotto.dto.MatchInfo;
import lotto.dto.WinningResult;
import lotto.model.ticket.LottoTickets;

public class LottoResultEvaluator {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final LottoNumbersMatchCounter lottoNumbersMatchCounter;
    private final LottoResultCollector lottoResultCollector;

    public LottoResultEvaluator(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoNumbersMatchCounter = new LottoNumbersMatchCounter();
        this.lottoResultCollector = new LottoResultCollector();
    }

    public WinningResult evaluate(LottoTickets lottoTickets) {
        for (List<Integer> lottoNumbers : lottoTickets.getAllNumbers()) {
            MatchInfo matchInfo = evaluateMatch(lottoNumbers);
            lottoResultCollector.increment(matchInfo);
        }
        return lottoResultCollector.createWinningResult(lottoTickets.getCount());
    }

    private MatchInfo evaluateMatch(List<Integer> lottoNumbers) {
        int matchesCount = lottoNumbersMatchCounter.countMatches(winningNumbers, lottoNumbers);
        boolean bonusMatch = isBonusNumberMatched(lottoNumbers, matchesCount);
        return new MatchInfo(matchesCount, bonusMatch);
    }

    private boolean isBonusNumberMatched(List<Integer> lottoNumbers, int matchesCount) {
        return matchesCount == 5 && lottoNumbers.contains(bonusNumber);
    }
}
