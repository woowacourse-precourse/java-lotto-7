package lotto;

import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.domain.Result;

import java.util.List;

public class MatchCalculator {

    private final List<Lotto> lottoTickets;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public MatchCalculator(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void calculateAllTickets(Result result) {
        for (Lotto ticket : lottoTickets) {
            int matchCount = getMatchCount(ticket.getNumbers());
            Match match = getMatchResult(matchCount, ticket.getNumbers());
            result.addResultCount(match);
        }
    }

    private Match getMatchResult(int matchCount, List<Integer> lottoNumbers) {
        if (matchCount == 5) {
            if (isBonusMatched(lottoNumbers)) {
                return Match.MATCH_5_WITH_BONUS;
            }
            return Match.MATCH_5;
        }

        if (matchCount == 4) {
            return Match.MATCH_4;
        }

        if (matchCount == 3) {
            return Match.MATCH_3;
        }

        return Match.NO_MATCH;
    }


    public int getMatchCount(List<Integer> lottoNumbers) {
        int matchCount = 0;
        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isBonusMatched(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
