package lotto.view.response;

import lotto.model.Lottos;

import java.util.List;

public class PurchaseLottoResponse {

    private final List<LottoNumberResponse> lottoNumberResponses;
    private final int purchasedAmount;

    private PurchaseLottoResponse(List<LottoNumberResponse> lottoNumberResponses, int purchasedAmount) {
        this.lottoNumberResponses = lottoNumberResponses;
        this.purchasedAmount = purchasedAmount;
    }

    public static PurchaseLottoResponse from(Lottos lottos) {
        return new PurchaseLottoResponse(
                lottos.getAllLottoNumbers().stream().map(LottoNumberResponse::from).toList(),
                lottos.getAllLottoNumbers().size()
        );
    }

    public List<LottoNumberResponse> getLottoNumberResponses() {
        return lottoNumberResponses;
    }

    public int getPurchasedAmount() {
        return purchasedAmount;
    }
}
