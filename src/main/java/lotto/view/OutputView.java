package lotto.view;

import static lotto.utils.Messages.*;

import java.text.DecimalFormat;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResultManager;
import lotto.model.enums.LottoResult;
import lotto.utils.Messages;

public class OutputView {

    public static void printBoughtLotto(LottoMachine lottoMachine) {
        System.out.println(lottoMachine.getCount() + BOUGHT_LOTTO);
        for (Lotto lotto : lottoMachine.getLottos()) {
            System.out.println(lotto.getFormattedNumbers());
        }
    }

    public static void printLottoResult() {
        printResultHeader();
        for (LottoResult lottoResult : LottoResult.values()) {
            System.out.printf((lottoResult.getMessage()) + "%n", lottoResult.getCount());
        }
    }

    private static void printResultHeader() {
        System.out.println(LOTTO_RESULT);
        System.out.println(DASH);
    }

    public static void printLottoProfit(LottoResultManager lottoResultManager) {
        DecimalFormat df = new DecimalFormat("#,##0.0"); // 항상 소수 첫째 자리까지 표시

        String formattedProfit = df.format(lottoResultManager.calculateProfit());
        System.out.println(PROFIT + formattedProfit + PERCENT);
    }
}
