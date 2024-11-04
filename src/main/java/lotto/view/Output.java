package lotto.view;

import java.util.EnumMap;
import java.util.List;
import lotto.constants.ViewMessage;
import lotto.domain.WinAmount;

public class Output {
    private static boolean isFirstOutput = true;

    public static void buyLottoPrint(List<Integer> lottoNumber, int count) {
        if (isFirstOutput) {
            System.out.println(ViewMessage.NEWLINE.getMessage() + count + ViewMessage.OUTPUT_BUY_COUNT.getMessage());
            isFirstOutput = false;
        }
        System.out.println(lottoNumber.toString());
    }

    public static void result(EnumMap<WinAmount, Integer> e) {
        System.out.println();
        System.out.println(ViewMessage.WINNING_STATISTICS.getMessage());
        System.out.println(ViewMessage.SEPARATOR1.getMessage());
        for (WinAmount winAmount : e.keySet()) {
            ResultPrint(e, winAmount);
            fiveBonusPrint(e, winAmount);
        }
    }

    public static void fiveBonusPrint(EnumMap<WinAmount, Integer> e, WinAmount winAmount) {
        if (winAmount == WinAmount.FiveBonus) {
            System.out.println(
                    winAmount.getNumber() + ViewMessage.FIVE_BONUS.getMessage() + winAmount.getAmount()
                            + ViewMessage.SEPARATOR2.getMessage() + e.get(winAmount)
                            + ViewMessage.HOW_MANY_COUNT.getMessage());
        }
    }

    public static void ResultPrint(EnumMap<WinAmount, Integer> e, WinAmount winAmount) {
        if (winAmount != WinAmount.FiveBonus) {
            System.out.println(
                    winAmount.getNumber() + ViewMessage.LOTTO_MATCH.getMessage() + winAmount.getAmount()
                            + ViewMessage.SEPARATOR2.getMessage() + e.get(winAmount)
                            + ViewMessage.HOW_MANY_COUNT.getMessage());
        }
    }

    public static void adventure(double a) {
        System.out.printf(ViewMessage.PROFIT_PERCENTAGE.getMessage(), a);
    }
}
