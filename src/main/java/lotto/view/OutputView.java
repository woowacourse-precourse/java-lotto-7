package lotto.view;

import lotto.model.lotto.Lotto;
import lotto.model.result.LottoResult;
import lotto.model.result.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLottoAmount(int input) {
        System.out.println(input + "개를 구매했습니다.");
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 %.1f%%입니다." + rateOfReturn);
    }

    public void printWinningStatisticHeader() {
        System.out.println("당첨 통계\n---");
    }
}
