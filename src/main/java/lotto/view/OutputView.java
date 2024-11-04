package lotto.view;

import static lotto.constant.LottoPrintConstant.PRINT_BUY;
import static lotto.constant.LottoPrintConstant.RESULT_LINE;
import static lotto.constant.LottoPrintConstant.STATISTICS;
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

    private String formatRank(LottoRank rank, int num) {
        if (rank.name().equals(SECOND_RANK)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", rank.getMatchCount(), rank.getPrize(), num);
        }
        return String.format("%d개 일치 (%,d원) - %d개", rank.getMatchCount(), rank.getPrize(), num);
    }

    public void printRate(double num) {
        System.out.println(formatRate(num));
    }

    private String formatRate(double num) {
        return "총 수익률은 " + String.format("%.1f", num) + "%입니다.";
    }
}
