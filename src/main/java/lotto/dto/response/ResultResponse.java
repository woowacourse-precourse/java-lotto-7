package lotto.dto.response;

import java.util.List;

import lotto.constant.Rank;

public record ResultResponse(
    List<InnerRankCountResponse> rankCounts,
    double gain
) {

    public static ResultResponse of(List<Rank> ranks, double gain) {
        return new ResultResponse(
            ranks.stream()
                .map(InnerRankCountResponse::from)
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

        private static InnerRankCountResponse from(Rank rank) {
            return new InnerRankCountResponse(rank.getRank(), rank.getMatchCount());
        }
    }
}
