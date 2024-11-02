package lotto.controller;

import lotto.converter.LottoWinningNumbersConverter;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.dto.LottoOutputDto;
import lotto.service.LottoBuyService;
import lotto.service.LottoCheckService;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoBuyService lottoBuyService;
    private final LottoCheckService lottoCheckService;

    public LottoController(InputView inputView, OutputView outputView, LottoBuyService lottoBuyService,
                           LottoCheckService lottoCheckService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoBuyService = lottoBuyService;
        this.lottoCheckService = lottoCheckService;
    }

    public void buyLotto() {
        String purchaseAmount = this.enterPurchaseAmount();

        Lottos lottos = lottoBuyService.buyLotto(purchaseAmount);
        outputView.showLottos(lottos);

        String winningNumbers = this.enterWinningNumber();
        String bonusNumber = this.enterBonusNumber(winningNumbers);

        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbersConverter.toLottoWinningNumbers(winningNumbers,
                bonusNumber);
        LottoOutputDto lottoOutputDto = lottoCheckService.checkLottos(purchaseAmount, lottoWinningNumbers, lottos);
        outputView.showResult(lottoOutputDto);
    }

    public String enterPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmount = inputView.enterPurchaseAmount();
                PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                outputView.showErrorMessage(e.getMessage());
            }
        }
    }

    public String enterWinningNumber() {
        while (true) {
            try {
                String winningNumber = inputView.enterWinningNumber();
                WinningNumberValidator.validateWinningNumber(winningNumber);
                return winningNumber;
            } catch (IllegalArgumentException e) {
                outputView.showErrorMessage(e.getMessage());
            }
        }
    }

    public String enterBonusNumber(String winningNumbers) {
        while (true) {
            try {
                String bonusNumber = inputView.enterBonusNumber();
                BonusNumberValidator.validateBonusNumber(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.showErrorMessage(e.getMessage());
            }
        }
    }
}
