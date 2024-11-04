package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoPrize;

public class OutputView {

    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String BONUS_REPORT_FORMAT = "5개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.\n";
    private static final String REPORT_FORMAT = "%d개 일치 (%,d원) - %d개\n";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String YIELD_FORMAT = "총 수익률은 %.1f%%입니다.\n";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계\n---";

    public void printPurchaseAmountPrompt() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printNumberOfPurchasedLottos(int count) {
        System.out.printf(PURCHASED_LOTTO_COUNT_FORMAT, count);
    }

    public void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningNumbersPrompt() {
        System.out.println(WINNING_NUMBERS_PROMPT);
    }

    public void printBonusNumberPrompt() {
        System.out.println(BONUS_NUMBER_PROMPT);
    }

    public void printReport(Map<LottoPrize, Integer> matchCountMap) {
        System.out.println(WINNING_STATISTICS_HEADER);

        for (LottoPrize prize : LottoPrize.values()) {
            if (prize == LottoPrize.MATCH_COUNT_5_WITH_BONUS) {
                System.out.printf(BONUS_REPORT_FORMAT, prize.getPrize(), matchCountMap.get(prize));
                continue;
            }

            System.out.printf(REPORT_FORMAT, prize.getMatchCount(), prize.getPrize(), matchCountMap.get(prize));
        }
    }

    public void printYield(double yield) {
        System.out.printf(YIELD_FORMAT, yield);
    }
}
