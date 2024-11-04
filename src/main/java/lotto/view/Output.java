package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoReward;
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
        System.out.println(
            "6개 일치 (" + formatReward(LottoReward.MATCH_6_REWARD.getReward()) + ") - " + results.getOrDefault(1, 0)
                + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + formatReward(LottoReward.MATCH_5_BONUS_REWARD.getReward()) + ") - "
            + results.getOrDefault(2, 0) + "개");
        System.out.println(
            "5개 일치 (" + formatReward(LottoReward.MATCH_5_REWARD.getReward()) + ") - " + results.getOrDefault(3, 0)
                + "개");
        System.out.println(
            "4개 일치 (" + formatReward(LottoReward.MATCH_4_REWARD.getReward()) + ") - " + results.getOrDefault(4, 0)
                + "개");
        System.out.println(
            "3개 일치 (" + formatReward(LottoReward.MATCH_3_REWARD.getReward()) + ") - " + results.getOrDefault(5, 0)
                + "개");

        double profitRate = ((double) statistics.getTotalPrize() / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private String formatReward(int reward) {
        return String.format("%,d원", reward);
    }
}
