package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.statistic.Statistic;

public class OutputHandler {

    private static final String PURCHASE_COST_PROMPT = "구입금액을 입력해주세요.";
    private static final String WINNING_LOTTO_PROMPT = "당첨 번호를 입력해주세요";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해주세요";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String INTEREST_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    public void showPurchaseCostInputComments() {
        System.out.println(PURCHASE_COST_PROMPT);
    }

    public void showWinningLottoInputComment() {
        System.out.println(WINNING_LOTTO_PROMPT);
    }

    public void showWinningLottoBonusNumberInputComment() {
        System.out.println(BONUS_NUMBER_PROMPT);
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
    }

    public void showPurchaseLottoCount(long purchaseCost) {
        System.out.printf(PURCHASE_MESSAGE, purchaseCost);
    }

    public void showWinningStatistics(Statistic statistic) {

        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(DIVIDER);
        System.out.printf("3개 일치 (5,000원) - %d개\n", statistic.getFifth());
        System.out.printf("4개 일치 (50,000원) - %d개\n", statistic.getFourth());
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", statistic.getThird());
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", statistic.getSecond());
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", statistic.getFirst());

    }

    public void showNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void showInterestRate(double interestRate) {
        System.out.printf(INTEREST_RATE_MESSAGE, interestRate);
    }
}
