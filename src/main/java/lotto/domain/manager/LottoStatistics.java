package lotto.domain.manager;

import static java.lang.String.join;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.Rank;
import lotto.domain.model.Lotto;

public class LottoStatistics {
    private static final String DEFAULT_DELIMITER = " - ";
    public static final int SPECIAL_MATCH_COUNT_CASE = 4;

    private final Map<Rank, Integer> statistics;

    public LottoStatistics(AutomaticLottoMachine automaticLottoMachine, WinningLottos winningNumbers) {
        statistics = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> 0,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        calculateStatistics(automaticLottoMachine, winningNumbers);
    }

    @Override
    public String toString() {
        return statistics.entrySet().stream()
                .map((entry) -> join(DEFAULT_DELIMITER, entry.getKey().getDescription(), entry.getValue() + "개"))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private void calculateStatistics(AutomaticLottoMachine automaticLottoMachine, WinningLottos winningNumbers) {
        automaticLottoMachine.getLottos()
                .filter((automaticLotto) -> Rank.contains(winningNumbers.match(automaticLotto)))
                .map(lotto -> toRank(winningNumbers, lotto))
                .forEach((rank) -> statistics.put(rank, statistics.getOrDefault(rank, 0) + 1));
    }

    private Rank toRank(WinningLottos winningNumbers, Lotto lotto) {
        boolean isPromiseWithBonusMatch = winningNumbers.match(lotto) == SPECIAL_MATCH_COUNT_CASE;
        if (isPromiseWithBonusMatch) {
            return Rank.calculate(winningNumbers.match(lotto), winningNumbers.isBonusMatched(lotto));
        }

        return Rank.calculate(winningNumbers.match(lotto), false);
    }
}
