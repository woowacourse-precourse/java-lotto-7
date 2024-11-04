package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.domain.model.RankInfo;

import static lotto.constants.LottoConstants.*;
import static lotto.domain.factory.RankInfoFactory.getAllRanks;
import static lotto.domain.factory.RankInfoFactory.getSecondRank;

public class LottoOutputView {

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
        print(String.format(LINE_SPACE + LOTTO_COUNT_TEXT, lottoCount));
    }

    public static void printWinningResult(Map<RankInfo, Integer> winningResults) {
        getAllRanks().forEach((rankInfo) -> {
            int matchCount = winningResults.get(rankInfo);
            printDescription(rankInfo, matchCount);
        });
    }

    private static void printDescription(RankInfo rankInfo, int matchCount) {
        String formattedPrizeAmount = formatPrizeAmount(rankInfo.getPrizeAmount());

        if (rankInfo.getRank() == getSecondRank().getRank()) {
            print(String.format(rankInfo.getDescription(), rankInfo.getMatchCount(), formattedPrizeAmount, matchCount));
        }
        if (rankInfo.getRank() != getSecondRank().getRank()) {
            print(String.format(rankInfo.getDescription(), rankInfo.getMatchCount(), formattedPrizeAmount, matchCount));
        }
    }

    private static String formatPrizeAmount(int prizeAmount) {
        return NumberFormat.getInstance().format(prizeAmount);
    }

    public static void printEarningsRate(String earningsRate) {
        print(String.format(EARNINGS_RATE_TEXT, earningsRate));
    }
}