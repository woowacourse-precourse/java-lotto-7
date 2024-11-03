package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinType;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    private final String LOTTO_COUNT = "\n%d개를 구매했습니다.\n";
    private final String RESULT_TITLE = "\n당첨 통계\n---";
    private final String RESULT_ROW = "%d개 일치 (%,d원) - %d개\n";
    private final String RESULT_ROW_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private final String RESULT_PRICE_RATIO = "총 수익률은 %.1f%%입니다.";

    public void printLottos(List<Lotto> lottos) {
        System.out.printf(LOTTO_COUNT, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printResult(HashMap<WinType, Integer> winCount, double priceRatio) {
        System.out.println(RESULT_TITLE);
        printResultByWinType(winCount);
        System.out.printf(RESULT_PRICE_RATIO, priceRatio);

    }

    private void printResultByWinType(HashMap<WinType, Integer> winCount) {
        for (WinType winType : WinType.ALL_WIN_TYPES) {
            int targetCount = winType.getCount();
            int targetPrice = winType.getPrice();
            int resultCount = winCount.getOrDefault(winType, 0);
            String resultFormat = findResultRowFormat(winType);
            System.out.printf(resultFormat, targetCount, targetPrice, resultCount);
        }
    }

    private String findResultRowFormat(WinType winType) {
        if (winType == WinType.FIVE_WITH_BONUS) {
            return RESULT_ROW_WITH_BONUS;
        }
        return RESULT_ROW;
    }
}