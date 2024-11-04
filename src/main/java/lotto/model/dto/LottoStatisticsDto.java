package lotto.model.dto;

import static lotto.constant.LottoGameConfig.TICKET_PRICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.domain.LottoRank;
import lotto.model.domain.LottoTickets;

public class LottoStatisticsDto {
    private final List<LottoRankCount> sortedRankCounts;
    private final double profitRate;

    public LottoStatisticsDto(List<LottoRank> lottoResults, LottoTickets lottoTickets) {
        this.sortedRankCounts = calculateSortedRankCounts(lottoResults);
        this.profitRate = calculateProfitRate(lottoTickets);
    }

    private List<LottoRankCount> calculateSortedRankCounts(List<LottoRank> lottoResults) {
        List<LottoRank> ranks = new ArrayList<>(List.of(LottoRank.values()));
        Collections.reverse(ranks);  // LottoRank를 역순으로 출력

        return ranks.stream()
                .filter(rank -> rank != LottoRank.FAIL)
                .map(rank -> new LottoRankCount(rank, (int) lottoResults.stream() // count 추출
                        .filter(result -> result == rank)
                        .count()))
                .toList();
    }

    private double calculateProfitRate(LottoTickets lottoTickets) {
        int purchaseAmount = lottoTickets.getTicketCount() * TICKET_PRICE;
        int totalPrize = sortedRankCounts.stream()
                .mapToInt(entry -> entry.rank().getPrize() * entry.count())
                .sum();

        return (double) totalPrize / purchaseAmount * 100;
    }

    public List<LottoRankCount> getSortedRankCounts() {
        return sortedRankCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
