package lotto.model.evaluate;

import java.util.List;
import lotto.dto.MatchInfo;
import lotto.dto.WinningResult;
import lotto.model.ticket.LottoTickets;
import lotto.model.win.LottoWinningSet;

public class LottoResultEvaluator {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final LottoNumbersMatchCounter lottoNumbersMatchCounter;

    public LottoResultEvaluator(LottoWinningSet lottoWinningSet) {
        this.winningNumbers = lottoWinningSet.getWinningNumbers();
        this.bonusNumber = lottoWinningSet.getBonusNumber();
        this.lottoNumbersMatchCounter = new LottoNumbersMatchCounter();
    }

    public WinningResult evaluate(LottoTickets lottoTickets) {
        LottoResultCollector lottoResultCollector = new LottoResultCollector();
        for (List<Integer> lottoNumbers : lottoTickets.getAllNumbers()) {
            MatchInfo matchInfo = evaluateMatch(lottoNumbers);
            lottoResultCollector.increment(matchInfo);
        }
        return lottoResultCollector.createWinningResult(lottoTickets.getCount());
    }

    private MatchInfo evaluateMatch(List<Integer> lottoNumbers) {
        int matchesCount = lottoNumbersMatchCounter.countMatches(winningNumbers, lottoNumbers);
        boolean bonusMatch = isBonusNumberMatched(lottoNumbers);
        return new MatchInfo(matchesCount, bonusMatch);
    }

    private boolean isBonusNumberMatched(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
