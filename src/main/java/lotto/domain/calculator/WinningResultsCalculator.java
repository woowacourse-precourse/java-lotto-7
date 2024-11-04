package lotto.domain.calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.model.RankInfo;

import static lotto.constants.LottoConstants.INITIAL_WINNING_COUNT;
import static lotto.domain.factory.RankInfoFactory.*;

public class WinningResultsCalculator {
    private final List<Lotto> lottoTickets;
    private final Lotto winningNumbers;
    private final Lotto bonusNumber;

    private final Map<RankInfo, Integer> winningResults;

    public WinningResultsCalculator(List<Lotto> lottoTickets, Lotto winningNumbers, Lotto bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.winningResults = initializeWinningResults();

        calculateRankResults();
    }

    private static Map<RankInfo, Integer> initializeWinningResults() {
        Map<RankInfo, Integer> initialCount = new HashMap<>();
        for (int rank = getAllRanks().size(); rank >= getFirstRank().getRank(); rank--) {
            initialCount.put(getAllRanks().get(rank - 1), INITIAL_WINNING_COUNT);
        }
        return initialCount;
    }

    private void calculateRankResults() {
        for (Lotto ticket : lottoTickets) {
            int matchCount = ticket.getMatchCount(winningNumbers);
            RankInfo rank = determineRank(matchCount, ticket);

            if (rank != null) {
                updateWinningRankCount(rank);
            }
        }
    }

    private void updateWinningRankCount(RankInfo rank) {
        if (rank.getRank() > 0) {
            winningResults.merge(rank, 1, Integer::sum);
        }
    }

    private boolean isSecondRankWinner(int matchCount, Lotto ticket) {
        return matchCount == getSecondRank().getMatchCount() && ticket.isBonusNumberMatched(bonusNumber);
    }

    private RankInfo determineRank(int matchCount, Lotto ticket) {
        if (isSecondRankWinner(matchCount, ticket)) {
            return getSecondRank();
        }

        return getAllRanks().stream()
                .filter(rankInfo -> (rankInfo.getMatchCount() == matchCount && !rankInfo.hasBonusBall()))
                .findFirst()
                .orElse(null);
    }

    public Map<RankInfo, Integer> getWinningResults() {
        return new HashMap<>(winningResults);
    }
}
