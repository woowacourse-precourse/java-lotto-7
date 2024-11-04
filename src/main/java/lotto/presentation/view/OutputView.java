package lotto.presentation.view;

import lotto.application.dto.LottoTicketsDTO;
import lotto.domain.model.LottoRank;
import lotto.domain.result.LottoResult;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String PURCHASED_TICKETS_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TITLE = "\n당첨 통계";
    private static final String SEPARATOR_LINE = "---";
    private static final String RANK_RESULT_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printLottoTickets(LottoTicketsDTO lottoTicketsDTO) {
        List<List<Integer>> tickets = lottoTicketsDTO.getTickets();
        System.out.println(String.format(PURCHASED_TICKETS_MESSAGE, tickets.size()));
        for (List<Integer> ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public void printResults(LottoResult result) {
        System.out.println(WINNING_STATISTICS_TITLE);
        System.out.println(SEPARATOR_LINE);

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .forEach(rank -> {
                    String formatMoney = NumberFormat.getInstance().format(rank.getPrize());

                    if (rank == LottoRank.SECOND) {
                        // 5개 일치, 보너스 볼 일치 형식으로 출력
                        System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개%n", formatMoney, result.getRankCount(rank));
                    } else {
                        // 그 외의 경우
                        System.out.printf(RANK_RESULT_FORMAT + "%n", rank.getMatchCount(), formatMoney, result.getRankCount(rank));
                    }
                });
    }
}
