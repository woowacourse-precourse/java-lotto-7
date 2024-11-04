package lotto.dto.response;

import lotto.domain.vo.LottoRank;

public record WinningResultDTO(
        LottoRank rank,
        Integer count
) {
    public static WinningResultDTO of(LottoRank rank, Integer count) {
        return new WinningResultDTO(rank, count);
    }
}
