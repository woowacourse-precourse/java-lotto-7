package lotto.domain.lotto.dto.response;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.domain.LottoResult;

public class LottoGameRes {
    private final Map<LottoResult, Integer> results;
    private final double profitRate;

    private LottoGameRes(Map<LottoResult, Integer> results, double profitRate) {
        this.results = results;
        this.profitRate = profitRate;
    }

    public static LottoGameRes of(Map<LottoResult, Integer> results, double profitRate) {
        return new LottoGameRes(results, profitRate);
    }

    public List<LottoResultRes> getResults() {
        return Arrays.stream(LottoResult.values())
                .filter(result -> result != LottoResult.NONE)
                .sorted((r1, r2) -> {
                    // 매칭 개수가 같으면 상금이 더 작은 것이 먼저
                    if (r1.getMatchCount() == r2.getMatchCount()) {
                        return Integer.compare(r1.getPrize(), r2.getPrize());
                    }
                    // 매칭 개수로 오름차순 정렬
                    return Integer.compare(r1.getMatchCount(), r2.getMatchCount());
                })
                .map(result -> LottoResultRes.of(result, results.getOrDefault(result, 0)))
                .collect(Collectors.toList());
    }

    public double getProfitRate() {
        return profitRate;
    }
}