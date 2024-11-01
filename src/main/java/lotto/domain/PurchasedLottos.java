package lotto.domain;

import lotto.dto.response.LottoResponse;

import java.util.List;

public class PurchasedLottos {

    private final List<Lotto> lottos;

    private PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static PurchasedLottos from(List<Lotto> purchasedLottos) {
        return new PurchasedLottos(purchasedLottos);
    }

    public List<LottoResponse> toLottoResponses() {
        return lottos.stream()
                .map(Lotto::toLottoResponse)
                .toList();
    }
}
