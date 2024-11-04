package lotto.view;

import lotto.domain.Lotto;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView implements Output {

    private static final String PURCHASED_TICKETS_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATISTICS_HEADER = "당첨 통계";
    private static final String STATISTICS_SEPARATOR = "---";
    private static final String YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.";

    @Override
    public void printLottoTickets(List<Lotto> lottos) {
        System.out.println(String.format(PURCHASED_TICKETS_MESSAGE, lottos.size()));
        lottos.forEach(lotto -> System.out.println(formatLottoNumbers(lotto)));
    }

    @Override
    public void printStatistics(String statistics) {
        System.out.println(STATISTICS_HEADER);
        System.out.println(STATISTICS_SEPARATOR);
        System.out.println(statistics);
    }

    public void printYield(double yield) {
        System.out.println(String.format(YIELD_MESSAGE, yield));
    }

    private String formatLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
