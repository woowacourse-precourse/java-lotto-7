package lotto.view;

import lotto.model.Lottos;
import lotto.model.Result;
import lotto.utils.OutputConvertor;

public class OutputView {

    private static final String PURCHASE_LOTTOS_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String RESULT_MESSAGE = "당첨 통계\n---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printPurchaseLottos(Lottos lottos) {
        System.out.printf(PURCHASE_LOTTOS_MESSAGE, OutputConvertor.formatPurchaseLottosCount(lottos));
        System.out.println(OutputConvertor.formatLottos(lottos));
    }

    public static void printResult(Result result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(OutputConvertor.formatResult(result));
        System.out.printf(RATE_OF_RETURN_MESSAGE, result.getRateOfReturn());
    }

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
