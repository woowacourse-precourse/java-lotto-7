package lotto.model.evaluate;

import java.util.List;
import lotto.dto.MatchInfo;
import lotto.dto.WinningResult;
import lotto.model.match.MatchCountAlgorithm;
import lotto.model.match.SetBasedMatchCountAlgorithm;
import lotto.model.ticket.LottoTickets;

public class LottoResultEvaluator {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final MatchCountAlgorithm<Integer> matchCountAlgorithm;
    private final LottoResultCounter lottoResultCounter;

    public LottoResultEvaluator(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.matchCountAlgorithm = new SetBasedMatchCountAlgorithm<>();
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
        int matchesCount = matchCountAlgorithm.countMatches(winningNumbers, lottoNumbers);
        boolean bonusMatch = isBonusNumberMatched(lottoNumbers, matchesCount);
        return new MatchInfo(matchesCount, bonusMatch);
    }

    private boolean isBonusNumberMatched(List<Integer> lottoNumbers, int matchesCount) {
        return matchesCount == 5 && lottoNumbers.contains(bonusNumber);
    }
}
