package lotto.dto;

import lotto.domain.LottoRank;

import java.util.Map;

public class LottoRankCountDto {
    private final Map<LottoRank, Long> rankCounts;

    public LottoRankCountDto(Map<LottoRank, Long> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public Map<LottoRank, Long> getRankCounts() {
        return rankCounts;
    }
}
