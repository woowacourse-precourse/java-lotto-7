package lotto.view;

import lotto.utils.LottoRules;

import java.util.List;
import java.util.Map;

import static lotto.utils.LottoRules.Winning.*;

public class OutputView {
    private static final String DISPLAY_LOTTO_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String DISPLAY_LOTTO_NUMBER_MESSAGE_FORMAT = "[%s]";
    private static final String DISPLAY_LOTTO_WINNING_RANK_COUNT_FORMAT =
            "당첨 통계\n" +
            "---\n" +
            "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개";
    private static final String DISPLAY_YIELD_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";


    public void displayPurchasedLottoCount(int count) {
        System.out.printf(DISPLAY_LOTTO_COUNT_MESSAGE_FORMAT + "%n", count);
    }

    public void displayPurchasedLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> lottoTicket : lottoTickets) {
            String lottoView = formattingLottoNumbers(lottoTicket);
            System.out.println(lottoView);
        }
    }

    public void displayWinningStatistics(Map<LottoRules.Winning, Integer> winningRankCount) {
        int countRank5 = winningRankCount.getOrDefault(WINNING_RANK_5, 0);
        int countRank4 = winningRankCount.getOrDefault(WINNING_RANK_4, 0);
        int countRank3 = winningRankCount.getOrDefault(WINNING_RANK_3, 0);
        int countRank2 = winningRankCount.getOrDefault(WINNING_RANK_2, 0);
        int countRank1 = winningRankCount.getOrDefault(WINNING_RANK_1, 0);

        String WinningRankCountMessage = String.format(
                DISPLAY_LOTTO_WINNING_RANK_COUNT_FORMAT,
                countRank5, countRank4, countRank3, countRank2, countRank1
        );

        System.out.println(WinningRankCountMessage);
    }

    private String formattingLottoNumbers(List<Integer> lottoTicket) {
        List<String> numbers = lottoTicket.stream()
                .map(String::valueOf)
                .toList();

        String joinedNumbers = String.join(", ", numbers);
        return String.format(DISPLAY_LOTTO_NUMBER_MESSAGE_FORMAT, joinedNumbers);
    }

    public void displayYieldRate(Double yieldRate) {
        System.out.printf(DISPLAY_YIELD_RATE_FORMAT + "%n", yieldRate);
    }

    public void displayErrorMessage(String message) {
        System.out.println(message);
    }
}
