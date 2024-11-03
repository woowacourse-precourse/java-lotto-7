package lotto.view;

import java.util.EnumMap;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;

public class OutputHandler {
    private static final String PURCHASE_FINISH_MESSAGE = "개를 구매했습니다.";
    private static final String TOTAL_RATE_OF_RETURN_MESSAGE = "총 수익률은 ";
    private static final String SYMBOL_PERCENT = "%";
    private static final String SYMBOL_HYPHEN = " - ";
    private static final String ENDING_SUFFIX = "입니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String OPEN_ROUND_BRACKET = " (";
    private static final String CLOSE_ROUND_BRACKET = ")";
    private static final String AMOUNT_ENDING_SUFFIX = "개";

    public static OutputHandler instance;

    private OutputHandler() {}

    // synchronized 키워드: 두개의 쓰레드가 동시에 인스턴스를 생성하는 상황 방지
    public static synchronized OutputHandler getInstance() {
        if (instance == null) {
            instance = new OutputHandler();
        }
        return instance;
    }

    public void printLottoStatus(Lottos lottos) {
        printNewLine();
        System.out.println(lottos.size() + PURCHASE_FINISH_MESSAGE);

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        printNewLine();
    }

    public void printLottoResults(EnumMap<Prize, Integer> prizeResult) {
        printNewLine();
        printResultNotice();

        // 당첨 결과 출력
        for (Prize currentPrize : Prize.values()) {
            printLottoResultOf(currentPrize, prizeResult.get(currentPrize));
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(TOTAL_RATE_OF_RETURN_MESSAGE + rateOfReturn + SYMBOL_PERCENT + ENDING_SUFFIX);
    }

    private void printNewLine() {
        System.out.println();
    }

    private void printResultNotice() {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVIDER);
    }

    private void printLottoResultOf(Prize prize, int count) {
        System.out.println(
                prize.getCondition() + OPEN_ROUND_BRACKET + prize.getPrizeMoney() + CLOSE_ROUND_BRACKET + SYMBOL_HYPHEN
                        + count + AMOUNT_ENDING_SUFFIX);
    }
}
