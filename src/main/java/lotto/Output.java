package lotto;

import java.util.List;
import java.util.Map;

public class Output {

    private static final String PURCHASE_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_HEADER = """
            
            당첨 통계
            ---
            """;
    private static final String RESULT_FORMAT = """
            3개 일치 (5,000원) - %s개
            4개 일치 (50,000원) - %s개
            5개 일치 (1,500,000원) - %s개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %s개
            6개 일치 (2,000,000,000원) - %s개
            총 수익률은 %s%%입니다.
            """;
    private static final String YIELD_FORMAT = "%.1f";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void printPurchaseLotto(List<Lotto> lottos) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResult(Map<LottoPrize, Integer> winningResult, double yield) {
        String result = WINNING_STATISTICS_HEADER + RESULT_FORMAT.formatted(
                winningResult.get(LottoPrize.FIFTH),
                winningResult.get(LottoPrize.FOURTH),
                winningResult.get(LottoPrize.THIRD),
                winningResult.get(LottoPrize.SECOND),
                winningResult.get(LottoPrize.FIRST),
                String.format(YIELD_FORMAT, yield)
        );
        System.out.println(result);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}
