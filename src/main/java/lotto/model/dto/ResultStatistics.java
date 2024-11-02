package lotto.model.dto;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.result.Rank;

public record ResultStatistics(
        Map<Rank, Integer> lottoResult
) {
    public Map<Rank, Integer> getStatistics() {
        List<Rank> sortedRanks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        Map<Rank, Integer> result = new LinkedHashMap<>();
        for (Rank rank : sortedRanks) {
            result.put(rank, lottoResult.get(rank));
        }
        return result;
    }
}
