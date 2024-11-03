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
    private static final int SPECIAL_MATCH_COUNT_CASE = 4;
    private static final String RATE_OF_RETURN_RULES = "%.1f";

    private final Map<Rank, Integer> winningStatusTable;
    private final double profitRate;

    public LottoStatistics(AutomaticLottoMachine automaticLottoMachine, WinningLottos winningNumbers) {
        winningStatusTable = initialize();
        buildWinningStatus(automaticLottoMachine, winningNumbers);
        profitRate = calculateProfitRate(automaticLottoMachine);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(),
                visualizeWiningStatus(),
                visualizeProfitRate());
    }

    private String visualizeProfitRate() {
        return String.join("", "총 수익률은 ", String.format(RATE_OF_RETURN_RULES, profitRate), "%입니다.");
    }

    private String visualizeWiningStatus() {
        return winningStatusTable.entrySet().stream()
                .map((entry) -> join(DEFAULT_DELIMITER,
                        entry.getKey().getDescription(),
                        entry.getValue() + "개"))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static LinkedHashMap<Rank, Integer> initialize() {
        return Arrays.stream(Rank.values())
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> 0,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }

    private double calculateProfitRate(AutomaticLottoMachine automaticLottoMachine) {
        int totalReward = calculateTotalReward();

        return (totalReward / (double) automaticLottoMachine.getAmount()) * 100.0;
    }

    private int calculateTotalReward() {
        return winningStatusTable.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(entry -> Rank.calculateReward(entry.getKey(), entry.getValue()))
                .reduce(0, Integer::sum);

    }

    private void buildWinningStatus(AutomaticLottoMachine automaticLottoMachine, WinningLottos winningNumbers) {
        automaticLottoMachine.getLottos()
                .filter((automaticLotto) -> Rank.contains(winningNumbers.match(automaticLotto)))
                .map(lotto -> toRanker(winningNumbers, lotto))
                .forEach((rank) -> winningStatusTable.put(rank, winningStatusTable.getOrDefault(rank, 0) + 1));
    }

    private Rank toRanker(WinningLottos winningNumbers, Lotto lotto) {
        boolean isPromiseWithBonusMatch = winningNumbers.match(lotto) == SPECIAL_MATCH_COUNT_CASE;
        if (isPromiseWithBonusMatch) {
            return Rank.getRank(winningNumbers.match(lotto), winningNumbers.isMatchBonus(lotto));
        }

        return Rank.getRank(winningNumbers.match(lotto), false);
    }
}
