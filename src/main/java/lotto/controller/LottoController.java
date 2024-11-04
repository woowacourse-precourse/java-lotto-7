package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.LottoRank;
import lotto.service.LottoService;
import lotto.utils.ErrorMessages;
import lotto.utils.LoggerUtils;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(
            LottoService lottoService,
            InputView inputView,
            ResultView resultView
    ) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        LoggerUtils.logInfo("로또 프로그램 시작");

        int purchaseAmount = Validator.getValidInput(
                inputView::inputPurchaseAmount,
                amount -> {
                    try {
                        Validator.validatePurchaseAmount(amount);
                        return true;
                    } catch (IllegalArgumentException e) {
                        return false;
                    }
                },
                ErrorMessages.INVALID_PURCHASE_AMOUNT.getMessage()
        );

        List<Lotto> tickets = lottoService.purchaseLottoTickets(purchaseAmount);
        LoggerUtils.logInfo("로또 티켓 발행 완료");

        resultView.printLottoTickets(tickets);

        List<Integer> winningNumbers = Validator.getValidInput(
                inputView::inputWinningNumbers,
                numbers -> {
                    try {
                        Validator.validateWinningNumbers(numbers);
                        return true;
                    } catch (IllegalArgumentException e) {
                        return false;
                    }
                },
                ErrorMessages.INVALID_WINNING_NUMBER.getMessage()
        );

        int bonusNumber = Validator.getValidInput(
                inputView::inputBonusNumber,
                number -> {
                    try {
                        Validator.validateBonusNumber(number);
                        return true;
                    } catch (IllegalArgumentException e) {
                        return false;
                    }
                },
                ErrorMessages.BONUS_NUMBER_OUT_OF_RANGE.getMessage()
        );

        Map<LottoRank, Integer> results = lottoService.calculateResults(tickets, winningNumbers, bonusNumber);
        double yield = lottoService.calculateYield(purchaseAmount, results);

        LoggerUtils.logInfo("당첨 결과 계산 완료");
        resultView.printResults(results, yield);
    }
}