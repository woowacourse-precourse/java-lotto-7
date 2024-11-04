package lotto.controller;

import java.util.List;
import lotto.domain.WinningResult;
import lotto.service.LottoService;
import lotto.service.PurchaseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void purchaseLotto() {
        PurchaseService purchaseService = new PurchaseService();
        int price = inputView.getPrice();
        int lottoCount = purchaseService.buyLotto(price);

        outputView.printPurchaseResult(lottoCount);
        makeLotto(lottoCount);
    }

    public void makeLotto(int lottoCount) {
        lottoService.makeLotto(lottoCount);

        lottoService.printLottoNumbers();
        makeWinningNumbers();
    }

    public void makeWinningNumbers() {
        List<Integer> winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();
        lottoService.makeWinningLotto(winningNumbers, bonusNumber);
        calculateLotto(winningNumbers, bonusNumber);
    }

    private void calculateLotto(List<Integer> winningNumbers, int bonusNumber) {
        List<WinningResult> results = lottoService.countLottoMatchNumbers(winningNumbers, bonusNumber);
        String resultToString = lottoService.toStringResult(results);
        outputView.printLottoResult(resultToString);
    }
}
