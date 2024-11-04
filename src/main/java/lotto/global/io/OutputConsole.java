package lotto.global.io;

import java.io.PrintStream;
import lotto.domain.Lotteries;
import lotto.domain.util.Statistics;

public class OutputConsole {

    private static OutputConsole instance;

    private final PrintStream out;

    private OutputConsole(PrintStream out) {
        this.out = out;
    }

    public static OutputConsole getInstance() {
        assert instance != null : "OutputConsole has not been initialized";
        return instance;
    }

    public static void init(PrintStream out) {
        assert instance == null : "Already initialized";
        instance = new OutputConsole(out);
    }

    public void printPurchaseMessage() {
        out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseResult(Lotteries lotteries) {
        out.println(lotteries.size() + "개를 구매했습니다.");
        out.println(lotteries);
    }

    public void printWinningNumberMessage() {
        out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        out.println("보너스 번호를 입력해 주세요.");
    }

    public void printProfitStatistics(Statistics statistics) {
        out.println("당첨 통계");
        out.println("---");
        out.println(statistics);
    }

    public void printProfitRate(double rate) {
        out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }

    public void printError(Exception e) {
        out.println(e.getMessage());
    }
}
