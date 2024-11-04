package lotto.View;

import java.util.List;

public class OutputView {
    public void printPurchaseResult(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printStatisticsTitle() {
        System.out.println("\n당첨 통계\n---");
    }

    public void printMatchResult(String message, int count) {
        System.out.println(message + " - " + count + "개");
    }

    public void printProfitRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rate);
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}