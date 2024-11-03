package lotto.model;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;

public class WinningStatistics {
    private static final int INITIAL_COUNT = 0;
    private static final int INCREMENT_AMOUNT = 1;
    private static final String STATISTICS_FORMAT = "%s - %d개";
    private final Map<WinningRule, Integer> statistics;

    public WinningStatistics() {
        this.statistics = initializeStatistics();
    }

    public Integer getStatisticResultByRule(WinningRule rule){
        return statistics.get(rule);
    }
    private Map<WinningRule, Integer> initializeStatistics() {
        Map<WinningRule, Integer> initialStats = new TreeMap<>();
        for (WinningRule rule : WinningRule.values()) {
            initialStats.put(rule, INITIAL_COUNT);
        }
        return initialStats;
    }

    public void increment(WinningRule rule) {
        validateWinningRule(rule);
        statistics.merge(rule, INCREMENT_AMOUNT, Integer::sum);
    }

    private void validateWinningRule(WinningRule rule) {
        if (rule == null) {
            throw new LottoException(ErrorMessages.WINNING_RULE_NULL);
        }
    }

    @Override
    public String toString() {
        return statistics.entrySet()
                .stream()
                .filter(entry -> entry.getKey().isWinning())
                .map(entry -> String.format(STATISTICS_FORMAT, entry.getKey().getDescription(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
