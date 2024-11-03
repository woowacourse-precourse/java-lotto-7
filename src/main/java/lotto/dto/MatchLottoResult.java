package lotto.dto;

import java.util.Map;
import lotto.domain.Result;

public record MatchLottoResult(
        Map<Integer, Integer> result
) {
    public static MatchLottoResult of(Result result) {
        return new MatchLottoResult(result.getResult());
    }
}
