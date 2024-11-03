package lotto.view;

import lotto.model.Lotto;
import lotto.model.Statistics;

import java.util.List;
import java.util.Map;

public class Output {

    public void printPrompt(Prompt prompt) {
        System.out.println(prompt.getMessage());
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printStatistics(Statistics statistics, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<String, Integer> results = statistics.getResults();
        System.out.println("3개 일치 (5,000원) - " + results.getOrDefault("5등", 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + results.getOrDefault("4등", 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.getOrDefault("3등", 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.getOrDefault("2등", 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.getOrDefault("1등", 0) + "개");

        double profitRate = ((double) statistics.getTotalPrize() / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
