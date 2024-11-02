package lotto.controller;

import lotto.domain.Lottos;
import lotto.dto.LottoPurchaseAmount;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = inputLottoPurchaseAmount();
        Lottos lottos = buyLottos(lottoPurchaseAmount);
    }

    private LottoPurchaseAmount inputLottoPurchaseAmount() {
        outputView.printLottoPurchaseAmountMessage();
        return LottoPurchaseAmount.from(inputView.InputLottoPurchaseAmount());
    }

    private Lottos buyLottos(LottoPurchaseAmount lottoPurchaseAmount) {
        Lottos lottos = lottoService.buyLottos(lottoPurchaseAmount);
        outputView.printLottos(lottos);

        return lottos;
    }
}
