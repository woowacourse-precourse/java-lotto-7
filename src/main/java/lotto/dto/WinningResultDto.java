package lotto.dto;

import lotto.domain.LottoRank;

public record WinningResultDto(
        int matchCount,
        boolean hasBonusMatch,
        String rank,
        long prizeAmount
) {
    public static WinningResultDto from(LottoRank lottoRank) {
        return new WinningResultDto(
                lottoRank.getMatchCount(),
                lottoRank.hasBonusMatch(),
                lottoRank.name(),
                lottoRank.getPrizeAmount()
        );
    }

    public boolean isSameRank(LottoRank rank) {
        return matchCount == rank.getMatchCount()
                && hasBonusMatch == rank.hasBonusMatch();
    }
}
