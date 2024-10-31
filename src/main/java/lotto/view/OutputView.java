package lotto.view;

import java.util.List;

public class OutputView {
    private static final String BUY_LOTTO = "개를 구매했습니다.";

    private static final String THREE_MATCH = "3";
    private static final String FOUR_MATCH = "4";
    private static final String FIVE_MATCH = "5";
    private static final String SIX_MATCH = "6";

    private static final String THREE_MATCH_MONEY = "5,000원";
    private static final String FOUR_MATCH_MONEY = "50,000원";
    private static final String FIVE_MATCH_MONEY = "1,500,000원";
    private static final String BONUS_MATCH_MONEY = "30,000,000원";
    private static final String SIX_MATCH_MONEY = "2,000,000,000원";

    private static void printEnter() {
        System.out.println();
    }

    public static void printBuyLotto(int amount) {
        printEnter();
        System.out.println(amount + BUY_LOTTO);
    }

    public static void printLottoNumber(List<List<Integer>> numbers) {
        for (List<Integer> number : numbers) {
            System.out.println(number);
        }
        printEnter();
    }

    public static void printMatchNumbers(int three, int four, int five, int fiveAndBonus, int six) {
        printResult();
        System.out.println(THREE_MATCH + "개 일치 " + "(" + THREE_MATCH_MONEY + ") - " + three + "개");
        System.out.println(FOUR_MATCH + "개 일치 " + "(" + FOUR_MATCH_MONEY + ") - " + four + "개");
        System.out.println(FIVE_MATCH + "개 일치 " + "(" + FIVE_MATCH_MONEY + ") - " + five + "개");
        System.out.println(FIVE_MATCH + "개 일치, 보너스 볼 일치 " + "(" + BONUS_MATCH_MONEY + ") - " + fiveAndBonus + "개");
        System.out.println(SIX_MATCH + "개 일치 " + "(" + SIX_MATCH_MONEY + ") - " + six + "개");
    }

    private static void printResult() {
        printEnter();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printProfit(double rate) {
        System.out.println("총 수익률은 " + rate +"%입니다.");
    }
}
