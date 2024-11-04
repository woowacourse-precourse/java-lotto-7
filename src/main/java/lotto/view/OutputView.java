package lotto.view;

import lotto.model.Lotto;
import lotto.model.PurchasedLottos;
import lotto.model.TicketCount;

public class OutputView {

    private static final String GUIDE_INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String GUIDE_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String GUIDE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public void printInputAmount() {
        System.out.println(GUIDE_INPUT_AMOUNT);
    }

    public void printPurchasedLottos(TicketCount ticketCount, PurchasedLottos purchasedLottos) {
        printTicketCount(ticketCount);
        printTicketNumbers(purchasedLottos);
    }

    private void printTicketCount(TicketCount ticketCount) {
        System.out.println(System.lineSeparator() + ticketCount.get() + TICKET_COUNT_MESSAGE);
    }

    private void printTicketNumbers(PurchasedLottos purchasedLottos) {
        for (Lotto nowTicket : purchasedLottos.get()) {
            System.out.println(nowTicket.get());
        }
    }

    public void printInputWinningNumbers() {
        System.out.println(System.lineSeparator() + GUIDE_INPUT_WINNING_NUMBERS);
    }

    public void printInputBonusNumbers() {
        System.out.println(System.lineSeparator() + GUIDE_INPUT_BONUS_NUMBER);
    }
}
