package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Output {
    public static void printPurchaseAmountRequestMessage() {
        System.out.println(OutputMessage.PURCHASE_AMOUNT_REQUEST);
    }

    public static void printNumberRequestMessage(int count) {
        printBlankLine();
        System.out.println(count + OutputMessage.LOTTO_PURCHASE_COUNT_MESSAGE);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningNumberRequestMessage() {
        printBlankLine();
        System.out.println(OutputMessage.WINNING_NUMBER_REQUEST);
    }

    public static void printBonusNumberRequestMessage() {
        printBlankLine();
        System.out.println(OutputMessage.BONUS_NUMBER_REQUEST);
    }

    public static void printWinningResultsHeader() {
        printBlankLine();
        System.out.println(OutputMessage.MESSAGE_WINNING_STATISTICS);
    }

    public static void printLine() {
        System.out.println(OutputMessage.LINE);
    }

    public static void printLottoRankResult(Map<LottoWinningRanks, Integer> rankCounts) {
        createRankMessages().forEach((rank, message) -> {
            int count = rankCounts.getOrDefault(rank, OutputMessage.NO_COUNT);
            System.out.printf("%s - %d개%n", message, count);
        });
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(OutputMessage.RATE_OF_RETURN_FORMAT, rateOfReturn);
    }

    private static Map<LottoWinningRanks, String> createRankMessages() {
        Map<LottoWinningRanks, String> messages = new LinkedHashMap<>();
        messages.put(LottoWinningRanks.FIFTH, OutputMessage.LOTTO_RESULT_FIFTH);
        messages.put(LottoWinningRanks.FOURTH, OutputMessage.LOTTO_RESULT_FOURTH);
        messages.put(LottoWinningRanks.THIRD, OutputMessage.LOTTO_RESULT_THIRD);
        messages.put(LottoWinningRanks.SECOND, OutputMessage.LOTTO_RESULT_SECOND);
        messages.put(LottoWinningRanks.FIRST, OutputMessage.LOTTO_RESULT_FIRST);
        return messages;
    }

    private static void printBlankLine() {
        System.out.println();
    }
}
