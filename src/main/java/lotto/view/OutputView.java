package lotto.view;

import java.util.List;

public class OutputView {
    public static void displayMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void displayCount(int count) {
        System.out.println();
        System.out.println(count+"개를 구매했습니다.");

    }

    public static void displayWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void displayBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void displayIssuedLotto(List<Integer> issued) {
        System.out.println(issued);
    }
}
