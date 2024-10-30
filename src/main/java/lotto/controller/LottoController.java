package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;

    public LottoController(LottoService lottoService, InputView inputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
    }

    public void run() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        while (true) {
            try {
                int price = inputView.readPrice();
                lottoService.createLottoList(price);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
