package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.validation.InputValidator;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ErrorView errorView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView,
                           ErrorView errorView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorView = errorView;
        this.lottoService = lottoService;
    }

    public void startLottoDraw() {
        Money money = getMoney();
        Lottos lottos = lottoService.makeLottos(money.money());
        outputView.printLottos(lottos);

        WinningLotto winningLotto = getWinningLotto(getWinningNumbers());
    }

    private Money getMoney() {
        Money money = null;

        while (money == null) {
            try {
                String moneyInput = inputView.requestMoneyInput();
                InputValidator.validateNotEmpty(moneyInput);
                money = new Money(Integer.parseInt(moneyInput));
            } catch (NumberFormatException e) {
                errorView.printMoneyParsingError();
            } catch (IllegalArgumentException e) {
                errorView.printErrorMessage(e.getMessage());
            }
        }

        return money;
    }

    private Lotto getWinningNumbers() {
        Lotto winningNumbers = null;

        while (winningNumbers == null) {
            try {
                String winningNumbersInput = inputView.requestWinningNumbersInput();
                InputValidator.validateNotEmpty(winningNumbersInput);
                winningNumbers = lottoService.makeLottoBySplitting(winningNumbersInput);
            } catch (NumberFormatException e) {
                errorView.printWinningNumbersParsingError();
            } catch (IllegalArgumentException e) {
                errorView.printErrorMessage(e.getMessage());
            }
        }

        return winningNumbers;
    }

    private BonusNumber getBonusNumber() {
        BonusNumber bonusNumber = null;

        while (bonusNumber == null) {
            try {
                String bonusNumberInput = inputView.requestBonusNumberInput().trim();
                InputValidator.validateNotEmpty(bonusNumberInput);
                bonusNumber = new BonusNumber(Integer.parseInt(bonusNumberInput));
            } catch (NumberFormatException e) {
                errorView.printBonusNumberParsingError();
            } catch (IllegalArgumentException e) {
                errorView.printErrorMessage(e.getMessage());
            }
        }

        return bonusNumber;
    }

    private WinningLotto getWinningLotto(Lotto winningNumbers) {
        WinningLotto winningLotto = null;

        while (winningLotto == null) {
            try {
                BonusNumber bonusNumber = getBonusNumber();
                winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            } catch (NumberFormatException e) {
                errorView.printBonusNumberParsingError();
            } catch (IllegalArgumentException e) {
                errorView.printErrorMessage(e.getMessage());
            }
        }

        return winningLotto;
    }
}
