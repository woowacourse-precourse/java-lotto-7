package lotto.view;

public class OutputView {
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계";
    private static final String DASHED_LINE = "---";
    private static final String LOTTO_MATCH_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개\n";

    public void printResultMessage() {
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println(DASHED_LINE);
    }

    public void printLottoPrize(int count, String price, int prizeCount) {
        System.out.printf(LOTTO_MATCH_RESULT_MESSAGE, count, price, prizeCount);
    }
}
