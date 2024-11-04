package lotto;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class Printer {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.out.println(Constants.FORM_ERROR_MESSAGE + message);
    }

    public static void printIssueResult(Lotto ticket) {
        ArrayList<Integer> numbers = ticket.getNumbersArrayList();
        System.out.printf("[%d, %d, %d, %d, %d, %d]%n"
                , numbers.get(0)
                , numbers.get(1)
                , numbers.get(2)
                , numbers.get(3)
                , numbers.get(4)
                , numbers.get(5));
    }

    public static void printCalculateResult(Data data) {
        System.out.println(Constants.INFORM_STATISTICS);
        setValuesAndCallPrintRanks(data);
        printStatistics(data);
    }

    private static void setValuesAndCallPrintRanks(Data data) {
        for (Result result : data.getResults()) {
            int rankCount = result.getRank().getMatchCount();
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String prize = decimalFormat.format(result.getRank().getPrize());
            int matchCount = result.getWonCount();

            if (result.getRank() == Rank.SECOND) {
                printRanksBonus(rankCount, prize, matchCount);
                continue;
            }
            printRanksNormal(rankCount, prize, matchCount);
        }
    }

    private static void printRanksNormal(int rankCount, String prize, int matchCount) {
        System.out.printf(Constants.FORM_RANKS_NORMAL_MESSAGE, rankCount, prize, matchCount);
    }

    private static void printRanksBonus(int rankCount, String prize, int matchCount) {
        System.out.printf(Constants.FORM_RANKS_BONUS_MESSAGE, rankCount, prize, matchCount);
    }

    private static void printStatistics(Data data) {
        double rate = ResultCalculator.calculateRateOfReturn(data);
        String rateString = setRateString(rate);
        System.out.printf("총 수익률은 %s%%입니다.%n", rateString);
    }

    private static String setRateString(double rate) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(rate);
    }
}