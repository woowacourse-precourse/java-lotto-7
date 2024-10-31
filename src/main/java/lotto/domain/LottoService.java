package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class LottoService {
    private static final int SECOND_RANK_WINNING_COUNT = 5;
    private static final Map<Integer, Integer> WINNING_RANKS = Map.of(
            6, 1,
            5, 3,
            4, 4,
            3, 5
    );
    private static final Map<Integer, Integer> WINNING_AMOUNTS = Map.of(
            1, 2000000000,
            2, 30000000,
            3, 1500000,
            4, 50000,
            5, 5000
    );
    private final Map<Integer, Integer> winningResults = new HashMap<>(Map.of(
            1, 0,
            2, 0,
            3, 0,
            4, 0,
            5, 0
    ));
    private final List<Lotto> lottoTickets;
    private final Lotto winningNumbers;
    private final Lotto bonusNumber;

    public LottoService(List<Lotto> lottoTickets, Lotto winningNumbers, Lotto bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int calculateWinningAmount() {
        calculateRankResults();
        return winningResults.entrySet().stream()
                .mapToInt(entry -> WINNING_AMOUNTS.get(entry.getKey()) * entry.getValue())
                .sum();
    }

    private void calculateRankResults() {
        for (Lotto lotto : lottoTickets) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            int rank = determineRank(matchCount, lotto);

            if (rank > 0) {
                winningResults.merge(rank, 1, Integer::sum);
            }
        }
    }

    private boolean isWinningSecondRank(int matchingCount, Lotto lottoNumbers) {
        return matchingCount == SECOND_RANK_WINNING_COUNT && lottoNumbers.isBonusNumberMatched(bonusNumber);
    }

    private int determineRank(int matchingCount, Lotto lottoNumbers) {
        if (isWinningSecondRank(matchingCount, lottoNumbers)) {
            return 2;
        }
        return WINNING_RANKS.getOrDefault(matchingCount, 0);
    }

}
