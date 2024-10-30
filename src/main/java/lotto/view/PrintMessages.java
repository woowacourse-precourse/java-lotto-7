package lotto.view;

public class PrintMessages {
    private PrintMessages() {}
    private static final String INPUT_MONEY_MSG         = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER_MSG    = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MSG  = "보너스 번호를 입력해 주세요.";
    private static final String OUT_BUY_MSG             = "개를 구매했습니다.";
    private static final String OUT_WIN_COUNT_MSG       = "개 일치";
    private static final String OUT_WIN_BONUS_MSG       = ", 보너스 볼 일치";
    private static final String OUT_DASH_MSG            = "---";
    private static final String OUT_ROI_MSG             = "당첨 통계";

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

    public static void printWinCountMsg(int count) {
        System.out.println(count + OUT_WIN_COUNT_MSG);
    }

    public static void printWinBonusMsg() {
        System.out.println(OUT_WIN_BONUS_MSG);
    }

    public static void printDash() {
        System.out.println(OUT_DASH_MSG);
    }

    public static void printRoiMsg() {
        System.out.println(OUT_ROI_MSG);
    }

}
