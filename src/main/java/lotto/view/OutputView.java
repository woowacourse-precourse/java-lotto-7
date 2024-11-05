package lotto.view;

import static lotto.constant.LottoPrintConstant.NON_SECOND_MATCH_RESULT;
import static lotto.constant.LottoPrintConstant.PERCENT_PRINT;
import static lotto.constant.LottoPrintConstant.PRINT_BUY;
import static lotto.constant.LottoPrintConstant.RESULT_LINE;
import static lotto.constant.LottoPrintConstant.SECOND_MATCH_RESULT;
import static lotto.constant.LottoPrintConstant.STATISTICS;
import static lotto.constant.LottoPrintConstant.TOTAL_PRINT;
import static lotto.constant.LottoValueConstant.SECOND_RANK;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;
import lotto.domain.LottoRank;

public class OutputView {

    public void printRandomNumber(List<List<Integer>> lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.size() + PRINT_BUY);
        System.out.println(formatLottoTickets(lottoTickets));
    }

    private String formatLottoTickets(List<List<Integer>> lottoTickets) {
        return lottoTickets.stream()
                .map(ticket -> ticket.toString())
                .collect(Collectors.joining("\n"));
    }

    public void printResult(Map<String, Integer> result) {
        System.out.println(STATISTICS);
        System.out.println(RESULT_LINE);
        System.out.println(formatRankResults(result));
    }

    private String formatRankResults(Map<String, Integer> result) {
        return Arrays.stream(LottoRank.values())
                .map(rank -> formatRank(rank, result.get(rank.name())))
                .collect(Collectors.joining("\n"));
    }

    private String formatRank(LottoRank rank, int rankCount) {
        if (rank.name().equals(SECOND_RANK)) {
            return String.format(SECOND_MATCH_RESULT,rank.getMatchCount(),rank.getPrize(), rankCount);
        }
        return String.format(NON_SECOND_MATCH_RESULT, rank.getMatchCount(), rank.getPrize(), rankCount);
    }

    public void printRate(double num) {
        System.out.println(formatRate(num));
    }

    private String formatRate(double num) {
        return TOTAL_PRINT + String.format("%.1f", num) + PERCENT_PRINT;
    }
}
