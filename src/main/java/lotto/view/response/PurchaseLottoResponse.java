package lotto.view.response;

import java.util.List;

public class PurchaseLottoResponse {

    private final int purchasedAmount;
    private final List<LottoNumberResponse> lottoNumberResponses;

    private PurchaseLottoResponse(List<LottoNumberResponse> lottoNumberResponses) {
        this.purchasedAmount = lottoNumberResponses.size();
        this.lottoNumberResponses = lottoNumberResponses;
    }

    public static PurchaseLottoResponse from(List<LottoNumberResponse> lottoNumberResponses) {
        return new PurchaseLottoResponse(lottoNumberResponses);
    }

    public int getPurchasedAmount() {
        return purchasedAmount;
    }

    public List<LottoNumberResponse> getLottoNumberResponses() {
        return lottoNumberResponses;
    }
}
