package lotto.model;

import java.util.List;

public record LottoResult(
    List<LottoStat> lottoStats,
    Double profit
) {
    public static LottoResult map(
        List<LottoStat> lottoStats,
        Double profit
    ) {
        return new LottoResult(
            lottoStats,
            profit
        );
    }
}
