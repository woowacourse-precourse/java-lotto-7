package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputService inputService;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputService inputService, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputService = inputService;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseMoney = inputService.promptAndValidatePurchaseMoney();
        outputView.printPurchaseQuantity(purchaseMoney);

        List<Lotto> lottos = lottoService.getLottos(purchaseMoney);
        outputView.printAllLottoNumbers(lottos);

        List<Integer> winningNumbers = inputService.promptAndValidateWinningNumbers();
        int bonusNumber = inputService.promptAndValidateBonusNumber();
        int totalPrizeMoney = lottoService.getTotalPrizeMoney(lottos, winningNumbers, bonusNumber);

        outputView.printWinningResult();
        outputView.printDetailResult();
        outputView.printRateOfReturn(totalPrizeMoney, purchaseMoney);
    }
}


