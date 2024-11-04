package lotto.view;

import lotto.enums.LottoRank;
import lotto.enums.Message;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchaseAmountInputMessage() {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println(Message.INPUT_WINNING_NUMBERS.getMessage());
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
    }

    public static void printPurchaseCount(int count) {
        String message = String.format(Message.PURCHASE_SUFFIX.getMessage(), count);
        System.out.println(message);
    }

    public static void printPurchasedLottoNumbers(List<Integer> lottoNumbers) {
        List<Integer> numbers = sortAscending(lottoNumbers);
        System.out.println(numbers);
    }

    public static List<Integer> sortAscending(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> lottoRankCount) {
        System.out.println("당첨 통계\n---");

        Map<LottoRank, String> rankInfo = LottoRank.getRankInfo();

        for (LottoRank rank : rankInfo.keySet()) {
            int count = lottoRankCount.getOrDefault(rank, 0);
            System.out.printf("%s - %d개%n", rankInfo.get(rank), count);
        }
    }

    public static void printTotalProfitRate(double profitRate) {
        System.out.printf(Message.TOTAL_PROFIT_RATE.getMessage(), formatProfitRate(profitRate));
    }

    public static void printExceptionMessage(String message) {
        System.out.println(Message.ERROR_PREFIX.getMessage() + message);
    }

    private static String formatProfitRate(double profitRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(profitRate);
    }
}
