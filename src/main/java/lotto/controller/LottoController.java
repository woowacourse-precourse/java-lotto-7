package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.*;

import java.util.List;

public class LottoController {

    public LottoController(LottoService lottoService, NumberOfLottoOutputHandler numberOfLottoOutputHandler, LottoStaticsOutputHandler lottoStaticsOutputHandler) {
        this.lottoService = lottoService;
        this.numberOfLottoOutputHandler = numberOfLottoOutputHandler;
        this.lottoStaticsOutputHandler = lottoStaticsOutputHandler;
    }

    LottoService lottoService = new LottoService();
    NumberOfLottoOutputHandler numberOfLottoOutputHandler = new NumberOfLottoOutputHandler(lottoService);
    LottoStaticsOutputHandler lottoStaticsOutputHandler = new LottoStaticsOutputHandler(lottoService);

    public void run() {
        int purchaseAmount = PurchaseAmountInputHandler.promptPurchaseAmount();

        numberOfLottoOutputHandler.displayNumberOfLottos(purchaseAmount);

        List<Lotto> lottos = lottoService.issueLottos(purchaseAmount);

        List<Integer> winningNumbers = WinningNumbersInputHandler.promptGetWinningNumbers();

        int bonusNubmer = BonusNumberInputHandler.promptGetBonusNumber();

        List<Rank> ranks = lottoService.getRanks(lottos, winningNumbers, bonusNubmer);

        lottoStaticsOutputHandler.displayLottoStatics(ranks);

        lottoStaticsOutputHandler.printReturn(ranks, purchaseAmount);
    }
}
