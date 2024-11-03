package lotto.dto;

import java.util.TreeMap;
import lotto.enums.Rank;

public record MatchLottoResult(
        TreeMap<Rank, Integer> result
) {
    public static MatchLottoResult of(TreeMap<Rank, Integer> result) {
        return new MatchLottoResult(result);
    }
}
