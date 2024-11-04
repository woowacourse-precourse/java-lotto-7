package lotto.view.dto;

public record LottoRankResponse(
        int lottoCount,
        String lottoRankPrice,
        int lottoRankCounts,
        boolean bonus
) {
}
