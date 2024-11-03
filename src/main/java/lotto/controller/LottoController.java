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
        Integer customerId = recordPayment();
        issueLottos(customerId);
    }

    public Integer recordPayment() {
        Integer customerId = 0;
        while (customerId == 0) {
            try {
                String payment = InputView.getPayment();
                customerId = lottoService.savePayment(payment);
            } catch (IllegalArgumentException e) {
                ErrorView.printErrorMessage(e.getMessage());
            }
        }
        return customerId;
    }

    public String issueLottos(Integer customerId) {
        lottoService.issueLottos(customerId);
        return "success";
    }
}
