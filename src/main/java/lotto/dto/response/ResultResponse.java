package lotto.dto.response;

import java.util.List;
import java.util.Map;

import lotto.constant.Rank;

public record ResultResponse(
    List<InnerRankCountResponse> rankCounts,
    double gain
) {

    public static ResultResponse of(Map<Rank, Integer> ranks, double gain) {
        return new ResultResponse(
            ranks.entrySet().stream()
                .map(value -> InnerRankCountResponse.of(value.getKey().getRank(), value.getValue()))
                .toList(),
            gain
        );
    }

    public int getRankCount(int rank) {
        return rankCounts.stream()
            .filter(rankCount -> rankCount.rank == rank)
            .findAny()
            .orElse(new InnerRankCountResponse(rank, 0))
            .count;
    }

    public record InnerRankCountResponse(
        int rank,
        int count
    ) {

        private static InnerRankCountResponse of(int rank, int count) {
            return new InnerRankCountResponse(rank, count);
        }
    }
}
