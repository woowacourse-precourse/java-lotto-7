package lotto.dto.response;

import java.util.List;
import java.util.Map;

import lotto.constant.Rank;

public record ResultResponse(
    List<InnerRankCountResponse> rankCounts,
    double gain
) {

    private static final int DEFAULT_RANK_COUNT = 0;

    public static ResultResponse of(Map<Rank, Integer> ranks, double gain) {
        return new ResultResponse(
            ranks.entrySet().stream()
                .map(InnerRankCountResponse::of)
                .toList(),
            gain
        );
    }

    public int getRankCount(int rank) {
        return rankCounts.stream()
            .filter(rankCount -> rankCount.rank == rank)
            .findAny()
            .orElse(new InnerRankCountResponse(rank, DEFAULT_RANK_COUNT))
            .count;
    }

    public record InnerRankCountResponse(
        int rank,
        int count
    ) {

        private static InnerRankCountResponse of(Map.Entry<Rank, Integer> rankCount) {
            return new InnerRankCountResponse(
                rankCount.getKey().getRank(),
                rankCount.getValue()
            );
        }
    }
}
