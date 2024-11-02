package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.*;

import java.util.List;

public class LottoController {
    LottoService lottoService = new LottoService();
    NumberOfLottoOutputHandler numberOfLottoOutputHandler = new NumberOfLottoOutputHandler(lottoService);
    LottoStaticsOutputHandler lottoStaticsOutputHandler = new LottoStaticsOutputHandler(lottoService);

    public void run() {
        int purchaseAmount = PurchaseAmountInputHandler.promptPurchaseAmount();

        numberOfLottoOutputHandler.displayNumberOfLottos(purchaseAmount);

        List<Lotto> lottos = lottoService.issueLottos(purchaseAmount);

        List<Integer> winningNumbers = WinningNumbersInputHandler.promptGetWinningNumbers();

        int bonusNubmer = BonusNumberInputHandler.promptGetBonusNumber();

//        lottoStaticsOutputHandler.displayLottoStatics();
    }
}
