package lotto.domain;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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

    public int getTotalPrize() {
        return totalPrize;
    }

    public List<String> getFormattedResults() {
        NumberFormat currencyFormat = NumberFormat.getInstance(Locale.US);
        List<LottoRank> ranks = List.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND,
                LottoRank.FIRST);
        List<String> formattedResults = new ArrayList<>();

        for (LottoRank rank : ranks) {
            int count = matchResults.getOrDefault(rank, 0);
            String formattedPrize = currencyFormat.format(rank.getPrize());
            formattedResults.add(String.format("%d개 일치%s (%s원) - %d개",
                    rank.getMatchCount(),
                    rank == LottoRank.SECOND ? ", 보너스 볼 일치" : "",
                    formattedPrize,
                    count));
        }
        return formattedResults;
    }
}

