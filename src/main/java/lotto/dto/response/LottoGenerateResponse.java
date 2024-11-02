package lotto.dto.response;

import lotto.domain.Lottoes;

public record LottoGenerateResponse(
        Lottoes lottoes
) {
    public static LottoGenerateResponse from(Lottoes lottoes) {
        return new LottoGenerateResponse(lottoes);
    }
}