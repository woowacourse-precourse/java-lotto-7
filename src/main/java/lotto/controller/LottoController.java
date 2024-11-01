package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
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
        Customer customer = retryOnInvalidInput(this::sellLottoToNewCustomer);
        displayLottoTicketsOf(customer);

        WinningLotto winningLotto = retryOnInvalidInput(this::createWinningLotto);

        lottoService.determineRanks(customer, winningLotto);
        displayResult(customer);
    }

    private Customer sellLottoToNewCustomer() {
        int paidAmount = InputHandler.getPaidAmount();
        return lottoService.sellLottoToNewCustomer(paidAmount);
    }

    private void displayLottoTicketsOf(Customer customer) {
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


    private <T> T retryOnInvalidInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }
}
