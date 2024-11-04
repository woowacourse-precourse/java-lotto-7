package lotto.controller;

import lotto.dto.WinningResultDto;
import lotto.handler.InputHandler;
import lotto.view.output.ResultView;
import lotto.domain.WinningLotto;
import lotto.wrapper.Amount;
import lotto.wrapper.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.service.WinningService;
import lotto.view.input.InputView;
import lotto.view.output.LottoView;

public class LottoController {

    private final LottoService lottoService;
    private final WinningService winningService;

    public LottoController(LottoService lottoService, WinningService winningService) {
        this.lottoService = lottoService;
        this.winningService = winningService;
    }

    public void run() {
        Amount amount = InputHandler.handle(InputView::inputAmount, Amount::of);
        Lottos lottos = lottoService.createLottos(amount);
        LottoView.printLottos(lottos);

        Lotto winningNumber = InputHandler.handle(InputView::inputWinningNumbers,
                lottoService::parseWinningNumberForLotto);
        BonusNumber bonusNumber = InputHandler.handle(InputView::inputBonusNumber,
                input -> lottoService.createBonusNumber(input, winningNumber));
        InputView.closeStream();

        WinningLotto winningLotto = WinningLotto.of(winningNumber, bonusNumber);
        WinningResultDto winningResult = winningService.calculateWinningResult(lottos, winningLotto);
        ResultView.printResult(winningResult);
    }

}
