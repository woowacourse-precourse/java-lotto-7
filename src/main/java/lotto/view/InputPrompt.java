package lotto.view;

import java.math.BigInteger;

public class InputPrompt {

    public static void printBudgetInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(BigInteger count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
