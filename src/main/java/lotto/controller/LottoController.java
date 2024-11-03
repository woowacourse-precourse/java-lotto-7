package lotto.controller;

import lotto.dto.WinningResultDto;
import lotto.view.output.ResultView;
import lotto.domain.WinningLotto;
import lotto.wrapper.Amount;
import lotto.wrapper.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.service.WinningService;
import lotto.view.input.InputView;
import lotto.view.output.ErrorView;
import lotto.view.output.LottoView;

public class LottoController {

    private final LottoService lottoService;
    private final WinningService winningService;

    public LottoController(LottoService lottoService, WinningService winningService) {
        this.lottoService = lottoService;
        this.winningService = winningService;
    }

    public void run() {
        Amount amount = getLottoAmount();
        Lottos lottos = lottoService.createLottos(amount);
        LottoView.printLottos(lottos);

        Lotto winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber);
        InputView.closeStream();

        WinningLotto winningLotto = WinningLotto.of(winningNumber, bonusNumber);
        WinningResultDto winningResult = winningService.calculateWinningResult(lottos, winningLotto);
        ResultView.printResult(winningResult);
    }

    private Amount getLottoAmount() {
        while (true) {
            try {
                String purchaseAmount = InputView.inputAmount();

                return Amount.of(purchaseAmount);
            } catch (IllegalArgumentException e) {
                ErrorView.printError(e);
            }
        }
    }

    private Lotto getWinningNumber() {
        while (true) {
            try {
                String winningNumber = InputView.inputWinningNumbers();

                return lottoService.parseWinningNumberForLotto(winningNumber);
            } catch (IllegalArgumentException e) {
                ErrorView.printError(e);
            }
        }
    }

    private BonusNumber getBonusNumber(Lotto winningNumber) {
        while (true) {
            try {
                String bonusNumber = InputView.inputBonusNumber();

                return lottoService.createBonusNumber(bonusNumber, winningNumber);
            } catch (IllegalArgumentException e) {
                ErrorView.printError(e);
            }
        }
    }

}
