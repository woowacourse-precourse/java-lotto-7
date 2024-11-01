package lotto.controller;

import java.util.List;
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
        long purchaseAmount = inputView.enterPurchaseAmount();
        Lottos lottos = lottoBuyService.buyLotto(purchaseAmount);

        outputView.showLottos(lottos);

        List<Integer> winningNumber = WinningNumberParser.parseWinningNumber(inputView.enterWinningNumber());
        int bonusNumber = inputView.enterBonusNumber();

        LottoOutputDto lottoOutputDto = lottoCheckService.checkLottos(
                new LottoInputDto(purchaseAmount, winningNumber, bonusNumber),
                lottos);

        outputView.showStatistics(lottoOutputDto);
    }
}
