package lotto.view;

import java.text.DecimalFormat;
import lotto.model.Lotto;
import lotto.model.PurchasedLottos;
import lotto.model.TicketCount;

public class OutputView {

    private static final String GUIDE_INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String GUIDE_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String GUIDE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String HEADER_WINNING_RESULT = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String UNIT = "개";
    private static final String RATE_OF_PROFIT = "총 수익률은 ";
    private static final String FOOTER_PROFIT = "%입니다.";
    private static final String NUMBER_FORMAT = "#,###.0";

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

    public void printHeaderWinningResult() {
        System.out.println(System.lineSeparator() + HEADER_WINNING_RESULT);
        System.out.println(SEPARATOR);
    }

    public void printRankResult(String rank, int count) {
        System.out.println(rank + count + UNIT);
    }

    public void printRateOfProfit(double rateOfProfit){
        DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
        System.out.println(RATE_OF_PROFIT + decimalFormat.format(rateOfProfit) + FOOTER_PROFIT);
    }
}
