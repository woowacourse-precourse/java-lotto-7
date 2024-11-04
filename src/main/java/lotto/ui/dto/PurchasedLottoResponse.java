package lotto.ui.dto;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class PurchasedLottoResponse {

    private final List<LottoNumbersResponse> lottos;

    private PurchasedLottoResponse(List<LottoNumbersResponse> lottos) {
        this.lottos = lottos;
    }

    public static PurchasedLottoResponse of(List<Lotto> lottos) {
        return new PurchasedLottoResponse(convertLottoNumbersResponse(lottos));
    }

    private static List<LottoNumbersResponse> convertLottoNumbersResponse(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::toResponse)
                .toList();
    }

    public List<LottoNumbersResponse> getLottos() {
        return lottos;
    }

}
