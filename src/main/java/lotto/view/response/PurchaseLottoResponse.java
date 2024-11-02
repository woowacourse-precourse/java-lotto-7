package lotto.view.response;

import lotto.model.Lottos;

import java.util.List;

public class PurchaseLottoResponse {

    private final List<LottoNumberResponse> lottoNumberResponses;
    private final int purchasedAmount;

    private PurchaseLottoResponse(Lottos lottos) {
        this.lottoNumberResponses = lottos.getAllLottoNumbers().stream().map(LottoNumberResponse::from).toList();
        this.purchasedAmount = lottoNumberResponses.size();
    }

    public static PurchaseLottoResponse from(Lottos lottos) {
        return new PurchaseLottoResponse(lottos);
    }

    public List<LottoNumberResponse> getLottoNumberResponses() {
        return lottoNumberResponses;
    }

    public int getPurchasedAmount() {
        return purchasedAmount;
    }
}
