package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class LottoStatistics {
    public static Map<LottoResult, Integer> countResult(List<Optional<LottoResult>> results) {
        Map<LottoResult, Integer> count = new HashMap<>(Map.of(
                LottoResult.FIFTH, 0,
                LottoResult.FOURTH, 0,
                LottoResult.THIRD, 0,
                LottoResult.SECOND, 0,
                LottoResult.FIRST, 0
        ));
        for (Optional<LottoResult> result : results) {
            result.ifPresent(lottoResult -> count.computeIfPresent(lottoResult, (key, value) -> value + 1));
        }
        return count;
    }

    public static List<Entry<LottoResult, Integer>> sortResultMap(Map<LottoResult, Integer> resultMap) {
        return resultMap.entrySet().stream().sorted((e1, e2) -> {
            int money1 = e1.getKey().getWinningMoney();
            int money2 = e2.getKey().getWinningMoney();
            return money1 - money2;
        }).toList();
    }

    public static double getRateOfReturn(List<Optional<LottoResult>> results) {
        int total = results.stream()
                .mapToInt(opt-> opt.map(LottoResult::getWinningMoney).orElse(0))
                .reduce(0, Integer::sum);
        return (double) total * 100 / (results.size() * 1000);
    }
}
