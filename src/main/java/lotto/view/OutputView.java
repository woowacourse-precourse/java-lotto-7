package lotto.view;

import static lotto.constants.LottoConstants.*;

import java.text.NumberFormat;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import lotto.Lotto;

public class OutputView {

    public static void print(String string) {
        System.out.println(string);
    }

    public static void promptPurchaseAmount(boolean isFirstPrompt) {
        if (isFirstPrompt) {
            print(PURCHASE_AMOUNT_TEXT);
        }

        if (!isFirstPrompt) {
            print(LINE_SPACE + PURCHASE_AMOUNT_TEXT);
        }
    }

    public static void promptWinningNumbers() {
        print(LINE_SPACE + WINNING_NUMBERS_TEXT);
    }

    public static void promptBonusNumber() {
        print(LINE_SPACE + BONUS_NUMBER_TEXT);
    }

    public static void promptWinningResult() {
        print(LINE_SPACE + WINNING_RESULT_TEXT + LINE_SPACE + DIVIDING_LINE);
    }

    public static void printLottoTickets(List<Lotto> lottoTickets) {
        lottoTickets.forEach(ticket -> printTicket(ticket.getNumbers()));
    }

    private static void printTicket(List<Integer> ticket) {
        String numbers = ticket.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(JOIN_DELIMITER));
        print(TICKET_START_TEXT + numbers + TICKET_END_TEXT);
    }

    public static void promptLottoCount(int lottoCount) {
        print(LINE_SPACE + lottoCount + LOTTO_COUNT_TEXT);
    }

    public static void printWinningResult(TreeMap<Integer, Integer> winningResult) {
        winningResult.forEach((rank, winningCount) -> {
            int matchCount = MATCH_COUNT_BY_RANK.get(rank);
            String formattedPrizeAmount = formatPrizeAmount(rank);

            if (rank == SECOND_RANK) {
                print(String.format(SECOND_RANK_DESCRIPTION, matchCount, formattedPrizeAmount, winningCount));
            }
            if (rank != SECOND_RANK) {
                print(String.format(DESCRIPTION, matchCount, formattedPrizeAmount, winningCount));
            }
        });
    }

    private static String formatPrizeAmount(int rank) {
        int prizeAmount = PRIZE_AMOUNT_BY_RANK.get(rank);
        return NumberFormat.getInstance().format(prizeAmount);
    }

    public static void printEarningRate(String earningRate) {
        print(String.format(EARNING_RATE_TEXT, earningRate));
    }
}