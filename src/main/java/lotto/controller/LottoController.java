package lotto.controller;

import lotto.dto.LottoInputDto;
import lotto.service.LottoBuyService;
import lotto.service.LottoCheckService;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        lottoBuyService.buyLotto(lottoInputDto.purchaseAmount());
    }

    public void checkLotto() {

    }
}
