package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Output {
    public static void printPurchaseAmountRequestMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumberRequestMessage(int count) {
        printBlankLine();
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningNumberRequestMessage() {
        printBlankLine();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberRequestMessage() {
        printBlankLine();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printRunResultMessage() {
        printBlankLine();
        System.out.println("당첨 통계");
    }

    public static void printLine() {
        System.out.println("---");
    }

    private static void printBlankLine() {
        System.out.println();
    }
}
