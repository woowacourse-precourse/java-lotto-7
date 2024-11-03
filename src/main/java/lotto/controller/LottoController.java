package lotto.controller;

import lotto.model.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        recordPayment();
    }

    public String recordPayment() {
        String payment = InputView.getPayment();
        lottoService.savePayment(payment);
        return "success";
    }
}
