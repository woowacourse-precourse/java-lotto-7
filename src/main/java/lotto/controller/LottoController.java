package lotto.controller;

import java.util.List;
import lotto.handler.InputHandler;
import lotto.model.Customer;
import lotto.model.LottoTicket;
import lotto.model.WinningLotto;
import lotto.model.dto.LottoDto;
import lotto.model.dto.ResultDto;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int paidAmount = InputHandler.getPaidAmount();

        List<LottoTicket> lottoTickets = lottoService.purchase(paidAmount);
        Customer customer = new Customer(paidAmount, lottoTickets);

        List<LottoDto> lottoNumbersOfCustomer = lottoService.getLottoNumbersOfCustomer(customer);
        OutputView.displayLottoNumbersOfCustomer(lottoNumbersOfCustomer);

        List<Integer> winningNumbers = InputHandler.getWinningNumbers();
        int bonusNumber = InputHandler.getBonusNumber();

        WinningLotto winningLotto = lottoService.registerWinningNumbers(winningNumbers, bonusNumber);

        lottoService.determineRanks(customer, winningLotto);
        ResultDto result = lottoService.getResult(customer);
        OutputView.displayResult(result);
    }
}
