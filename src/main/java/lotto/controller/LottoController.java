package lotto.controller;

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

    public String issueLottos(Integer customerId) {
        LottosResponse response = lottoService.issueLottos(customerId);
        OutputView.printCustomerLottos(response);
        return "success";
    }

    public String recordWinningNumbers() {
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
        return "success";
    }

    public String recordBonusNumber() {
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
        return "success";
    }

    public String checkWinnings(Integer customerId) {
        lottoService.statisticsWinningOfCustomerLottos(customerId);
        return "success";
    }

}
