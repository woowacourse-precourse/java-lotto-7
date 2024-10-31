package lotto.controller;

import static lotto.view.InputView.getConsoleInput;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoStore;
import lotto.view.InputView;

public class LottoController {

    private InputView inputView;
    private LottoStore lottoStore;
    private int lottoCount;
    private String purchaseAmount;
    private List<Lotto> lottos;

    public void run() {
        purchaseAmount = inputView.requestPurchaseAmount(getConsoleInput());
        lottoCount = lottoStore.getLottoCount(purchaseAmount);
        lottos = lottoStore.buyLotto(lottoCount);

    }
}
