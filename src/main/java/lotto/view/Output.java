package lotto.view;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.WinAmount;

public class Output {
    private static boolean isFirstOutput = true;

    public static void buyLottoPrint(List<Integer> lottoNumber, int count) {
        if (isFirstOutput) {
            System.out.println("\n" + count + "개를 구매했습니다.");
            isFirstOutput = false;
        }
        System.out.println(lottoNumber.toString());
    }

    public static void result(EnumMap<WinAmount, Integer> e) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinAmount winAmount : e.keySet()) {
            ResultPrint(e, winAmount);
            fiveBonusPrint(e, winAmount);
        }
    }

    public static void fiveBonusPrint(EnumMap<WinAmount, Integer> e, WinAmount winAmount) {
        if (winAmount == WinAmount.FiveBonus) {
            System.out.println(
                    winAmount.getNumber() + "개 일치, 보너스 볼 일치 (" + winAmount.getAmount() + ") - " + e.get(winAmount)
                            + "개");
        }
    }

    public static void ResultPrint(EnumMap<WinAmount, Integer> e, WinAmount winAmount) {
        if (winAmount != WinAmount.FiveBonus) {
            System.out.println(
                    winAmount.getNumber() + "개 일치 (" + winAmount.getAmount() + ") - " + e.get(winAmount) + "개");
        }
    }

    public static void adventure(double a) {
        System.out.printf("총 수익률은 %.1f%%입니다.", a);
    }
}
