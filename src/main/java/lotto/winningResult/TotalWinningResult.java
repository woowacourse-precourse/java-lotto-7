package lotto.winningResult;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.lotto.MatchingCondition;

public class TotalWinningResult {
    private final List<WinningResultInfo> winningResultInfos;

    private TotalWinningResult(List<WinningResultInfo> winningResultInfos) {
        this.winningResultInfos = winningResultInfos;
    }

    public static TotalWinningResult from(List<MatchingCondition> conditions) {
        List<WinningResultInfo> matchingConditionsToWinningResult = conditions.stream()
                .map(WinningResultInfo::findByMatchingCondition)
                .toList();

        return new TotalWinningResult(matchingConditionsToWinningResult);
    }

    public Map<WinningResultInfo, Long> getWinningResultMap() {
        Map<WinningResultInfo, Long> initialMap = Arrays.stream(WinningResultInfo.values())
                .collect(Collectors.toMap(
                        Function.identity(),
                        v -> 0L
                ));

        Map<WinningResultInfo, Long> winningResult = winningResultInfos.stream()
                .collect(groupingBy(
                        Function.identity(),
                        counting()
                ));

        initialMap.putAll(winningResult);

        return initialMap;
    }
}
