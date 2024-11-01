package lotto.controller;

import lotto.converter.WinningNumberConverter;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.dto.LottoOutputDto;
import lotto.service.LottoBuyService;
import lotto.service.LottoCheckService;
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
        String purchaseAmount = inputView.enterPurchaseAmount();
        Lottos lottos = lottoBuyService.buyLotto(purchaseAmount);

        outputView.showLottos(lottos);

        String winningNumbers = inputView.enterWinningNumber();
        String bonusNumber = inputView.enterBonusNumber();
        WinningNumber winningNumber = WinningNumberConverter.toWinningNumber(winningNumbers, bonusNumber);

        LottoOutputDto lottoOutputDto = lottoCheckService.checkLottos(
                Long.parseLong(purchaseAmount), winningNumber, lottos);

        outputView.showStatistics(lottoOutputDto);
    }
}
