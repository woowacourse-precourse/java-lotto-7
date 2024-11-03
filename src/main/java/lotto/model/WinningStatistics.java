package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.WinningNumberException;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningStatistics {
    private static final int INITIAL_COUNT = 0;
    private static final int INCREMENT_AMOUNT = 1;
    private static final String STATISTICS_FORMAT = "%s - %d개";
    private final Map<WinningRule, Integer> statistics;

    public WinningStatistics() {
        this.statistics = initializeStatistics();
    }

    public Integer getStatisticResultByRule(WinningRule rule) {
        return statistics.get(rule);
    }

    private Map<WinningRule, Integer> initializeStatistics() {
        return Stream.of(WinningRule.values())
                .collect(Collectors.toMap(
                        rule -> rule,
                        rule -> INITIAL_COUNT,
                        (existing, replacement) -> existing,
                        TreeMap::new
                ));
    }

    public void increment(WinningRule rule) {
        validateWinningRule(rule);
        statistics.merge(rule, INCREMENT_AMOUNT, Integer::sum);
    }

    private void validateWinningRule(WinningRule rule) {
        if (rule == null) {
            throw new WinningNumberException(ErrorMessages.WINNING_RULE_NULL);
        }
    }

    @Override
    public String toString() {
        return statistics.entrySet()
                .stream()
                .filter(entry -> entry.getKey().isWinning())
                .map(this::formatStatisticsEntry)
                .collect(Collectors.joining("\n"));
    }

    private String formatStatisticsEntry(Map.Entry<WinningRule, Integer> entry) {
        return String.format(STATISTICS_FORMAT, entry.getKey().getDescription(), entry.getValue());
    }
}
