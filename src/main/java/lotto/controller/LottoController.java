package lotto.controller;

import lotto.model.dto.LottoStatisticsResponse;
import lotto.model.dto.LottosResponse;
import lotto.model.service.LottoService;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        Integer customerId = recordPayment();
        issueLottos(customerId);
        recordWinningNumbers();
        recordBonusNumber();
        checkWinnings(customerId);
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

    public void issueLottos(Integer customerId) {
        LottosResponse response = lottoService.issueLottos(customerId);
        OutputView.printCustomerLottos(response);
    }

    public void recordWinningNumbers() {
        boolean isValid = false;
        while (!isValid) {
            try {
                String winningNumbersInput = InputView.getWinningNumbers();
                lottoService.saveWinningLottos(winningNumbersInput);
                isValid = true;
            } catch (IllegalArgumentException e) {
                ErrorView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void recordBonusNumber() {
        OutputView.printBlankLine();
        boolean isValid = false;
        while (!isValid) {
            try {
                String bonusNumber = InputView.getBonusNumber();
                lottoService.saveBonusNumber(bonusNumber);
                isValid = true;
            } catch (IllegalArgumentException e) {
                ErrorView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void checkWinnings(Integer customerId) {
        LottoStatisticsResponse response = lottoService.statisticsWinningOfCustomerLottos(customerId);
        OutputView.printWinningStatistics(response);
    }

}
