package lotto.view;

import java.util.List;

public class PrintMessages {
    private static final String INPUT_MONEY_MSG         = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER_MSG    = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MSG  = "보너스 번호를 입력해 주세요.";
    private static final String OUT_BUY_MSG             = "개를 구매했습니다.";
    private static final String OUT_DASH_MSG            = "---";
    private static final String OUT_RESULT_MSG          = "당첨 통계";

    private PrintMessages() {}

    public static void printInputMoneyMsg() {
        System.out.println(INPUT_MONEY_MSG);
    }

    public static void printInputWinNumberMsg() {
        System.out.println(INPUT_WIN_NUMBER_MSG);
    }

    public static void printInputBonusNumberMsg() {
        System.out.println(INPUT_BONUS_NUMBER_MSG);
    }

    public static void printBuyMsg(int count) {
        System.out.println(count + OUT_BUY_MSG);
    }

    public static void printCreatePaperMsg(List<Integer> paper) {
        System.out.println(paper);
    }
    public static void printResultMsg() {
        System.out.println(OUT_RESULT_MSG);
        System.out.println(OUT_DASH_MSG);
    }

    public static void printRoiMsg(List<Integer> matchCount, double roi) {
        System.out.println("3개 일치 (5,000원) - "                      + matchCount.get(1) + "개");
        System.out.println("4개 일치 (50,000원) - "                     + matchCount.get(2) + "개");
        System.out.println("5개 일치 (1,500,000원) - "                  + matchCount.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "   + matchCount.get(4) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - "              + matchCount.get(5) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", roi);
    }

}
