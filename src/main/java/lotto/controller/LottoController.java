package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        String purchaseAmountInput = inputView.inputPurchaseAmount();
        // 입력값 검증
//        validatePurchaseAmount(purchaseAmountInput);
        // 입력값이 유효할 경우 로또 개수 계산
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        int lottoCount = purchaseAmount / 1000;

    }


}
