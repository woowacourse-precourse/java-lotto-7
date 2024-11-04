package lotto.global.io;

import lotto.domain.Lotteries;
import lotto.domain.util.Statistics;

public class OutputConsole {

    private static OutputConsole instance;

    private OutputConsole() {
    }

    public static OutputConsole getInstance() {
        if (instance == null) {
            instance = new OutputConsole();
        }
        return instance;
    }

    public void printPurchaseMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseResult(Lotteries lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        System.out.println(lotteries);
    }

    public void printWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printProfitStatistics(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(statistics);
    }

    public void printProfitRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }
}
