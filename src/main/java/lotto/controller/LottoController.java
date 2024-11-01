package lotto.controller;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoGroups;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final InputController inputController;

    public LottoController(InputView inputView,
                           OutputView outputView,
                           LottoService lottoService,
                           InputController inputController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.inputController = inputController;
    }

    public void process() {
        Money lottoPurchaseMoney = inputController.inputLottoPurchaseAmount();
        LottoGroups lottoGroups = lottoService.purchaseLottos(lottoPurchaseMoney);
        outputView.printPurchaseLottos(lottoGroups.getLottos());

        String winningNumber = inputView.inputWinningNumber();
        List<Integer> winningNumbers = Stream.of(winningNumber.split(","))
                .map(Integer::valueOf)
                .toList();
        String inputBonusNumber = inputView.inputBonusNumber();
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        LottoResult lottoResult = lottoGroups.calculateLottoResult(winningLotto, lottoPurchaseMoney);
        outputView.printLottoResults(lottoResult);
    }
}
