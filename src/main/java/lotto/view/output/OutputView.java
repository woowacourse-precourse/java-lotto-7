package lotto.view.output;

import lotto.model.Lotto;
import lotto.utils.constants.LottoPrize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printGetPrice() {
        printMessage(OutputMessages.LOTTO_INPUT_PRICE_MESSAGE.getMessage());
    }

    public void printLottoNumber() {
        printMessage(OutputMessages.LOTTO_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public void printLottoBonusNumber() {
        printMessage(OutputMessages.LOTTO_BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public void printPurchasedLottoCount(Integer count) {
        printMessage(count + OutputMessages.LOTTO_PURCHASE_TOTAL_COUNT.getMessage());
    }

    public void printLottoPurchaseList(List<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            printMessage(lotto.toString());
        }
    }

    public void resultStatistics(List<LottoPrize> resultPrize, double resultProfitRate) {
        Map<LottoPrize, Integer> prizeCountMap = initializePrizeCountMap();
        updatePrizeCount(prizeCountMap, resultPrize);

        printStatistics(prizeCountMap, resultProfitRate);
    }

    private Map<LottoPrize, Integer> initializePrizeCountMap() {
        Map<LottoPrize, Integer> prizeCountMap = new HashMap<>();
        for (LottoPrize prize : LottoPrize.values()) {
            prizeCountMap.put(prize, 0);
        }

        return prizeCountMap;
    }

    private void updatePrizeCount(Map<LottoPrize, Integer> prizeCountMap, List<LottoPrize> resultPrize) {
        for (LottoPrize prize : resultPrize) {
            prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
        }
    }

    private void printStatistics(Map<LottoPrize, Integer> prizeCountMap, double resultProfitRate) {
        printMessage(OutputMessages.STATISTICS_TITLE.getMessage());
        printMessage(OutputMessages.STATISTICS_DIVIDER.getMessage());

        printMatchStatistics(prizeCountMap);
        printMessage(String.format(OutputMessages.TOTAL_PROFIT_RATE_OUTPUT.getMessage(), resultProfitRate));
    }

    private void printMatchStatistics(Map<LottoPrize, Integer> prizeCountMap) {
        printMessage(String.format(OutputMessages.MATCH_3_OUTPUT.getMessage(), prizeCountMap.get(LottoPrize.LOTTO_MATCH_5TH)));
        printMessage(String.format(OutputMessages.MATCH_4_OUTPUT.getMessage(), prizeCountMap.get(LottoPrize.LOTTO_MATCH_4TH)));
        printMessage(String.format(OutputMessages.MATCH_5_OUTPUT.getMessage(), prizeCountMap.get(LottoPrize.LOTTO_MATCH_3RD)));
        printMessage(String.format(OutputMessages.MATCH_5_BONUS_OUTPUT.getMessage(), prizeCountMap.get(LottoPrize.LOTTO_MATCH_2ND)));
        printMessage(String.format(OutputMessages.MATCH_6_OUTPUT.getMessage(), prizeCountMap.get(LottoPrize.LOTTO_MATCH_1ST)));
    }
}
