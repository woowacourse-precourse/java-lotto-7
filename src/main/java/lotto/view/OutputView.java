package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.common.Prompts;
import lotto.model.LottoRank;

public class OutputView {
    public void showPurchaseCount(int count) {
        System.out.println(count + Prompts.OUTPUT_PURCHASE_COUNT_PROMPT);
    }

    public void showLottoNumbers(String lottoNumbers, int lottoCount) {
        System.out.println(lottoCount + Prompts.OUTPUT_PURCHASE_COUNT_PROMPT);
        System.out.println(lottoNumbers);
    }

    public void showStatistics(List<String> results, double profit, Map<LottoRank, Integer> rankCount) {
        System.out.println(Prompts.OUTPUT_STATISTICS_PROMPT);
        System.out.println(Prompts.OUTPUT_STATISTICS_DECO);
//        showLottoResults(results);
        showRankStatistics(rankCount);
        System.out.print(Prompts.OUTPUT_PERCENTAGE_PROMPT_PRE);
        showCalculatedProfit(profit);
        System.out.print(Prompts.OUTPUT_PERCENTAGE_PROMPT_POST);
    }

//    private void showLottoResults(List<String> result) {
//        for (String s : result) {
//            System.out.println(s);
//        }
//    }

    private void showCalculatedProfit(double profit) {
        System.out.print(Math.round(profit * 100.0) / 100.0 + Prompts.OUTPUT_PERCENTAGE_UNIT);
    }

    private void showRankStatistics(Map<LottoRank, Integer> rankCount) {
        for (Map.Entry<LottoRank, Integer> entry : rankCount.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            System.out.println(rank.getMessage() + count + "개");
        }
    }

}
