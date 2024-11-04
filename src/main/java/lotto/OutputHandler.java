package lotto;

import static lotto.OutputMessage.DASH_LINE;
import static lotto.OutputMessage.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.OutputMessage.INPUT_PURCHASE_AMOUNT_MESSAGE;
import static lotto.OutputMessage.INPUT_WINNING_NUMBERS_MESSAGE;
import static lotto.OutputMessage.PURCHASE_QUANTITY_INFORMATION_MESSAGE;
import static lotto.OutputMessage.WINNING_STATISTICS_HEADER;

import java.util.List;

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

    public void printWinningStatistics(LottoWinningResult winningResult) {
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(DASH_LINE);

        for (WinningPrize prize : WinningPrize.values()) {
            int count = winningResult.getResults().get(prize);
            boolean bonusMatchRequired = prize.requiresBonus();
            System.out.print(prize.getFormattedMessage(count, bonusMatchRequired));
        }
    }
}
