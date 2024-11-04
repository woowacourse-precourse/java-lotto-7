package lotto.view;

public class OutputView {
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계";
    private static final String DASHED_LINE = "---";
    private static final String LOTTO_MATCH_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String LOTTO_MATCH_BONUS_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String EARNINGS_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printResultMessage() {
        System.out.println();
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println(DASHED_LINE);
    }

    public void printLottoPrize(int count, Boolean hasBonus, String price, int prizeCount) {
        if (hasBonus) {
            System.out.printf(LOTTO_MATCH_BONUS_RESULT_MESSAGE, count, price, prizeCount);
            return;
        }
        System.out.printf(LOTTO_MATCH_RESULT_MESSAGE, count, price, prizeCount);
    }

    public void printLottoRate(double rate) {
        System.out.printf(EARNINGS_RATE_MESSAGE, rate);
    }
}
