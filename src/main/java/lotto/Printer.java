package lotto;

import java.util.List;

public class Printer {

    public void printInputAmount() {
        System.out.println("로또 구입 금액을 입력해 주세요.");
    }

    public void promptWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void promptBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoPurchaseCount(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void printWinningStatistics(List<Integer> prizeCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize prize : Prize.values()) {
            System.out.println(prize.getDescription() + " - " + prizeCount.get(prize.ordinal()) + "개");
        }
    }

    public void printProfitability(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
