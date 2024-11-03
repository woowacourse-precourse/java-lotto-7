package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;
import lotto.handler.InputHandler;
import lotto.model.customer.Customer;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningLotto;
import lotto.service.LottoResultService;
import lotto.service.LottoSalesService;
import lotto.view.OutputView;

public class LottoController {

    private final LottoSalesService lottoSalesService;
    private final LottoResultService lottoResultService;

    public LottoController(LottoSalesService lottoSalesService, LottoResultService lottoResultService) {
        this.lottoSalesService = lottoSalesService;
        this.lottoResultService = lottoResultService;
    }

    public void run() {
        Customer customer = retryOnInvalidInput(this::sellLottoToNewCustomer);
        displayLottoTicketsOf(customer);

        WinningLotto winningLotto = retryOnInvalidInput(this::createWinningLotto);

        lottoResultService.determineRanks(customer, winningLotto);
        displayResult(customer);
    }

    private Customer sellLottoToNewCustomer() {
        int paidAmount = InputHandler.getPaidAmount();
        return lottoSalesService.sellLottoToNewCustomer(paidAmount);
    }

    private void displayLottoTicketsOf(Customer customer) {
        List<LottoDto> lottoNumbersOfCustomer = lottoSalesService.getIssuedLottoNumbersOf(customer);
        OutputView.displayLottoNumbers(lottoNumbersOfCustomer);
    }

    private WinningLotto createWinningLotto() {
        Lotto lotto = new Lotto(InputHandler.getWinningNumbers());
        int bonusNumber = InputHandler.getBonusNumber();

        return lottoResultService.registerWinningNumbers(lotto, bonusNumber);
    }

    private void displayResult(Customer customer) {
        ResultDto result = lottoResultService.getResult(customer);
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
