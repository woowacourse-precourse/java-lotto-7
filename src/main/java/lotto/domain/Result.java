package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<LottoRank, Integer> matchResults;
    private int totalPrize;

    public Result() {
        matchResults = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            matchResults.put(rank, 0);
        }
    }

    // 모든 티켓의 결과를 계산하고 저장
    public void calculateResults(LottoTicket lottoTicket, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : lottoTicket.getTickets()) {
            int matchCount = lotto.matchCount(winningNumbers.getWinningNumbers());
            boolean matchBonus = lotto.containsBonus(bonusNumber);
            LottoRank rank = LottoRank.findByMatchCountAndBonus(matchCount, matchBonus);
            addMatchResult(rank);
        }
    }

    private void addMatchResult(LottoRank rank) {
        if (rank != LottoRank.MISS) {
            matchResults.put(rank, matchResults.get(rank) + 1);
        }
        totalPrize += rank.getPrize();
    }

    public Map<LottoRank, Integer> getMatchResults() {
        return matchResults;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}

