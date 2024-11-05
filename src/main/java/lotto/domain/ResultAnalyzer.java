package lotto.domain;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultAnalyzer {

    public Map<LottoRank, Integer> getRankCounts(List<Lotto> tickets, WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> rankCount = new EnumMap<>(LottoRank.class);

        for (Lotto ticket : tickets) {
            LottoRank rank = determineRank(ticket, winningNumbers);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        return rankCount;
    }

    private LottoRank determineRank(Lotto ticket, WinningNumbers winningNumbers) {
        int matchCount = getMatchCount(ticket, winningNumbers.getNumbers());
        boolean bonusMatch = ticket.getNumbers().contains(winningNumbers.getBonusNumber());

        if (isFirstRank(matchCount)) {
            return LottoRank.FIRST;
        }
        if (isSecondRank(matchCount, bonusMatch)) {
            return LottoRank.SECOND;
        }
        if (isThirdRank(matchCount)) {
            return LottoRank.THIRD;
        }
        if (isFourthRank(matchCount)) {
            return LottoRank.FOURTH;
        }
        if (isFifthRank(matchCount)) {
            return LottoRank.FIFTH;
        }

        return LottoRank.NONE;
    }

    private int getMatchCount(Lotto ticket, Set<Integer> winningNumbers) {
        Set<Integer> ticketNumbers = new HashSet<>(ticket.getNumbers());
        ticketNumbers.retainAll(winningNumbers);
        return ticketNumbers.size();
    }

    private boolean isFirstRank(int matchCount) {
        return matchCount == 6;
    }

    private boolean isSecondRank(int matchCount, boolean bonusMatch) {
        return matchCount == 5 && bonusMatch;
    }

    private boolean isThirdRank(int matchCount) {
        return matchCount == 5;
    }

    private boolean isFourthRank(int matchCount) {
        return matchCount == 4;
    }

    private boolean isFifthRank(int matchCount) {
        return matchCount == 3;
    }
}
