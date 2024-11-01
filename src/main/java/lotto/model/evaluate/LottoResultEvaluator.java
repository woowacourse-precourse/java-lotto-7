package lotto.model.evaluate;

import java.util.List;
import lotto.dto.MatchInfo;
import lotto.dto.WinningResult;
import lotto.model.match.MatchCounter;
import lotto.model.match.SetBasedLottoNumbersMatchCounter;
import lotto.model.ticket.LottoTickets;

public class LottoResultEvaluator {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final MatchCounter<Integer> matchCounter;
    private final LottoResultCounter lottoResultCounter;

    public LottoResultEvaluator(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.matchCounter = new SetBasedLottoNumbersMatchCounter<>();
        this.lottoResultCounter = new LottoResultCounter();
    }

    public WinningResult evaluate(LottoTickets lottoTickets) {
        for (List<Integer> lottoNumbers : lottoTickets.getAllNumbers()) {
            MatchInfo matchInfo = evaluateMatch(lottoNumbers);
            lottoResultCounter.increment(matchInfo);
        }
        return lottoResultCounter.createWinningResult(lottoTickets.getCount());
    }

    private MatchInfo evaluateMatch(List<Integer> lottoNumbers) {
        int matchesCount = matchCounter.countMatches(winningNumbers, lottoNumbers);
        boolean bonusMatch = isBonusNumberMatched(lottoNumbers, matchesCount);
        return new MatchInfo(matchesCount, bonusMatch);
    }

    private boolean isBonusNumberMatched(List<Integer> lottoNumbers, int matchesCount) {
        return matchesCount == 5 && lottoNumbers.contains(bonusNumber);
    }
}
