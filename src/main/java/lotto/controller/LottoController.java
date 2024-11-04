package lotto.controller;

import lotto.Money;
import lotto.model.LottoBought;
import lotto.model.LottoInfo;
import lotto.model.LottoResult;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoInputView inputView;
    private final LottoOutputView outputView;
    private final LottoService service;

    public LottoController() {
        this.inputView = new LottoInputView();
        this.outputView = new LottoOutputView();
        this.service = new LottoService();
    }

    public void execute() {
        Money money = inputView.readMoneyInfo();

        LottoBought = boughtOutput = service.buyLotto(
            money.getValue()
        );

        LottoInfo lottoInput = inputView.readLottoInfo();

        LottoResult lottoOutput = service.runLotto(
            boughtOutput.lottos(),
            lottoInput.winningNum(),
            lottoInput.bonusNum()
        );

        outputView.printResult(
            lottoOutput.lottoStats(),
            lottoOutput.profit()
        );
    }
}
