package lotto.domain.lotto.dto.response;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.domain.LottoResult;

public class LottoGameRes {
    private final List<LottoResultRes> results;
    private final double profitRate;

    private LottoGameRes(List<LottoResultRes> results, double profitRate) {
        this.results = results;
        this.profitRate = profitRate;
    }

    public static LottoGameRes of(Map<LottoResult, Integer> results, double profitRate) {
        List<LottoResultRes> resultResponses = results.entrySet().stream()
                .map(entry -> LottoResultRes.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return new LottoGameRes(resultResponses, profitRate);
    }

    public List<LottoResultRes> getResults() {
        return results;
    }

    public double getProfitRate() {
        return profitRate;
    }
}