package lotto.view;

import lotto.model.Lottos;
import lotto.model.Result;
import lotto.utils.OutputHandler;

public class OutputView {

    private static final String PURCHASE_LOTTOS_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String RESULT_MESSAGE = "당첨 통계\n---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printPurchaseLottos(Lottos lottos) {
        System.out.printf(PURCHASE_LOTTOS_MESSAGE, OutputHandler.formatPurchaseLottosCount(lottos));
        System.out.println(OutputHandler.formatLottos(lottos));
    }

    public static void printResult(Result result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(OutputHandler.formatResult(result));
    }

    public static void printRateOfReturn(Result result) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, result.getRateOfReturn());
    }

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
