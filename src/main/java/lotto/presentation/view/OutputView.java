package lotto.presentation.view;

import lotto.application.dto.LottoTicketsDTO;
import lotto.domain.model.LottoRank;
import lotto.domain.result.LottoResult;
import lotto.util.LottoFormatter;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String PURCHASED_TICKETS_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TITLE = "\n당첨 통계";
    private static final String SEPARATOR_LINE = "---";

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

    public void printResults(LottoResult result, double profitRate) {
        System.out.println(WINNING_STATISTICS_TITLE);
        System.out.println(SEPARATOR_LINE);

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .forEach(rank -> {
                    String rankResult = LottoFormatter.formatRankResult(rank, result.getRankCount(rank));
                    System.out.println(rankResult);
                });

        String formattedProfitRate = LottoFormatter.formatProfitRate(profitRate);
        System.out.println(formattedProfitRate);
    }
}
