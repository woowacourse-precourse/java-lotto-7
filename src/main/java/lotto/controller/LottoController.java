package lotto.controller;

import lotto.converter.WinningNumberConverter;
import lotto.domain.Lotto;
import lotto.dto.LottoInputDto;
import lotto.service.LottoBuyService;
import lotto.service.LottoCheckService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoBuyService lottoBuyService;
    private final LottoCheckService lottoCheckService;

    public LottoController(InputView inputView, OutputView outputView, LottoBuyService lottoBuyService, LottoCheckService lottoCheckService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoBuyService = lottoBuyService;
        this.lottoCheckService = lottoCheckService;
    }

    public void buyLotto() {
        LottoInputDto lottoInputDto = inputView.enterInput();
        List<Lotto> lottos = lottoBuyService.buyLotto(lottoInputDto.purchaseAmount());
        checkLotto(lottoInputDto, lottos);
    }

    public void checkLotto(LottoInputDto lottoInputDto, List<Lotto> lottos) {
        lottoCheckService.checkLotto(WinningNumberConverter.toWinningNumber(lottoInputDto), lottos);
    }
}
