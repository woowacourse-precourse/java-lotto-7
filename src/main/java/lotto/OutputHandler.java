package lotto;

import static lotto.OutputMessage.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.OutputMessage.INPUT_PURCHASE_AMOUNT_MESSAGE;
import static lotto.OutputMessage.INPUT_WINNING_NUMBERS_MESSAGE;
import static lotto.OutputMessage.PURCHASE_QUANTITY_INFORMATION_MESSAGE;

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

    public static void printInputBonusNumbers(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        List<Lotto> tickets = lottoTickets.getLottoTickets();

        System.out.println(tickets.size() + PURCHASE_QUANTITY_INFORMATION_MESSAGE);
        tickets.forEach(ticket -> System.out.println(ticket));
    }
}
