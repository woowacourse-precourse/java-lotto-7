package lotto.dto;

import lotto.domain.lotto.Lotto;

import java.util.List;

public record PurchasedLottosResponse(List<LottoResponse> lottoResponses) {
    public static PurchasedLottosResponse from(List<Lotto> lottos) {
        List<LottoResponse> lottoResponses = lottos.stream()
                .map(LottoResponse::new)
                .toList();

        return new PurchasedLottosResponse(lottoResponses);
    }

    public record LottoResponse(List<Integer> numbers) {
        public LottoResponse(Lotto lotto) {
            this(lotto.getNumbers());
        }
    }
}
