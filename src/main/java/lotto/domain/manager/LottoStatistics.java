package lotto.domain.manager;

import static java.lang.String.join;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.domain.constant.Rank;
import lotto.domain.model.Lotto;
import lotto.domain.model.Profit;

public class LottoStatistics {
    private static final String DEFAULT_DELIMITER = " - ";
    private static final int SPECIAL_MATCH_COUNT_CASE = 4;

    private final Map<Rank, Integer> winningStatusTable;
    private final Profit profit;

    public LottoStatistics(AutomaticLottoMachine automaticLottoMachine, WinningLotto winningNumbers) {
        winningStatusTable = initialize();
        buildWinningStatus(automaticLottoMachine, winningNumbers);
        profit = calculateProfit(automaticLottoMachine.getAmount());
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(),
                visualizeWiningStatus(),
                visualizeProfit());
    }

    private LinkedHashMap<Rank, Integer> initialize() {
        return Arrays.stream(Rank.values())
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> 0,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }

    private Profit calculateProfit(int amount) {
        int totalReward = winningStatusTable.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(entry -> entry.getKey().calculateReward(entry.getValue()))
                .reduce(0, Integer::sum);

        return new Profit(amount, totalReward);
    }

    private String visualizeProfit() {
        return String.join("", "총 수익률은 ", profit.toString(), "%입니다.");
    }

    private String visualizeWiningStatus() {
        return winningStatusTable.entrySet()
                .stream()
                .map(this::toDefaultFormat)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String toDefaultFormat(Entry<Rank, Integer> entry) {
        return join(DEFAULT_DELIMITER, entry.getKey().getDescription(), entry.getValue() + "개");
    }

    private void buildWinningStatus(AutomaticLottoMachine automaticLottoMachine, WinningLotto winningNumbers) {
        automaticLottoMachine.getLottos()
                .filter((automaticLotto) -> Rank.contains(winningNumbers.match(automaticLotto)))
                .map(lotto -> toRanker(winningNumbers, lotto))
                .forEach((rank) -> winningStatusTable.put(rank, winningStatusTable.getOrDefault(rank, 0) + 1));
    }

    private Rank toRanker(WinningLotto winningNumbers, Lotto lotto) {
        boolean isPromiseWithBonusMatch = winningNumbers.match(lotto) == SPECIAL_MATCH_COUNT_CASE;
        if (isPromiseWithBonusMatch) {
            return Rank.getRank(winningNumbers.match(lotto), winningNumbers.isMatchBonus(lotto));
        }

        return Rank.getRank(winningNumbers.match(lotto), false);
    }
}
