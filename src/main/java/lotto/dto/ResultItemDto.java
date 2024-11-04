package lotto.dto;

import lotto.model.Ranking;

public record ResultItemDto(
        Ranking ranking,
        int numberOfMatch,
        boolean isBonusMatch,
        int prizeMoney,
        int count
) {
    public ResultItemDto(Ranking ranking, int count) {
        this(ranking, ranking.getNumberOfMatch(), ranking.requiresBonusMatch(), ranking.getPrizeMoney(), count);
    }

}
