package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoResult {

    private final Map<LottoRank, Integer> rankResults;

    public LottoResult() {
        this.rankResults = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankResults.put(rank, 0);
        }
    }

    public void compare(LottoTicket lottoTicket, WinningLotto winningLotto) {
        List<List<Integer>> ticketNumbers = lottoTicket.getLottoTicketNumbers();
        for (List<Integer> lottoNumbers : ticketNumbers) {
            int matchCount = (int) lottoNumbers.stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();
            boolean hasBonus = lottoNumbers.contains(winningLotto.getBonusNum());
            if (matchCount >= 3) {
                LottoRank rank = LottoRank.valueOfMatchCount(matchCount, hasBonus);

                rankResults.put(rank, rankResults.get(rank) + 1);
            }
        }
    }

    public Map<LottoRank, Integer> getRankResults() {
        return rankResults;
    }
}
