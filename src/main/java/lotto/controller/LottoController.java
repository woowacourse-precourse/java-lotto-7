package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.model.Customer;
import lotto.model.LottoTicket;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        String rawPaidAmount = InputView.getPaidAmount();
        InputValidator.validatePaidAmount(rawPaidAmount);
        int paidAmount = Integer.parseInt(rawPaidAmount);

        List<LottoTicket> lottoTickets = lottoService.purchase(paidAmount);
        Customer customer = new Customer(paidAmount, lottoTickets);
    }
}
