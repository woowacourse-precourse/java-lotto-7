package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoPrize;

public class OutputView {

    private static final String PURCHASED_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.\n";
    private static final String REPORT_FORMAT = "%d개 일치 (%d원) - %d개\n";
    private static final String YIELD_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printNumberOfPurchasedLottos(int count) {
        System.out.printf(PURCHASED_LOTTO_COUNT_FORMAT, count);
    }

    public void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printReport(Map<LottoPrize, Integer> matchCountMap) {
        for (LottoPrize prize : LottoPrize.values()) {
            System.out.printf(REPORT_FORMAT, prize.getMatchCount(), prize.getPrize(), matchCountMap.get(prize));
        }
    }

    public void printYield(double yield) {
        System.out.printf(YIELD_FORMAT, yield);
    }
}
