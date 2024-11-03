package lotto.ui;

import lotto.models.LottoResults;
import lotto.models.constants.RewardTable;
import lotto.ui.constants.ResultText;

import java.util.List;

public class OutputView {
    public void printPurchasedMessage(int amount) {
        System.out.println("\n" + amount + ResultText.PURCHASED.getText());
    }

    public void printLottoResults(LottoResults lottoResults) {
        System.out.println(ResultText.RESULT_HEADER.getText());
        RewardTable[] rewardTableKeys = RewardTable.values();
        for (RewardTable key : rewardTableKeys) {
            int value = lottoResults.getMatchValue(key);
            System.out.println(key.getLabel() + value + ResultText.COUNT_SUFFIX.getText());
        }
    }

    public void printProfit(double profit) {
        System.out.println(ResultText.RETURN_RATE_PREFIX.getText() + profit + ResultText.RETURN_RATE_SUFFIX.getText());
    }

    public void printIntegerList(List<Integer> list) {
        System.out.println(list);
    }
}
