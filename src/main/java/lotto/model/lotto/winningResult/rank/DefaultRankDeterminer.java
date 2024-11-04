package lotto.model.lotto.winningResult.rank;

import lotto.dto.MatchingResultDto;

public class DefaultRankDeterminer implements RankDeterminer<MatchingResultDto> {
    @Override
    public Rank determine(MatchingResultDto matchingResultDto) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchingAmount() == matchingResultDto.matchingAmount()) {
                return fromMatchingAmountAndBonusNumber(rank, matchingResultDto.matchesBonusNumber());
            }
        }
        return Rank.FAIL;
    }

    private Rank fromMatchingAmountAndBonusNumber(Rank rank, boolean matchesBonusNumber) {
        if (rank.isWithBonusNumber()) {
            if (matchesBonusNumber) {
                return rank;
            }
            return Rank.findByRank(rank.getRank() + 1);
        }
        return rank;
    }
}
