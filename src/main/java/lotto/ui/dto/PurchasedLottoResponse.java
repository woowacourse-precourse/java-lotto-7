package lotto.ui.dto;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class PurchasedLottoResponse {

    private final int lottoCount;
    private final List<LottoNumbersResponse> lottos;

    private PurchasedLottoResponse(int lottoCount, List<LottoNumbersResponse> lottos) {
        this.lottoCount = lottoCount;
        this.lottos = lottos;
    }

    public static PurchasedLottoResponse of(int lottoCount, List<Lotto> lottos) {
        return new PurchasedLottoResponse(lottoCount, convertLottoNumbersResponse(lottos));
    }

    private static List<LottoNumbersResponse> convertLottoNumbersResponse(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::toResponse)
                .toList();
    }

    public List<LottoNumbersResponse> getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

}
