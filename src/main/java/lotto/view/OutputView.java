package lotto.view;

import lotto.model.Lottos;
import lotto.model.Result;

public class OutputView {

    private static final String COUNT_PURCHASE_LOTTO = "개를 구매했습니다.";
    private static final String RESULT_LIST = "당첨 통계";
    private static final String DIVIDE_LINE = "---";
    private static final String TOTAL_PRIZE_RATE = "총 수익률은 %s입니다.";

    public static void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.getSize() + COUNT_PURCHASE_LOTTO);
        System.out.println(lottos.getLottos());
    }

    public static void printResult(Result result) {
        System.out.println(RESULT_LIST);
        System.out.println(DIVIDE_LINE);
        System.out.println(result.getResult());
    }

    public static void printPrizeRate(String result) {
        System.out.printf(TOTAL_PRIZE_RATE, result);
    }
}
