package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class LottoService {
    private static final int SECOND_PLACE_MATCH_COUNT = 5;
    private static final Map<Integer, Integer> MATCH_COUNT_TO_RANK = Map.of(
            6, 1,
            5, 3,
            4, 4,
            3, 5
    );  // (n, m) n개 일치 시 m등
    private static final Map<Integer, Integer> PRIZE_AMOUNT_BY_RANK = Map.of(
            1, 2000000000,
            2, 30000000,
            3, 1500000,
            4, 50000,
            5, 5000
    );  // (m, k) m등 상금 k원
    private final Map<Integer, Integer> winningRankCount = new HashMap<>(Map.of(
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
        return winningRankCount.entrySet().stream()
                .mapToInt(entry -> PRIZE_AMOUNT_BY_RANK.get(entry.getKey()) * entry.getValue())
                .sum();
    }

    private void calculateRankResults() {
        for (Lotto ticket : lottoTickets) {
            int matchCount = ticket.getMatchCount(winningNumbers);
            int rank = determineRank(matchCount, ticket);

            if (rank > 0) {
                winningRankCount.merge(rank, 1, Integer::sum);
            }
        }
    }

    private boolean isSecondPlaceWinner(int matchCount, Lotto ticket) {
        return matchCount == SECOND_PLACE_MATCH_COUNT && ticket.isBonusNumberMatched(bonusNumber);
    }

    private int determineRank(int matchCount, Lotto ticket) {
        if (isSecondPlaceWinner(matchCount, ticket)) {
            return 2;
        }
        return MATCH_COUNT_TO_RANK.getOrDefault(matchCount, 0);
    }

}
