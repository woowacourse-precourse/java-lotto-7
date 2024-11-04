package lotto.view;

import java.util.List;

public class OutputView {

    private static final String LOTTO_COUNT_SUFFIX = "개를 구매했습니다.";
    private static final String MATCH_STATISTICS_HEADER = "당첨 통계" + System.lineSeparator() + "---";
    private static final String YIELD_PREFIX = "총 수익률은 ";
    private static final String YIELD_SUFFIX = "%입니다.";

    public void printLottoCount(String lottoCount) {
        System.out.println(lottoCount + LOTTO_COUNT_SUFFIX);
    }

    public void printLottoNumbers(List<String> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
    }

    public void printMatchStatistics(List<String> matchStatistics) {
        System.out.println(MATCH_STATISTICS_HEADER);
        matchStatistics.forEach(System.out::println);
    }

    public void printYield(String yield) {
        System.out.println(YIELD_PREFIX + yield + YIELD_SUFFIX);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
