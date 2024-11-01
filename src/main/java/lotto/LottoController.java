package lotto;

import lotto.model.Purchase;

public class LottoController {
    private final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void purchaseLotto() {
        String payment = lottoView.getPayment();
        Purchase purchase = new Purchase(payment);
    }
}
