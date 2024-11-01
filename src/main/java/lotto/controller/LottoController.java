package lotto.controller;

import java.util.List;
import lotto.handler.InputHandler;
import lotto.model.customer.Customer;
import lotto.model.dto.LottoDto;
import lotto.model.dto.ResultDto;
import lotto.model.lotto.WinningLotto;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int paidAmount = InputHandler.getPaidAmount();
        Customer customer = lottoService.sellLottoToNewCustomer(paidAmount);
        displayLottoTickets(customer);

        WinningLotto winningLotto = createWinningLotto();

        lottoService.determineRanks(customer, winningLotto);
        displayResult(customer);
    }

    private void displayLottoTickets(Customer customer) {
        List<LottoDto> lottoNumbersOfCustomer = lottoService.getIssuedLottoNumbersOf(customer);
        OutputView.displayLottoNumbers(lottoNumbersOfCustomer);
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = InputHandler.getWinningNumbers();
        int bonusNumber = InputHandler.getBonusNumber();

        return lottoService.registerWinningNumbers(winningNumbers, bonusNumber);
    }

    private void displayResult(Customer customer) {
        ResultDto result = lottoService.getResult(customer);
        OutputView.displayResult(result);
    }
}
