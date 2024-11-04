package lotto.view;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.LottoPrice;

public class LottoOutputView {
    public void printInputLottoMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottosNumber(List<List<Integer>> lottosNumbers) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottosNumbers.size());
        for (List<Integer> lottoNumber : lottosNumbers) {
            System.out.println(lottoNumber);
        }
    }

    public void printWinningNumbersMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printLottoWinPrice(HashMap<LottoPrice, Integer> prices) {
        System.out.println("\n당첨 통계\n---");
        for (LottoPrice lottoPrice : LottoPrice.getValues()) {
            lottoPrice.print(prices.getOrDefault(lottoPrice, 0));
        }
    }

    public void printProfitRate(Map<LottoPrice, Integer> prices, int lottoCount) {
        long profit = 0L;
        for (var price : prices.entrySet()) {
            profit += price.getKey().getProfit(price.getValue());
        }
        double profitRate = (double) profit / (double) (lottoCount * LOTTO_PRICE);
        double profitPercentage = (double) Math.round(profitRate * 1000) / 10;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitPercentage);
    }
}
