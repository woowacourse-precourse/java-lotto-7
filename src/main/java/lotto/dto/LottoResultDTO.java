package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.Rank;

public record LottoResultDTO(
        List<Integer> matchCounts,
        List<Integer> prizes,
        List<Long> counts,
        List<Boolean> requiresBonus,
        double rateOfResult
) {
    public static LottoResultDTO of(Map<Rank, Long> lottoResults, double rateOfResult) {
        List<Integer> matchCounts = new ArrayList<>();
        List<Integer> prizes = new ArrayList<>();
        List<Long> counts = new ArrayList<>();
        List<Boolean> requiresBonus = new ArrayList<>();

        mapRankDataToResultLists(lottoResults, matchCounts, prizes, counts, requiresBonus);

        return new LottoResultDTO(matchCounts, prizes, counts, requiresBonus, rateOfResult);
    }

    private static void mapRankDataToResultLists(Map<Rank, Long> lottoResults,
                                                 List<Integer> matchCounts,
                                                 List<Integer> prizes,
                                                 List<Long> counts,
                                                 List<Boolean> requiresBonus) {
        lottoResults.forEach((rank, count) -> {
            matchCounts.add(rank.getMatchCount());
            prizes.add(rank.getPrize());
            counts.add(count);
            requiresBonus.add(rank.isRequiresBonus());
        });
    }
}
