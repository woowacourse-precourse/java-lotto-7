package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.util.constant.LottoConstants;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.constant.LottoConstants.*;

public class OutputView {

    /**
     * Constants that only use in OutputView
     */
    // Message for Input announcement
    public static final String MSG_INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String MSG_INPUT_WINNER_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String MSG_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    // Message for Result header or tail
    public static final String RESULT_NEW_LOTTO_COUNT = "개를 구매했습니다.";
    public static final String RESULT_STATISTICS_HEADER = "당첨 통계\n---";
    public static final String RESULT_PROFIT_RATE_HEADER = "총 수익률은 ";
    public static final String RESULT_PROFIT_RATE_TAIL = "%입니다.";

    /**
     * METHODS
     */

    private static void printEmptyLine(){
        System.out.println();
    }

    public static void printPurchaseAmountPrompt() {
        System.out.println(MSG_INPUT_PURCHASE_MONEY);
    }

    public static void printWinnerNumbersPrompt() {
        printEmptyLine();
        System.out.println(MSG_INPUT_WINNER_NUMBERS);
    }

    public static void printBonusNumbersPrompt() {
        printEmptyLine();
        System.out.println(MSG_INPUT_BONUS_NUMBER);
    }

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

    public static void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }


}