package lotto.controller;

import lotto.service.LottoService;
import lotto.view.ConsoleLottoView;
import lotto.view.LottoView;

public class LottoController {
    private final LottoService lottoService;
    private final LottoView lottoView;

    public LottoController(LottoService lottoService, ConsoleLottoView lottoView) {
        this.lottoService = lottoService;
        this.lottoView = lottoView;
    }

    public void run() {
        purchaseLotto();
        lottoView.displayLottoNumbers(lottoService.getPurchaseDto());

        assignWinningNumbers();
    }

    private void purchaseLotto() {
        try {
            String amount = lottoView.readPurchaseAmount();
            lottoService.buyLotto(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseLotto();
        }
    }

    public void assignWinningNumbers() {
        try {
            String numbers = lottoView.readWinningNumbers();
            lottoService.assignWinningLotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assignWinningNumbers();
        }
    }
}
