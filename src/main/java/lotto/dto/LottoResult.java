package lotto.dto;

import java.util.Map;
import lotto.domain.Rank;

public record LottoResult(Map<Rank, Integer> result, double profit) {
    public static LottoResult of(Map<Rank, Integer> result, double profit) {
        return new LottoResult(result, profit);
    }
}
