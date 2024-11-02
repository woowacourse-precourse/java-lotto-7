package lotto.model.dto;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.LottoResult;
import lotto.model.Rank;

public record WinningStatistics(
        LottoResult lottoResult
) {
    public Map<Rank, Integer> getStatistics() {
        Map<Rank, Integer> result = new LinkedHashMap<>();
        List<Rank> sortedRanks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        for (Rank rank : sortedRanks) {
            int count = lottoResult.getResult().getOrDefault(rank, 0);
            result.put(rank, count);
        }
        return result;
    }
}
