package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;

import java.util.List;

import static lotto.util.constant.LottoConstants.ZERO;

public class OutputResult extends OutputView {

    /**
     * Constants that only use in OutputView
     */
    // Message for Result header or tail
    public static final String RESULT_NEW_LOTTO_COUNT = "개를 구매했습니다.";
    public static final String RESULT_STATISTICS_HEADER = "당첨 통계\n---";
    public static final String RESULT_PROFIT_RATE_HEADER = "총 수익률은 ";
    public static final String RESULT_PROFIT_RATE_TAIL = "%입니다.";

    /**
     * METHODS
     */

    public static void printNewLotto(List<Lotto> Lotto){
        printEmptyLine();
        System.out.println( Lotto.size() + RESULT_NEW_LOTTO_COUNT );
        for (Lotto lotto : Lotto) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStatus(LottoResult lottoResult){
        printEmptyLine();
        System.out.println(RESULT_STATISTICS_HEADER);
        for (LottoPrize prize : LottoPrize.values()) {
            if(prize.getPrizeMoney() != ZERO)
                System.out.println(prize.toString() + LottoResult.getPrizeCount(prize) + "개");
        }
    }

    public static void printTotalProfit(float profit) {
        System.out.println(RESULT_PROFIT_RATE_HEADER + profit + RESULT_PROFIT_RATE_TAIL);
    }

}
