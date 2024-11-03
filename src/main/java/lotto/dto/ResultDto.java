package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.lotto.Rank;
import lotto.utils.RankDescriptionGenerator;

public record ResultDto(
        List<RankDto> rankDtos,
        double profitRate
) {
    public static ResultDto from(Map<Rank, Integer> rankCounts, double profitRate) {
        List<RankDto> rankDtos = new ArrayList<>();

        for (Rank rank : rankCounts.keySet()) {
            rankDtos.add(new RankDto(RankDescriptionGenerator.makeDescription(rank), rankCounts.get(rank)));
        }

        return new ResultDto(rankDtos, profitRate);
    }

    public record RankDto(
            String description,
            int count
    ) {

    }
}
