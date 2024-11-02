package lotto.format.dto;

import lotto.domain.LottoRank;

public record LottoRankCountMessageDto(LottoRank rank, long count) {

    public static LottoRankCountMessageDto of(LottoRank rank, long count)  {
        return new LottoRankCountMessageDto(rank, count);
    }
}
