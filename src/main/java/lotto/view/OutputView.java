package lotto.view;

import lotto.constant.OutputMessage;

public class OutputView {
    public static void printPurchaseMessage(int purchaseCount) {
        System.out.println(System.lineSeparator() + purchaseCount + OutputMessage.PURCHASE_COUNT_MESSAGE.getMessage());
    }

    public static void printIssuedLottoOutput(String issuedNumbers) {
        System.out.println(issuedNumbers);
    }

    public static void printLineSeparator() {
        System.out.println(OutputMessage.LINE_SEPARATOR.getMessage());
    }

    public static void printStatisticMessage() {
        System.out.println(System.lineSeparator() + OutputMessage.STATISTICS_MESSAGE.getMessage());
    }

    public static void printLottoResultOutput(String rankMessage, int matchingCount) {
        System.out.println(rankMessage +
                OutputMessage.MATCHING_COUNT_MESSAGE.getMatchingCountMessage(matchingCount));
    }

    public static void printEarningRateOutput(double earningRate) {
        System.out.println(OutputMessage.EARNING_RATE_MESSAGE.getEarningRateMessage(earningRate));
    }

    public static void printErrorMessageOutput(String message) {
        System.out.println(message);
    }
}
