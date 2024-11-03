package lotto.controller;

import lotto.model.service.LottoService;
import lotto.view.ErrorView;
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
        boolean isCorrect = false;
        while (!isCorrect) {
            try {
                String payment = InputView.getPayment();
                lottoService.savePayment(payment);
                isCorrect = true;
            } catch (IllegalArgumentException e) {
                ErrorView.printErrorMessage(e.getMessage());
            }
        }
        return "success";
    }
}
