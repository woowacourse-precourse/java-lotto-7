package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.*;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;
    private final NumberOfLottoOutputHandler numberOfLottoOutputHandler;
    private final LottoStaticsOutputHandler lottoStaticsOutputHandler;

    public LottoController(LottoService lottoService,
                           NumberOfLottoOutputHandler numberOfLottoOutputHandler,
                           LottoStaticsOutputHandler lottoStaticsOutputHandler) {
        this.lottoService = lottoService;
        this.numberOfLottoOutputHandler = numberOfLottoOutputHandler;
        this.lottoStaticsOutputHandler = lottoStaticsOutputHandler;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = issueLottos(purchaseAmount);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        List<Rank> ranks = lottoService.getRanks(lottos, winningNumbers, bonusNumber);

        displayResults(ranks, purchaseAmount);
    }

    private int getPurchaseAmount() {
        return PurchaseAmountInputHandler.promptPurchaseAmount();
    }

    private List<Lotto> issueLottos(int purchaseAmount) {
        numberOfLottoOutputHandler.displayNumberOfLottos(purchaseAmount);
        return lottoService.issueLottos(purchaseAmount);
    }

    private List<Integer> getWinningNumbers() {
        return WinningNumbersInputHandler.promptGetWinningNumbers();
    }

    private int getBonusNumber() {
        return BonusNumberInputHandler.promptGetBonusNumber();
    }

    private void displayResults(List<Rank> ranks, int purchaseAmount) {
        lottoStaticsOutputHandler.displayLottoStatics(ranks);
        lottoStaticsOutputHandler.printReturn(ranks, purchaseAmount);
    }
}
