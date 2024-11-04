package lotto.view;

import java.util.List;

public class OutputView {

    public void showPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void showLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void showResultHeadline() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public void showPrizeCount(String description, int count) {
        System.out.printf("%s - %d개%n", description, count);
    }

    public void showProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profit);
    }

    public void showError(String message) {
        System.out.println(message);
    }
}
