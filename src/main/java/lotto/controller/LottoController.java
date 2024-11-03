package lotto.controller;

import lotto.view.InputView;
import lotto.domain.LottoService;

import static lotto.constants.LottoConstants.*;
import static lotto.view.OutputView.*;

public class LottoController {
    private final InputView inputView;
    private LottoService lottoService;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        int purchaseAmount = inputView.getInputPurchaseAmount();

        int lottoCount = calculateLottoCount(purchaseAmount);
        promptLottoCount(lottoCount);
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / PURCHASE_AMOUNT_UNIT;
    }
}
