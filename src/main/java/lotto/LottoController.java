package lotto;

public class LottoController {
    private final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void start() {
        int purchaseAmount = lottoView.requestPurchaseAmount();

    }
}
