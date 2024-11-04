package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;

public class OutputView {
    public static final String FIFTH_PLACE_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String WINNING_STATS_MESSAGE = "당첨 통계\n---";
    public static final String FOURTH_PLACE_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    public static final String THIRD_PLACE_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    public static final String SECOND_PLACE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    public static final String FIRST_PLACE_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    public static final String TOTAL_EARNINGS_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void printWinningNumbersMessage() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos) {
        String purchase_msg = LOTTO_PURCHASE_MESSAGE.formatted(lottos.size());

        System.out.println(purchase_msg);
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    public void printLottoResult(Map<Integer, Integer> lottoResult) {
        System.out.println(WINNING_STATS_MESSAGE);

        System.out.printf((FIFTH_PLACE_MESSAGE), lottoResult.get(5));
        System.out.printf((FOURTH_PLACE_MESSAGE), lottoResult.get(4));
        System.out.printf((THIRD_PLACE_MESSAGE), lottoResult.get(3));
        System.out.printf((SECOND_PLACE_MESSAGE), lottoResult.get(2));
        System.out.printf((FIRST_PLACE_MESSAGE), lottoResult.get(1));
    }

    public void printTotalEarningsRate(float totalEarningsRate) {
        System.out.printf(TOTAL_EARNINGS_RATE_MESSAGE, totalEarningsRate);
    }
}
