package lotto.view;

import lotto.LottoMatchState;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.Parser;

import java.util.Map;

public class OutputView {
    private static final String PURCHASE_OUTPUT_MESSAGE = "개를 구매했습니다.";
    private static final String STATS_OUTPUT_MESSAGE = "당첨 통계\n---";
    private static final String THREE_MATCHING_OUTPUT_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCHING_OUTPUT_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCHING_OUTPUT_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_MATCHING_BONUS_OUTPUT_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_MATCHING_OUTPUT_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String PROFIT_RATE_OUTPUT_MESSAGE_1 = "총 수익률은 ";
    private static final String PROFIT_RATE_OUTPUT_MESSAGE_2 = "% 입니다.";

    public void printIssuedLottos(Lottos lottos) {
        System.out.println();
        System.out.println(lottos.getLottos().size() + PURCHASE_OUTPUT_MESSAGE);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
    }

    public void printWinningDetail(Map<LottoMatchState, Integer> winningDetail) {
        System.out.println();
        System.out.println(STATS_OUTPUT_MESSAGE);
        System.out.println(THREE_MATCHING_OUTPUT_MESSAGE + winningDetail.getOrDefault(LottoMatchState.THREE, 0) + "개");
        System.out.println(FOUR_MATCHING_OUTPUT_MESSAGE + winningDetail.getOrDefault(LottoMatchState.FOUR, 0) + "개");
        System.out.println(FIVE_MATCHING_OUTPUT_MESSAGE + winningDetail.getOrDefault(LottoMatchState.FIVE, 0) + "개");
        System.out.println(FIVE_MATCHING_BONUS_OUTPUT_MESSAGE + winningDetail.getOrDefault(LottoMatchState.FIVE_BONUS, 0) + "개");
        System.out.println(SIX_MATCHING_OUTPUT_MESSAGE + winningDetail.getOrDefault(LottoMatchState.SIX, 0) + "개");
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_OUTPUT_MESSAGE_1 + "%.2f", profitRate);
        System.out.println(PROFIT_RATE_OUTPUT_MESSAGE_2);
    }
}
