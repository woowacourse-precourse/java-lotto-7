package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Winning;

public class OutputView {
    private final static String RESULT_TITLE = "\n당첨 통계";
    private final static String DIVIDER = "---";
    private final static String ISSUE_LOTTO_TITLE = "\n%d개를 구매했습니다.\n";
    private final static String YIELD_PRINT = "총 수익률은 %.1f%%입니다.";

    public void printLotto(List<Lotto> lottos) {
        System.out.printf(ISSUE_LOTTO_TITLE, lottos.size());
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public void printResult(Map<Winning, Integer> winnings, double yield) {
        System.out.println(RESULT_TITLE);
        System.out.println(DIVIDER);
        for (Winning winning : Winning.values()) {
            System.out.printf(winning.getPrompt(), winnings.getOrDefault(winning, 0));
        }
        System.out.printf(YIELD_PRINT, yield);
    }
}
