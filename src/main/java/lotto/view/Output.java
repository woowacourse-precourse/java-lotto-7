package lotto.view;

import lotto.model.Lotto;
import lotto.model.Statistics;

import java.util.List;
import java.util.Map;

public class Output {

    private final String MATCHSIX = "2,000,000,000원";
    private final String MATCHFIVEBONUS = "5,000,000원";
    private final String MATCHFIVE = "1,500,000원";
    private final String MATCHFOUR = "50,000원";
    private final String MATCHTHREE = "5,000원";

    public void printPrompt(Prompt prompt) {
        System.out.println(prompt.getMessage());
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printStatistics(Statistics statistics, int purchaseAmount) {
        Map<Integer, Integer> results = statistics.getResults();

        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("6개 일치 (" + MATCHSIX + ") - " + results.getOrDefault(1, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + MATCHFIVEBONUS + ") - " + results.getOrDefault(2, 0) + "개");
        System.out.println("5개 일치 (" + MATCHFIVE + ") - " + results.getOrDefault(3, 0) + "개");
        System.out.println("4개 일치 (" + MATCHFOUR + ") - " + results.getOrDefault(4, 0) + "개");
        System.out.println("3개 일치 (" + MATCHTHREE + ") - " + results.getOrDefault(5, 0) + "개");

        double profitRate = ((double) statistics.getTotalPrize() / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
