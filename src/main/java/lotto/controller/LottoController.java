package lotto.controller;

import lotto.domain.Lottos;
import lotto.dto.LottoInputDto;
import lotto.dto.LottoOutputDto;
import lotto.service.LottoBuyService;
import lotto.service.LottoCheckService;
import lotto.util.WinningNumberParser;
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

        String winningNumber = inputView.enterWinningNumber();
        int bonusNumber = inputView.enterBonusNumber();

        LottoOutputDto lottoOutputDto = lottoCheckService.checkLottos(
                new LottoInputDto(Long.parseLong(purchaseAmount), WinningNumberParser.parseWinningNumber(winningNumber),
                        bonusNumber),
                lottos);

        outputView.showStatistics(lottoOutputDto);
    }
}
