package lotto.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultAnalyzer {

    public Map<LottoRank, Integer> getRankCounts(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> rankCount = new HashMap<>();

        for (Lotto ticket : tickets) {
            LottoRank rank = determineRank(ticket, winningNumbers, bonusNumber);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        return rankCount;
    }

    private LottoRank determineRank( Lotto ticket, List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> ticketNumbers = new HashSet<>(ticket.getNumbers());
        Set<Integer> winningSet = new HashSet<>(winningNumbers);

        boolean bonusMatch = ticketNumbers.contains(bonusNumber);
        ticketNumbers.retainAll(winningSet);
        int matchCount = ticketNumbers.size();

        if (matchCount == 6) {
            return LottoRank.FIRST;
        }
        if (matchCount == 5 && bonusMatch) {
            return LottoRank.SECOND;
        }
        if (matchCount == 5) {
            return LottoRank.THIRD;
        }
        if (matchCount == 4) {
            return LottoRank.FOURTH;
        }
        if (matchCount == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.NONE;
    }
}
