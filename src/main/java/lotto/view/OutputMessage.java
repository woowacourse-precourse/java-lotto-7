package lotto.view;

import lotto.constants.messageType.OutputMessageType;

public class OutputMessage {

    public static void buyLottoCount(int lottoTicketCount) {
        System.out.println("\n" + lottoTicketCount + OutputMessageType.OUTPUT_BUY_LOTTO_MESSAGE_GUIDE.getMessage());
    }

    public static void buyLottoResults(String buyLottoResults) {
        System.out.println(buyLottoResults + "\n");
    }

    public static void winningStatistics() {
        System.out.println(OutputMessageType.OUTPUT_WINNING_STATISTICS.getMessage());
    }

    public static void winningsYield(double yield) {
        System.out.printf(OutputMessageType.OUTPUT_WINNING_YIELD.getMessage(), yield);
    }

}
