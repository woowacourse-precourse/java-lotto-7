package lotto;

import java.util.List;

public class OutputView {

    public static void promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void promptWinningNumbersInput() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void promptBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }
}