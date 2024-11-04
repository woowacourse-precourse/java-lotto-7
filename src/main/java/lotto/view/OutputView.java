package lotto.view;

import java.util.List;
import lotto.model.constant.Match;

public class OutputView {
    private static void printEnter() {
        System.out.println();
    }

    public static void printBuyLotto(final int amount) {
        printEnter();
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printLottoNumber(final List<List<Integer>> numbers) {
        for (List<Integer> number : numbers) {
            System.out.println(number);
        }
        printEnter();
    }

    public static void printMatchNumbers(final int three, final int four, final int five, final int fiveAndBonus, final int six) {
        printResult();
        System.out.println(Match.THREE.getCount() + "개 일치 (" + Match.THREE.getPrizeLabel() + ") - " + three + "개");
        System.out.println(Match.FOUR.getCount() + "개 일치 (" + Match.FOUR.getPrizeLabel() + ") - " + four + "개");
        System.out.println(Match.FIVE.getCount() + "개 일치 (" + Match.FIVE.getPrizeLabel() + ") - " + five + "개");
        System.out.println(Match.BONUS.getCount() + "개 일치, 보너스 볼 일치 (" + Match.BONUS.getPrizeLabel() + ") - " + fiveAndBonus + "개");
        System.out.println(Match.SIX.getCount() + "개 일치 (" + Match.SIX.getPrizeLabel() + ") - " + six + "개");
    }

    private static void printResult() {
        printEnter();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printProfit(final double rate) {
        System.out.println("총 수익률은 " + rate +"%입니다.");
    }
}
