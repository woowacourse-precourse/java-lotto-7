package lotto.view;

public class OutputView {
    private final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private final String STATISTIC_AFTER_MATCH_TYPE = "%d개 일치 (";
    private final String STATISTIC_AFTER_MATCH_PRIZE = "원) - ";
    private final String STATISTIC_AFTER_MATCH_COUNT = "개";
    private final String STATISTIC_TOTAL_START = "총 수익률은 ";
    private final String STATISTIC_TOTAL_END = "%입니다.";

    public void printLottoNumbers(String numbers) {
        System.out.println(numbers);
    }
}
