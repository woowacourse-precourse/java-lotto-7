package lotto.dto.response;

import lotto.domain.Lotto;

import java.util.List;

public record LottoesResponse(
        List<Lotto> lottoes
) {
    public static LottoesResponse from(List<Lotto> lottoes) {
        return new LottoesResponse(lottoes);
    }
}
