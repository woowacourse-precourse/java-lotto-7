package lotto.dto.response;

import java.util.List;

import lotto.domain.player.RankCounts;

public record ResultResponse(
    List<InnerRankCountResponse> rankCounts,
    double gain
) {

    private static final int DEFAULT_RANK_COUNT = 0;

    public static ResultResponse of(List<RankCounts.RankCount> rankCounts, double gain) {
        return new ResultResponse(
            rankCounts.stream()
                .map(InnerRankCountResponse::from)
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

        private static InnerRankCountResponse from(RankCounts.RankCount rankCount) {
            return new InnerRankCountResponse(
                rankCount.rank().getRank(),
                rankCount.count()
            );
        }
    }
}
