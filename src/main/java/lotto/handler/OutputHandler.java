package lotto.handler;

import static lotto.constants.OutputMessage.DASH_LINE;
import static lotto.constants.OutputMessage.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.constants.OutputMessage.INPUT_PURCHASE_AMOUNT_MESSAGE;
import static lotto.constants.OutputMessage.INPUT_WINNING_NUMBERS_MESSAGE;
import static lotto.constants.OutputMessage.PURCHASE_QUANTITY_INFORMATION_MESSAGE;
import static lotto.constants.OutputMessage.TOTAL_PROFIT_RATE_MESSAGE_FORMAT;
import static lotto.constants.OutputMessage.WINNING_STATISTICS_HEADER;

import java.util.List;
import lotto.domain.WinningPrize;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.service.LottoWinningResult;

public class OutputHandler {
    private OutputHandler() {
    }

    public static void printInputPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printInputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public static void printInputBonusNumbers() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        List<Lotto> tickets = lottoTickets.getLottoTickets();

        System.out.println(tickets.size() + PURCHASE_QUANTITY_INFORMATION_MESSAGE);
        tickets.forEach(ticket -> System.out.println(ticket));
    }

    public static void printWinningStatistics(LottoWinningResult winningResult) {
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(DASH_LINE);

        for (WinningPrize prize : WinningPrize.values()) {
            int count = winningResult.getResults().get(prize);
            boolean bonusMatchRequired = prize.requiresBonus();
            System.out.print(prize.getFormattedMessage(count, bonusMatchRequired));
        }
    }

    public static void printTotalProfitRate(double totalProfitRate) {
        System.out.printf(TOTAL_PROFIT_RATE_MESSAGE_FORMAT, totalProfitRate);
    }
}
