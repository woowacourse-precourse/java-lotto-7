package lotto.dto;

import lotto.domain.LottoRank;

import java.util.Map;

public class WinningRankCountDto {
    private final Map<LottoRank, Long> rankCounts;

    public WinningRankCountDto(Map<LottoRank, Long> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public Map<LottoRank, Long> getRankCounts() {
        return rankCounts;
    }

    public Long getRankCount (LottoRank lottoRank) {
        return rankCounts.get(lottoRank);
    }
}
