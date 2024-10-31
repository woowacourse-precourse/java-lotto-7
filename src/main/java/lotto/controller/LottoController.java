package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.input.LottoInputView;
import lotto.view.output.LottoOutputView;

import java.util.List;

public class LottoController {

    private final LottoInputView inputView;
    private final LottoOutputView outputView;
    private final LottoService lottoService;

    public LottoController(LottoInputView inputView, LottoOutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public List<Lotto> purchaseLotto() {
        List<Lotto> lottoBundle = lottoService.purchaseLottoBundle(getPurchaseCount());
        outputView.printLottoBundle(lottoBundle);

        return lottoBundle;
    }

    private int getPurchaseCount() {
        outputView.printMoneyInput();
        int money = inputView.readMoney();

        return money / 1000;
    }
}
