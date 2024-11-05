package lotto.view;

import lotto.enums.LottoRank;
import lotto.model.LottoTicket;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class OutputView {
    private static final String PURCHASE_OUTPUT = "%d개를 구매했습니다.";
    private static final String WINNING_HEADER = "당첨 통계";
    private static final String OUTPUT_SEPARATOR = "---";
    private static final String MATCH_OUTPUT_FORMAT = "%d개 일치%s (%s원) - %d개%n";
    private static final String BONUS_MATCH_OUTPUT = ", 보너스 볼 일치";
    private static final String YIELD_OUTPUT = "총 수익률은 %.1f%%입니다.";

    private static final int MATCH_THRESHOLD = 3;
    private static final Locale KOREAN_LOCALE = Locale.KOREA;

    public void displayTickets(List<LottoTicket> tickets) {
        System.out.printf(PURCHASE_OUTPUT + "%n", tickets.size());
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getLottoNumbers());
        }
    }

    public void displayResults(Map<LottoRank, Integer> results, int purchaseAmount) {
        displayStatisticsHeader();
        displayAllRanks(results);
        displayYield(results, purchaseAmount);
    }

    private void displayStatisticsHeader() {
        System.out.println(WINNING_HEADER);
        System.out.println(OUTPUT_SEPARATOR);
    }

    private void displayAllRanks(Map<LottoRank, Integer> results) {
        for (LottoRank rank : LottoRank.values()) {
            displayRankResult(rank, results.getOrDefault(rank, 0));
        }
    }

    private void displayRankResult(LottoRank rank, int count) {
        if (rank.getMatchCount() >= MATCH_THRESHOLD || rank == LottoRank.FOUR_MATCH || rank == LottoRank.FIVE_MATCH) {
            System.out.printf(
                    MATCH_OUTPUT_FORMAT,
                    rank.getMatchCount(),
                    rank.matchesBonus() ? BONUS_MATCH_OUTPUT : "",
                    formatPrizeMoney(rank.getReward()),
                    count
            );
        }
    }

    private void displayYield(Map<LottoRank, Integer> results, int purchaseAmount) {
        long totalPrizeMoney = results.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
        double yield = (double) totalPrizeMoney / purchaseAmount * 100;

        System.out.printf(YIELD_OUTPUT + "%n", yield);
    }

    private String formatPrizeMoney(long prizeMoney) { // 가독성을 위한 포맷팅
        NumberFormat numberFormat = NumberFormat.getInstance(KOREAN_LOCALE);
        return numberFormat.format(prizeMoney);
    }
}