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
    private final PurchaseService purchaseService = new PurchaseService();

    public void purchaseLotto() {
        try {
            int price = inputView.getPrice();
            int lottoCount = purchaseService.buyLotto(price);

            outputView.printPurchaseResult(lottoCount);
            makeLotto(lottoCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void makeLotto(int lottoCount)  throws IllegalArgumentException {
        lottoService.makeLotto(lottoCount);

        lottoService.printLottoNumbers();
        makeWinningNumbers();
    }

    public void makeWinningNumbers()  throws IllegalArgumentException {
        List<Integer> winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();
        lottoService.makeWinningLotto(winningNumbers, bonusNumber);
        calculateLotto(winningNumbers, bonusNumber);
    }

    private void calculateLotto(List<Integer> winningNumbers, int bonusNumber)  throws IllegalArgumentException {
        List<WinningResult> results = lottoService.countLottoMatchNumbers(winningNumbers, bonusNumber);
        String resultToString = lottoService.toStringResult(results);
        outputView.printLottoResult(resultToString);

        double percent = purchaseService.calculateWinningPercent(results);
        outputView.printWinningPercent(percent);
    }
}
