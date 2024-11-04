package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public record PurchaseLotto(List<LottoResponse> lottoResponses, int purchaseCount) {
    public static PurchaseLotto of(List<Lotto> lottos, int purchaseCount) {
        return new PurchaseLotto(lottos.stream()
                .map(LottoResponse::of)
                .toList(), purchaseCount);
    }
}
